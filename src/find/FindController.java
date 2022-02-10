package find;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import find.service.FindService;
import find.service.FindServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import login.LoginController;
import main.MainController;

public class FindController implements Initializable{
	private Parent findForm;
	private FindService findSvc;
	private LoginController loginCtrl;
	private MainController mainCtrl;
	
// -------------------- 아이디, 비밀번호 찾기 --------------------	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findSvc = new FindServiceImpl();	
	}
	
	public void setFindForm(Parent findForm) {
		this.findForm = findForm;
	}
		
	public void setMainCtrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setLoginController(LoginController loginController) {
		this.loginCtrl = loginController;
	}
	
	public void findIdProc() {
		findSvc.findIdProc(findForm);	
	}
	
	public void findPwProc() {
		findSvc.findPwProc(findForm);
		
	}
	
	public void gotoLoginProc() {
		CommonService.closeStage(findForm);
	}
	
}
