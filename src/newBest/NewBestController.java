package newBest;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;
import main.service.FormServiceImpl;
import newBest.service.NewBestService;
import newBest.service.NewBestServiceImpl;
import preview.PreviewController;


public class NewBestController implements Initializable{
	private Parent newBestForm;
	private MainController mainCtrl;
	private NewBestService bestSvc;
	private FormServiceImpl formSvc = new FormServiceImpl();
	
	
	public void setNewBestForm(Parent newBestForm) {
		this.newBestForm = newBestForm;
	}
	public Parent getNewBestForm() {
		return newBestForm;
	}
	public void setMainctrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bestSvc = new NewBestServiceImpl();
		
	}
	public void clickLogo() {
		mainCtrl.openMainForm();
		CommonService.closeStage(newBestForm);
	}
	public void openResultForm() {
		mainCtrl.openSearchForm(newBestForm);
		CommonService.closeStage(newBestForm);
	}
	public void labEntered1() {
		bestSvc.labSizeUp(newBestForm, "#labelsize1");
	}
	public void labExited1() {
		bestSvc.labSizeDown(newBestForm, "#labelsize1");
	}
		
	public void labEntered2() {
		bestSvc.labSizeUp(newBestForm, "#labelsize2");
	}
	
	public void labExited2() {
		bestSvc.labSizeDown(newBestForm, "#labelsize2");
	}
	
	public void labEntered3() {
		bestSvc.labSizeUp(newBestForm, "#labelsize3");
	}
	public void labExited3() {
		bestSvc.labSizeDown(newBestForm, "#labelsize3");
		
	}

	public void openNoticeForm() {
		mainCtrl.openNoticeForm();
		CommonService.closeStage(newBestForm);
	}
	public void openIntroForm() {
		mainCtrl.openIntroForm();
		CommonService.closeStage(newBestForm);
	}

	public void openLoginForm() {
		mainCtrl.openLoginForm(newBestForm);
	}
	public void openJoinForm() {
		mainCtrl.openJoinForm(newBestForm);
		CommonService.closeStage(newBestForm);
	}
	public void openPartForm() {
		mainCtrl.openPartForm(newBestForm);
	}
	
	public void newBestOnmouseClick3() {
		bestSvc.newBestSizeup(newBestForm);
		CommonService.openStage(newBestForm);
	}
	
	public void newBestSet() {
		bestSvc.newBestSizeup(newBestForm);
	}

	public void inBestOnmouseClick1() {
		bestSvc.inBestSizeup(newBestForm);
	}

	public void outBestOnmouseClick2() {
		bestSvc.outBestSizeUp(newBestForm);

	}
    public void bookInfo () {	
    	PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
     	bestSvc.bookInfo(newBestForm,preCtrl,"#title1");
    }	
    
    public void bookInfo1 () {
    	PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
     	bestSvc.bookInfo(newBestForm,preCtrl,"#title2"); 
    
    }
    public void bookInfo2 () {
    	PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
     	bestSvc.bookInfo(newBestForm,preCtrl,"#title3");
    }
    
    public void bookInfo3 () {
    	PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
     	bestSvc.bookInfo(newBestForm,preCtrl,"#title4");
    }
}