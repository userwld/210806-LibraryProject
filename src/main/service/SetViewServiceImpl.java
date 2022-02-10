package main.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import allDAO.MainDAO;
import allDAO.PartDAO;
import allDTO.LikeDTO;
import allDTO.NewBestDTO;
import allDTO.NoticeDTO;
import common.CommonService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.MainController;

public class SetViewServiceImpl implements SetViewService{
	private MainDAO dao;
	private String open = "new";
	
	public SetViewServiceImpl() {
		dao = new MainDAO();
	}
		
	public void setChart(Parent mainForm) {		
		
		PieChart pieChart = (PieChart)mainForm.lookup("#pieChart");
		ArrayList<NewBestDTO> bestGenre = dao.bestGenre();
	
		
		pieChart.setData(FXCollections.observableArrayList(
			new Data(bestGenre.get(0).getGenre(),bestGenre.get(0).getGood()),
			new Data(bestGenre.get(1).getGenre(),bestGenre.get(1).getGood()),
			new Data(bestGenre.get(2).getGenre(),bestGenre.get(2).getGood()),
			new Data(bestGenre.get(3).getGenre(),bestGenre.get(3).getGood()),
			new Data(bestGenre.get(4).getGenre(),bestGenre.get(4).getGood())
				));		
		
		BarChart bar = (BarChart)mainForm.lookup("#barChart");
		ArrayList<NewBestDTO> likeBook = dao.moreLike();
		
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setData(FXCollections.observableArrayList( 		
			new XYChart.Data(likeBook.get(0).getName(),likeBook.get(0).getGood()),
			new XYChart.Data(likeBook.get(1).getName(),likeBook.get(1).getGood()),
			new XYChart.Data(likeBook.get(2).getName(),likeBook.get(2).getGood())			
		));
		bar.getData().add(series1);
		
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		
	
		String[] genre = {"경영","경제","소설","수필","역사"};
		int sum = 0;
				
		
		HashMap<String,Integer> teen = dao.preferGenre(nowYear-(19-1),nowYear-(10-1));
		sum = dao.sumCount(nowYear-(19-1),nowYear-(10-1));
		LineChart line = (LineChart)mainForm.lookup("#lineChart");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("10대");
		series2.setData(FXCollections.observableArrayList( 
				new XYChart.Data(genre[0], teen.get(genre[0]) / (double)sum  * 100),
				new XYChart.Data(genre[1], teen.get(genre[1]) / (double)sum  * 100),
				new XYChart.Data(genre[2], teen.get(genre[2]) / (double)sum  * 100),
				new XYChart.Data(genre[3], teen.get(genre[3]) / (double)sum  * 100),
				new XYChart.Data(genre[4], teen.get(genre[4]) / (double)sum  * 100)
				
		));
		HashMap<String,Integer> twenty = dao.preferGenre(nowYear-(29-1),nowYear-(20-1));
		sum = dao.sumCount(nowYear-(29-1),nowYear-(20-1));
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("20대");
		series3.setData(FXCollections.observableArrayList( 
			
				new XYChart.Data(genre[0], twenty.get(genre[0]) / (double)sum  * 100),
				new XYChart.Data(genre[1], twenty.get(genre[1]) / (double)sum  * 100),
				new XYChart.Data(genre[2], twenty.get(genre[2]) / (double)sum  * 100),
				new XYChart.Data(genre[3], twenty.get(genre[3]) / (double)sum  * 100),
				new XYChart.Data(genre[4], twenty.get(genre[4]) / (double)sum  * 100)
				
		));
		
		HashMap<String,Integer> thirty = dao.preferGenre(nowYear-(39-1),nowYear-(30-1));
		sum = dao.sumCount(nowYear-(39-1),nowYear-(30-1));
		
		XYChart.Series series4 = new XYChart.Series();
		series4.setName("30대");
		series4.setData(FXCollections.observableArrayList( 
			
				new XYChart.Data(genre[0], thirty.get(genre[0]) / (double)sum  * 100),
				new XYChart.Data(genre[1], thirty.get(genre[1]) / (double)sum  * 100),
				new XYChart.Data(genre[2], thirty.get(genre[2]) / (double)sum  * 100),
				new XYChart.Data(genre[3], thirty.get(genre[3]) / (double)sum  * 100),
				new XYChart.Data(genre[4], thirty.get(genre[4]) / (double)sum  * 100)
				
		));
		
		
		HashMap<String,Integer> forty = dao.preferGenre(nowYear-(40-1));
		sum = dao.sumCount(nowYear-(40-1));
		
		XYChart.Series series5 = new XYChart.Series();
		series5.setName("40대이상");
		series5.setData(FXCollections.observableArrayList( 
			
				new XYChart.Data(genre[0], forty.get(genre[0]) / (double)sum  * 100),
				new XYChart.Data(genre[1], forty.get(genre[1]) / (double)sum  * 100),
				new XYChart.Data(genre[2], forty.get(genre[2]) / (double)sum  * 100),
				new XYChart.Data(genre[3], forty.get(genre[3]) / (double)sum  * 100),
				new XYChart.Data(genre[4], forty.get(genre[4]) / (double)sum  * 100)	
		));
		
		line.getData().addAll(series2,series3,series4,series5);
	}

