package find.service;

import allDAO.MemberDAO;
import allDTO.MemberDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class FindServiceImpl implements FindService{
	private static MemberDAO memberDao = new MemberDAO();

// -------------------- 아이디찾기 메서드 --------------------
	@Override
	public void findIdProc(Parent findForm) {
		TextField nameText = (TextField) findForm.lookup("#nameText");
		TextField phone1Text = (TextField) findForm.lookup("#phone1Text");
		MemberDTO memberDto =  memberDao.selectName(nameText.getText());
		if(nameText.getText().isEmpty() || phone1Text.getText().isEmpty()) {
			CommonService.ErrorMsg("이름과 전화번호 모두 입력해주세요");
		}else { 
			if(memberDto == null) {
				CommonService.ErrorMsg("이름 또는 전화번호의 정보가 올바르지 않습니다");
			}else if(!memberDto.getPhone().equals(phone1Text.getText())){
				CommonService.ErrorMsg("이름 또는 전화번호의 정보가 올바르지 않습니다");
			}else {
				CommonService.InformationMsg("아이디 정보", memberDto.getId());
			}
		}
	}
	
// -------------------- 비밀번호 찾기 메서드 --------------------	
	public void findPwProc(Parent findForm) {
		TextField idText = (TextField) findForm.lookup("#idText");
		TextField phone2Text = (TextField) findForm.lookup("#phone2Text");
		ComboBox<String> hintCombo = (ComboBox<String>) findForm.lookup("#pwHintCombo");
		TextField hintText = (TextField) findForm.lookup("#hintText");
		MemberDTO memberDto =  memberDao.selectId(idText.getText());
		if(idText.getText().isEmpty() || phone2Text.getText().isEmpty() ||
			hintCombo.getValue() == null || hintText.getText().isEmpty()) {
			CommonService.ErrorMsg("작성되지 않은 항목이있습니다");
		}else {
			if(memberDto == null) {
				CommonService.ErrorMsg("올바르지 않은 항목이있습니다");
			}else if(!memberDto.getPhone().equals(phone2Text.getText()) || !memberDto.getHintCombo().equals(hintCombo.getValue())
					|| !memberDto.getHint().equals(hintText.getText())){
				CommonService.ErrorMsg("올바르지 않은 항목이있습니다");
			}else {
				CommonService.InformationMsg("패스워드 정보", memberDto.getPw());				
			}
		}
	}


		
	

		
	
}
