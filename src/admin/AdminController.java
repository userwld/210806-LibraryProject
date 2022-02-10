package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import allDAO.AdminDAO;
import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.MainController;


public class AdminController implements Initializable {
    
	private Parent adminForm;
	private MainController mainCtrl;

	@FXML
    private  Label gohome;
 	@FXML
    private TextField tfName;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfGenre;

    @FXML
    private TextField tfDay;

    @FXML
    private TextField tfMap;
	@FXML
	private TextField tfReview;
    @FXML
    private TextField tfGood;
   
    @FXML
    private TextField tfImg;

    @FXML
    private TextField tfNation;
    @FXML
    private TextField tfStory;
    @FXML
    private TextField tfTotal;
    @FXML
    private TableView<AdminDAO> tvBooks;
    @FXML
    private TableColumn<AdminDAO, Integer> colNum;
    @FXML
    private TableColumn<AdminDAO, String> colName;

    @FXML
    private TableColumn<AdminDAO, String> colAuthor;

    @FXML
    private TableColumn<AdminDAO, String> colGenre;

    @FXML
    private TableColumn<AdminDAO, String> colDay;

    @FXML
    private TableColumn<AdminDAO, String> colMap;
    
    @FXML
    private TableColumn<AdminDAO, String> colReview;
    @FXML
    private TableColumn<AdminDAO, Integer> colGood;

    @FXML
    private TableColumn<AdminDAO, String> colImg;
    
    @FXML
    private TableColumn<AdminDAO, String> colNation;
    @FXML
    private TableColumn<AdminDAO, String> colStory;
    @FXML
    private TableColumn<AdminDAO, Integer> colTotal;
    
    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    
	public void setAdForm(Parent adminForm) {
		this.adminForm = adminForm;
		
	}

	public void setMainCtrl(MainController mainController) {
		this.mainCtrl = mainController;
		
	}
    
    @FXML
    private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
       }
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
       
        showBooks();
    }
 
	
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lib","lib");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<AdminDAO> getBooksList(){
        ObservableList<AdminDAO> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM book";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            AdminDAO adminDAO;
            while(rs.next()){
                adminDAO = new AdminDAO(rs.getInt("num"), rs.getString("name"), rs.getString("author"), rs.getString("genre"), rs.getString("day"),rs.getString("map"),
                		rs.getString("review"),rs.getInt("good"),rs.getString("img"),rs.getString("nation"),rs.getString("story") ,rs.getInt("total"));
                bookList.add(adminDAO);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
    }

    
    public void showBooks(){
        ObservableList<AdminDAO> list = getBooksList();
        colNum.setCellValueFactory(new PropertyValueFactory<AdminDAO, Integer>("num"));
        colName.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("genre"));
        colDay.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("day"));
        colMap.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("map"));
        colReview.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("review"));
        colGood.setCellValueFactory(new PropertyValueFactory<AdminDAO, Integer>("good"));
        colImg.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("img"));
        colNation.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("nation"));
        colStory.setCellValueFactory(new PropertyValueFactory<AdminDAO, String>("story"));
        colTotal.setCellValueFactory(new PropertyValueFactory<AdminDAO, Integer>("total"));
        
        tvBooks.setItems(list);
    }
    private void insertRecord(){
    	if(isEmptyCheck() == true) {
	        String query = "INSERT INTO book VALUES(book_seq.nextval, '" + tfName.getText() + "','" + tfAuthor.getText() + "','" + tfGenre.getText() + "','" +
	    tfDay.getText() + "','" + tfMap.getText() + "', '" + tfReview.getText() + "'," + tfGood.getText() + ", '" + tfImg.getText() + "','" +
	        		tfNation.getText() + "','" + tfStory.getText() + "' , " + tfTotal.getText() + ")";
	        executeQuery(query);
	        showBooks();
    	}else {
    		CommonService.ErrorMsg("빈 항목이 존재합니다.");
    	}
    }
    private boolean isEmptyCheck() {
    	if(tfName.getText().isEmpty()||tfAuthor.getText().isEmpty()||tfGenre.getText().isEmpty()||
    	   tfGenre.getText().isEmpty() || tfDay.getText().isEmpty() || tfMap.getText().isEmpty() ||
    	   tfReview.getText().isEmpty() || tfGood.getText().isEmpty() || tfImg.getText().isEmpty() ||
    	   tfNation.getText().isEmpty() || tfStory.getText().isEmpty() || tfTotal.getText().isEmpty()) {
    		return false;
    	}
    
    	return true;

	}

	private void updateRecord(){
    	if(selectRecord()) {
		String query = "UPDATE book SET genre = '" + tfGenre.getText() + "', day = '" + tfDay.getText() + "', map = '" + tfMap.getText()
		+ "', review = '" + tfReview.getText() + "',good ='" + tfGood.getText() + "', img = '" +tfImg.getText() + "', nation ='" +
	            tfNation.getText() + "', story = '" + tfStory.getText() + "' , total = '" + tfTotal.getText() + "' WHERE name  = '" + tfName.getText() + "'";
	    executeQuery(query);
	    showBooks();
        }else {
        	CommonService.ErrorMsg("그런책은 없습니다.");
        }
    }
    private void deleteButton(){
        String query = "DELETE FROM book WHERE name =  '"+ tfName.getText() + "'";
        executeQuery(query);
        showBooks();
    }
    
    private boolean selectRecord() {
    	String query = "SELECT * FROM book WHERE name ='" + tfName.getText() + "'";
    	Connection conn = getConnection();
        Statement st;
          try{
              st = conn.createStatement();
              ResultSet rs =   st.executeQuery(query);
              if(rs.next()) return true;
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
          return false;
    }
    


    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
       

    @FXML
    private void handleMouseAction(MouseEvent event) {	
    	AdminDAO book = tvBooks.getSelectionModel().getSelectedItem();
    	if(book != null) {
	    	tfName.setText(book.getName());
	    	tfAuthor.setText(book.getAuthor());
	    	tfGenre.setText(book.getGenre());
	    	tfDay.setText(book.getDay());
	    	tfMap.setText(book.getMap());
	    	tfReview.setText(book.getReview());
	    	tfGood.setText(""+book.getGood());
	    	tfImg.setText(book.getImg());
	    	tfNation.setText(book.getNation());
	    	tfStory.setText(book.getStory());
	    	tfTotal.setText(""+book.getTotal());
	        	
    	}
	}	

    public void home() {
    	mainCtrl.setChart();
    	mainCtrl.openMainForm();
    	CommonService.closeStage(adminForm);
    }


   
        
    
}
