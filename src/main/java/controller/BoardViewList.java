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

@WebServlet("/BoardViewList")
public class BoardViewList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		List<BoardDTO> boardList;
		
		try {
			BoardDAO dao = new BoardDAO();
			
			boardList = dao.boardViewList();
			
			request.setAttribute("boardList", boardList);
			
			String page = "/homepage/boardPage.jsp";
            
	         RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	         dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardDTO> boardList;
		
		try {
			BoardDAO dao = new BoardDAO();
			
			boardList = dao.boardViewList();
			
			request.setAttribute("boardList", boardList);
			
			String page = "/homepage/boardPage.jsp";
            
	         RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	         dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}

