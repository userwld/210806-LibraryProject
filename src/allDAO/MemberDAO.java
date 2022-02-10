package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import allDTO.MemberDTO;
import common.CommonService;
import javafx.scene.Parent;

public class MemberDAO {
   private Connection con;
   
   
   public MemberDAO() {
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
   
// -------------------- member 테이블 관련 쿼리문 --------------------   
   public MemberDTO selectId(String id) {
      String sql = "select * from member where id=?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, id);
         rs = ps.executeQuery();
         
         if(rs.next()) {
            MemberDTO memberDto = new MemberDTO();
            memberDto.setNum(rs.getInt("num"));
            memberDto.setId(rs.getString("id"));
            memberDto.setPw(rs.getString("pw"));
            memberDto.setName(rs.getString("name"));
            memberDto.setYear(rs.getString("year"));
            memberDto.setMonth(rs.getString("month"));
            memberDto.setDay(rs.getString("day"));
            memberDto.setGender(rs.getString("gender"));
            memberDto.setPhone(rs.getString("phone"));
            memberDto.setHint(rs.getString("hint"));
            memberDto.setHintCombo(rs.getString("hintCombo"));
            memberDto.setBooktotal(rs.getInt("booktotal"));
            return memberDto;
         }else {
            return null;
         }
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
          CommonService.closeAll(ps, rs);
     }
      return null;
   }
   
   public MemberDTO selectName(String name) {
      String sql = "select * from member where name=?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, name);
         rs = ps.executeQuery();
         
         if(rs.next()) {
            MemberDTO memberDto = new MemberDTO();
            memberDto.setNum(rs.getInt("num"));
            memberDto.setId(rs.getString("id"));
            memberDto.setPw(rs.getString("pw"));
            memberDto.setName(rs.getString("name"));
            memberDto.setYear(rs.getString("year"));
            memberDto.setMonth(rs.getString("month"));
            memberDto.setDay(rs.getString("day"));
            memberDto.setGender(rs.getString("gender"));
            memberDto.setPhone(rs.getString("phone"));
            memberDto.setHint(rs.getString("hint"));
            memberDto.setHintCombo(rs.getString("hintCombo"));
            return memberDto;
         }else {
            return null;
         }
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
          CommonService.closeAll(ps, rs);
     }
      return null;
   }
   
   public void insert(MemberDTO member) {
      String sql = "insert into member values(num_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,0)";
      PreparedStatement ps = null;
      try {
         ps = con.prepareStatement(sql);
         
         ps.setString(1, member.getId());
         ps.setString(2, member.getPw());
         ps.setString(3, member.getName());
         ps.setString(4, member.getYear());
         ps.setString(5, member.getMonth());
         ps.setString(6, member.getDay());
         ps.setString(7, member.getGender());
         ps.setString(8, member.getPhone());
         ps.setString(9, member.getHintCombo());
         ps.setString(10, member.getHint());
         ps.setString(11, member.getGenre());
         ps.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
          CommonService.closeAll(ps, null);
     }
   }
   
   public void booktotal(int num, String id) {
      String sql = "update member set booktotal=? where id=?";
      PreparedStatement ps = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, num);
         ps.setString(2, id);
         ps.executeUpdate();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
          CommonService.closeAll(ps, null);
     }
   }

   
   
}
