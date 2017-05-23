/*
 * �۾��� ��û�� ó���ϴ� ��Ʈ�ѷ�
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
	
	//3�ܰ� �˸´� ���� ��ü�� �� ��Ų��.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		boardDAO.insert(board);
	
	
	//4�ܰ� �ʿ����
		//���Բ� ��Ű��~
	//5�ܰ� �˸´� �� �����ֱ�
	//	response.sendRedirect("/board/list.do");
		
		//RequestDispatcher dis = request.getRequestDispatcher("/board/list.do");
		//dis.forward(request, response);
		
		return "/result/board/write";
	}

	public boolean isForward() {
		return false;
	}

}
