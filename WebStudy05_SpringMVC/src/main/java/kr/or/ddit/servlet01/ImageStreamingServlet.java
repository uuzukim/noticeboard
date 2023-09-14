package kr.or.ddit.servlet01;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class ImageStreamingServlet{
	@Value("#{appInfo.mediaFolder}")
	private String folderPath;
	@Value("#{appInfo.mediaFolder}")
	private File folder;
	
	@Inject
	private WebApplicationContext context;
	private ServletContext application;

	@PostConstruct
	public void init(){
		application = context.getServletContext();
	}
	
	@RequestMapping("/image.do")
	public ResponseEntity<?> doGet(@RequestParam String image){
		
		File imageFile = new File(folder, image);
		HttpStatus status = HttpStatus.OK;
		String message = null;
//		MIME(Multipuposed Internet Mail Extension)
		String mime = application.getMimeType(image);
		Object body = null;
		MediaType contentType = null;
		long contentLength = -1;
		if(!imageFile.exists()) {
			status = HttpStatus.NOT_FOUND;
			body = "파일이 없음.";
			contentType = MediaType.parseMediaType("text/plain;charset=UTF-8");
			contentLength = body.toString().length();
		}else if(mime==null || !mime.startsWith("image/")) {
			status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
			body = "지원하지 않는 파일형식임.";
			contentType = MediaType.parseMediaType("text/plain;charset=UTF-8");
			contentLength = body.toString().length();
		}else {
			status = HttpStatus.OK;
			body  = new FileSystemResource(imageFile);
			contentType = MediaType.parseMediaType(mime);
			contentLength = imageFile.length();
		}
		
		return ResponseEntity.status(status)
						.contentType(contentType)
						.contentLength(contentLength)
						.body(body);
		
	}
}