	public void setChartClear(Parent mainForm) {
		PieChart pieChart = (PieChart)mainForm.lookup("#pieChart");
		BarChart bar = (BarChart)mainForm.lookup("#barChart");
		LineChart line = (LineChart)mainForm.lookup("#lineChart");
		
		pieChart.getData().clear();
		bar.getData().clear();
		line.getData().clear();
		
	}
		
	public void setListView(Parent mainForm, MainController mainCtrl,FormService formSvc) {
		
		ArrayList<NoticeDTO> recent = dao.recentNotice();
		Parent notiPageForm = formSvc.openNotiPage(mainCtrl);
			
		ListView<String> listView = (ListView<String>)mainForm.lookup("#recentList");
		listView.getItems().add("최근 5개항목이 표시됩니다.");
		listView.getItems().add("");
		
		for(int i = 0; i < 5; i++) {
			listView.getItems().add(recent.get(i).getTitle());
		}
				
			listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
				
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {	
				newValue = listView.getSelectionModel().getSelectedItem();
			
				
					if(newValue == listView.getItems().get(0)) 	return;			
					if(newValue == listView.getItems().get(1)) 	return;
					if(newValue == listView.getItems().get(2)) setRecentList(notiPageForm,0);					
					if(newValue == listView.getItems().get(3)) setRecentList(notiPageForm,1);					
					if(newValue == listView.getItems().get(4)) setRecentList(notiPageForm,2);
					if(newValue == listView.getItems().get(5)) setRecentList(notiPageForm,3);
					if(newValue == listView.getItems().get(6)) setRecentList(notiPageForm,4);
				
				if(open.equals("new")) {
					open = "old";
					CommonService.newStage(notiPageForm);
					
				}else if(open.equals("old")){
					CommonService.openStage(notiPageForm);
					}
				}
			});
		
	}
	
	public void setListUpdate(Parent mainForm) {
		ArrayList<NoticeDTO> recent = dao.recentNotice();
		ListView<String> listView = (ListView<String>)mainForm.lookup("#recentList");
//		Button newBtn = (Button)mainForm.lookup("#newButton");
//		newBtn.setStyle("-fx-padding : 0,10,15,10");
	
		for(int i = 0; i < 5; i++) {
			listView.getItems().set(i+2, recent.get(i).getTitle());
		}
		return;		// 리스트 뷰 갱신 후 notipageForm뜨는 문제때문에 return;
	}
	
	private void setRecentList(Parent notiPageForm, int i) {
		ArrayList<NoticeDTO> recent = dao.recentNotice();
		Text name = (Text)notiPageForm.lookup("#nameBox");
		Text title = (Text)notiPageForm.lookup("#titleBox");
		Text day = (Text)notiPageForm.lookup("#dayBox");
		Text text = (Text)notiPageForm.lookup("#textBox");
		
		name.setText(recent.get(i).getName());
		title.setText(recent.get(i).getTitle());
		day.setText(recent.get(i).getDay());
		text.setText(recent.get(i).getText()); 

	}

	public void setMoreButton(Parent mainForm) {
		ImageView more = new ImageView("/img/play.jpg");
		more.setFitHeight(35);
		more.setFitWidth(40); 
		Button moreButton = (Button)mainForm.lookup("#moreButton");
		moreButton.setGraphic(more);
		
	}
	

	public void setNewBest(Parent mainForm) {
		MainDAO dao = new MainDAO();
		ArrayList<NewBestDTO> newBook = dao.selectNew();
		
		ImageView newImage1 = (ImageView)mainForm.lookup("#newImage1");
		ImageView newImage2 = (ImageView)mainForm.lookup("#newImage2");
		ImageView newImage3 = (ImageView)mainForm.lookup("#newImage3");
		ImageView newImage4 = (ImageView)mainForm.lookup("#newImage4");
						
		Image img = new Image(newBook.get(0).getImg());
		newImage1.setImage(img);			
		img = new Image(newBook.get(1).getImg());
		newImage2.setImage(img);
		img = new Image(newBook.get(2).getImg());
		newImage3.setImage(img);
		img = new Image(newBook.get(3).getImg());
		newImage4.setImage(img);
	}
	

	public void  setBookPage(Parent previewForm, int i) {
		MainDAO dao = new MainDAO();
		ArrayList<NewBestDTO> newBook = dao.selectNew();
		Label name = (Label)previewForm.lookup("#title");
		ImageView imgView = (ImageView)previewForm.lookup("#introimg");
		Label day = (Label)previewForm.lookup("#date");
		Label num = (Label)previewForm.lookup("#bookNum");
		Label map = (Label)previewForm.lookup("#bookLocation");
		Label author = (Label)previewForm.lookup("#writer");
		Label review = (Label)previewForm.lookup("#review");
		Label like = (Label)previewForm.lookup("#like");
		TextArea ta = (TextArea)previewForm.lookup("#findarea");
		
		name.setText(newBook.get(i).getName());
		
		Image img = new Image(newBook.get(i).getImg());
		imgView.setImage(img);
		day.setText(newBook.get(i).getDay());
		num.setText(newBook.get(i).getNum() + "");
		map.setText(newBook.get(i).getMap());
		author.setText(newBook.get(i).getAuthor());
		review.setText(newBook.get(i).getReview());		
		like.setText("좋아요 : " + newBook.get(i).getGood());
		ta.setText(newBook.get(i).getStory());
			
	}

	public void addCombo(Parent joinForm) {
		ComboBox<String> year = (ComboBox)joinForm.lookup("#yearCombo");
		ComboBox<String> month = (ComboBox)joinForm.lookup("#monthCombo");
		ComboBox<String> day = (ComboBox)joinForm.lookup("#dayCombo");
		ComboBox<String> hint = (ComboBox)joinForm.lookup("#pwHintCombo");
		ComboBox<String> genre = (ComboBox<String>) joinForm.lookup("#genreCombo");
		String[] hintcombo = {"출신 초등학교","출생지","좋아하는 음식"};
		String[] genrecombo = {"경영", "경제", "수필", "소설", "역사"};
		
		
		for(int i = 2021; i >= 1910; i-- ) {
			String y = i + "년";
			year.getItems().add(y);
		}
		for(int i = 1; i <= 12; i++) {
			String m = i + "월";
			month.getItems().add(m);
		}
		for(int i = 1; i <= 31; i++) {
			String d = i + "일";
			day.getItems().add(d);
		}
		for(int i = 0; i <= 2; i++) {
			hint.getItems().add(hintcombo[i]);
		}
		for(int i = 0; i <= 4; i++) {
		   genre.getItems().add(genrecombo[i]);
		 }
	}

	@Override
	public void addAllBook(Parent partForm) {
		ComboBox<String>allBook1 =(ComboBox<String>) partForm.lookup("#allBookCombo1");
		ComboBox<String>allBook2 =(ComboBox<String>) partForm.lookup("#allBookCombo2");
		
		ArrayList<NewBestDTO> allBook = dao.bookAll();
		if(!allBook.isEmpty()) {
			for(int i=0; i < allBook.size(); i++) {
				allBook1.getItems().add(allBook.get(i).getName() + ", " + allBook.get(i).getAuthor());
				allBook2.getItems().add(allBook.get(i).getName() + ", " + allBook.get(i).getAuthor());
			}
		}
	}
	
	public void myLikeBook(Parent form) {
		PartDAO partDao = new PartDAO();
		ComboBox<String>myLike =(ComboBox<String>) form.lookup("#myLike");
		
		Label idLabel = (Label)form.lookup("#loginLabel");
		if(!idLabel.getText().equals("로그인")) {
			String id = idLabel.getText().substring(0, idLabel.getText().length()-6);
			ArrayList<LikeDTO> likeBook = partDao.likeBook(id);
			
			myLike.getItems().clear();
			
			for(int i = 0; i < likeBook.size(); i++) {
				myLike.getItems().add(likeBook.get(i).getBook());
			}
		}
	}

	public String setLabel(Parent form, Parent mainForm) {
		
		Label loginLabel = (Label)form.lookup("#loginLabel");
		Label registerLabel = (Label)form.lookup("#registerLabel");
		Label mainloginLabel = (Label)mainForm.lookup("#loginLabel");
		Label mainregisterLabel = (Label)mainForm.lookup("#registerLabel");
	
		loginLabel.setText(mainloginLabel.getText());
		registerLabel.setText(mainregisterLabel.getText());
		
		return loginLabel.getText();
	}
	
	public void setLikeButton(Parent partForm) {
		Button likeButton = (Button)partForm.lookup("#likeButton");
		Button cancelButton = (Button)partForm.lookup("#cancelButton");
	
		likeButton.setGraphic(new ImageView("/img/heart.jpg"));
		cancelButton.setGraphic(new ImageView("/img/cancel.jpg"));

	}

	
	
	
}
