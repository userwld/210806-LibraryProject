package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import newBest.NewBestController;
import newBest.service.NewBestServiceImpl;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent mainForm = loader.load();
		
		MainController mainCtrl = loader.getController();
		mainCtrl.setMainForm(mainForm);
			
		primaryStage.setTitle("main");
		primaryStage.setScene(new Scene(mainForm));
		primaryStage.show();

	}
	

}
