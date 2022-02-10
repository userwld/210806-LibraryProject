package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import allDTO.NewBestDTO;
import allDTO.NoticeDTO;
import allDTO.RentalDTO;
import common.CommonService;

public class MainDAO {
	private Connection con;
	
	public MainDAO() {
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

	public ArrayList<NewBestDTO> moreLike() {
		ArrayList<NewBestDTO> likeBook = new ArrayList<>();
		String sql = "select name,good from book order by good desc";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()){
					NewBestDTO dto = new NewBestDTO();
					dto.setName(rs.getString("name"));
					dto.setGood(rs.getInt("good"));
					likeBook.add(dto);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	          CommonService.closeAll(ps, rs);
	       }
		return likeBook;
	}

	public ArrayList<NewBestDTO> selectNew() {
		ArrayList<NewBestDTO> newBook = new ArrayList<>();
		String sql = "select * from book order by day desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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
				dto.setStory(rs.getString("story"));
				dto.setReview(rs.getString("review"));
				dto.setGood(rs.getInt("Good"));
				newBook.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		return newBook;
	}

	public ArrayList<NewBestDTO> bestGenre() {
		ArrayList<NewBestDTO> bestGenre = new ArrayList<>();
		String sql = "select genre,sum(good) from book group by genre";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				NewBestDTO dto = new NewBestDTO();
				dto.setGenre(rs.getString("genre"));
				dto.setGood(rs.getInt("SUM(GOOD)"));
				bestGenre.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		return bestGenre;
	}

	public ArrayList<NoticeDTO> recentNotice() {
		ArrayList<NoticeDTO> recent = new ArrayList<>();
		String sql = "select * from notice order by day desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setDay(rs.getString("day"));
				dto.setText(rs.getString("text"));
				recent.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		return recent;
	}

	public HashMap<String,Integer> preferGenre(int i) {
		HashMap<String,Integer> prefer = new HashMap<>();
		String ages = i + "";
		String sql = "select genre,count(*) from member where year <= ? group by genre";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ages);
			rs = ps.executeQuery();
			while(rs.next()) {
				prefer.put(rs.getString("genre"), rs.getInt("count(*)"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		return prefer;
	}
	
	public HashMap<String,Integer> preferGenre(int i, int j) {
		HashMap<String,Integer> prefer = new HashMap<>();
		String ages = i + "년"; String ages2 = j + "년";
		String sql = "select genre,count(*) from member where year between ? and ? group by genre";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ages);
			ps.setString(2, ages2);
			rs = ps.executeQuery();
			while(rs.next()) {
				prefer.put(rs.getString("genre"), rs.getInt("count(*)"));
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		return prefer;
	}
	
	public int sumCount(int i) {
		String ages = i + "년";
		String sql = "select sum(count(*)) from member where year <= ? group by genre";
		int sum = 0; 
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ages);
			rs = ps.executeQuery();
			if(rs.next())
				sum = rs.getInt("sum(count(*))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	          CommonService.closeAll(ps, rs);
	     }
		return sum;
	}
	
	public int sumCount(int i, int j) {
		String ages = i + "년"; String ages2 = j + "년";
		String sql = "select sum(count(*)) from member where year between ? and ? group by genre";
		int sum = 0;
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ages);
			ps.setString(2, ages2);
			rs = ps.executeQuery();
			if(rs.next())
				sum = rs.getInt("sum(count(*))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	          CommonService.closeAll(ps, rs);
	    }
		return sum;
	}

	public ArrayList<NewBestDTO> bookAll() {
		ArrayList<NewBestDTO>allBook = new ArrayList<NewBestDTO>();
		String sql = "select name,author from book";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				NewBestDTO dto = new NewBestDTO();
				dto.setName(rs.getString("name"));
				dto.setAuthor(rs.getString("author"));
				allBook.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        CommonService.closeAll(ps, rs);
	    }
		
		return allBook;
	}
	

	 
	
	
	
	

}
