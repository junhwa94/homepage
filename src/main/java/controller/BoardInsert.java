package controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardDAO;


@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String b_writer = (String) session.getAttribute("uid");
		
		
		
		String b_pw = "";
		if(request.getParameter("bpw") == null) {
			b_pw = "null";
		}else {
			b_pw = request.getParameter("bpw");
		}
		
		String b_title = request.getParameter("btitle");
		String b_content = request.getParameter("bcontent");
		
		b_title = XssReplace(b_title);
		b_content = XssReplace(b_content);
		
		try {
			BoardDAO dao = new BoardDAO();
			
			dao.boardInsert(b_writer, b_pw, b_title, b_content);
			
			String page = "/BoardViewList";
			
			RequestDispatcher dispatcher= request.getRequestDispatcher(page);
			
			dispatcher.forward(request, response);
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String XssReplace(String str) {
        
	      str = str.replaceAll("&", "&amp;");
	      str = str.replaceAll("\"", "&quot;");
	      str = str.replaceAll("'", "&apos;");
	      str = str.replaceAll("<", "&lt;");
	      str = str.replaceAll(">", "&gt;");
	      str = str.replaceAll("\r", "<br>");
	      str = str.replaceAll("\n", "<p>");

	      return str;
	   }
}
