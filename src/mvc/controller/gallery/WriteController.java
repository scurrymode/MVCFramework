package mvc.controller.gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gallery.model.Gallery;
import gallery.model.GalleryService;
import mvc.controller.Controller;

public class WriteController implements Controller {
	GalleryService service = new GalleryService();
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service.upload(request);		
		return "/result/gallery/write";
	}

	public boolean isForward() {
		return false;
	}

}
