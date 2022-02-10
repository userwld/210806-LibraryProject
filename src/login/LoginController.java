package login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import find.FindController;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import login.service.LoginService;
import login.service.LoginServiceImpl;
import main.MainController;

public class LoginController implements Initializable{
	private Parent loginForm;
	private LoginService loginSvc;
	private MainController mainCtrl;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginSvc = new LoginServiceImpl(); 		
	}

	public void setMainController(MainController mainController) {
		this.mainCtrl = mainController;
	}

	public void setLoginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}
	public Parent getLoginForm() {
		// TODO Auto-generated method stub
		return loginForm;
	}
	
// -------------------- 로그인 버튼 --------------------  
	public void LoginProc() {
	  boolean flag = loginSvc.LoginProc(loginForm);
     	if(flag == true) {
        Parent mainForm = mainCtrl.getMainForm();
	        Label loginLabel = (Label) mainForm.lookup("#loginLabel");
	        Label registerLabel = (Label) mainForm.lookup("#registerLabel");
	        
	        TextField idText = (TextField)loginForm.lookup("#idText");
	        PasswordField pwText = (PasswordField)loginForm.lookup("#pwText");
	        
	        if(idText.getText().equals("admin") && pwText.getText().equals("1234")) {
	           loginLabel.setText(idText.getText() + "님 로그아웃");
	           registerLabel.setText("관리자페이지");
	        }else {
	           loginLabel.setText(idText.getText() + "님 로그아웃");
	           registerLabel.setText("회원정보");      
	        }  
	        CommonService.closeStage(loginForm);
	        mainCtrl.openMainForm();   
	     }
	}
	
// -------------------- 메인가는 버튼 --------------------	
	public void gotoMainProc() {
		 CommonService.closeStage(loginForm);
		 mainCtrl.openMainForm();	
	}
	
// -------------------- 아이디, 비밀번호 찾는 씬으로 --------------------	
	public void findPwProc() {
		 loginSvc.findPwProc(this);
		
	}
	
// -------------------- 로그인 하는 씬으로 --------------------	
	public void openLoginForm() {
		CommonService.openStage(loginForm);
	}

	
	
}
