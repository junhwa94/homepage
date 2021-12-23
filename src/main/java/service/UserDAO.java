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


import model.UserDTO;

	public class UserDAO {
	
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
	

		public int idChecker(String userId)throws NamingException, SQLException {
			
				conn = null;
			    pstmt = null;
			    rs = null;
	
			    try {			
					Context init = new InitialContext();
			        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			        conn = ds.getConnection();
			         
			        String sql = "select * from user where uid = ?";
	
					pstmt = conn.prepareStatement(sql);			
					
					pstmt.setString(1, userId);
					
					rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return 1;
				}else if(userId.equals("")) {
					return 2;
				}else {
					return 0;
				}
				 
				
			} catch (Exception e) {
				
				System.out.println("아이디 비교 실패");
			
			} finally {
		         rs.close();
		         pstmt.close();
		         conn.close();
		      }
		      return -1;
	
		}
						
		public void join(String userId, String userPw, String userName, String userBirth, String userGender, String userEmail, String userPhone)throws NamingException, SQLException {
						
				conn = null;
				pstmt = null;
			
			try {			
				Context init = new InitialContext();
			    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			    conn = ds.getConnection();
				
			    String sql = "insert into user(uid, upassword, uname, ubirth, ugender, uemail, uphone) values(?,?,?,?,?,?,?)";
			      
			    pstmt = conn.prepareStatement(sql);		
			   
			    pstmt.setString(1, userId);
			    pstmt.setString(2, userPw);
			    pstmt.setString(3, userName);
			    pstmt.setString(4, userBirth);
			    pstmt.setString(5, userGender);
			    pstmt.setString(6, userEmail);
			    pstmt.setString(7, userPhone);
			    
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				
				System.out.println("회원가입 실패");
			
			}finally {
				if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();

			  }
		}
				
		public int login(String userId, String userPw) throws NamingException, SQLException {
			
			conn = null;
		    pstmt = null;
		    rs = null;

			try {
				
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
		
			    String sql = "select uid, upassword from user where uid = ?";
				
			    pstmt = conn.prepareStatement(sql);			
				
			    pstmt.setString(1, userId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					if(userId.equals(rs.getString("uid"))&&userPw.equals(rs.getString("upassword"))){				
						return 1;					
					}else if(!userPw.equals(rs.getString("upassword"))) {
		            	 return 2;
		            }else {
		            	return 0;
		            }	
					
				}
			} catch (Exception e) {
				System.out.println("로그인 실패");
			} finally {
		         if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
		        }
		       return -1;
			}
	
		public List<UserDTO> myPage(String userId) throws SQLException {
				
	
				List<UserDTO> userList = new ArrayList<UserDTO>();
				
				conn = null;
			    pstmt = null;
			    rs = null;
				
			try {			
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
				
			     String sql = "select * from user where uid = ?";
			     
			     pstmt = conn.prepareStatement(sql);
			     
			     pstmt.setString(1, userId);
			     
			     rs = pstmt.executeQuery();
			     
			     while(rs.next()) {
						
			    	 UserDTO dto = new UserDTO();
				            
				          dto.setUnum(rs.getString("unum"));
				          dto.setUid(rs.getString("uid"));
				          dto.setUpassword(rs.getString("upassword"));
				          dto.setUname(rs.getString("uname"));
				          dto.setUbirth(rs.getString("ubirth"));
				          dto.setUgender(rs.getString("ugender"));
				          dto.setUemail(rs.getString("uemail"));
				          dto.setUphone(rs.getString("uphone"));
			            
				          userList.add(dto);
		
					}
					return userList;
					
				} catch (Exception e) {
					System.out.println("회원정보 select 실패");
				} finally {
			         if(pstmt != null)
			             pstmt.close();
			          if(conn != null)
			             conn.close();
			        }
			       
			       
			   return userList;
	
			
		}
		
		public void delete(String uid, String upassword) throws SQLException {
			
			conn = null;
		    pstmt = null;
		   

			try {
				
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();
		
			     String sql = "delete from user where uid = ?";
			     
			   	 pstmt = conn.prepareStatement(sql);
			   	 
			   	 pstmt.setString(1, uid);
			   	 
			   	 pstmt.executeUpdate();
			   	 
				
			} catch (Exception e) {
				System.out.println("회원탈퇴 실패");
			} finally {
		         if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
		        }
		      
			
		}
		
		public void update(String userId, String userPw, String userName, String userBirth, String userGender, String userEmail, String userPhone)throws SQLException{
	
			conn = null;
		    pstmt = null;
		   
		    try {
				
				 Context init = new InitialContext();
			     DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
			     conn = ds.getConnection();

			     String sql = "update user set upassword =?, uname=?, ubirth= ?, ugender=?, uemail =?, uphone =?" + " where uid =?";
	
			   	 pstmt = conn.prepareStatement(sql);
			   	 
			   	 pstmt.setString(1, userPw);
			   	 pstmt.setString(2, userName);
			   	 pstmt.setString(3, userBirth);
			   	 pstmt.setString(4, userGender);
			   	 pstmt.setString(5, userEmail);
			   	 pstmt.setString(6, userPhone);
			   	 pstmt.setString(7, userId);
		   	 
			   	 pstmt.executeUpdate();
				System.out.println("111111111111111111");

				
			} catch (Exception e) {
				System.out.println("회원정보수정 실패");
			} finally {
		         if(pstmt != null)
		             pstmt.close();
		          if(conn != null)
		             conn.close();
		        }
			
			
		}

}