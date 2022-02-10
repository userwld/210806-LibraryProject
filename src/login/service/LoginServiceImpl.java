package login.service;

import java.io.IOException;

import allDAO.MemberDAO;
import allDTO.MemberDTO;
import common.CommonService;
import find.FindController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.LoginController;
import main.MainController;
import main.service.FormServiceImpl;
import memberInfo.MemberInfoController;

public class LoginServiceImpl implements LoginService{
	private static MemberDAO memberDao = new MemberDAO();

// -------------------- 로그인 메서드 --------------------	
	@Override
	public boolean LoginProc(Parent loginForm) {	
		TextField idText = (TextField) loginForm.lookup("#idText");
		PasswordField pwText = (PasswordField) loginForm.lookup("#pwText");
		MemberDTO memberDto = memberDao.selectId(idText.getText());
			
		if(idText.getText().isEmpty() || pwText.getText().isEmpty()) {
			CommonService.ErrorMsg("아이디와 비밀번호를 모두 입력해주세요");
		}else {
			if(memberDto == null) {
				CommonService.ErrorMsg("로그인 실패");
				return false;
			}else if(!memberDto.getPw().equals(pwText.getText())){
				CommonService.ErrorMsg("로그인 실패");
				return false;
			}else {
				CommonService.InformationMsg("로그인성공", memberDto.getName() + "님 환영합니다");
				return true;	
			}
		}
		return false;
	}
	
// -------------------- 아이디, 비번 찾는 씬 setController --------------------	
	public void findPwProc(LoginController loginController) {
		FindController findCtrl = new FindController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/find/FindForm.fxml"));
		loader.setController(findCtrl);
		Parent findForm = null;
		
		try {
			findForm = loader.load();
			findCtrl.setFindForm(findForm);
			findCtrl.setLoginController(loginController);
			addCombo(findForm);
			CommonService.newStage(findForm);
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

// -------------------- 비밀번호 힌트 등록해서 넘겨줌 --------------------
	public void addCombo(Parent findForm) {
		ComboBox<String> hint = (ComboBox)findForm.lookup("#pwHintCombo");
		String[] hintcombo = {"출신 초등학교","출생지","좋아하는 음식"};
		for(int i = 0; i <= 2; i++) {
			hint.getItems().add(hintcombo[i]);
		}	
	}
	
	
	
	
	
	
	
}
