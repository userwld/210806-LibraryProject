package newBest.service;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import preview.PreviewController;

public interface NewBestService {
	void labSizeUp(Parent newBestForm , String labelName);
	void labSizeDown(Parent newBestForm,  String labelName);
	
	
	void outBestSizeUp(Parent newBestForm);
	void inBestSizeup(Parent newBestForm);
	void newBestSizeup(Parent newBestForm);
	
	
	void bookInfo(Parent newBestForm,PreviewController preCtrl, String title);
	static Label lookup(String string) {
		
		return null;
	}

}
