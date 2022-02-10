package main.service;

import javafx.scene.Parent;
import main.MainController;

public interface SetViewService {
	
	void setChart(Parent mainForm);

	void setListView(Parent mainForm, MainController mainCtrl, FormService formSvc);

	void setMoreButton(Parent mainForm);
	
	void setNewBest(Parent mainForm);
	
	void setBookPage(Parent previewForm, int i);

	void addCombo(Parent joinForm);

	void addAllBook(Parent partForm);
	
	String setLabel(Parent form, Parent mainForm);

	void setListUpdate(Parent mainForm);

	void setLikeButton(Parent partForm);
	
	void myLikeBook(Parent partForm);

	void setChartClear(Parent mainForm);

	


}
