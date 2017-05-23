package mvc.controller.gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;

public class DeleteController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	public boolean isForward() {
		return false;
	}

}
