package join;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import join.service.JoinService;
import join.service.JoinServiceImpl;
import login.LoginController;
import main.MainController;

public class JoinController implements Initializable{
	private Parent joinForm;
	private JoinService joinSvc;
	private LoginController loginCtrl;
	private MainController mainCtrl;

// -------------------- 회원가입 --------------------
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		joinSvc = new JoinServiceImpl();
	}
	
	public void setMainCtrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}
	
	public void setLoginCtrl(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
	
	public void setJoinForm(Parent joinForm) {
		this.joinForm = joinForm;	
	} 
	
	public Parent getJoinForm() {
		return joinForm;
	}
	
	public void checkAll1() {
		joinSvc.checkAll1(joinForm);
	}
	public void checkAll2() {
		joinSvc.checkAll2(joinForm);
	}
	
	public void gotoMainProc() {
	      AnchorPane ac = (AnchorPane) joinForm.lookup("#join1");
	      AnchorPane ac2 = (AnchorPane) joinForm.lookup("#join2");
	      CommonService.closeStage(joinForm);
	      joinSvc.checkAll2(joinForm);
	      ac2.setScaleX(0);
	      ac.setScaleX(1);
	      mainCtrl.openMainForm();
	   }
	
	public void gotoJoinProc() {
		joinSvc.gotoJoin2(joinForm);
	}
	
	public void checkAgree() {
		joinSvc.checkAgree(joinForm);
	}

	public void confirmIdProc() {
		joinSvc.confirmIdProc(joinForm);
	}
	
	public void joinButtonProc() {
		joinSvc.joinButtonProc(joinForm, mainCtrl);
	}
	

	
}
