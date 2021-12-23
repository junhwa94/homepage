package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDTO;
import service.UserDAO;

@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		
//		System.out.println("aaaaaaaaaaaaaaaaa");
		
		
		String userId = (String) session.getAttribute("uid");
//		System.out.println("userId=================== " + userId);
		
		List<UserDTO> userList;
	      
	      try {
	    	  UserDAO dao = new UserDAO();
	  		
	  		
	         userList = dao.myPage(userId);
	         
        
	         request.setAttribute("userList", userList);
	         
//	         System.out.println("userList=================== " + userList);
	         
	         dispatcher= request.getRequestDispatcher("/homepage/myPage.jsp");
	         
	         dispatcher.forward(request, response);
	      
	       
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
