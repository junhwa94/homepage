package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDAO;

@WebServlet("/BoardPwCheck")
public class BoardPwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String b_pw = request.getParameter("bpw");
		
				
		BoardDAO dao = new BoardDAO();
		int result = 0;
		
		try {
			result = dao.boardPwCheck(b_pw);
//			response.sendRedirect("/homepage/boardPwPage.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		response.getWriter().print(result);
	}

}
