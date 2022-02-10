package main;

import java.net.URL;
import java.util.ResourceBundle;
import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.service.MainService;
import main.service.MainServiceImpl;
import main.service.OpenService;
import main.service.OpenServiceImpl;
import main.service.FormService;
import main.service.FormServiceImpl;
import main.service.SetViewService;
import main.service.SetViewServiceImpl;

public class MainController implements Initializable{
	private Parent mainForm;
	private MainService mainSvc;
	private SetViewService setSvc;
	private FormService formSvc;
	private OpenService openSvc;
			
	public void setMainForm(Parent mainForm) {
		setMainView(mainForm, this);
		this.mainForm = mainForm;
	}
	
	public void setMainView(Parent mainForm, MainController mainCtrl) {
		setSvc.setChart(mainForm);
		setSvc.setListView(mainForm, mainCtrl, formSvc);
		setSvc.setMoreButton(mainForm);
		setSvc.setNewBest(mainForm);
	}
	
	public Parent getMainForm() { return this.mainForm; }	
	public MainController getMainCtrl() { return this; }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainSvc = new MainServiceImpl();					// event기능(버튼등)
		setSvc = new SetViewServiceImpl();					// form화면(view)기본 셋팅기능(dao호출하는부분)
		formSvc = new FormServiceImpl();					// 로드하고 컨트롤러 혹은 폼 반환해주는 기능
		openSvc = new OpenServiceImpl(formSvc,this,setSvc);	// 검증하고 여는기능
	}
		
	public void openViewBox() {
		mainSvc.openViewBox(mainForm);
	}
	public void closeViewBox() {
		mainSvc.closeViewBox(mainForm);
	}
	public void showMoreLabel() {
		mainSvc.showMoreLabel(mainForm);
	}
	public void exitMoreLabel() {
		mainSvc.exitMoreLabel(mainForm);
	}
	public void sizeUpImage1() {
		mainSvc.sizeUpImage(mainForm,"#newImage1");
		mainSvc.moveInfoImage(mainForm,"#newImage1","/img/word2.png");
	}
	public void sizeDownImage1() {
		mainSvc.sizeDownImage(mainForm,"#newImage1");
		setSvc.setNewBest(mainForm);
	}
	public void sizeUpImage2() {
		mainSvc.sizeUpImage(mainForm,"#newImage2");
		mainSvc.moveInfoImage(mainForm,"#newImage2","/img/word2.png");
	}
	public void sizeDownImage2() {
		mainSvc.sizeDownImage(mainForm,"#newImage2");
		setSvc.setNewBest(mainForm);
	}
	public void sizeUpImage3() {
		mainSvc.sizeUpImage(mainForm,"#newImage3");
		mainSvc.moveInfoImage(mainForm,"#newImage3","/img/word2.png");
	}
	public void sizeDownImage3() {
		mainSvc.sizeDownImage(mainForm,"#newImage3");
		setSvc.setNewBest(mainForm);
	}
	public void sizeUpImage4() {
		mainSvc.sizeUpImage(mainForm,"#newImage4");
		mainSvc.moveInfoImage(mainForm,"#newImage4","/img/word2.png");
	}
	public void sizeDownImage4() {
		mainSvc.sizeDownImage(mainForm,"#newImage4");
		setSvc.setNewBest(mainForm);
	}

	public void showChart() {
		mainSvc.showChart(mainForm);
	}
	
	public void openMainForm() {
		CommonService.openStage(mainForm);
	}
		
	public void openLoginForm() {
		openSvc.openLogin(mainForm);
	}
	public void openLoginForm(Parent form) {
		openSvc.openLogin(form);
	}

	public void openJoinForm() {
		openSvc.openJoin(mainForm);
	}
	public void openJoinForm(Parent form) {
		openSvc.openJoin(form);
	}
	
	public void openSearchForm() {
		openSvc.openSearch(mainForm);
	}
	
	public void openSearchForm(Parent form) {
		openSvc.openSearch(form);
	}

	public void openNewBestForm() {
		openSvc.openNewBest(mainForm);
	}

	public void openIntroForm() {
		openSvc.openIntro(mainForm);	
	}
	public void openNoticeForm() {
		openSvc.openNotice(mainForm);
	}
	public void openBookPageForm() {
		openSvc.openBookPage();
	}
	public void openNotiPage() {
		openSvc.openNotiPage();
	}

	public void openRule() {
		openSvc.openRule(mainForm);
	}
	
	public void openInterior() {
		openSvc.openInterior(mainForm);
	}
	
	public void openRoot() {
		openSvc.openRoot(mainForm);
	}
	
	public void openEvent() {
		openSvc.openEvent(mainForm);
	}
	
	public void openEventPage() {
		openSvc.openEventPage();
	}
	
	public void openNew() {
		openSvc.openNew(mainForm);
	}
	
	public void openBest1() {
		openSvc.openBest1(mainForm);
	}
	public void openBest2() {
		openSvc.openBest2(mainForm);
	}

	public void openPreview1() {
		openSvc.openPreview1(setSvc);
	}	
	public void openPreview2() {
		openSvc.openPreview2(setSvc);
	}
	public void openPreview3() {
		openSvc.openPreview3(setSvc);
	}
	public void openPreview4() {
		openSvc.openPreview4(setSvc);
	}
	
	public void openPartForm() {
		openSvc.openPart(mainForm);
	}
	
	public void openPartForm(Parent form) {
		openSvc.openPart(form, mainForm);
	}
	public void openNewList() {
		setSvc.setListUpdate(mainForm);
	}
	public void setChart() {
		setSvc.setChartClear(mainForm);
		setSvc.setChart(mainForm);
	}
	


}
