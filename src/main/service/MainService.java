package main.service;

import javafx.scene.Parent;

public interface MainService {
	
	void openViewBox(Parent mainForm);

	void closeViewBox(Parent mainForm);

	void showMoreLabel(Parent mainForm);

	void exitMoreLabel(Parent mainForm);

	void sizeUpImage(Parent mainForm,String bookName);

	void sizeDownImage(Parent mainForm,String bookName);

	void moveInfoImage(Parent mainForm, String bookName, String imageName);

	void showChart(Parent mainForm);






	





	



}
