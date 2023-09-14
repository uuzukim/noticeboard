package kr.or.ddit.props.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.props.service.PropertyService;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.vo.PropertyVO;

@Controller
@RequestMapping("/property")
public class PropertyControllerServlet{
	@Inject
	private PropertyService service;
	
	@GetMapping
	public String html() {
		return "props/singleViewCase2";
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String jsonList(Model model){
		List<PropertyVO> propList = service.retrieveProperties();
		model.addAttribute("propList", propList);
		return "jsonView";
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = "what")
	public String jsonDetail(@RequestParam("what") String propertyName, Model model){
		PropertyVO prop = service.retrieveProperty(propertyName);
		model.addAttribute("prop", prop);
		return "jsonView";
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String doPost(
		@Valid @RequestBody PropertyVO propVO
		, Errors errors
		, Model model
	){
		Map<String, Object> resultMap = new HashMap<>();
		model.addAttribute("result", resultMap);
		String viewName = null;
		if(errors.hasErrors()) {
			resultMap.put("success", false);
			resultMap.put("status", 400);
			viewName = "jsonView";
		}else {
			// call by reference
			boolean success = service.createProperty(propVO);
			
			resultMap.put("prop", propVO);
			resultMap.put("success", success);
			
			if(success) {
				viewName = "redirect:/property";
			}else {
				viewName = "jsonView";
			}
		}
		return viewName;
		
	}
	
	@PutMapping
	public String doPut(
		@Valid @RequestBody PropertyVO propVO
		, Errors errors
		, Model model
		
	){
		Map<String, Object> resultMap = new HashMap<>();
		model.addAttribute("result", resultMap);
		String viewName = null;
		if(errors.hasErrors()) {
			resultMap.put("success", false);
			resultMap.put("status", 400);
			viewName = "jsonView";
		}else {
			// call by reference
			boolean success = service.modifyProperty(propVO);
			
			resultMap.put("prop", propVO);
			resultMap.put("success", success);
			
			if(success) {
				viewName = "redirect:/property";
			}else {
				viewName = "jsonView";
			}
		}
		return viewName;
	}
	
	@DeleteMapping
	public String doDelete(
		@Validated(DeleteGroup.class) @RequestBody PropertyVO prop
		, Errors errors
		, Model model
	) {
		Map<String, Object> resultMap = new HashMap<>();
		model.addAttribute("result", resultMap);
		resultMap.put("prop", prop);
		String propertyName = prop.getPropertyName();
		
//		String propertyName = req.getParameter("propertyName");
		
		if(errors.hasErrors()) {
			resultMap.put("success", false);
			resultMap.put("status", 400);
			resultMap.put("errorMsg", "필수파라미터 누락");
		}else {
			boolean success = service.removeProperty(propertyName);
			resultMap.put("success", success);
			
		}
		return "jsonView";
	}
}















