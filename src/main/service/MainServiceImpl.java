package main.service;

import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MainServiceImpl implements MainService{
		
	@Override
	public void openViewBox(Parent mainForm) {
		HBox viewBox = (HBox)mainForm.lookup("#viewBox");
		viewBox.setScaleY(1);
	}

	@Override
	public void closeViewBox(Parent mainForm) {
		HBox viewBox = (HBox)mainForm.lookup("#viewBox");
		viewBox.setScaleY(0);	
	}


	@Override
	public void showMoreLabel(Parent mainForm) {
		Label moreLabel = (Label)mainForm.lookup("#moreLabel");
		moreLabel.setStyle("-fx-text-fill : red");
	}

	@Override
	public void exitMoreLabel(Parent mainForm) {
		Label moreLabel = (Label)mainForm.lookup("#moreLabel");
		moreLabel.setStyle("-fx-text-fill : transparent");
		
	}

	@Override
	public void sizeUpImage(Parent mainForm,String bookName) {
		ImageView newImage = (ImageView)mainForm.lookup(bookName);
		newImage.setScaleX(1.2);		
		newImage.setScaleY(1.2);		
	}


	public void sizeDownImage(Parent mainForm,String bookName) {
		ImageView newImage = (ImageView)mainForm.lookup(bookName);
		newImage.setScaleX(1.0);		
		newImage.setScaleY(1.0);			
	}

	@Override
	public void moveInfoImage(Parent mainForm, String bookName,String imageName) {
		ImageView newImage = (ImageView)mainForm.lookup(bookName);
		Image pageMove = new Image(imageName);
		newImage.setImage(pageMove);
	
	}

	@Override
	public void showChart(Parent mainForm) {
		Label label = (Label)mainForm.lookup("#chartLabel");
		BarChart bar = (BarChart)mainForm.lookup("#barChart");
		PieChart pie = (PieChart)mainForm.lookup("#pieChart");
		LineChart line = (LineChart)mainForm.lookup("#lineChart");
		
		if(label.getText().equals("인기 장르")) {
			bar.setScaleX(1);
			pie.setScaleX(0);
			label.setText("최다 좋아요 Top3");
		}
		
		else if(label.getText().equals("최다 좋아요 Top3")) {
			bar.setScaleX(0);
			line.setScaleX(1);
			label.setText("연령별 장르 선호율");
		}
		
		else if(label.getText().equals("연령별 장르 선호율")) {
			line.setScaleX(0);
			pie.setScaleX(1);
			label.setText("인기 장르");
			
		}
		
	}






}

