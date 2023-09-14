package kr.or.ddit.servlet05;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

/**
 * Model2 구조에서 컨트롤러의 역할
 * 1. 요청 접수
 * 2. Model information 생성
 * 	 * data vs information vs content(view layer, MIME type)
 * 3. model 을 공유 -> scope's setAttribute(name, value)
 * 4. view layer 선택 : logical view Name
 * 5. view 로 이동 : forward [redirect]
 *
 */
@Controller

public class ServerFileExplorerController implements ServletContextAware{
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.application = servletContext;
	}
	
	private ServletContext application;
	
	
	@RequestMapping("/server")
	public Object doGet(
		@RequestParam(name="target", required = false, defaultValue = "/") String rootUrl 
		, Model model
	){
		
		String realPath = application.getRealPath(rootUrl);
		File targetFolder = new File(realPath);
		
		HttpStatus status = HttpStatus.OK;
		String message = null;
		if(!targetFolder.exists()) {
			status = HttpStatus.NOT_FOUND;
			message = MessageFormat.format("{0} 해당 자원은 존재하지 않습니다.", rootUrl);
		}else if(targetFolder.isFile()) {
			status = HttpStatus.BAD_REQUEST;
			message = MessageFormat.format("{0} 해당 자원은 디렉토리가 아닙니다.", rootUrl);
		}
		
		if(status!=HttpStatus.OK) {
			return ResponseEntity.status(status)
							.contentType(MediaType.parseMediaType("text/plain;charset=UTF-8"))
							.body(message);
		}else {
			File[] listFiles = targetFolder.listFiles((d,n)->true);
			
			List<WebResource> children = Stream.of(listFiles)
					.map((f)->{
						try {
							return new FileAdapter(f, application);
						}catch (IOException e) {
							// 예외 전환 (checked->unChecked), wrapper pattern
							throw new RuntimeException(e);
						}
					}).collect(Collectors.toList());
			
			model.addAttribute("listFiles", children);
			
			return "server/explorer";
		}
		
	}
}














