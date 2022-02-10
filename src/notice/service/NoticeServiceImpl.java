package notice.service;

import java.util.ArrayList;

import allDAO.EventDAO;
import allDAO.NoticeDAO;
import allDTO.EventDTO;
import allDTO.NoticeDTO;
import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.MainController;
import main.service.FormService;
import notice.NotiAdminController;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDAO noticeDao = new NoticeDAO();
	private EventDAO eventDao = new EventDAO();
	NoticeService noticeSvc;
	FormService formSvc;	MainController mainCtrl;
	//Parent writeNotice;

	public void selectOne(Parent notiPageForm, int num) {
		ArrayList <NoticeDTO> noticeDto = new ArrayList<NoticeDTO>();
		Text title = (Text)notiPageForm.lookup("#titleBox");
		Text name = (Text)notiPageForm.lookup("#nameBox");
		Text day = (Text)notiPageForm.lookup("#dayBox");
		Text text = (Text)notiPageForm.lookup("#textBox");
				
		title.setText(noticeDto.get(num).getTitle());
		name.setText(noticeDto.get(num).getName());
		day.setText(noticeDto.get(num).getDay());
		text.setText(noticeDto.get(num).getText());
		
	}
	
	public void selectEvent(Parent eventPageForm, int num) {
		ArrayList <EventDTO> dto = new ArrayList<EventDTO>();
		Text title = (Text)eventPageForm.lookup("#titleBox");
		Text name = (Text)eventPageForm.lookup("#nameBox");
		Text day = (Text)eventPageForm.lookup("#dayBox");
		Text text = (Text)eventPageForm.lookup("#textBox");
		Text image = (Text)eventPageForm.lookup("#imgBox");
				
		title.setText(dto.get(num).getTitle());
		name.setText(dto.get(num).getName());
		day.setText(dto.get(num).getDay());
		text.setText(dto.get(num).getText());
		image.setText(dto.get(num).getImg());
	}
	
	@Override
	public void openEventBox(Parent noticeForm) {
		VBox eventBox = (VBox)noticeForm.lookup("#eventBox");
		VBox noticeBox = (VBox)noticeForm.lookup("#noticeBox");
		Label registerLabel = (Label)noticeForm.lookup("#registerLabel");
		Button eventWrite = (Button)noticeForm.lookup("#eventWrite");
		eventBox.setScaleY(1);
		noticeBox.setScaleY(0);
		
		if (registerLabel.getText().equals("관리자페이지")) {
			eventWrite.setDisable(false);
		}
	}

	@Override
	public void openNoticeBox(Parent noticeForm) {
		VBox eventBox = (VBox)noticeForm.lookup("#eventBox");
		VBox noticeBox = (VBox)noticeForm.lookup("#noticeBox");
		Label registerLabel = (Label)noticeForm.lookup("#registerLabel");
		Button noticeWrite = (Button)noticeForm.lookup("#noticeWrite");
		eventBox.setScaleY(0);
		noticeBox.setScaleY(1);
		if (registerLabel.getText().equals("관리자페이지")) {
			noticeWrite.setDisable(false);
		}
	}

	public void setNoticeList(Parent noticeForm) {
		
		setNo(noticeForm,"#t1","#na1","#d1",13);
		setNo(noticeForm,"#t2","#na2","#d2",12);
		setNo(noticeForm,"#t3","#na3","#d3",11);
		setNo(noticeForm,"#t4","#na4","#d4",10);
		setNo(noticeForm,"#t5","#na5","#d5",9);
		setNo(noticeForm,"#t6","#na6","#d6",8);
 		setNo(noticeForm,"#t7","#na7","#d7",7);
 		setNo(noticeForm,"#t8","#na8","#d8",6);
 		setNo(noticeForm,"#t9","#na9","#d9",5);
 		setNo(noticeForm,"#t10","#na10","#d10",4);
 		setNo(noticeForm,"#t11","#na11","#d11",3);
 		setNo(noticeForm,"#t12","#na12","#d12",2);
 		setNo(noticeForm,"#t13","#na13","#d13",1);
 		setNo(noticeForm,"#t14","#na14","#d14",0);
	}
	
	
	private void setNo(Parent noticeForm,String t, String n, String d, int i) {
		ArrayList<NoticeDTO> all = noticeDao.selectAll();
		
		Label title = (Label)noticeForm.lookup(t);
		Label name = (Label)noticeForm.lookup(n);
		Label day = (Label)noticeForm.lookup(d);
		title.setText(all.get(i).getTitle());
		name.setText(all.get(i).getName());
		day.setText(all.get(i).getDay());
	}
	public void setEventList(Parent noticeForm) {		
		setNo2(noticeForm,"#e1","#i1",3);
		setNo2(noticeForm,"#e2","#i2",2);
		setNo2(noticeForm,"#e3","#i3",1);
		setNo2(noticeForm,"#e4","#i4",0);
	}
	private void setNo2(Parent noticeForm,String t, String img, int i) {
		ArrayList<EventDTO> all = eventDao.selectAll();
	
		Label title = (Label)noticeForm.lookup(t);
		ImageView image = (ImageView)noticeForm.lookup(img);
		
		title.setText(all.get(i).getTitle());
		Image img1 = new Image(all.get(i).getImg());
		image.setImage(img1);
	}

	public Parent notiPage(Parent noticeForm, Parent notiPageForm, String t) {
		Label titleLabel = (Label)noticeForm.lookup(t);
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO noti = dao.selectOne(titleLabel.getText());
		Text title = (Text)notiPageForm.lookup("#titleBox");
		Text name = (Text)notiPageForm.lookup("#nameBox");
		Text day = (Text)notiPageForm.lookup("#dayBox");
		Text text = (Text)notiPageForm.lookup("#textBox");
		
		title.setText(noti.getTitle());
		name.setText(noti.getName());
		day.setText(noti.getDay());
		text.setText(noti.getText());
		return notiPageForm;
		
	}
