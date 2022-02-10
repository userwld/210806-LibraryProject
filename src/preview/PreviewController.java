package preview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main.MainController;
import preview.service.PreviewImpl;
import preview.service.PreviewService;

public class PreviewController implements Initializable {
	private Parent newPreViewForm;
	private MainController mainCtrl;
	private PreviewService preSvc;
		
	public void setNewPreViewForm(Parent newPreViewForm) {
		this.newPreViewForm = newPreViewForm;
	}
	public Parent getNewPreViewForm() {
		return newPreViewForm;

	}
	public void setMainCtrl(MainController mainController) {
		this.mainCtrl = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preSvc = new PreviewImpl();
		
	}
	public void likeBigButton() {
		preSvc.likeClick(newPreViewForm, "#likeButton");
	}
	public void likeSmallButton() {
		preSvc.likeClick1(newPreViewForm, "#likeButton");
	}
	public void openarea() {
		preSvc.openarea(newPreViewForm);
	}
	public void closearea() {
		preSvc.closearea(newPreViewForm);
		}
	
	}
