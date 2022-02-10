package participate;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;
import participate.service.PartService;
import participate.service.PartServiceImpl;

public class PartController implements Initializable{
	private Parent partForm;
	private MainController mainCtrl;
	private PartService partSvc;
	
	public void setMainCtrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setPartForm(Parent partForm) {
		this.partForm = partForm;
	}
	public Parent getPartForm() {
		return partForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		partSvc = new PartServiceImpl();
		
	}
	
	public void clickLogo() {
		CommonService.openStage(mainCtrl.getMainForm());
		CommonService.closeStage(partForm);
	}

	
	public void openNewBestForm() {
		mainCtrl.openNew();
		CommonService.closeStage(partForm);
	}
	public void openNoticeForm() {
		mainCtrl.openNoticeForm();
		CommonService.closeStage(partForm);
	}
	public void openIntroForm() {
		mainCtrl.openIntroForm();
		CommonService.closeStage(partForm);	
	}
	public void openSearchForm() {
		mainCtrl.openSearchForm(partForm);
		CommonService.closeStage(partForm);
	}
	public void openLoginForm() {
		mainCtrl.openLoginForm(partForm);
	}
	public void openJoinForm() {
		mainCtrl.openJoinForm(partForm);
		CommonService.closeStage(partForm);
	}
	
	public void inputLike() {
		partSvc.inputLike(partForm);
	}
	public void cancelLike() {
		partSvc.cancelLike(partForm);
	}
	public void setMyLike() {
		partSvc.setMyLike(partForm);
	}
	public void revInsert() {
		partSvc.setRevInsert(partForm);
	}
	public void viewReview() {
		partSvc.viewReview(partForm);
	}
	
	
	

}
