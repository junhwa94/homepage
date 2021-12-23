package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardDAO;


@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("1111111111");
		HttpSession session = request.getSession();
			
			String uid = (String) session.getAttribute("uid"); //로그인한 상태면 세션값 자동으로 유지
			String bnum = request.getParameter("bnum");
			
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			
			System.out.println(bnum);
			System.out.println(btitle);
			System.out.println(bcontent);
			
			BoardDAO dao = new BoardDAO();
		
			
			try {
				dao.contentUpdate(bnum,btitle,bcontent);
				response.sendRedirect("/homepage/BoardViewList");
				
			} catch (Exception e) {
				
			}
		
	}

}
