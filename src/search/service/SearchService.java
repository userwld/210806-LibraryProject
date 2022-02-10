package search.service;

import javafx.scene.Parent;
import main.MainController;
import preview.PreviewController;
import search.SearchController;

public interface SearchService {

	void openPreViewForm1(Parent searchForm, PreviewController preCtrl );
	void openPreViewForm2(Parent searchForm, PreviewController preCtrl);
	void openPreViewForm3(Parent searchForm, PreviewController preCtrl);
	void labSizeUp(Parent searchForm, String labelName);
	void labSizeDown(Parent searchForm,  String labelName);
	void boxColorUp(Parent searchForm, String boxName);
	void boxColorDown(Parent searchForm, String boxName);
	void setSearch(Parent searchForm, String bookname);
	void setSearchClear(Parent searchForm);
	
}
