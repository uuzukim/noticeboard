package kr.or.ddit.servlet05.fancytree;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet("/server/fancytree")
public class FancytreeServerFileExplorerServlet extends HttpServlet {
	private ServletContext application;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = null;
		
		if(req.getHeader("accept").contains("json")) {
			req.setCharacterEncoding("UTF-8");
			String rootUrl = Optional.ofNullable(req.getParameter("target"))
									.filter((t)->!t.isEmpty())
									.orElse("/");
			String realPath = application.getRealPath(rootUrl);
			File targetFolder = new File(realPath);
			
			int status = 200;
			String message = null;
			if(!targetFolder.exists()) {
				status = 404;
				message = MessageFormat.format("{0} 해당 자원은 존재하지 않습니다.", rootUrl);
			}else if(targetFolder.isFile()) {
				status = 400;
				message = MessageFormat.format("{0} 해당 자원은 디렉토리가 아닙니다.", rootUrl);
			}
			
			if(status!=200) {
				resp.sendError(status, message);
				return;
			}
			
			File[] listFiles = targetFolder.listFiles((d,n)->true);
			
			List<FancyTreeNodeFileAdapter> children = Stream.of(listFiles)
												.map(f->new FancyTreeNodeFileAdapter(f))
												.sorted()
												.collect(Collectors.toList());
			
			req.setAttribute("listFiles", children);
			
			viewName = "/jsonView.view";
		}else {
			String logicalViewName = "server/explorerFancyTree";
			viewName = "/"+logicalViewName+".tiles";
		}
		
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}














