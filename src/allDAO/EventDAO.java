package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import allDTO.EventDTO;
import common.CommonService;

public class EventDAO {
	private Connection con;
	
	public EventDAO() {
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
		
		public EventDTO selectOne(String title) {
			String sql = "select * from event where title = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1,title);
				rs = ps.executeQuery();
				if(rs.next()) {
					EventDTO eventDto = new EventDTO();
					eventDto.setNum(rs.getInt("num"));
					eventDto.setTitle(rs.getString("title"));
					eventDto.setName(rs.getString("name"));
					eventDto.setDay(rs.getString("day"));
					eventDto.setText(rs.getString("text"));
					eventDto.setImg(rs.getString("image"));
					return eventDto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			   CommonService.closeAll(ps, rs);
			}
			
			return null;
		}
		
		public void insert(EventDTO args) {
			String sql = "insert into event values(event_seq.nextval,?,?,?,?,?)";
			PreparedStatement ps = null;
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, args.getTitle());
				ps.setString(2, args.getName());
				ps.setString(3, args.getDay());
				ps.setString(4, args.getText());
				ps.setString(5, args.getImg());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			   CommonService.closeAll(ps, null);
			}
		}
		
		public void delete(int num) {
			String sql = "delete from event where num=?";
			PreparedStatement ps = null;
			
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
			   CommonService.closeAll(ps, null);
			}
		}
		
		public ArrayList<EventDTO> selectAll() {
			ArrayList<EventDTO> all = new ArrayList<>();
			String sql = "select * from event order by day desc";
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					EventDTO dto = new EventDTO();
					dto.setDay(rs.getString("day"));
					dto.setName(rs.getString("name"));
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setText(rs.getString("text"));
					dto.setImg(rs.getString("image"));
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


