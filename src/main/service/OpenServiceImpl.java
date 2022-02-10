package main.service;

import common.CommonService;
import intro.IntroController;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import join.JoinController;
import login.LoginController;
import main.MainController;
import memberInfo.MemberInfoController;
import newBest.NewBestController;
import notice.NoticeController;
import participate.PartController;
import preview.PreviewController;
import search.SearchController;

public class OpenServiceImpl implements OpenService{
	private MainController mainCtrl;
	private FormService formSvc;
	private SetViewService setSvc;
	private NewBestController newBestCtrl;
	private SearchController searchCtrl;
	private LoginController loginCtrl;
	private IntroController introCtrl;
	private NoticeController notiCtrl;
	private JoinController joinCtrl;
	private MemberInfoController memInfoCtrl;
	private PreviewController preViewCtrl;
	private PartController partCtrl;
	private Parent notiPageForm;
	private Parent eventPageForm;

	
	
	public OpenServiceImpl(FormService formSvc, MainController mainCtrl, SetViewService setSvc) {
		this.formSvc = formSvc;
		this.mainCtrl = mainCtrl;
		this.setSvc = setSvc;
	}

	@Override
	public void openLogin(Parent form) {
		this.loginCtrl = formSvc.openLoginForm(mainCtrl);
		Parent mainForm = mainCtrl.getMainForm();
		Label loginLabel = (Label)form.lookup("#loginLabel");
		Label alreadyreg = (Label)form.lookup("#registerLabel");
		Label mainLogin = (Label)mainForm.lookup("#loginLabel");
		Label mainreg = (Label)mainForm.lookup("#registerLabel");
		
		if(loginLabel.getText().equals("로그인")) {
			CommonService.newStage(loginCtrl.getLoginForm());
			CommonService.closeStage(form);
		}else if(loginLabel.getText().endsWith("로그아웃")) {
			CommonService.InformationMsg("로그아웃", "로그아웃 되셨습니다.");
			loginLabel.setText("로그인"); mainLogin.setText("로그인");
			alreadyreg.setText("회원가입"); mainreg.setText("회원가입");
			CommonService.closeStage(form);
			CommonService.openStage(mainCtrl.getMainForm());
		}
	}

	@Override
	public void openJoin(Parent form) {
		Label alreadyreg = (Label)form.lookup("#registerLabel");
		if(alreadyreg.getText().equals("회원가입")){
			if(joinCtrl == null) {
				this.joinCtrl = formSvc.openJoinForm(mainCtrl);
				CommonService.newStage(joinCtrl.getJoinForm());
			}else {
				CommonService.openStage(joinCtrl.getJoinForm());
			}
			CommonService.closeStage(form);
		}else if(alreadyreg.getText().equals("회원정보")) {	
			if(memInfoCtrl == null) {
				this.memInfoCtrl = formSvc.openMemberInfoForm(mainCtrl);
				memInfoCtrl.setMemInfo(loginCtrl.getLoginForm(),memInfoCtrl.getMemInfoForm());
				CommonService.newStage(memInfoCtrl.getMemInfoForm());
			}else {	
				memInfoCtrl.setMemInfo(loginCtrl.getLoginForm(),memInfoCtrl.getMemInfoForm());
				CommonService.openStage(memInfoCtrl.getMemInfoForm());
			}
			CommonService.closeStage(form);
		}else if(alreadyreg.getText().equals("관리자페이지")) {
			formSvc.openAdminForm(mainCtrl);
		}	
	}

	public void openSearch(Parent form) {
		String open;
		if(searchCtrl == null) {
			this.searchCtrl = formSvc.openSearchForm(mainCtrl);
			open = "new";
		}else {
			open = "old";
		}
		Parent searchForm = searchCtrl.getSearchForm();
		Label findLabel = (Label)searchForm.lookup("#findLabel");

		TextField findText = (TextField)form.lookup("#findText");
		findLabel.setText(findText.getText() + "의 검색결과입니다.");
		setSvc.setLabel(searchForm,form);
		
		if(findText.getText().equals("")) {
			searchCtrl.setSearchClear();
		}else {
			searchCtrl.setSearch(searchForm,findText.getText());
		}
		
		if(open == "new") {
			CommonService.newStage(searchCtrl.getSearchForm());
		}else {
			CommonService.openStage(searchCtrl.getSearchForm());
		}
		CommonService.closeStage(mainCtrl.getMainForm());
		
	}
	
	public void openNewBest(Parent mainForm) {		
		if(newBestCtrl == null ) {	
			this.newBestCtrl = formSvc.openNewBestForm(mainCtrl);
			setSvc.setLabel(newBestCtrl.getNewBestForm(),mainForm);
			CommonService.newStage(newBestCtrl.getNewBestForm());
		}else {
			setSvc.setLabel(newBestCtrl.getNewBestForm(),mainForm);
			CommonService.openStage(newBestCtrl.getNewBestForm());
		}
		CommonService.closeStage(mainForm);
	}


	public void openIntro(Parent mainForm) {
		this.introCtrl = formSvc.openIntroForm(mainCtrl);
		setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
		CommonService.newStage(introCtrl.getIntroForm());
		CommonService.closeStage(mainForm);
	}
	
	public void openNotice(Parent mainForm) {
		this.notiCtrl = formSvc.openNoticeForm(mainCtrl);
		setSvc.setLabel(notiCtrl.getNotiForm(),mainForm);
		notiCtrl.openNoticeBox();
		CommonService.newStage(notiCtrl.getNotiForm());
		CommonService.closeStage(mainForm);
	}
	
