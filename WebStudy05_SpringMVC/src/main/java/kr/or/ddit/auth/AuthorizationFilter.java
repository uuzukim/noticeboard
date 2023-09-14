package kr.or.ddit.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVOWrapper;

/**
 * 클라이언트가 보호 자원을 요청한 경우,
 * 자원에 설정된 허가 목록과 클라이언트가 부여받은 역할 정보가 일치하는지 여부 판단.
 * 권한을 소유한 경우, 접근 허용.
 * 권한이 없는 경우, 403 상태 코드로 응답 전송.
 *
 */
public class AuthorizationFilter implements Filter{

	private ServletContext application;

	@Override
	public void init(FilterConfig config) throws ServletException {
		application = config.getServletContext();
	}	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String requestURI = request.getRequestURI().substring(request.getContextPath().length());
		
		Map<String, String[]> securedResources = 
				(Map<String, String[]>) application.getAttribute("securedResources");
		
		String[] roles = securedResources.get(requestURI);
		
		boolean pass = true;
		
		if(roles!=null) {
			// 보호 자원
			MemberVOWrapper principal = (MemberVOWrapper) request.getUserPrincipal();
			String userRole = principal.getRealUser().getMemRole();
			pass = Arrays.binarySearch(roles, userRole) >= 0;
		}else {
			// 비보호 자원
			pass = true;
		}
		
		if(pass) {
			chain.doFilter(req, resp);
		}else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}











