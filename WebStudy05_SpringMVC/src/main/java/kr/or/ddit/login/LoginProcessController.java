package kr.or.ddit.login;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginProcessController{
	
	@Inject
	private WebApplicationContext context;
	
	@Inject
	private AuthenticateService service;

	private ServletContext application;
	
	@PostConstruct
	public void init() {
		application = context.getServletContext();
		log.info("WebApplicationContext : {}", context);
		log.info("ServletContext : {}", application);
	}
	
	@RequestMapping(value="/login/loginProcess", method = RequestMethod.POST)
	public String loginProcess(
		@Validated(DeleteGroup.class) MemberVO inputData
		, Errors errors
		, @RequestParam(required = false) Optional<String> idSave
		, HttpSession session
		, HttpServletResponse resp
		, HttpServletRequest req
			
	){
//		* 1. 요청 접수(파라미터나 헤더와 관련된 데이터 확보->검증)
//		req.setCharacterEncoding("UTF-8");
		
		boolean saveFlag = idSave.map(c->true)
								.orElse(false);
		
		
		boolean valid = !errors.hasErrors();
		
//		* 3. model 을 공유 -> scope's setAttribute(name, value)
//		* 4. view layer 선택 : logical view Name
		String viewName = null;
		
		if(!valid) {
//			resp.sendError(400, "아이디나 비번 누락.");
//			return;
			session.setAttribute("message", "아이디나 비번 누락");
			viewName = "redirect:/login/loginForm.jsp";
		}else {
//		* 2. Model information 생성
//		* 	 * data vs information vs content(view layer, MIME type)
			
			try {
			 	MemberVO authMember = service.authenticate(inputData);
			 	
			 	session.setAttribute("authMember", authMember);
				// redirect ?? 현재 요청에 대한 정보를 제거.
				viewName = "redirect:/";
//				Cookie : client side 저장 데이터
				Cookie idCookie = new Cookie("idCookie", authMember.getMemId());
				idCookie.setPath(application.getContextPath());
				if(saveFlag) {
					// create
					idCookie.setMaxAge(60*60*24*7);
				}else {
					// remove
					idCookie.setMaxAge(0);
				}
				resp.addCookie(idCookie);
			}catch (AuthenticateException e) {
				session.setAttribute("message", e.getMessage());
				viewName = "redirect:/login/loginForm.jsp";
			}
		}
		return viewName;
	}
	
	@PostMapping("/login/logout")
	public String doPost(HttpSession session){
		if(session!=null && !session.isNew()) {
//			session.removeAttribute("authId");
			session.invalidate();
		}
		return "redirect:/";
	}
}

















