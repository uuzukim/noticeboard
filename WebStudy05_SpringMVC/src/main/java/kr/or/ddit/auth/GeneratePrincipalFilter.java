package kr.or.ddit.auth;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneratePrincipalFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("{} 필터 초기화", this.getClass().getSimpleName());
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletRequestWrapper wrapper =
				new HttpServletRequestWrapper(request) {
			@Override
			public Principal getUserPrincipal() {
				HttpServletRequest req = (HttpServletRequest) getRequest();
				HttpSession session = req.getSession(false);
				if(session!=null && !session.isNew()&&session.getAttribute("authMember")!=null) {
					MemberVO authMember = (MemberVO) session.getAttribute("authMember");
					MemberVOWrapper principal = new MemberVOWrapper(authMember);
					return principal;
				}else {
					return super.getUserPrincipal();
				}
			}
		};
		chain.doFilter(wrapper, resp);
		
	}

	@Override
	public void destroy() {
		log.info("{} 필터 소멸", this.getClass().getSimpleName());
	}

}












