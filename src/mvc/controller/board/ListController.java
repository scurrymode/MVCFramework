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
	
	//3단계: 알맞는 로직 객체에 일 시킨다.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = boardDAO.select();
		
		//4단계: 결과가 있으니 결과 저장
		request.setAttribute("list", list);
		
		//형님께 시키자 왜냐면 view mapping도 알고 있으니,
		//5단계: 결과 보여주기
		//RequestDispatcher dis = request.getRequestDispatcher("/board/list.jsp");
		//dis.forward(request, response);
		
		return "/result/board/list";
	}

	public boolean isForward() {
		return true;
	}

}
