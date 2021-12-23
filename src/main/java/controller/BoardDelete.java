package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardDAO;


@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
			
		String uid = (String) session.getAttribute("uid"); //濡�洹몄�명���� �� id諛�����
		String bnum = request.getParameter("bnum");
		String bviews = request.getParameter("bviews");
	   
		BoardDAO dao = new BoardDAO();
		
		try {
			dao.contentDelete(uid, bnum, bviews);
		//	session.invalidate(); //占싸그아울옙占싱놂옙 탈占쏙옙占쌀띰옙占쏙옙 占쏙옙占�
			response.sendRedirect("/homepage/BoardViewList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
