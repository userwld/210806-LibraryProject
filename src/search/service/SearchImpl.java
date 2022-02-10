package search.service;

import java.util.ArrayList;

import allDAO.SearchDAO;
import allDTO.NewBestDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import preview.PreviewController;

public class SearchImpl implements SearchService {
	private SearchDAO dao = new SearchDAO();
	NewBestDTO dto = new NewBestDTO();
	
	@Override
	public void openPreViewForm1(Parent searchForm,PreviewController preCtrl ) {
		
		Label name = (Label)searchForm.lookup("#name0");
		if(!name.getText().equals("")) {
			NewBestDTO dto = dao.selectName(name.getText());
			Parent pre = preCtrl.getNewPreViewForm();
			
			Label name1 =(Label)pre.lookup("#title");
			name1.setText(dto.getName());
			Label name2 =(Label)pre.lookup("#date");
			name2.setText(dto.getDay());
			Label name3 =(Label)pre.lookup("#bookNum");
			name3.setText(dto.getNum()+" ");
			Label name4 =(Label)pre.lookup("#bookLocation");
			name4.setText(dto.getMap());
			Label name5 =(Label)pre.lookup("#writer");
			name5.setText(dto.getAuthor());
			Label name6 =(Label)pre.lookup("#review");
			name6.setText(dto.getReview());
			ImageView img1 =(ImageView)pre.lookup("#introimg");
			Image d = new Image(dto.getImg());
			img1.setImage(d);
			Label name7 = (Label)pre.lookup("#like");
			name7.setText("좋아요 : " + dto.getGood());
			TextArea name8 = (TextArea)pre.lookup("#findarea");
			name8.setText(dto.getStory());
			CommonService.newStage(pre);
		}
	}
	

	@Override
	public void openPreViewForm2(Parent searchForm,PreviewController preCtrl) {
		Label name = (Label)searchForm.lookup("#name1");
		if(!name.getText().equals("")) {
			NewBestDTO dto = dao.selectName(name.getText());
			Parent pre = preCtrl.getNewPreViewForm();
			
			Label name1 =(Label)pre.lookup("#title");
			name1.setText(dto.getName());
			Label name2 =(Label)pre.lookup("#date");
			name2.setText(dto.getDay());
			Label name3 =(Label)pre.lookup("#bookNum");
			name3.setText(dto.getNum()+" ");
			Label name4 =(Label)pre.lookup("#bookLocation");
			name4.setText(dto.getMap());
			Label name5 =(Label)pre.lookup("#writer");
			name5.setText(dto.getAuthor());
			Label name6 =(Label)pre.lookup("#review");
			name6.setText(dto.getReview());
			ImageView img1 =(ImageView)pre.lookup("#introimg");
			Image d = new Image(dto.getImg());
			img1.setImage(d);
			Label name7 = (Label)pre.lookup("#like");
			name7.setText("좋아요 : " + dto.getGood());
			TextArea name8 = (TextArea)pre.lookup("#findarea");
			name8.setText(dto.getStory());
			CommonService.newStage(pre);
		}
	}
							
	@Override
	public void openPreViewForm3(Parent searchForm,PreviewController preCtrl ) {
		Label name = (Label)searchForm.lookup("#name2");
		if(!name.getText().equals("")) {
			NewBestDTO dto = dao.selectName(name.getText());
			Parent pre = preCtrl.getNewPreViewForm();
			
			Label name1 =(Label)pre.lookup("#title");
			name1.setText(dto.getName());
			Label name2 =(Label)pre.lookup("#date");
			name2.setText(dto.getDay());
			Label name3 =(Label)pre.lookup("#bookNum");
			name3.setText(dto.getNum()+" ");
			Label name4 =(Label)pre.lookup("#bookLocation");
			name4.setText(dto.getMap());
			Label name5 =(Label)pre.lookup("#writer");
			name5.setText(dto.getAuthor());
			Label name6 =(Label)pre.lookup("#review");
			name6.setText(dto.getReview());
			ImageView img1 =(ImageView)pre.lookup("#introimg");
			Image d = new Image(dto.getImg());
			Label name7 = (Label)pre.lookup("#like");
			name7.setText("좋아요 : " + dto.getGood());
			TextArea name8 = (TextArea)pre.lookup("#findarea");
			name8.setText(dto.getStory());
			img1.setImage(d);
			CommonService.newStage(pre);
		}
	}


	private void setPreviewForm(Parent previewForm) {

	}


	@Override
	public void labSizeUp(Parent searchForm, String labelName) {
		Label lb = (Label)searchForm.lookup(labelName);
		lb.setScaleX(1.3);
		lb.setScaleY(1.3);
		
	}

	@Override
	public void labSizeDown(Parent searchForm, String labelName) {
		Label lb = (Label)searchForm.lookup(labelName);
		lb.setScaleX(1);
		lb.setScaleY(1);
		
	}

	@Override
	public void boxColorUp(Parent searchForm, String boxName) {
		HBox box =(HBox)searchForm.lookup(boxName);
		box.setStyle("fx-background-color: black");
	}

	@Override
	public void boxColorDown(Parent searchForm, String boxName) {
		HBox box =(HBox)searchForm.lookup(boxName);
		box.setStyle("fx-background-color : red ");
		
	}

	public void setSearch(Parent searchForm, String bookname) {
		setSearchClear(searchForm);
		
		String a = "%"+bookname+"%";
		ArrayList<NewBestDTO> dto = dao.selectLike(a);
		
		for(int i= 0; i < dto.size(); i++) {
			if (i < 3)
				setView(searchForm,i,dto.get(i).getName(),dto.get(i).getAuthor(),dto.get(i).getImg());
			else break;

		}
	}


	public void setSearchClear(Parent searchForm) {
		Label name0 = (Label)searchForm.lookup("#name0");
		Label name1 = (Label)searchForm.lookup("#name1");
		Label name2 = (Label)searchForm.lookup("#name2");
		
		Label author0 = (Label)searchForm.lookup("#author0");
		Label author1 = (Label)searchForm.lookup("#author1");
		Label author2 = (Label)searchForm.lookup("#author2");
		
		ImageView img0 =(ImageView)searchForm.lookup("#img0");
		ImageView img1 =(ImageView)searchForm.lookup("#img1");
		ImageView img2 =(ImageView)searchForm.lookup("#img2");
		
		
		name0.setText("");
		name1.setText("");
		name2.setText("");

		author0.setText("");
		author1.setText("");
		author2.setText("");
		
		img0.setImage(new Image("/img/no.png"));
		img1.setImage(new Image("/img/no.png"));
		img2.setImage(new Image("/img/no.png"));
	}


	private void setView(Parent searchForm, int i, String bookname,String author, String img) {
	
		String a = "#name"+i;
		Label name = (Label) searchForm.lookup(a);
		name.setText(bookname);
		
		String b = "#author"+i;
		Label authorLabel = (Label) searchForm.lookup(b);
		authorLabel.setText(author);
		
		String c = "#img" + i;
		ImageView img1 =(ImageView)searchForm.lookup(c);
		
		Image d = new Image(img);
		img1.setImage(d);

		
	}



	
	}
		
	

