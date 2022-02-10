package notice;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;
import main.service.FormServiceImpl;
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;

public class NoticeController implements Initializable{
	private Parent noticeForm;
	private Parent notiPageForm;
	private Parent eventPageForm;
	private MainController mainCtrl;
	private NoticeService noticeSvc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noticeSvc = new NoticeServiceImpl();
		
	}
	
	public void setMainCtrl(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setNoticeForm(Parent noticeForm) {
		this.noticeForm = noticeForm;
	}
	public Parent getNotiForm() {
		return noticeForm;
	}

	public void setNotipageForm(Parent notiPageForm) {
		this.notiPageForm = notiPageForm;
		
	}
	public void setEventpageForm(Parent eventPageForm) {
		this.eventPageForm = eventPageForm;
		
	}
	public Parent getNoticeForm() {
		return noticeForm;
	}
	
	public void clickLogo() {
		CommonService.openStage(mainCtrl.getMainForm());
		CommonService.closeStage(noticeForm);
	}
	
	public void openNoticeBox() {
		noticeSvc.openNoticeBox(noticeForm);
		noticeSvc.setNoticeList(noticeForm);
	}
	public void setEventBox() {
		noticeSvc.openEventBox(noticeForm);
		noticeSvc.setEventList(noticeForm);
	}
	
	public void openEventBox() {
		noticeSvc.openEventBox(noticeForm);
		noticeSvc.setEventList(noticeForm);
		CommonService.openStage(noticeForm);
	}
	
	public void openNotiPage1() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t1");
		CommonService.newStage(form);
		
	}
	public void openNotiPage2() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t2");
		CommonService.newStage(form);
	}
	public void openNotiPage3() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t3");
		CommonService.newStage(form);
		
	}
	public void openNotiPage4() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t4");
		CommonService.newStage(form);
		
	}
	public void openNotiPage5() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t5");
		CommonService.newStage(form);
		
	}
	public void openNotiPage6() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t6");
		CommonService.newStage(form);
		
	}
	public void openNotiPage7() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t7");
		CommonService.newStage(form);
		
	}
	public void openNotiPage8() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t8");
		CommonService.newStage(form);
		
	}
	public void openNotiPage9() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t9");
		CommonService.newStage(form);
	}
	public void openNotiPage10() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t10");
		CommonService.newStage(form);
		
	}
	public void openNotiPage11() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t11");
		CommonService.newStage(form);
		
	}
	public void openNotiPage12() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t12");
		CommonService.newStage(form);
		
	}
	public void openNotiPage13() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t13");
		CommonService.newStage(form);
		
	}
	public void openNotiPage14() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.notiPageForm = formSvc.openNotiPage(mainCtrl);
		Parent form = noticeSvc.notiPage(noticeForm, notiPageForm, "#t14");
		CommonService.newStage(form);
		
	}
	
	public void openEventPage1() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.eventPageForm = formSvc.openEventPage(mainCtrl);
		Parent form = noticeSvc.eventPage(noticeForm, eventPageForm, "#e1");
		CommonService.newStage(form);
		
	}
	public void openEventPage2() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.eventPageForm = formSvc.openEventPage(mainCtrl);
		Parent form = noticeSvc.eventPage(noticeForm, eventPageForm, "#e2");
		CommonService.newStage(form);
		
	}
	public void openEventPage3() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.eventPageForm = formSvc.openEventPage(mainCtrl);
		Parent form = noticeSvc.eventPage(noticeForm, eventPageForm, "#e3");
		CommonService.newStage(form);
		
	}
	public void openEventPage4() {
		FormServiceImpl formSvc = new FormServiceImpl();
		this.eventPageForm = formSvc.openEventPage(mainCtrl);
		Parent form = noticeSvc.eventPage(noticeForm, eventPageForm, "#e4");
		CommonService.newStage(form);
		
	}
	
	public void openNotiPage() {
		mainCtrl.openNotiPage();
	}
	public void openEventPage() {
		mainCtrl.openEventPage();
	}
	public void openNewBestForm() {
		mainCtrl.openNew();
		CommonService.closeStage(noticeForm);
	}
	public void openSearchForm() {
		mainCtrl.openSearchForm(noticeForm);
		CommonService.closeStage(noticeForm);
	}
	public void openIntroForm() {
		mainCtrl.openIntroForm();
		CommonService.closeStage(noticeForm);
		
	}
	public void openPartForm() {
		mainCtrl.openPartForm(noticeForm);
	}
	public void setNoticeList() {
		noticeSvc.setNoticeList(noticeForm);
	}
	public void setEventList() {
		noticeSvc.setEventList(noticeForm);
	}

	public void openLoginForm() {
		mainCtrl.openLoginForm(noticeForm);
	}
	public void openJoinForm() {
		mainCtrl.openJoinForm(noticeForm);
		CommonService.closeStage(noticeForm);
	}
	
	public void labNoticeEntered() {
		noticeSvc.labelSizeUp(noticeForm, "#labNotice");
	}
	public void labNoticeExited() {
		noticeSvc.labelSizeDown(noticeForm, "#labNotice");
	}
	public void labEventEntered() {
		noticeSvc.labelSizeUp(noticeForm, "#labEvent");
	}
	public void labEventExited() {
		noticeSvc.labelSizeDown(noticeForm, "#labEvent");
	}
	public void noticeButton() {
		Parent writeNotice = noticeSvc.noticeButton(noticeForm);
		NotiAdminController notiAdCtrl = new NotiAdminController();

		CommonService.newStage(writeNotice);
	}
	
	public void eventButton() {
		Parent writeEvent = noticeSvc.eventButton(noticeForm);
		CommonService.newStage(writeEvent);
	}
	
	
	public void imgProc() {
		
	}

}
