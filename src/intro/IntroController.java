package intro;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import intro.service.IntroService;
import intro.service.IntroServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;

public class IntroController implements Initializable{
	private Parent introForm;
	private MainController mainCtrl;
	private IntroService introSvc;
	
	public void setMainCtrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setIntroForm(Parent introForm) {
		this.introForm = introForm;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		introSvc = new IntroServiceImpl();
		
	}
		
	public void clickLogo() {
		CommonService.openStage(mainCtrl.getMainForm());
		CommonService.closeStage(introForm);
	}
	public void openIntroForm() {
		introSvc.openIntroForm(introForm);
	}
	
	public void openIntro2Box() {
		introSvc.openIntro2Box(introForm);
	}
	
	public void openIntro3Box() {
		introSvc.openIntro3Box(introForm);
	}
	
	public void openIntro4Box() {
		introSvc.openIntro4Box(introForm);
	}
	
	public void openNewBestForm() {
		mainCtrl.openNew();
		CommonService.closeStage(introForm);
	}
	public void openNoticeForm() {
		mainCtrl.openNoticeForm();
		CommonService.closeStage(introForm);
	}
	public void openSearchForm() {
		mainCtrl.openSearchForm(introForm);
		CommonService.closeStage(introForm);
	}

	public Parent getIntroForm() {
		return introForm;
	}
	public void openLoginForm() {
		mainCtrl.openLoginForm(introForm);
	}
	public void openJoinForm() {
		mainCtrl.openJoinForm(introForm);
		CommonService.closeStage(introForm);
	}
	public void openPartForm() {
		mainCtrl.openPartForm(introForm);
	}
	
	public void labEntered1() {
		introSvc.labelSizeUp(introForm, "#lab1");
	}
	public void labExited1() {
		introSvc.labelSizeDown(introForm, "#lab1");
	}
	public void labEntered2() {
		introSvc.labelSizeUp(introForm, "#lab2");
	}
	public void labExited2() {
		introSvc.labelSizeDown(introForm, "#lab2");
	}
	public void labEntered3() {
		introSvc.labelSizeUp(introForm, "#lab3");
	}
	public void labExited3() {
		introSvc.labelSizeDown(introForm, "#lab3");
	}
	public void labEntered4() {
		introSvc.labelSizeUp(introForm, "#lab4");
	}
	public void labExited4() {
		introSvc.labelSizeDown(introForm, "#lab4");
	}
	
	
}
