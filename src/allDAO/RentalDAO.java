package allDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import allDTO.NewBestDTO;
import allDTO.RentalDTO;
import common.CommonService;



public class RentalDAO {
   private Connection con;
   
   public RentalDAO() {
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "lib";
      String password = "lib";
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
// -------------------- rental 테이블 관련 쿼리문 --------------------   
   public void rental(RentalDTO dto) {
      String sql = "insert into rental values(?,?,?,to_date(sysdate),to_date(sysdate)+14)";
      PreparedStatement ps = null;      
      try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, dto.getNum());
         ps.setString(2, dto.getId());
         ps.setString(3, dto.getBookname());
         ps.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         CommonService.closeAll(ps, null);
      }
   }
   
   public void returnbook(int num) {
      String sql = "delete from rental  where num=?";
      PreparedStatement ps = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, num);
         ps.executeUpdate();
      } catch (SQLException e) {
         
         e.printStackTrace();
      }finally {
          CommonService.closeAll( ps, null);
       }
   }
   
   public ArrayList<RentalDTO> selectId(String id) {
      ArrayList<RentalDTO> list = new ArrayList<RentalDTO>();
      String sql = "select * from rental where id=?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, id);
         rs = ps.executeQuery();
         while(rs.next()) {
            RentalDTO rentalDto = new RentalDTO();
            rentalDto.setNum(rs.getInt("num"));         
            rentalDto.setBookname(rs.getString("bookname"));
            rentalDto.setRentaldate(rs.getDate("rentaldate"));
            rentalDto.setReturndate(rs.getDate("returndate"));
            list.add(rentalDto);
         }
         return list;
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
          CommonService.closeAll(ps, rs);
       }
      return null;
   }
   
   public RentalDTO selectOne(String id) {
      String sql = "select * from rental where id=?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, id);
         rs = ps.executeQuery();
         if(rs.next()) {
            RentalDTO rentalDto = new RentalDTO();
            rentalDto.setNum(rs.getInt("num"));
            rentalDto.setBookname(rs.getString("bookname"));
            rentalDto.setRentaldate(rs.getDate("rentaldate"));
            rentalDto.setReturndate(rs.getDate("returndate"));
            return rentalDto;
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
          CommonService.closeAll(ps, rs);
       }
      return null;
   }
   
   public int selectArr(String bookname) {
      String sql = "select num from rental where bookname=?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      int num = 0;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1,  bookname);
         rs = ps.executeQuery();
         if(rs.next()) {
            num = rs.getInt("num");   
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
          CommonService.closeAll(ps, rs);
       }
      return num;
   }

// -------------------- book 테이블 관련 쿼리분 --------------------
   public void updateBook(int num, String name) {
      String sql = "update book set total=? where name=?";
      PreparedStatement ps = null;      
      try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, num);
         ps.setString(2, name);
         ps.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
          CommonService.closeAll(ps, null);
       }
   }
   
   public NewBestDTO lookupBook(String text) {      
      int number = 0;
      if(!text.isEmpty()) {
         try {
            number = Integer.parseInt(text);
         }catch(NumberFormatException e) {
            
         }catch(Exception e) {
            
         }
      }
      String sql = "select * from book where num=?";
      PreparedStatement ps = null;      
      ResultSet rs = null;
      try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, number);
         rs = ps.executeQuery();
         if(rs.next()) {
            NewBestDTO newBestDto = new NewBestDTO();   
            newBestDto.setNum(rs.getInt("num"));
            newBestDto.setName(rs.getString("name"));
            newBestDto.setTotal(rs.getInt("total"));
            return newBestDto;
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
          CommonService.closeAll(ps, rs);
       }
      return null;
   }
   

  
   
   


}