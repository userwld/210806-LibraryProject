package intro.service;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class IntroServiceImpl implements IntroService{


	public void openIntro2Box(Parent introForm) {
		VBox intro1tBox = (VBox)introForm.lookup("#intro1Box");
		VBox intro2tBox = (VBox)introForm.lookup("#intro2Box");
		VBox intro3tBox = (VBox)introForm.lookup("#intro3Box");
		VBox intro4tBox = (VBox)introForm.lookup("#intro4Box");
		intro1tBox.setScaleY(1);
		intro2tBox.setScaleY(0);
		intro3tBox.setScaleY(0);
		intro4tBox.setScaleY(0);
		
	}

	@Override
	public void openIntro3Box(Parent introForm) {
		VBox intro1tBox = (VBox)introForm.lookup("#intro1Box");
		VBox intro2tBox = (VBox)introForm.lookup("#intro2Box");
		VBox intro3tBox = (VBox)introForm.lookup("#intro3Box");
		VBox intro4tBox = (VBox)introForm.lookup("#intro4Box");
		intro1tBox.setScaleY(0);
		intro2tBox.setScaleY(1);
		intro3tBox.setScaleY(0);
		intro4tBox.setScaleY(0);
		
	}

	@Override
	public void openIntro4Box(Parent introForm) {
		VBox intro1tBox = (VBox)introForm.lookup("#intro1Box");
		VBox intro2tBox = (VBox)introForm.lookup("#intro2Box");
		VBox intro3tBox = (VBox)introForm.lookup("#intro3Box");
		VBox intro4tBox = (VBox)introForm.lookup("#intro4Box");
		intro1tBox.setScaleY(0);
		intro2tBox.setScaleY(0);
		intro3tBox.setScaleY(1);
		intro4tBox.setScaleY(0);
		
	}

	public void openIntroForm(Parent introForm) {
		VBox intro1tBox = (VBox)introForm.lookup("#intro1Box");
		VBox intro2tBox = (VBox)introForm.lookup("#intro2Box");
		VBox intro3tBox = (VBox)introForm.lookup("#intro3Box");
		VBox intro4tBox = (VBox)introForm.lookup("#intro4Box");
		intro1tBox.setScaleY(0);
		intro2tBox.setScaleY(0);
		intro3tBox.setScaleY(0);
		intro4tBox.setScaleY(1);
		
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
