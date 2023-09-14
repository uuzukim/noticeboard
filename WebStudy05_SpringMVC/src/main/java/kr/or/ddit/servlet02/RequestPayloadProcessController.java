package kr.or.ddit.servlet02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.SampleFormVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/03/payloadDataProcess.do")
public class RequestPayloadProcessController{
	@PostMapping(produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String responseToHTML(@RequestBody SampleFormVO commandObject){
		log.info(commandObject.toString());
		return "요청 처리 완료. 결과 메시지 전송.";
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> responseToJSON(@RequestBody SampleFormVO commandObject){
		log.info(commandObject.toString());
		Map<String, Object> target = new HashMap<>();
		target.put("message", "요청 처리 완료. 결과 메시지 전송.");
		return target;
	}
}












