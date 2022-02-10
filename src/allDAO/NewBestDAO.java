package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import allDTO.NewBestDTO;
import common.CommonService;

public class NewBestDAO {
	
	private Connection con;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "lib";
	String password = "lib";
	
	public NewBestDAO() {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

	public ArrayList<NewBestDTO> selectNewBest(){
    	
		   ArrayList<NewBestDTO> newbook = new ArrayList<>();

		   String sql = "select * from book order by day desc";
		   PreparedStatement ps = null;  ResultSet rs = null;
		   
		   try {
			   ps = con.prepareStatement(sql);
			   rs = ps.executeQuery();
		
			   while(rs.next()) {
				   NewBestDTO dto = new NewBestDTO();
				   dto.setNum(rs.getInt("num"));
				   dto.setName(rs.getString("name"));
				   dto.setAuthor(rs.getString("author"));
				   dto.setImg(rs.getString("img"));
				   dto.setDay(rs.getString("day"));
				   dto.setMap(rs.getString("map"));
				   dto.setReview(rs.getString("review"));
				   dto.setGood(rs.getInt("good"));
				   dto.setStory(rs.getString("story"));

				   newbook.add(dto);
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   } finally {
		       CommonService.closeAll(ps, rs);
		   }

		   return newbook;
	   }

   public ArrayList<NewBestDTO> selectOut(String na){
	  
	   ArrayList<NewBestDTO> newbook = new ArrayList<>();  
	   String sql = "select * from book where nation=? order by good desc";
	   PreparedStatement ps = null; ResultSet rs = null;
	    
	   try {
		   ps = con.prepareStatement(sql);
		   ps.setString(1,na);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   NewBestDTO dto = new NewBestDTO();
			   dto.setNum(rs.getInt("num"));
			   dto.setName(rs.getString("name"));
			   dto.setAuthor(rs.getString("author"));
			   dto.setImg(rs.getString("img"));
			   dto.setDay(rs.getString("day"));
			   dto.setMap(rs.getString("map"));
			   dto.setReview(rs.getString("review"));
			   dto.setGood(rs.getInt("good"));
			   dto.setStory(rs.getString("story"));

			   newbook.add(dto);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
	       CommonService.closeAll(ps, rs);
	   }
	   return newbook;

  }
   
   
   
     public ArrayList<NewBestDTO> selectInBest(String na){
    	
	   ArrayList<NewBestDTO> newbook = new ArrayList<>();

	   String sql = "select * from book where nation=? order by good desc";
	   PreparedStatement ps = null; ResultSet rs = null;
	   
	   try {
		   ps = con.prepareStatement(sql);
		   ps.setString(1,na);
		   rs = ps.executeQuery();
	
		   while(rs.next()) {
			   NewBestDTO dto = new NewBestDTO();
			   dto.setNum(rs.getInt("num"));
			   dto.setName(rs.getString("name"));
			   dto.setAuthor(rs.getString("author"));
			   dto.setImg(rs.getString("img"));
			   dto.setDay(rs.getString("day"));
			   dto.setMap(rs.getString("map"));
			   dto.setReview(rs.getString("review"));
			   dto.setGood(rs.getInt("good"));
			   dto.setStory(rs.getString("story"));

			   newbook.add(dto);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
	       CommonService.closeAll(ps, rs);
	   }

	   return newbook;
   }
	      
		   
	   
	   
	   
  
  
  public ArrayList<NewBestDTO> selectOutBest(String na){
	  
	   ArrayList<NewBestDTO> newbook = new ArrayList<>();
	   
	   String sql = "select * from book where nation =? order by good desc";
	   PreparedStatement ps = null; ResultSet rs= null;
	   
	   try {
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   NewBestDTO dto = new NewBestDTO();
			   dto.setNum(rs.getInt("num"));
			   dto.setName(rs.getString("name"));
			   dto.setAuthor(rs.getString("author"));
			   dto.setImg(rs.getString("img"));
			   dto.setDay(rs.getString("day"));
			   dto.setMap(rs.getString("map"));
			   dto.setReview(rs.getString("review"));
			   dto.setGood(rs.getInt("good"));

			   newbook.add(dto);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
	       CommonService.closeAll(ps, rs);
	   }
	   return newbook;
	   	  
 }




	public NewBestDTO choiceAll(String bookName) {
	   String sql = "select * from book where name = ?";
	   NewBestDTO dto = new NewBestDTO();
	   PreparedStatement ps = null; ResultSet rs = null;
	   
	   try {
		ps = con.prepareStatement(sql);
		ps.setString(1,bookName);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			dto.setNum(rs.getInt("num"));
			dto.setAuthor(rs.getString("author"));
			dto.setName(rs.getString("name"));
			dto.setDay(rs.getString("day"));
			dto.setGood(rs.getInt("good"));
			dto.setImg(rs.getString("img"));
			dto.setMap(rs.getString("map"));
			dto.setReview(rs.getString("review"));
			dto.setStory(rs.getString("story"));
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	    CommonService.closeAll(ps, rs);
	}
	return dto;
		
	}



	  
  }

   
   