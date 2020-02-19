package store.main.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
	
	private static final String PATH = "/error";
	
	@RequestMapping(PATH)
	public String handle (Model model, HttpServletRequest request) {
		int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		loadErrorOnPage(model, httpErrorCode);
		return "Error";
	}

	public void loadErrorOnPage(Model model, int httpErrorCode) {
		switch (httpErrorCode) {
		case 404:{
			LoadErrors(model, httpErrorCode, "It seems we can’t find the page you are looking for.", "Page not found");
			break;
		}
		case 500:{
			LoadErrors(model, httpErrorCode, "Oops. There was an internal error, try again later.", "Internal server error");
			break;
		}
		}
	}

	private void LoadErrors(Model model, int httpErrorCode, String msg, String errorTitle) {
		String customMsg = msg;
		String title = "Error "+ httpErrorCode+": "+errorTitle;
		model.addAttribute("name", title);
		model.addAttribute("msg", customMsg);
	}
	
	@Override
	public String getErrorPath() {
	    return PATH;
	}
}
