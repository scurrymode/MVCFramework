/*
 * 글쓰기 요청만 처리하는 컨트롤러
 * */
package mvc.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Board;
import board.model.BoardDAO;
import mvc.controller.Controller;

public class WriteController implements Controller{
	BoardDAO boardDAO;
	
	public WriteController() {
		boardDAO = new BoardDAO();
	}
	
	//3단계 알맞는 로직 객체에 일 시킨다.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		boardDAO.insert(board);
	
	
	//4단계 필요없고
		//형님께 시키자~
	//5단계 알맞는 뷰 보여주기
	//	response.sendRedirect("/board/list.do");
		
		//RequestDispatcher dis = request.getRequestDispatcher("/board/list.do");
		//dis.forward(request, response);
		
		return "/result/board/write";
	}

	public boolean isForward() {
		return false;
	}

}
