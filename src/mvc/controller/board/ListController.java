package mvc.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import mvc.controller.Controller;

public class ListController implements Controller{
	BoardDAO boardDAO;
	
	public ListController() {
		boardDAO = new BoardDAO();
		
	}
	
	//3�ܰ�: �˸´� ���� ��ü�� �� ��Ų��.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = boardDAO.select();
		
		//4�ܰ�: ����� ������ ��� ����
		request.setAttribute("list", list);
		
		//���Բ� ��Ű�� �ֳĸ� view mapping�� �˰� ������,
		//5�ܰ�: ��� �����ֱ�
		//RequestDispatcher dis = request.getRequestDispatcher("/board/list.jsp");
		//dis.forward(request, response);
		
		return "/result/board/list";
	}

	public boolean isForward() {
		return true;
	}

}
