package kr.or.ddit.servlet01;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

@Controller
public class ImageFormControllerServlet implements ServletContextAware{
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.application = servletContext;
	}
	private ServletContext application;
	
	@Value("#{appInfo.mediaFolder}")
	private String folderPath;
	@Value("#{appInfo.mediaFolder}")
	private File folder;
	
	@RequestMapping("/imageForm3.do")
	public String doGet(Model model){
		String[] imageFiles = folder.list((d,n)->{
			String mime = application.getMimeType(n);
			return mime!=null && mime.startsWith("image/");
		});
		
		model.addAttribute("imageFiles", imageFiles);
		return "images/imageForm3";
	}
}













