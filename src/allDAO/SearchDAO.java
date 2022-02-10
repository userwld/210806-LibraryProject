package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import allDTO.NewBestDTO;
import common.CommonService;

public class SearchDAO {
	
private Connection con;
	
	public SearchDAO() {
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

	public ArrayList<NewBestDTO> selectLike(String bookname) {
		ArrayList<NewBestDTO> list = new ArrayList<>();
		String sql = "select * from book where name like ?";
		PreparedStatement ps = null; ResultSet rs = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,bookname);
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
				list.add(dto);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   CommonService.closeAll(ps, rs);
		}
		return list;
	}

	public NewBestDTO selectName(String bookname) {
		NewBestDTO dto = new NewBestDTO();
		String sql = "select * from book where name = ?";
		PreparedStatement ps = null; ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAuthor(rs.getString("author"));
				dto.setImg(rs.getString("img"));
				dto.setDay(rs.getString("day"));
				dto.setMap(rs.getString("map"));
				dto.setReview(rs.getString("review"));
				dto.setGood(rs.getInt("good"));
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
