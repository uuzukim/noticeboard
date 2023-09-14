package kr.or.ddit.servlet04;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/bloodType")
public class BloodTypeController{
	@Inject
	private WebApplicationContext context;
	
	private Map<String, String[]> bloodType;

	private ServletContext application;

	@PostConstruct
	public void init(){
		application = context.getServletContext();
		bloodType = new HashMap<>();
		bloodType.put("BT01", new String[] {"A형", "blood/a"});
		bloodType.put("BT02", new String[] {"B형", "blood/b"});
		bloodType.put("BT03", new String[] {"AB형", "blood/ab"});
		bloodType.put("BT04", new String[] {"O형", "blood/o"});
		application.setAttribute("bloodType", bloodType);
	}
	
	@GetMapping
	public String doGet(){
		return "blood/formView";
	}
	
	@PostMapping
	public Object doPost(@RequestParam(name="blood") String code){
		int status = 200;
		
		if(!bloodType.containsKey(code)){
			status = HttpServletResponse.SC_NOT_FOUND;
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.contentType(MediaType.parseMediaType("text/html;charset=UTF-8"))
						.body("이런 혈액형은 없음.");
		}else {
			String[] bloodInfo = bloodType.get(code);
			return bloodInfo[1];
		}
		
		
	}
}




























