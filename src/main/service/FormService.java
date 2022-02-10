package main.service;

import intro.IntroController;
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

public interface FormService {
	
	LoginController openLoginForm(MainController mainController);

	JoinController openJoinForm(MainController mainController);

	PreviewController openBookPageForm(MainController mainController);

	IntroController openIntroForm(MainController mainController);

	NoticeController openNoticeForm(MainController mainController);

	NewBestController openNewBestForm(MainController mainController);

	SearchController openSearchForm(MainController mainController);

	MemberInfoController openMemberInfoForm(MainController mainController);

	Parent openNotiPage(MainController mainController);
	
	Parent openEventPage(MainController mainCtrl);

	void openAdminForm(MainController mainController);

	PartController openPartForm(MainController mainCtrl);
	

}
