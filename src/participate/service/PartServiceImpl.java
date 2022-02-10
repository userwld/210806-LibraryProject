package participate.service;

import java.util.ArrayList;

import allDAO.PartDAO;
import allDTO.LikeDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.service.SetViewServiceImpl;

public class PartServiceImpl implements PartService{
	private PartDAO dao;
	private SetViewServiceImpl setSvc;
	
	public PartServiceImpl() {
		dao = new PartDAO();
		setSvc = new SetViewServiceImpl();
	}

	@Override
	public void inputLike(Parent partForm) {
		
		String[] split = getSource(partForm,"#allBookCombo1");
		
		Label idLabel = (Label)partForm.lookup("#loginLabel");
		String id = idLabel.getText().substring(0, idLabel.getText().length()-6);

		ArrayList<LikeDTO> alreadyLike = dao.likeBook(id);
		
		boolean check = alreadyCheck(alreadyLike,partForm,split[0]);
		
		if(check) {
			if(alreadyLike.size() >= 5) {
				CommonService.ErrorMsg("좋아요는 다섯권까지만 가능합니다.");
			}else {
				if(split[0] != null) {
					dao.insertLike(split[0],split[1],id);
					CommonService.InformationMsg("좋아요", "좋아요한 책에 추가되었습니다.");
					setSvc.myLikeBook(partForm);
				}else {
					CommonService.ErrorMsg("책을 선택해주세요");
				}
			}
		}else {
			CommonService.ErrorMsg("이미 좋아요를 누른 책입니다.");
		}
	}
	

	@Override
	public void cancelLike(Parent partForm) {
		String[] split = getSource(partForm,"#allBookCombo1");
		
		Label idLabel = (Label)partForm.lookup("#loginLabel");
		String id = idLabel.getText().substring(0, idLabel.getText().length()-6);

		ArrayList<LikeDTO> alreadyLike = dao.likeBook(id);
		
		boolean check = alreadyCheck(alreadyLike,partForm,split[0]);
		if(check == false) {
			dao.cancelLike(split[0],split[1],id);
			CommonService.InformationMsg("취소", "좋아요가 취소되었습니다.");
			setSvc.myLikeBook(partForm);
		}else {
			CommonService.ErrorMsg("좋아요 누른책이 아닙니다!");
		}

	}
	
	@Override
	public void setRevInsert(Parent partForm) {
		String[] split = getSource(partForm,"#allBookCombo2");
		
		Label idLabel = (Label)partForm.lookup("#loginLabel");
		String id = idLabel.getText().substring(0, idLabel.getText().length()-6);
		
		TextField revField = (TextField)partForm.lookup("#revField");
		String check = "";
		if(split[0] != null) {
			check = dao.revBook(id,split[0]);
		}
		
		
		if(revField.getText().isEmpty()) {
			CommonService.ErrorMsg("리뷰를 입력 후 클릭해주세요");
			return;
		}
		
		if(!check.equals("")) {
			dao.updateReview(id,split[0],revField.getText());
			CommonService.InformationMsg("리뷰등록", "리뷰가 수정되었습니다.");
		}else {
			if(split[0] == null) {
				CommonService.ErrorMsg("리뷰 남길 책을 선택해주세요!");
			}else {
				dao.newReview(id,split[0],revField.getText());
				CommonService.InformationMsg("리뷰등록", "새로운 리뷰가 등록되었습니다.");
			}
		}
		
		revField.clear();
	}
	

	@Override
	public void viewReview(Parent partForm) {
		String[] split = getSource(partForm,"#allBookCombo2");
			
		Label idLabel = (Label)partForm.lookup("#loginLabel");
		String id = idLabel.getText().substring(0, idLabel.getText().length()-6);
		
		Label viewRevLabel = (Label)partForm.lookup("#viewRevLabel");
		
		String check = "";
		if(split[0] != null) {
			check = dao.revBook(id,split[0]);
		}
		
		if(check.equals("")) {
			viewRevLabel.setText("아직 등록된 리뷰가 없습니다.");
		}else {
			viewRevLabel.setText(check);
		}
		
	}


	private String[] getSource(Parent partForm, String comboBox) {
		ComboBox<String>allBookCombo1 = (ComboBox<String>)partForm.lookup(comboBox);
		
		String[] split = new String[2];
		if(allBookCombo1.getValue() != null) {
			split = allBookCombo1.getValue().split(", "); }
		
		return split;
	}

	private boolean alreadyCheck(ArrayList<LikeDTO> alreadyLike, Parent partForm, String book) {
		
		if(!alreadyLike.isEmpty()) {
			for(int i = 0; i < alreadyLike.size(); i++) {
				if(alreadyLike.get(i).getBook().equals(book)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void setMyLike(Parent partForm) {
		setSvc.myLikeBook(partForm);
	}

	

}
