package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.CommentDTO;

	public class CommentDAO {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		public List<CommentDTO> commentView(String bnum) throws SQLException, NamingException{
			List<CommentDTO> commentlist = new ArrayList<CommentDTO>();			
			
			try {
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
			     String sql = "select * from comment where bnum = "+ bnum +" order by c_num desc";
			     
			     pstmt = conn.prepareStatement(sql);
			     
			     rs = pstmt.executeQuery();	
			     System.out.println("pstmt   "+pstmt);
			     while(rs.next()) {
			    	 CommentDTO dto = new CommentDTO();
				     
			         dto.setC_num(rs.getString("c_num"));
			         dto.setC_id(rs.getString("c_id"));
			         dto.setC_content(rs.getString("c_content"));
			         dto.setC_date(rs.getString("c_date"));
			         dto.setBnum(rs.getString("bnum"));
				         commentlist.add(dto); 
				         				     
			}
			return commentlist;
			
		}catch (Exception e) {
			System.out.println("´ñ±Û ¸ñ·Ï select ½ÇÆÐ");
		}finally {
			pstmt.close();	        
		    conn.close();
		    rs.close();
		}
			return commentlist;
	
	}

		public void deleteBoardComment(String c_num, String bnum) throws SQLException{
			
			try {
				
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
		
			     String sql = "delete from comment where c_num = " + c_num;
			     
			   	 pstmt = conn.prepareStatement(sql);
		
			   	 
			   	 pstmt.executeUpdate();
			   	 
			   	 init(conn, pstmt, rs);
				
			} catch (Exception e) {
				System.out.println("´ñ±Û delete ½ÇÆÐ");
			}finally {
				pstmt.close();
				conn.close();
			}
			
		}
		
		public void init(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {

		      int count = 0;
		      String sql = "select count(*) as 'count' from comment";

		      try {
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();

		         if (rs.next()) {
		            count = rs.getInt("count");
		         }

		         String sqlList[] = { "SET @CNT = 0",
		               "UPDATE comment SET comment.c_num = @CNT:=@CNT+1", 
		               "ALTER TABLE comment AUTO_INCREMENT=" + (count + 1) };

		         for (int i = 0; i < 3; i++) {
		            pstmt = conn.prepareStatement(sqlList[i]);
		            pstmt.executeUpdate();
		         }

		      } finally {
		         if (rs != null) {
		            rs.close();
		         }
		      }
		   }

		public void insertBoardComment(String bnum, String c_id, String c_content)throws SQLException {
			
			try {
				Context init = new InitialContext();
			    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			    conn = ds.getConnection();
			    
			    String sql = "insert into comment(c_id, c_content, bnum) values(?,?,?)";
			    
			    pstmt = conn.prepareStatement(sql);
			    
			    pstmt.setString(1, c_id);
			    pstmt.setString(2, c_content);
			    pstmt.setString(3, bnum);
			    
			    pstmt.executeUpdate();
				
			}catch (Exception e) {
				System.out.println("´ñ±Ûinsert ½ÇÆÐ");
			}finally {
				pstmt.close();
				conn.close();
			}
												
		}
		
		
	}
		
