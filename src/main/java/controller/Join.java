package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserDAO;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("uid");
		String userPw = request.getParameter("upassword");
		String userName = request.getParameter("uname");
	
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String userBirth = year+"-"+month+"-"+day;
		
	
		String userGender = request.getParameter("ugender");
		String userEmail = request.getParameter("uemail");
		String userPhone = request.getParameter("uphone");
		
		HttpSession session = request.getSession();
		
		UserDAO dao = new UserDAO();
		
		try {
			dao.join(userId, userPw, userName, userBirth, userGender, userEmail, userPhone);
			
			session.setAttribute("uid", userId);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//join메서드에 매개변수는 회원가입페이지에서 유저가 직접 적은 정보
		
		response.sendRedirect("/homepage/homepage/home.jsp");
		

		
//		
//		response.getWriter().print();
	}

}
