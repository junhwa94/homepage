package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.CommentDAO;

@WebServlet("/commentInsert")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String bnum = request.getParameter("bnum"); String c_num =
		 * request.getParameter("c_num"); String c_id = request.getParameter("c_id");
		 * String c_content = request.getParameter("c_content");
		 * 
		 * CommentDAO dao = new CommentDAO();
		 * 
		 * try {
		 * 
		 * dao.insertBoardComment(bnum, c_num, c_id, c_content);
		 * 
		 * String page = "/BoardContent";
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		 * dispatcher.forward(request, response);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bnum = request.getParameter("bnum");
		String c_id = request.getParameter("c_id");
		String c_content = request.getParameter("c_content");
		
		CommentDAO dao = new CommentDAO();
		
		try {
			
			dao.insertBoardComment(bnum, c_id, c_content);
			
			/*
			 * String page = "/BoardContent?bnum="+bnum;
			 * 
			 * RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			 * dispatcher.forward(request, response);
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
