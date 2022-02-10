package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import allDTO.LikeDTO;
import common.CommonService;

public class PartDAO {
	
private Connection con;
	
	public PartDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "lib";
		String password = "lib";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<LikeDTO> likeBook(String id) {
		ArrayList<LikeDTO> likeBook = new ArrayList<>();
		String sql = "select book from mylike where id = ?";
		PreparedStatement ps = null; ResultSet rs  = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				LikeDTO dto = new LikeDTO();
				dto.setBook(rs.getString("book"));
				likeBook.add(dto);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   CommonService.closeAll(ps, rs);
		}
		return likeBook;
	}


	public void insertLike(String book, String author, String id) {
		String sql = "update book set good = good+1 where name = ? and author = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,book);
			ps.setString(2,author);
			ps.executeQuery();
			
			sql = "insert into myLike values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,book);
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   CommonService.closeAll(ps, null);
		}
	}


	public void cancelLike(String book, String author, String id) {
		String sql = "update book set good = good-1 where name = ? and author = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,book);
			ps.setString(2,author);
			ps.executeQuery();
			
			sql = "delete from mylike where id = ? and book = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,book);
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonService.closeAll(ps, null);
	    }
	}


	public void updateReview(String id, String book, String review) {
		String sql = "update myreview set review = ? where book = ? and id = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,review);
			ps.setString(2,book);
			ps.setString(3,id);
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		    CommonService.closeAll(ps, null);
		}
		
	}

	public void newReview(String id, String book, String review) {
		String sql = "insert into myreview values(?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,book);
			ps.setString(3,review);
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    CommonService.closeAll(ps, null);
		}
	}


	public String revBook(String id, String book) {
		String review = "";
		String sql = "select review from myreview where id = ? and book = ?";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,book);
			rs = ps.executeQuery();
			if(rs.next()) {
				review = rs.getString("review");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   CommonService.closeAll(ps, rs);
		}
		
		return review;
	}
	
	

}
