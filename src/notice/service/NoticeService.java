package notice.service;

import javafx.scene.Parent;

public interface NoticeService {
	
	void openEventBox(Parent noticeForm);
	
	void openNoticeBox(Parent noticeForm);

	void setNoticeList(Parent noticeForm);

	Parent notiPage(Parent noticeForm, Parent notiPageForm, String t);

	Parent eventPage(Parent noticeForm, Parent eventPageForm, String t);

	void labelSizeUp(Parent noticeForm, String labelName);
	
	void labelSizeDown(Parent noticeForm, String labelName);

	void setEventList(Parent noticeForm);
	
	Parent noticeButton(Parent noticeForm);
	
	Parent eventButton(Parent noticeForm);
	
	void okWriteNotice(Parent writeNotice);
	
	void okWriteEvent(Parent writeEvent);
	
}