// ------------------- notice 폼 내  공지사항 글쓰기 버튼 --------------------	
	public Parent noticeButton(Parent noticeForm) {
		NotiAdminController notiAdCtrl = new NotiAdminController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/notice/writeNotice.fxml"));
		loader.setController(notiAdCtrl);
		Parent writeNotice = null;
		try {
			writeNotice = loader.load();
			notiAdCtrl.setWriteNotice(writeNotice);
			notiAdCtrl.setNoticeForm(noticeForm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeNotice;
	}
// ----------------------- notice 폼 내 이벤트 글쓰기 버튼 ------------------	
	public Parent eventButton(Parent noticeForm) {
		NotiAdminController notiAdCtrl = new NotiAdminController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/notice/writeEvent.fxml"));
		loader.setController(notiAdCtrl);
		Parent writeEvent = null;
		try {
			writeEvent = loader.load();
			notiAdCtrl.setWriteEvent(writeEvent);
			notiAdCtrl.setNoticeForm(noticeForm);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeEvent;
	}

	//---------------------- 등록 버튼(writeNotice 내)--------------------
	public void okWriteNotice(Parent writeNotice) {
		TextField nameText = (TextField) writeNotice.lookup("#nameText");
		TextField titleText = (TextField) writeNotice.lookup("#titleText");
		TextField dayText = (TextField) writeNotice.lookup("#dayText");
		TextArea textText = (TextArea) writeNotice.lookup("#textText");

		NoticeDTO dto = new NoticeDTO();
		

		
		  if (titleText.getText().isEmpty() || nameText.getText().isEmpty() ||
				  dayText.getText().isEmpty() || textText.getText().isEmpty()) {
			  	CommonService.ErrorMsg("작성되지 않은 빈칸이 존재합니다.");
		  }else {
				dto.setTitle(titleText.getText());
				dto.setName(nameText.getText());
				dto.setDay(dayText.getText());
				dto.setText(textText.getText());

				noticeDao.insert(dto);
		  }
			
			//	nameText.clear(); titleText.clear(); dayText.clear(); textText.clear();
				
//		  }
		 
		

	}
	
	//---------------------- 등록 버튼(writeEvent 내)--------------------
	public void okWriteEvent(Parent writeEvent) {
		

		TextField nameText = (TextField) writeEvent.lookup("#nameText");
		TextField titleText = (TextField) writeEvent.lookup("#titleText");
		TextField dayText = (TextField) writeEvent.lookup("#dayText");
		TextField imgText = (TextField) writeEvent.lookup("#imgText");
		TextArea textText = (TextArea) writeEvent.lookup("#textText");

		
		EventDTO dto = new EventDTO();
		
		dto.setTitle(titleText.getText());
		dto.setName(nameText.getText());
		dto.setDay(dayText.getText());
		dto.setText(textText.getText());
		dto.setImg(imgText.getText());

		eventDao.insert(dto);
		
	}


	public Parent eventPage(Parent noticeForm, Parent eventPageForm, String t) {
		Label titleLabel = (Label)noticeForm.lookup(t);
		EventDAO dao = new EventDAO();
		EventDTO event = dao.selectOne(titleLabel.getText());
		Text title = (Text)eventPageForm.lookup("#titleBox");
		Text name = (Text)eventPageForm.lookup("#nameBox");
		Text day = (Text)eventPageForm.lookup("#dayBox");
		Text text = (Text)eventPageForm.lookup("#textBox");
		ImageView image = (ImageView)eventPageForm.lookup("#imgBox");
		
		title.setText(event.getTitle());
		name.setText(event.getName());
		day.setText(event.getDay());
		text.setText(event.getText());
		Image img = new Image(event.getImg());
		image.setImage(img);

		return eventPageForm;
	}

	@Override
	public void labelSizeUp(Parent noticeForm, String labelName) {
		Label lb = (Label)noticeForm.lookup(labelName);
		lb.setScaleX(1.2);
		lb.setScaleY(1.2);
		
	}

	@Override
	public void labelSizeDown(Parent noticeForm, String labelName) {
		Label lb = (Label)noticeForm.lookup(labelName);
		lb.setScaleX(1);
		lb.setScaleY(1);
		
	}

	
}


	
	
	
	
	

