package kr.or.ddit.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 클라이언트가 보호 자원을 요청한 경우,
 * 인증 여부를 판단하고, 미인증시 로그인폼으로 이동.
 *
 */
@Slf4j
public class AuthenticationFilter implements Filter{
	private Map<String, String[]> securedResources;

	@Override
	public void init(FilterConfig config) throws ServletException {
		ResourceBundle bundle = ResourceBundle.getBundle("kr/or/ddit/SecuredResources");
		securedResources = new LinkedHashMap<>();
		config.getServletContext().setAttribute("securedResources", securedResources);
		bundle.keySet().forEach(k->{
			String roles = bundle.getString(k);
			String[] values = roles.split(",");
			Arrays.sort(values);
			securedResources.put(k.trim(), values);
			log.info("보호자원 : {}, 설정된 role : {}", k, values);
		});
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String requestURI = request.getRequestURI().substring(request.getContextPath().length());
		boolean pass = true;
		if(securedResources.containsKey(requestURI)) {
			// 보호 자원
			pass = request.getUserPrincipal()!=null;
		}else {
			// 비보호 자원
			pass = true;
		}
		
		if(pass) {
			chain.doFilter(req, resp);
		}else {
			response.sendRedirect(request.getContextPath() + "/login/loginForm.jsp");
		}
	}

	@Override
	public void destroy() {
		
	}

}












