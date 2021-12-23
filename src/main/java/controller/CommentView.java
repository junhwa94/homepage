package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.CommentDTO;
import service.CommentDAO;

@WebServlet("/commentView")
public class CommentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		String bnum = request.getParameter("bnum");
		System.out.println(bnum);
		
		CommentDAO dao = new CommentDAO();
		
		List<CommentDTO> commentlist = new ArrayList<CommentDTO>();
		
		try {
			
			
			commentlist = dao.commentView(bnum);
			
			System.out.println(commentlist);
			
			request.setAttribute("commentlist", commentlist);
			
			String commentlistToJson = new Gson().toJson(commentlist);
            
	         response.getWriter().println(commentlistToJson);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
