package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import service.BoardDAO;

@WebServlet("/BoardContent1")
public class BoardContent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String bnum = request.getParameter("b_bnum");
		String bpw = request.getParameter("b_bpw");
	
	
		BoardDAO dao = new BoardDAO();
		
		List<BoardDTO> contentlist = new ArrayList<BoardDTO>();
		
		try {
						
			contentlist = dao.boardContentList(bnum);
				
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			request.setAttribute("contentlist", contentlist);
			
			String page = "/homepage/updatePage.jsp";
            
	        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	        dispatcher.forward(request, response);
	
//		if(bpw != null) {
//			
//			request.setAttribute("bnum", bnum);
//			request.setAttribute("bpw", bpw);
//			
//			String page = "/board/boardPw.jsp";
//            
//	        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//	        dispatcher.forward(request, response);
//			//response.sendRedirect("/homepage/board/boardPw.jsp");
//
//		}else {
//			if(update != null) {
//				BoardDAO dao = new BoardDAO();
//				
//				List<BoardDTO> contentlist = new ArrayList<BoardDTO>();
//				
//				try {
//								
//					contentlist = dao.boardContentList(bnum);
//						
//					
//				} catch (SQLException | NamingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//					request.setAttribute("contentlist", contentlist);
//					
//					String page = "/homepage/updatePage.jsp";
//		            
//			        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//			        dispatcher.forward(request, response);
//				
//
//			}else {
//				BoardDAO dao = new BoardDAO();
//				
//				List<BoardDTO> contentlist = new ArrayList<BoardDTO>();
//				
//				try {
//								
//					contentlist = dao.boardContentList(bnum);
//						
//					
//				} catch (SQLException | NamingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//					request.setAttribute("contentlist", contentlist);
//					
//					String page = "/homepage/contentPage.jsp";
//		            
//			        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//			        dispatcher.forward(request, response);
//				
//
//			}
//		}
		
		
		

	}
}

