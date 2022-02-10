package main.service;

import java.io.IOException;

import admin.AdminController;
import common.CommonService;
import intro.IntroController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import join.JoinController;
import login.LoginController;
import main.MainController;
import memberInfo.MemberInfoController;
import newBest.NewBestController;
import notice.NoticeController;
import participate.PartController;
import preview.PreviewController;
import search.SearchController;

public class FormServiceImpl implements FormService{
	private SetViewService setSvc = new SetViewServiceImpl();

	public LoginController openLoginForm(MainController mainController) {
		LoginController logCtrl = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/LoginForm.fxml"));
		loader.setController(logCtrl);
		Parent loginForm =  null;

		try {
			loginForm = loader.load();
			logCtrl.setLoginForm(loginForm);
			logCtrl.setMainController(mainController);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return logCtrl;
	}
	public JoinController openJoinForm(MainController mainController) {
		
		JoinController joinCtrl = new JoinController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/join/JoinForm.fxml"));
		loader.setController(joinCtrl);
		Parent joinForm =  null;
		
		try {
			joinForm = loader.load();
			joinCtrl.setJoinForm(joinForm);
			joinCtrl.setMainCtrl(mainController);
			setSvc.addCombo(joinForm);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return joinCtrl;
	}

	
	public PreviewController openBookPageForm(MainController mainController) {
		 PreviewController preViewCtrl = new PreviewController();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/preView/preview.fxml"));
		 loader.setController(preViewCtrl);
		 Parent previewForm =  null;
		 try {
				previewForm = loader.load();
				preViewCtrl.setNewPreViewForm(previewForm);
				preViewCtrl.setMainCtrl(mainController);
				
		 } catch (IOException e) {			
				e.printStackTrace();
			}
		return preViewCtrl;
	}

	public IntroController openIntroForm(MainController mainController) {
		IntroController introCtrl = new IntroController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/intro/intro.fxml"));
		loader.setController(introCtrl);
		Parent introForm =  null;
		
		try {
			introForm = loader.load();
			introCtrl.setIntroForm(introForm);
			introCtrl.setMainCtrl(mainController);
			
	
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return introCtrl;
	}
	public NoticeController openNoticeForm(MainController mainController) {
		NoticeController notiCtrl = new NoticeController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/notice/notice.fxml"));
		loader.setController(notiCtrl);
		Parent noticeForm =  null;
		
		try {
			noticeForm = loader.load();
			notiCtrl.setNoticeForm(noticeForm);
			notiCtrl.setMainCtrl(mainController);	
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return notiCtrl;
	}	
	public NewBestController openNewBestForm(MainController mainController) {
		NewBestController newBestCtrl = new NewBestController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/newBest/newbest.fxml"));
		loader.setController(newBestCtrl);
		Parent newBestForm =  null;
		
		try {
			newBestForm = loader.load();
			newBestCtrl.setNewBestForm(newBestForm);
			newBestCtrl.setMainctrl(mainController);
	
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return newBestCtrl;
	}

	public SearchController openSearchForm(MainController mainController) {
		SearchController searchCtrl = new SearchController();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/search/search.fxml"));
		loader.setController(searchCtrl);
		Parent searchForm =  null;
		
		try {
			searchForm = loader.load();
			searchCtrl.setSearchForm(searchForm);
			searchCtrl.setMainCtrl(mainController);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return searchCtrl;
	}

	public MemberInfoController openMemberInfoForm(MainController mainController) {
		MemberInfoController memCtrl = new MemberInfoController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberInfo/MemberinfoForm.fxml"));
		loader.setController(memCtrl);
		Parent memInfoForm =  null;
		
		try {
			memInfoForm = loader.load();
			memCtrl.setMemInfoForm(memInfoForm);
			memCtrl.setMainCtrl(mainController);
	
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return memCtrl;
	}
	public Parent openNotiPage(MainController mainCtrl) {
		NoticeController notiCtrl = new NoticeController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/notice/notipage.fxml"));
		Parent notiPageForm =  null;
		loader.setController(notiCtrl);

		try {
			notiPageForm = loader.load();
			notiCtrl.setNotipageForm(notiPageForm);
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
		return notiPageForm;
	}

	public void openAdminForm(MainController mainController) {
		AdminController adCtrl = new AdminController();	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/AdminForm.fxml"));
		loader.setController(adCtrl);
		Parent adminForm =  null;
		
		try {
			adminForm = loader.load();
			adCtrl.setAdForm(adminForm);
			adCtrl.setMainCtrl(mainController);
			CommonService.newStage(adminForm);
			CommonService.closeStage(mainController.getMainForm());
	
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public Parent openEventPage(MainController mainCtrl) {
		NoticeController notiCtrl = new NoticeController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/notice/eventPage.fxml"));
		Parent eventPageForm =  null;
		loader.setController(notiCtrl);

		try {
			eventPageForm = loader.load();
			notiCtrl.setEventpageForm(eventPageForm);
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
		return eventPageForm;
	}
	
	@Override
	public PartController openPartForm(MainController mainCtrl) {
		PartController partCtrl = new PartController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/participate/partForm.fxml"));
		loader.setController(partCtrl);
		Parent partForm =  null;
		
		try {
			partForm = loader.load();
			partCtrl.setPartForm(partForm);
			partCtrl.setMainCtrl(mainCtrl);
			setSvc.addAllBook(partForm);
			setSvc.setLikeButton(partForm);
			setSvc.myLikeBook(partForm);
	
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return partCtrl;
	}
	
	

	
}
