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

@WebServlet("/userDelete")
public class MyPageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String uid = (String) session.getAttribute("uid"); //로그인한 상태면 세션값 자동으로 유지
		String upassword = request.getParameter("upassword");
		
	    
		UserDAO dao = new UserDAO();
		
		try {
			dao.delete(uid, upassword);
			session.invalidate();
			response.sendRedirect("/homepage/homepage/home.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* String unum = request.getParameter("unum"); */
		
		/*
		 * UserDAO dao = new UserDAO();
		 * 
		 * try { dao.delete(unum); session.invalidate();
		 * response.getWriter().println(1); // mayfageForm 에 있는 ajax로 값을 응답
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		
	}

}
