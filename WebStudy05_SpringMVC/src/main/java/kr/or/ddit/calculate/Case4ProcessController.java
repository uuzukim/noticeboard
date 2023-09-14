package kr.or.ddit.calculate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculate/Case4ProcessServlet")
public class Case4ProcessController{
	
//	@RequestBody : 요청 payload 를 unmarshalling 할때 사용.(consumes 과 함께 사용)
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO jsonPayload(@RequestBody CalculateVO commandObject){
		return commandObject;
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO parameter(CalculateVO commandObject){
		return commandObject;
	}

}






























