package mvc.controller.gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gallery.model.Gallery;
import gallery.model.GalleryService;
import mvc.controller.Controller;

public class DetailController implements Controller{
	GalleryService service = new GalleryService();

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gallery gallery = service.select(request);
		request.setAttribute("gallery", gallery);
		return "/result/gallery/detail";
	}

	public boolean isForward() {
		return true;
	}

}
