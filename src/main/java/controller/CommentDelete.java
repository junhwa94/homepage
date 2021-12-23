package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentDAO;


@WebServlet("/commentDelete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c_num = request.getParameter("c_num");
		String bnum = request.getParameter("bnum");
		
		CommentDAO dao = new CommentDAO();
		
		try {
			dao.deleteBoardComment(c_num, bnum);
			
			String page = "/BoardContent";
            
	        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	        dispatcher.forward(request, response);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