	public void openBookPage() {
		this.preViewCtrl = formSvc.openBookPageForm(mainCtrl);	
		CommonService.newStage(preViewCtrl.getNewPreViewForm());
	}


	public void openNotiPage() {
		if(notiPageForm == null) {
			this.notiPageForm = formSvc.openNotiPage(mainCtrl);
			CommonService.newStage(notiPageForm);
		}else {
			CommonService.openStage(notiPageForm);
		}
		
	}

	
	@Override
	public void openRule(Parent mainForm) {
		if(introCtrl == null) {
			this.introCtrl = formSvc.openIntroForm(mainCtrl);
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro2Box();
			CommonService.newStage(introCtrl.getIntroForm());
		}else {
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro2Box();
			CommonService.openStage(introCtrl.getIntroForm());
		}
		CommonService.closeStage(mainForm);
		
	}
	
	public void openInterior(Parent mainForm) {
		if(introCtrl == null) {
			this.introCtrl = formSvc.openIntroForm(mainCtrl);
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro3Box();
			CommonService.newStage(introCtrl.getIntroForm());
		}else {
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro3Box();
			CommonService.openStage(introCtrl.getIntroForm());
		}
		CommonService.closeStage(mainForm);
	}
	
	public void openRoot(Parent mainForm) {
		if(introCtrl == null) {
			this.introCtrl = formSvc.openIntroForm(mainCtrl);
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro4Box();
			CommonService.newStage(introCtrl.getIntroForm());
		}else {
			setSvc.setLabel(introCtrl.getIntroForm(),mainForm);
			introCtrl.openIntro4Box();
			CommonService.openStage(introCtrl.getIntroForm());
		}
		CommonService.closeStage(mainForm);
	}
	
	@Override
	public void openEvent(Parent mainForm) {
		if(notiCtrl == null) {
			this.notiCtrl = formSvc.openNoticeForm(mainCtrl);
			setSvc.setLabel(notiCtrl.getNotiForm(),mainForm);
			notiCtrl.setEventBox();
			CommonService.newStage(notiCtrl.getNotiForm());
			
		}else {
			setSvc.setLabel(notiCtrl.getNotiForm(),mainForm);
			notiCtrl.setEventBox();
			CommonService.openStage(notiCtrl.getNotiForm());
		}
		CommonService.closeStage(mainForm);
		
	}


	public void openPreview1(SetViewService setSvc) {
		openPreView(setSvc,0);
	}

	public void openPreview2(SetViewService setSvc) {
		openPreView(setSvc,1);
	}

	public void openPreview3(SetViewService setSvc) {
		openPreView(setSvc,2);
	}

	public void openPreview4(SetViewService setSvc) {
		openPreView(setSvc,3);	
	}
	
	private void openPreView(SetViewService setSvc, int i) {
		this.preViewCtrl = formSvc.openBookPageForm(mainCtrl);
		Parent previewForm = preViewCtrl.getNewPreViewForm();
		setSvc.setBookPage(previewForm, i);
		CommonService.newStage(previewForm);
	}

	@Override
	public void openNew(Parent mainForm) {
		this.newBestCtrl = formSvc.openNewBestForm(mainCtrl);
		setSvc.setLabel(newBestCtrl.getNewBestForm(),mainForm);
		newBestCtrl.newBestSet();
		CommonService.newStage(newBestCtrl.getNewBestForm());
		CommonService.closeStage(mainForm);
	}

	@Override
	public void openBest1(Parent mainForm) {
		this.newBestCtrl = formSvc.openNewBestForm(mainCtrl);
		setSvc.setLabel(newBestCtrl.getNewBestForm(),mainForm);
		newBestCtrl.inBestOnmouseClick1();
		CommonService.newStage(newBestCtrl.getNewBestForm());
		CommonService.closeStage(mainForm);
	}

	@Override
	public void openBest2(Parent mainForm) {
		this.newBestCtrl = formSvc.openNewBestForm(mainCtrl);
		setSvc.setLabel(newBestCtrl.getNewBestForm(),mainForm);
		newBestCtrl.outBestOnmouseClick2();
		CommonService.newStage(newBestCtrl.getNewBestForm());
		CommonService.closeStage(mainForm);
		
	}

	@Override
	public void openEventPage() {
		if(eventPageForm == null) {
			this.eventPageForm = formSvc.openEventPage(mainCtrl);
			CommonService.newStage(eventPageForm);
		}else {
			CommonService.openStage(eventPageForm);
		}
	}

	@Override
	public void openPart(Parent mainForm) {
		this.partCtrl = formSvc.openPartForm(mainCtrl);
		String check = setSvc.setLabel(partCtrl.getPartForm(),mainForm);
		
		if(check.equals("로그인")) {
			CommonService.ErrorMsg("로그인 후 이용가능합니다.");
			return;
		}else {
			CommonService.newStage(partCtrl.getPartForm());
			CommonService.closeStage(mainForm);
		}

	}

	@Override
	public void openPart(Parent form, Parent mainForm) {
		this.partCtrl = formSvc.openPartForm(mainCtrl);
		String check = setSvc.setLabel(partCtrl.getPartForm(),mainForm);
		
		if(check.equals("로그인")) {
			CommonService.ErrorMsg("로그인 후 이용가능합니다.");
			return;
		}else {
			CommonService.newStage(partCtrl.getPartForm());
			CommonService.closeStage(form);
		}

	}
	
	
	


	



	






	
	






	





	
	
	
	
	
	

	
	
	
	

}
