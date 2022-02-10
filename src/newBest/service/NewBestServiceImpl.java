package newBest.service;

import java.util.ArrayList;

import allDAO.NewBestDAO;
import allDTO.NewBestDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import preview.PreviewController;

public class NewBestServiceImpl implements NewBestService {

	private static final Parent newBestForm = null;
	private static final PreviewController preCtrl = null;

	@Override
	public void labSizeUp(Parent newBestForm, String labelName) {
		Label lb = (Label)newBestForm.lookup(labelName);
		lb.setScaleX(1.3);
		lb.setScaleY(1.3);
		 	 	
	}

	@Override
	public void labSizeDown(Parent newBestForm, String labelName) {
		Label lb = (Label)newBestForm.lookup(labelName);
		lb.setScaleX(1);
		lb.setScaleY(1);
	}

	
	@Override	
    public void newBestSizeup(Parent newBestForm) {
	  NewBestDAO dao = new NewBestDAO();
	  ArrayList<NewBestDTO> newbook = dao.selectNewBest();
	  
	  ImageView inBestimg1 = (ImageView)newBestForm.lookup("#bookimg1");
	  ImageView inBestimg2 = (ImageView)newBestForm.lookup("#bookimg2");
	  ImageView inBestimg3 = (ImageView)newBestForm.lookup("#bookimg3");
	  ImageView inBestimg4 = (ImageView)newBestForm.lookup("#bookimg4");
	  
	  Label title1 = (Label)newBestForm.lookup("#title1");
	  Label title2 = (Label)newBestForm.lookup("#title2");
	  Label title3 = (Label)newBestForm.lookup("#title3");
	  Label title4 = (Label)newBestForm.lookup("#title4");
	  
	  Label author1 = (Label)newBestForm.lookup("#author1");
	  Label author2 = (Label)newBestForm.lookup("#author2");
	  Label author3 = (Label)newBestForm.lookup("#author3");
	  Label author4 = (Label)newBestForm.lookup("#author4");
	  
	  Image img = new Image(newbook.get(0).getImg());
	  inBestimg1.setImage(img);
	  img = new Image(newbook.get(1).getImg());
	  inBestimg2.setImage(img);
	  img = new Image(newbook.get(2).getImg());
	  inBestimg3.setImage(img);
	  img = new Image(newbook.get(3).getImg());
	  inBestimg4.setImage(img);
	  
	  title1.setText(newbook.get(0).getName());
	  title2.setText(newbook.get(1).getName());
	  title3.setText(newbook.get(2).getName());
      title4.setText(newbook.get(3).getName());
	  
	  author1.setText(newbook.get(0).getAuthor());
	  author2.setText(newbook.get(1).getAuthor());
	  author3.setText(newbook.get(2).getAuthor());
      author4.setText(newbook.get(3).getAuthor());

	
}

	public void outBestSizeUp(Parent newBestForm) {
		  NewBestDAO dao = new NewBestDAO();
		  ArrayList<NewBestDTO> newBook = dao.selectOut("해외");
		 		  
		  ImageView outBestimg1 = (ImageView)newBestForm.lookup("#bookimg1");
		  ImageView outBestimg2 = (ImageView)newBestForm.lookup("#bookimg2");
		  ImageView outBestimg3 = (ImageView)newBestForm.lookup("#bookimg3");
		  ImageView outBestimg4 = (ImageView)newBestForm.lookup("#bookimg4");
		  
		  Label title1 = (Label)newBestForm.lookup("#title1");
		  Label title2 = (Label)newBestForm.lookup("#title2");
		  Label title3 = (Label)newBestForm.lookup("#title3");
		  Label title4 = (Label)newBestForm.lookup("#title4");
		  
		  Label author1 = (Label)newBestForm.lookup("#author1");
		  Label author2 = (Label)newBestForm.lookup("#author2");
		  Label author3 = (Label)newBestForm.lookup("#author3");
		  Label author4 = (Label)newBestForm.lookup("#author4");

		  
		  Image img = new Image(newBook.get(0).getImg());
		  outBestimg1.setImage(img);
		  img = new Image(newBook.get(1).getImg());
		  outBestimg2.setImage(img);
		  img = new Image(newBook.get(2).getImg());
		  outBestimg3.setImage(img);
		  img = new Image(newBook.get(3).getImg());
		  outBestimg4.setImage(img);
		  
		  title1.setText(newBook.get(0).getName());
		  title2.setText(newBook.get(1).getName());
		  title3.setText(newBook.get(2).getName());
		  title4.setText(newBook.get(3).getName());
		  
		  author1.setText(newBook.get(0).getAuthor());
		  author2.setText(newBook.get(1).getAuthor());
		  author3.setText(newBook.get(2).getAuthor());
		  author4.setText(newBook.get(3).getAuthor());
		  
		  
	}

