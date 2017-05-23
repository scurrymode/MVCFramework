package mvc.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Board;
import board.model.BoardDAO;
import mvc.controller.Controller;

public class EditController implements Controller {
	BoardDAO boardDAO;
	
	public EditController() {
		boardDAO = new BoardDAO();

	}

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Board dto = new Board();
		dto.setContent(request.getParameter("content"));
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		boardDAO.update(dto);
		request.setAttribute("board", dto);
		
		return "/result/board/edit";
	}

	public boolean isForward() {
		return true;
	}

}
