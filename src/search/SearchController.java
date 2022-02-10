package search;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;
import main.service.FormServiceImpl;
import main.service.MainService;
import preview.PreviewController;
import search.service.SearchImpl;
import search.service.SearchService;

public class SearchController implements Initializable{

	
	private Parent searchForm;
	private MainController mainCtrl;
	private SearchService searchSvc;
	private MainService mainSvc;
	private FormServiceImpl formSvc = new FormServiceImpl();
	
	
	
	public void setSearchForm(Parent searchForm) {
		this.searchForm = searchForm;
	}
	public Parent getSearchForm() {
		return searchForm;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchSvc = new SearchImpl();	
	}
	public void clickLogo() {
		mainCtrl.openMainForm();
		CommonService.closeStage(searchForm);
	}
	public void openPreView1()  {
		PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
		searchSvc.openPreViewForm1(searchForm,preCtrl);

	}
	public void openPreView2()  {
		PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
		searchSvc.openPreViewForm2(searchForm,preCtrl);
	}
	public void openPreView3()  {
		PreviewController preCtrl = formSvc.openBookPageForm(mainCtrl);
		searchSvc.openPreViewForm3(searchForm,preCtrl);
	}
	
	public void openSearchForm() {
		mainCtrl.openSearchForm(searchForm);
	}
	
	public void singanPage() {
		mainCtrl.openNew();
		CommonService.closeStage(searchForm);
		
	}
	public void koreaPage() {
		mainCtrl.openBest1();
		CommonService.closeStage(searchForm);
	}
	public void osPage() {
		mainCtrl.openBest2();
		CommonService.closeStage(searchForm);
	}
	
	
	public void sizeup() {}
	public void sizedown() {}	
	
	
	public void labEntered1() {
		searchSvc.labSizeUp(searchForm, "#labelsize1");
	}
	public void labExited1() {
		searchSvc.labSizeDown(searchForm, "#labelsize1");
	}
		
	public void labEntered2() {
		searchSvc.labSizeUp(searchForm, "#labelsize2");
	}
	
	public void labExited2() {
		searchSvc.labSizeDown(searchForm, "#labelsize2");
	}
	public void labEntered3() {
		searchSvc.labSizeUp(searchForm, "#labelsize3");
	
	}
	public void labExited3() {
		searchSvc.labSizeDown(searchForm, "#labelsize3");
		
	}
	public void backcolorEntered1() {
//	searchSvc.boxColorUp(searchForm, "#boxcolor1");
	}
	public void backcolorExited1() {
//	searchSvc.boxColorDown(searchForm, "#boxcolor1");
	}
	public void backcolorEntered2() {
//	searchSvc.boxColorUp(searchForm, "#boxcolor2");
	}
	public void backcolorExited2() {
//	searchSvc.boxColorDown(searchForm, "#boxcolor2");
	}
	public void backcolorEntered3() {
//	searchSvc.boxColorUp(searchForm, "#boxcolor3");
	}
	public void backcolorExited3() {
//	searchSvc.boxColorDown(searchForm, "#boxcolor3");
	}

	
	
	public void setMainCtrl(MainController mainController) {
		this.mainCtrl = mainController;		
	}
	
	public void openNewBestForm() {
		mainCtrl.openNew();
		CommonService.closeStage(searchForm);
	}
	public void openIntroForm() {
		mainCtrl.openIntroForm();
		CommonService.closeStage(searchForm);
	}
	
	public void openNoticeForm() {
		mainCtrl.openNoticeForm();
		CommonService.closeStage(searchForm);
	}
	
	public void openLoginForm() {
		mainCtrl.openLoginForm(searchForm);

	}
	public void openJoinForm() {
		mainCtrl.openJoinForm(searchForm);
		CommonService.closeStage(searchForm);
	}
	public void openPartForm() {
		mainCtrl.openPartForm(searchForm);
	}
	
	public void setSearch(Parent searchForm, String bookname) {
		searchSvc.setSearch(searchForm,bookname);		
	}
	public void setSearchClear() {
		searchSvc.setSearchClear(searchForm);
	}
	
}