	@Override	
         public void inBestSizeup(Parent newBestForm) {
		  NewBestDAO dao = new NewBestDAO();
		  ArrayList<NewBestDTO> newbook = dao.selectInBest("국내");
	
		  
		  ImageView inBestimg1 = (ImageView)newBestForm.lookup("#bookimg1");
		  ImageView inBestimg2 = (ImageView)newBestForm.lookup("#bookimg2");
		  ImageView inBestimg3 = (ImageView)newBestForm.lookup("#bookimg3");
		  ImageView inBestimg4 = (ImageView)newBestForm.lookup("#bookimg4");
		  
		  Label title1 = (Label)newBestForm.lookup("#title1");
		  Label title2 = (Label)newBestForm.lookup("#title2");
		  Label title3 = (Label)newBestForm.lookup("#title3");
		  Label title4 = (Label)newBestForm.lookup("#title4");
		  
		  Label author1 = (Label)newBestForm.lookup("#author1");
		  Label author2 = (Label)newBestForm.lookup("#author2");
		  Label author3 = (Label)newBestForm.lookup("#author3");
		  Label author4 = (Label)newBestForm.lookup("#author4");
		  
		  Image img = new Image(newbook.get(0).getImg());
		  inBestimg1.setImage(img);
		  img = new Image(newbook.get(1).getImg());
		  inBestimg2.setImage(img);
		  img = new Image(newbook.get(2).getImg());
		  inBestimg3.setImage(img);
		  img = new Image(newbook.get(3).getImg());
		  inBestimg4.setImage(img);
		  
		  title1.setText(newbook.get(0).getName());
		  title2.setText(newbook.get(1).getName());
		  title3.setText(newbook.get(2).getName());
		  title4.setText(newbook.get(3).getName());
		  
		  author1.setText(newbook.get(0).getAuthor());
		  author2.setText(newbook.get(1).getAuthor());
		  author3.setText(newbook.get(2).getAuthor());
		  author4.setText(newbook.get(3).getAuthor());


	}

	@Override
	public void bookInfo(Parent newBestForm,PreviewController preCtrl,String t) {
		
		NewBestDAO dao = new NewBestDAO();
		Label titleLabel = (Label) newBestForm.lookup(t);
	    NewBestDTO dto = dao.choiceAll(titleLabel.getText());
	    Parent preForm = preCtrl.getNewPreViewForm();
	  
	    Label title =(Label) preForm.lookup("#title");
	    Label date = (Label) preForm.lookup("#date");
		Label writer = (Label) preForm.lookup("#writer");
	    Label bookNum = (Label) preForm.lookup("#bookNum");
	    Label bookLocation = (Label) preForm.lookup("#bookLocation");
		Label review = (Label) preForm.lookup("#review");
	    ImageView introimg = (ImageView) preForm.lookup("#introimg");
	    Label like = (Label)preForm.lookup("#like");
	    TextArea text = (TextArea)preForm.lookup("#findarea");
	    
	    
	    title.setText(dto.getName());
	    date.setText(dto.getDay());
	    writer.setText(dto.getAuthor());
	    bookNum.setText(dto.getNum() + "");
	    bookLocation.setText(dto.getMap());
	    review.setText(dto.getReview());
	    like.setText("좋아요 : " + dto.getGood());
	    text.setText(dto.getStory());
	    
	    Image img = new Image(dto.getImg());
	    introimg.setImage(img);
	    
	    CommonService.newStage(preForm);
	}  

     
   
	}  


//System.out.println(dto.getAuthor());
//System.out.println(titleLabel.getText());




