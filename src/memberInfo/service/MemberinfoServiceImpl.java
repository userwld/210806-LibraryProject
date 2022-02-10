package memberInfo.service;


import java.util.ArrayList;

import allDAO.MemberDAO;
import allDAO.RentalDAO;
import allDTO.MemberDTO;
import allDTO.NewBestDTO;
import allDTO.RentalDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MemberinfoServiceImpl implements Memberinfo{
	Parent loginForm;
	private MemberDAO memberDao = new MemberDAO();
	private RentalDAO rentalDao = new RentalDAO();
	
// -------------------- 책 번호 조회 --------------------
	@Override
	public void lookupProc(Parent memInfoForm) {
		TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");		
		NewBestDTO newBestDto = rentalDao.lookupBook(bookNumText.getText()); 
		
		if(bookNumText.getText().isEmpty()) {
			CommonService.ErrorMsg("책번호를 입력해주세요");
		}else {
			if(newBestDto == null) {
				CommonService.ErrorMsg("없는 책번호 입니다");
			}else {
				CommonService.InformationMsg("알림", newBestDto.getName() + " 의 남은권수 : " + newBestDto.getTotal());
			}
		}		
	}
// -------------------- 책 대여 --------------------	
	@Override
	   public void rentalProc(Parent memInfoForm) {
		  int bookNum = 0;
	      TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");
	      Label idLabel = (Label) memInfoForm.lookup("#idLabel");
	      ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
	            
	      NewBestDTO newBestDto = rentalDao.lookupBook(bookNumText.getText());
	      RentalDTO rentalDto = new RentalDTO();
	      ArrayList<RentalDTO> renDto = rentalDao.selectId(idLabel.getText());
	      MemberDTO memberDto = memberDao.selectId(idLabel.getText());
 
    	  if(!bookNumText.getText().isEmpty()) {
    		  bookNum = Integer.parseInt(bookNumText.getText());  	    	
    	  }else {
    		  CommonService.ErrorMsg("책번호를 입력해주세요");
    		  return;
    	  }
    	  
    	  for(int i = 0; i < renDto.size(); i++) {
	    	  if(bookNum == (renDto.get(i).getNum())) {	    		  
	    		  CommonService.ErrorMsg("같은 책은 한권만 빌릴 수 있습니다");
	    		  return;
	    	  }
	    	  
	      }
    	     
	      if(newBestDto == null) {	    	 
	    	  CommonService.ErrorMsg("없는 책번호 입니다");
	      }else {
	    	  if(newBestDto.getTotal() < 1) {
	    		  CommonService.ErrorMsg("남은 책이 없습니다");
	    	  }else {
	    		  if(memberDto.getBooktotal() >= 3) {
	    			  CommonService.ErrorMsg("책은 3권까지 빌릴수 있습니다");
	    		  }else {    	
    		    		  CommonService.InformationMsg("알림", newBestDto.getName() + " 을(를) 빌렸습니다");
		    			  rentalDao.updateBook(newBestDto.getTotal() -1, newBestDto.getName());
		    			  rentalDto.setNum(bookNum); rentalDto.setId(idLabel.getText());
		    			  rentalDto.setBookname(newBestDto.getName()); rentalDao.rental(rentalDto);
		    			  memberDao.booktotal(memberDto.getBooktotal()+1, memberDto.getId());
		    			  bookNumText.clear();	    		    	 
	    			  }
	    		  }	
			  }
		  }
  
// -------------------- 책 반납 --------------------
	@Override
	public void returnProc(Parent memInfoForm) {
		int bookNum = 0;
		TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");
		ListView<String> booknumList = (ListView<String>) memInfoForm.lookup("#bookNumList");
		ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
		Label idLabel = (Label) memInfoForm.lookup("#idLabel");
		
		NewBestDTO newBestDto = rentalDao.lookupBook(bookNumText.getText()); 
		RentalDTO rentalDto = rentalDao.selectOne(idLabel.getText()); 
		MemberDTO memberDto = memberDao.selectId(idLabel.getText());

	    ArrayList<RentalDTO> rendto = rentalDao.selectId(idLabel.getText());
       
	       String[] numArr = new String[rendto.size()];
	       for(int i = 0; i < rendto.size(); i++) {
	    	   numArr[i] = rendto.get(i).getNum()+"";
	       }
// -------------------- NumberFormatException 예외처리 --------------------
	       if(!bookNumText.getText().isEmpty()) {
	    	   if(rentalDto != null) {
	    		   try {
	    			   bookNum = Integer.parseInt(bookNumText.getText());
	    		   }catch(NumberFormatException e){

	    		   }catch (Exception e) {    			  
	    			   CommonService.ErrorMsg("책번호를 제대로 입력해주세요");
	    		   }
	    	   }else {
	    		   CommonService.ErrorMsg("빌리지 않은 책입니다");
	    		   return;
	    	   }
	       }else {
	    	   CommonService.ErrorMsg("책번호를 입력해주세요"); 
	    	   return;
	       }
	       
	        
	       if(newBestDto == null) {
	    	   CommonService.ErrorMsg("없는 책번호 이다");
	    //	   System.out.println("오지마");
	       }else {
	    	   if(memberDto.getBooktotal() < 1) {
	    		   CommonService.ErrorMsg("반납할 책이 없습니다");	    		   
	    	   }else {
	    		   for(int i = 0; i < numArr.length; i++) {
	    			   if(numArr.equals(bookNumText.getText())) {
		    			   CommonService.ErrorMsg("빌린책이 아닙니다");
	    			   }else {
	    				   if(newBestDto.getTotal() >= 3) {
	    					   CommonService.ErrorMsg("빌리지 않은 책입니다.");
	    					   return;
	    				   }else {
	    					  
	    				   }
	    			   }   
	    		   }
		    		   CommonService.InformationMsg("알림", newBestDto.getName() + " 을(를) 반납했습니다");
					   rentalDao.updateBook(newBestDto.getTotal() +1, newBestDto.getName());
					   rentalDao.returnbook(bookNum);
					   memberDao.booktotal(memberDto.getBooktotal()-1, memberDto.getId());
					   bookNumText.clear();   		   
	    	   }
	       }
		}

	
	
}
