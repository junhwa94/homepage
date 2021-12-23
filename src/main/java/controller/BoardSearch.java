package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import service.BoardDAO;


@WebServlet("/BoardSearch")
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardDTO> boardList;
		
		String word = request.getParameter("word");
		String col = request.getParameter("col");
		
		/*
		 * System.out.println("word---------?>"+word);
		 * System.out.println("col---------?>"+col);
		 */
		
		try {
			BoardDAO dao = new BoardDAO();
			
			boardList = dao.boardSearch(word, col);
			
			request.setAttribute("boardList", boardList);
			
			String page = "/homepage/boardPage.jsp";
            
	        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	        dispatcher.forward(request, response);
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
