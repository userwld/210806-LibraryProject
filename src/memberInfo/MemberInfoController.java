package memberInfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import allDAO.MemberDAO;
import allDAO.RentalDAO;
import allDTO.MemberDTO;
import allDTO.RentalDTO;
import common.CommonService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.MainController;
import memberInfo.service.Memberinfo;
import memberInfo.service.MemberinfoServiceImpl;

public class MemberInfoController implements Initializable{
	private RentalDAO rentalDao = new RentalDAO();
	private Parent memInfoForm;
	private Parent loginForm;
	private MainController mainCtrl;
	private Memberinfo meminfoSvc;

	public void setMemInfoForm(Parent memInfoForm) {
		this.memInfoForm = memInfoForm;
	}
	public void setMainCtrl(MainController mainController) {
		this.mainCtrl = mainController;
	}
	public Parent getMemInfoForm() {
		return memInfoForm;
	}
	
	 @Override
		public void initialize(URL location, ResourceBundle resources) {
			meminfoSvc = new MemberinfoServiceImpl();			
		}	 
	 
	 public void lookupProc() {
		 meminfoSvc.lookupProc(memInfoForm);
	 }

// -------------------- 회원정보창에 정보 뿌려주기 --------------------
	 public void setMemInfo(Parent loginForm, Parent memInfoForm) {
		  this.loginForm = loginForm;
	      MemberDAO memberDao = new MemberDAO();
	      TextField id = (TextField)loginForm.lookup("#idText");
	      MemberDTO memberDto = memberDao.selectId(id.getText());

	      Label nameLabel = (Label)memInfoForm.lookup("#nameLabel");
	      Label idLabel = (Label)memInfoForm.lookup("#idLabel");
	      Label phoneLabel = (Label)memInfoForm.lookup("#phoneLabel");
     
	      nameLabel.setText(memberDto.getName());
	      idLabel.setText(memberDto.getId());
	      phoneLabel.setText(memberDto.getPhone());
	 }	 

	 public void rentalProc() {
		 meminfoSvc.rentalProc(memInfoForm);
		 ListView<String> booknumList = (ListView<String>) memInfoForm.lookup("#bookNumList");
		 ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
		 ListView<String> rentalList = (ListView<String>) memInfoForm.lookup("#rentalList");
		 ListView<String> returnList = (ListView<String>) memInfoForm.lookup("#returnList");	
		 TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");
			
		 bookNumText.clear();
	 }
	 
	 public void returnProc() {
		 meminfoSvc.returnProc(memInfoForm);
		 ListView<String> booknumList = (ListView<String>) memInfoForm.lookup("#bookNumList");
		 ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
		 ListView<String> rentalList = (ListView<String>) memInfoForm.lookup("#rentalList");
		 ListView<String> returnList = (ListView<String>) memInfoForm.lookup("#returnList");	
		 TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");

		 bookNumText.clear();
	 }
	 
	 public void gotoMainProc() {
		 ListView<String> booknumList = (ListView<String>) memInfoForm.lookup("#bookNumList");
		 ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
		 ListView<String> rentalList = (ListView<String>) memInfoForm.lookup("#rentalList");
		 ListView<String> returnList = (ListView<String>) memInfoForm.lookup("#returnList");	
		 TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");
			
		 booknumList.getItems().clear();
		 booknameList.getItems().clear();
		 rentalList.getItems().clear();
		 returnList.getItems().clear();
		 bookNumText.clear();

		 CommonService.closeStage(memInfoForm);
		 CommonService.openStage(mainCtrl.getMainForm());
	 }
	 
	 public void listClick() {
		 TextField id = (TextField)loginForm.lookup("#idText");
		 ArrayList<RentalDTO> rentalDto = rentalDao.selectId(id.getText());
		 ListView<String> booknumList = (ListView<String>) memInfoForm.lookup("#bookNumList");
		 ListView<String> booknameList = (ListView<String>) memInfoForm.lookup("#booknameList");
	     ListView<String> rentalList = (ListView<String>) memInfoForm.lookup("#rentalList");
		 ListView<String> returnList = (ListView<String>) memInfoForm.lookup("#returnList");	
		 TextField bookNumText = (TextField) memInfoForm.lookup("#bookNumText");
		 
		 booknumList.getItems().clear();
		 booknameList.getItems().clear();
		 rentalList.getItems().clear();
		 returnList.getItems().clear();
		 

		 for(int i = 0; i < rentalDto.size(); i++) {
			booknumList.getItems().add(rentalDto.get(i).getNum()+"");
			booknameList.getItems().add(rentalDto.get(i).getBookname());
			rentalList.getItems().add(rentalDto.get(i).getRentaldate().toString());
			returnList.getItems().add(rentalDto.get(i).getReturndate().toString());	 
		 }
	 }
	 
	 
	 
	 
	 
	 
}
