package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import allDTO.NoticeDTO;
import common.CommonService;

public class NoticeDAO {
	private Connection con;
	
	public NoticeDAO() {
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
		
		public NoticeDTO selectOne(String title) {
			String sql = "select * from notice where title = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1,title);
				rs = ps.executeQuery();
				if(rs.next()) {
					NoticeDTO noticeDto = new NoticeDTO();
					noticeDto.setNum(rs.getInt("num"));
					noticeDto.setTitle(rs.getString("title"));
					noticeDto.setName(rs.getString("name"));
					noticeDto.setDay(rs.getString("day"));
					noticeDto.setText(rs.getString("text"));
					return noticeDto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			    CommonService.closeAll(ps, rs);
		    }
			
			return null;
		}
		
		public void insert(NoticeDTO args) {
			String sql = "insert into notice values(noti_seq.nextval,?,?,?,?)";
			PreparedStatement ps = null;
		
	
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, args.getTitle());
				ps.setString(2, args.getName());
				ps.setString(3, args.getDay());
				ps.setString(4, args.getText());
				ps.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			    CommonService.closeAll(ps, null);
			}
			 
		}
		
		public void delete(int num) {
			String sql = "delete from notice where num=?";
			PreparedStatement ps = null;
			
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			   CommonService.closeAll(ps, null);
			}
		}
		
		public ArrayList<NoticeDTO> selectAll() {
			ArrayList<NoticeDTO> all = new ArrayList<>();
			String sql = "select * from notice order by day desc";
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					NoticeDTO dto = new NoticeDTO();
					dto.setDay(rs.getString("day"));
					dto.setName(rs.getString("name"));
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setText(rs.getString("text"));
					all.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			   CommonService.closeAll(ps, rs);
			}
			return all;
			
		}
	

}


