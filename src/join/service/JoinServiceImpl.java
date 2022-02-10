package join.service;



import allDAO.MemberDAO;
import allDTO.MemberDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import join.JoinController;
import main.MainController;

public class JoinServiceImpl implements JoinService{
	private static MemberDAO memberDao = new MemberDAO();
	int cnt = 0;
	
// -------------------- 회원가입 가는 창 --------------------	
	@Override
	public void gotoJoin2(Parent joinForm) {
		AnchorPane ac = (AnchorPane) joinForm.lookup("#join1");
		AnchorPane ac2 = (AnchorPane) joinForm.lookup("#join2");
		CheckBox ch1 = (CheckBox) joinForm.lookup("#check1");
		CheckBox ch2 = (CheckBox) joinForm.lookup("#check2");
	
		if(ch1.isSelected() && ch2.isSelected()) {
			ac.setScaleX(0);
			ac2.setScaleX(1);				
		}else {
			CommonService.ErrorMsg("동의란을 확인해주세요");
		}
			
	}
// -------------------- 체크박스 모두동의 해야 넘어갈수 있음 --------------------	
	@Override
	public void checkAll1(Parent joinForm) {
		CheckBox chAll1 = (CheckBox) joinForm.lookup("#checkAll0");
		CheckBox chAll2 = (CheckBox) joinForm.lookup("#checkAll00");
		CheckBox ch1 = (CheckBox) joinForm.lookup("#check1");
		CheckBox ch2 = (CheckBox) joinForm.lookup("#check2");
		
		if(ch1.isSelected() == true || ch2.isSelected() == true) {
			chAll1.setSelected(false);
			chAll1.setScaleX(0);
			chAll2.setSelected(true);
			chAll2.setScaleX(1);
			ch1.setSelected(true);
			ch2.setSelected(true);
		}	
		chAll1.setScaleX(0);
		chAll2.setScaleX(1);
		chAll2.setSelected(true);
		chAll1.setSelected(false);
		ch1.setSelected(true);
		ch2.setSelected(true);			
	}
	
	public void checkAll2(Parent joinForm) {
		CheckBox chAll1 = (CheckBox) joinForm.lookup("#checkAll0");
		CheckBox chAll2 = (CheckBox) joinForm.lookup("#checkAll00");
		CheckBox ch1 = (CheckBox) joinForm.lookup("#check1");
		CheckBox ch2 = (CheckBox) joinForm.lookup("#check2");

		chAll2.setScaleX(0);
		chAll1.setScaleX(1);
		chAll2.setSelected(false);
		
		ch1.setSelected(false);
		ch2.setSelected(false);
	}
		
