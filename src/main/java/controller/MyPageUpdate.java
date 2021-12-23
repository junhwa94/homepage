package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserDAO;


@WebServlet("/userUpdate")
public class MyPageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("uid");
		String userPw = request.getParameter("upassword");
		
		String userName = request.getParameter("uname");
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String userBirth = year+"-"+month+"-"+day;
		
	
		String userGender = request.getParameter("ugender");
		String userEmail = request.getParameter("uemail");
		String userPhone = request.getParameter("uphone");
	
		

		System.out.println("---------------"+userId+userPw+userName+userBirth+userGender+userEmail+userPhone);
		
		UserDAO dao = new UserDAO();
		
		try {
			dao.update(userId, userPw, userName, userBirth, userGender, userEmail, userPhone);
			//session.invalidate(); ·Î±×¾Æ¿ô
			response.sendRedirect("/homepage/home.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
