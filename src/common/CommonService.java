package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public interface CommonService {
	
	public static void newStage(Parent form) {
		Stage stage = new Stage();
		stage.setScene(new Scene(form));
		openStage(form);

	}
	
	public static void openStage(Parent form) {
		Stage stage = (Stage) form.getScene().getWindow();
		stage.show();
		
	}
	public static void closeStage(Parent form) {
		Stage stage = (Stage) form.getScene().getWindow();
		stage.close();

	}
	
	public static void ErrorMsg(String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error를 확인해주세요.");
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	
	public static void InformationMsg(String contentText1, String contentText2) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알림");
		alert.setHeaderText(contentText1);
		alert.setContentText(contentText2);
		alert.showAndWait();
	}

   public static void closeAll(PreparedStatement ps, ResultSet rs) {

      try {if(ps!= null) ps.close();} catch(SQLException e) {} 
      try {if(rs!= null) rs.close();} catch(SQLException e) {}
	}
	
	
	
}
