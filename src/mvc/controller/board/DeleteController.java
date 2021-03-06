package mvc.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import mvc.controller.Controller;

public class DeleteController implements Controller {
	BoardDAO boardDAO;
	
	public DeleteController() {
		boardDAO = new BoardDAO();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String board_id = request.getParameter("board_id");
		boardDAO.delete(Integer.parseInt(board_id));
		
		return "/result/board/delete";
	}

	public boolean isForward() {
		return false;
	}

}
