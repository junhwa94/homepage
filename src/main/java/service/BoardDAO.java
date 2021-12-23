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

import model.BoardDTO;


	public class BoardDAO {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		public List<BoardDTO> boardViewList() throws SQLException{
			
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
	    
	    try {			
			 Context init = new InitialContext();
		     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
		     conn = ds.getConnection();
			
		     String sql = "select * from board order by bnum desc";
		     
		     pstmt = conn.prepareStatement(sql);
		     
		     rs = pstmt.executeQuery();
		     
		     while(rs.next()) {
					
		    	 BoardDTO dto = new BoardDTO();
			            
			         dto.setBnum(rs.getString("bnum"));
			         dto.setBwriter(rs.getString("bwriter"));
			         dto.setBpw(rs.getString("bpw"));
			         dto.setBtitle(rs.getString("btitle"));
			         dto.setBcontent(rs.getString("bcontent"));
			         dto.setBviews(rs.getString("bviews"));
			         dto.setBreg_date(rs.getString("breg_date"));
			
			          boardList.add(dto);
	
				}
				return boardList;
				
			} catch (Exception e) {
				System.out.println("게시판목록 select 실패");
			} finally {
		         if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
		        }
		       
		       
		   return boardList;
	 }


		public List<BoardDTO> boardContentList(String bnum) throws SQLException, NamingException {

			List<BoardDTO> contentlist = new ArrayList<BoardDTO>();
		
			try {

				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
			     String sql = "select * from board where bnum = " + bnum;
			     pstmt = conn.prepareStatement(sql);

			     rs = pstmt.executeQuery();

			     while(rs.next()) {
						
			    	 BoardDTO dto = new BoardDTO();
				            
				         dto.setBnum((rs.getString("bnum")));
				         dto.setBwriter(rs.getString("bwriter"));
				         dto.setBpw(rs.getString("bpw"));
				         dto.setBtitle(rs.getString("btitle"));
				         dto.setBcontent(rs.getString("bcontent"));
				         dto.setBviews(rs.getString("bviews"));
				         dto.setBreg_date(rs.getString("breg_date"));
      
				         contentlist.add(dto);
				         
				}
			     
			     pstmt.close();
			     conn.close();
			     rs.close();
			     
			     conn= null;
			     pstmt=null;
			     rs= null;
			     
					
		    String sqlU = "update board set bviews = bviews+1 where bnum = " + bnum;  

		    Context init1 = new InitialContext();
		     DataSource ds1 = (DataSource) init1.lookup("java:comp/env/jdbc/MySQL");
		     conn = ds1.getConnection();
	      
		      pstmt = conn.prepareStatement(sqlU);   

		      pstmt.executeUpdate();

		      return contentlist;
			       
		}catch (Exception e) {
			
			System.out.println("글읽기 실패");
		
		}finally {
			if(pstmt != null)
	             pstmt.close();
	          if(conn != null)
	             conn.close();

		  }
			
			return contentlist;
	}
		
		
			
		public void boardInsert(String b_writer, String b_pw, String b_title, String b_content)throws SQLException, NamingException{
			
			try {			
				Context init = new InitialContext();
			    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			    conn = ds.getConnection();
				
			    if(b_pw.equals("null")){
					String sql = "insert into board(bwriter, btitle, bcontent) values(?,?,?)";
			    	
			    	 pstmt = conn.prepareStatement(sql);		
					   
					 pstmt.setString(1, b_writer);
					 pstmt.setString(2, b_title);
					 pstmt.setString(3, b_content);
				    
					 pstmt.executeUpdate();
					
			    }else {
			    	String sql = "insert into board(bwriter, bpw, btitle, bcontent) values(?,?,?,?)";
				      
				    pstmt = conn.prepareStatement(sql);		

				    pstmt.setString(1, b_writer);
				    pstmt.setString(2, b_pw);
				    pstmt.setString(3, b_title);
				    pstmt.setString(4, b_content);
			    
					pstmt.executeUpdate();
			    	
			    }
			    
				
				
			} catch (Exception e) {
				
				System.out.println("글작성 실패");
			
			}finally {
				if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
	
			  }
	
	}
			
		public int boardPwCheck(String b_pw) throws SQLException {
			
			try {			
					Context init = new InitialContext();
			        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			        conn = ds.getConnection();
			         
			        String sql = "select * from board where bpw = ?";
	
					pstmt = conn.prepareStatement(sql);			
					
					pstmt.setString(1, b_pw);
					
					rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return 1;
				}else if(b_pw.equals("")) {
					return 2;
				}else {
					return 0;
				}
				 
				
			} catch (Exception e) {
				
				System.out.println("비밀번호 비교 실패");
			
			} finally {
		         rs.close();
		         pstmt.close();
		         conn.close();
		      }
			
			return -1;
			
		}
		
		public void contentDelete(String uid, String bnum, String bviews) throws SQLException{
					
			try {
				
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
		
			     String sql = "delete from board where bnum = " + bnum;
			     
			   	 pstmt = conn.prepareStatement(sql);
		
			   	 
			   	 pstmt.executeUpdate();
			   	 
			   	 init(conn, pstmt, rs);
			   	 
				
			} catch (Exception e) {
				System.out.println("글삭제 실패");
			} finally {
		         if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
		        }
			
		}
		public void contentUpdate(String bnum, String btitle, String bcontent) throws SQLException {
			
			try {
				
				Context init = new InitialContext();
			    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			    conn = ds.getConnection();
			
			    String sql = "update board set btitle = ?, bcontent =? where bnum = ?";
			    
			   	pstmt = conn.prepareStatement(sql);
			   	
			   	pstmt.setString(1, btitle);
				pstmt.setString(2, bcontent);
				pstmt.setString(3, bnum);
				
			   	pstmt.executeUpdate();
			   	
			} catch (Exception e) {
				System.out.println("update 실패");
			}finally {
				if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
			}
			
		}
	
		
		public void init(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {

		      int count = 0;
		      String sql = "select count(*) as 'count' from board";

		      try {
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();

		         if (rs.next()) {
		            count = rs.getInt("count");
		         }

		         String sqlList[] = { "SET @CNT = 0",
		               "UPDATE board SET board.bnum = @CNT:=@CNT+1", 
		               "ALTER TABLE board AUTO_INCREMENT=" + (count + 1) };

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
		
		public List<BoardDTO> boardSearch(String word, String col)throws SQLException{
			
			List<BoardDTO> boardSearchList = new ArrayList<BoardDTO>();
			
			try {
				 Context init = new InitialContext();
			     
				 DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     
				 conn = ds.getConnection();
			     
				 String sql = "select * from board where bwriter like ? OR btitle like ? OR bcontent like ?";
			     
				 pstmt = conn.prepareStatement(sql);
				 
				 pstmt.setString(1, '%'+word+'%');
		         pstmt.setString(2, '%'+word+'%');
		         pstmt.setString(3, '%'+word+'%');

			     rs = pstmt.executeQuery();
			     
			     while(rs.next()) {
			    	 BoardDTO dto = new BoardDTO();
			    	 dto.setBnum((rs.getString("bnum")));
			         dto.setBwriter(rs.getString("bwriter"));
			         dto.setBpw(rs.getString("bpw"));
			         dto.setBtitle(rs.getString("btitle"));
			         dto.setBcontent(rs.getString("bcontent"));
			         dto.setBviews(rs.getString("bviews"));
			         dto.setBreg_date(rs.getString("breg_date"));
			         
		            
			         boardSearchList.add(dto);
			     }
			
			     
		}catch (Exception e) {
			// TODO: handle exception
		}finally {	
	       pstmt.close();	        
	       conn.close();
	       rs.close();
	         
		}
			return boardSearchList;
		
	}
}


		
		
		

