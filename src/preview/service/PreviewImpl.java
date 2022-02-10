package preview.service;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;


public class PreviewImpl implements PreviewService {
		

	@Override
	public void likeClick(Parent newPreViewForm, String likeName) {
		ImageView likebutton = (ImageView)newPreViewForm.lookup(likeName);
		likebutton.setScaleX(1.4);
		likebutton.setScaleY(1.4);
		
	}

	@Override
	public void likeClick1(Parent newPreViewForm, String likeName) {
		ImageView likebutton = (ImageView)newPreViewForm.lookup(likeName);
		likebutton.setScaleX(1);
		likebutton.setScaleY(1);
		
	}

	@Override
	public void openarea(Parent newPreViewForm) {
		TextArea viewBox = (TextArea)newPreViewForm.lookup("#findarea");
		viewBox.setScaleY(1);
		
	}

	@Override
	public void closearea(Parent newPreViewForm) {
		TextArea viewBox = (TextArea)newPreViewForm.lookup("#findarea");
		viewBox.setScaleY(0);
		
	}
	



}
