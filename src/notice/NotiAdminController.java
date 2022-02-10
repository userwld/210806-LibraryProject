package notice;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;

public class NotiAdminController implements Initializable {
	private NoticeService notiSvc;
	private Parent writeNotice;
	private Parent writeEvent;
	private Parent noticeForm;

	
	public void setWriteNotice(Parent writeNotice) {
		this.writeNotice = writeNotice;
	}
	public void setWriteEvent(Parent writeEvent) {
		this.writeEvent = writeEvent;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		notiSvc = new NoticeServiceImpl();
	}
	
	public void okWriteNotice() {
		notiSvc.okWriteNotice(writeNotice);
		notiSvc.setNoticeList(noticeForm);
		
		CommonService.closeStage(writeNotice);
	}
	
	public void okWriteEvent() {
		notiSvc.okWriteEvent(writeEvent);
		notiSvc.setEventList(noticeForm);
		CommonService.closeStage(writeEvent);
	}
	public void setNoticeForm(Parent noticeForm) {
		this.noticeForm = noticeForm;
		
	}
	
	

}
