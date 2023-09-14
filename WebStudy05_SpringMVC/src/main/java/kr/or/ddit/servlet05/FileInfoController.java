package kr.or.ddit.servlet05;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileInfoController implements ApplicationContextAware{
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) {
		this.context = (WebApplicationContext) arg0;
		application = context.getServletContext();
		log.info("주입된 컨테이너 : {}", this.context);
	}
	
	private WebApplicationContext context;
	private ServletContext application;
	
	@RequestMapping("/server/fileInfo")
	public Object doGet(
		@RequestParam String target	
		, Model model
	) throws IOException{
		String realPath = application.getRealPath(target);
		
		File targetFile = new File(realPath);
		if(!targetFile.exists()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.contentType(MediaType.parseMediaType("text/plain;charset=UTF-8"))
						.body(MessageFormat.format("{0} 파일은 없음.", target));
		}else {
			FileAdapter information = new FileAdapter(targetFile, application);
			model.addAttribute("fileInfo", information);
			return "jsonView";
		}
		
	}
}



