	@Override
	public void checkAgree(Parent joinForm) {
		CheckBox chAll1 = (CheckBox) joinForm.lookup("#checkAll0");
		CheckBox chAll2 = (CheckBox) joinForm.lookup("#checkAll00");
		
			chAll1.setSelected(false);
			chAll2.setSelected(false);
			chAll2.setScaleX(0);
			chAll1.setScaleX(1);		
		}

// -------------------- 회원가입 메서드 --------------------	
	 @Override
	  public void joinButtonProc(Parent joinForm, MainController mainCtrl) {
	  TextField idText = (TextField) joinForm.lookup("#idText");
	  PasswordField pwText = (PasswordField) joinForm.lookup("#pwText");
	  PasswordField pwComfirmText = (PasswordField) joinForm.lookup("#pwConfirmText");
	  TextField nameText = (TextField) joinForm.lookup("#nameText");
	  ComboBox<String> yearCombo = (ComboBox<String>) joinForm.lookup("#yearCombo");
	  ComboBox<String> monthCombo = (ComboBox<String>) joinForm.lookup("#monthCombo");
	  ComboBox<String> dayCombo = (ComboBox<String>) joinForm.lookup("#dayCombo");
	  RadioButton genderM = (RadioButton) joinForm.lookup("#genderM");
	  RadioButton genderF = (RadioButton) joinForm.lookup("#genderF");
	  TextField phoneText = (TextField) joinForm.lookup("#phoneText");
	  ComboBox<String> pwHintCombo = (ComboBox<String>) joinForm.lookup("#pwHintCombo");
	  TextField pwHintText = (TextField) joinForm.lookup("#pwHintText");
	  ComboBox<String> genre = (ComboBox<String>) joinForm.lookup("#genreCombo");
	  Label mes = (Label) joinForm.lookup("#comfirmMes");
	  AnchorPane ac = (AnchorPane) joinForm.lookup("#join1");
	  AnchorPane ac2 = (AnchorPane) joinForm.lookup("#join2");

	
	  String gender = "";
	  if(genderM.isSelected()) {
	     gender = "남자";
	  }else {
	     gender = "여자";
	  }
	  
	  MemberDTO memberDto = new MemberDTO();
	  if(cnt == 0) {
	     CommonService.ErrorMsg("중복확인해주세요");
	  }else {   
	     if(idText.getText().isEmpty() || pwText.getText().isEmpty() || pwComfirmText.getText().isEmpty() ||
	        nameText.getText().isEmpty() || yearCombo.getValue() == null || monthCombo.getValue() == null ||
	        dayCombo.getValue() == null || phoneText.getText().isEmpty() || pwHintCombo.getValue() ==null
	        || pwHintText.getText().isEmpty() || genre.getValue() == null) {
	        
	        CommonService.ErrorMsg("작성되지 않은 빈칸이 존재합니다");
		 }else {
		    if(!pwText.getText().equals(pwComfirmText.getText())) {
		       CommonService.ErrorMsg("비밀번호 확인");
		    
		    }else {
		       if(idText.getText().length() > 20 || pwText.getText().length() > 20 ||
		          pwComfirmText.getText().length() > 20) {
		          CommonService.ErrorMsg("아이디와 비밀번호는 최대 20자리까지 가능합니다");
		       }else {
		          if(phoneText.getText().length() > 11 || phoneText.getText().length() < 11 || !phoneText.getText().substring(0,3).equals("010")) {
		             CommonService.ErrorMsg("핸드폰번호를 확인해주세요");
		          }else {
		        	  for(int i = 0; i < phoneText.getText().length();i++){
	                         if(phoneText.getText().charAt(i) < '0' || phoneText.getText().charAt(i) > '9') {
	                            CommonService.ErrorMsg("핸드폰번호를 확인해주세요2");
	                          return;
	                        }
		        	  }     
		             if(confirmIdProc(joinForm)) {
		                memberDto.setId(idText.getText());         	 memberDto.setPw(pwText.getText()); 
		                memberDto.setName(nameText.getText());         memberDto.setYear(yearCombo.getValue());
		                memberDto.setMonth(monthCombo.getValue());   memberDto.setDay(dayCombo.getValue());
		                memberDto.setGender(gender);               memberDto.setPhone(phoneText.getText());
		                memberDto.setHintCombo(pwHintCombo.getValue()); memberDto.setHint(pwHintText.getText());
		                memberDto.setGenre(genre.getValue());
		                CommonService.InformationMsg("회원가입완료", "환영합니다");
		                memberDao.insert(memberDto);
		                idText.clear(); pwText.clear(); nameText.clear(); yearCombo.setValue(null); monthCombo.setValue(null); dayCombo.setValue(null); 
		                phoneText.clear(); pwHintCombo.setValue(null); pwHintText.clear(); genre.setValue(null); pwComfirmText.clear();
		                mes.setText("");
		                CommonService.closeStage(joinForm);
		                ac.setScaleX(1); ac2.setScaleX(0);
		                checkAll2(joinForm);
		                mainCtrl.setChart();
		                mainCtrl.openMainForm();
		                
	                    }
	                 }
	              }
	           }
	        }
	     }         
	}

// -------------------- 중복확인 메서드 --------------------	 
	 @Override
	 public boolean confirmIdProc(Parent joinForm) {
	    cnt = 1;
	    TextField idText = (TextField) joinForm.lookup("#idText");
	    Label mes = (Label) joinForm.lookup("#comfirmMes");
		MemberDTO memberDto = memberDao.selectId(idText.getText());
		
		if(idText.getText().isEmpty()) {
		   CommonService.ErrorMsg("아이디를 입력해주세요");
		}else {
		   if(memberDto != null) {
		      mes.setText("중복된 아이디입니다.");
		   }else {
		    	mes.setText("사용가능한 아이디입니다.");
		          return true;
		       }
		    }
		    return false;
	 	}
	 
	 
	 
	}
 