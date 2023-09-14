package kr.or.ddit.calculate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;

/**
 * 1. request parameter / html response
 * 2. request parameter / json response
 * 
 * 3. request json payload / html response
 * 4. request json payload / json response
 *
 */
@Controller
@RequestMapping("/calculate/Case5ProcessServlet")
public class Case5ProcessController{
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String parameterToHtml(CalculateVO commandObject){
		return commandObject.getExpr();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO parameterToJson(CalculateVO commandObject){
		return commandObject;
	}
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String jsonToHtml(@RequestBody CalculateVO commandObject){
		return commandObject.getExpr();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO jsonToJson(@RequestBody CalculateVO commandObject){
		return commandObject;
	}
}




















