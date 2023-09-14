<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">      
			<li class="nav-item">
				<a class="nav-link" data-href="#" href="javascript:;">dummy</a>
			</li>
			
        </ul>
      </div>
    </nav>
    <script>
    	$("a[data-href]").on("click", (event)=>{
    		event.preventDefault();
    		let href = event.target.dataset.href;
    		location.href=`<%=request.getContextPath()%>\${href}`;
    	});
    </script>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    