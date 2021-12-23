<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom:0">
		<h1>My First Project</h1>
		<p>#homepage</p> 
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	
	<%
	   if(session.getAttribute("uid") != null){
	%>
		<a class="navbar-brand" href="/homepage/homepage/home.jsp">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span></button>
		
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				
				<li class="nav-item">
					<a class="nav-link" href="/homepage/logout">log out</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="/homepage/MyPage">my page</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="/homepage/BoardViewList">board</a>
				</li>
			
			</ul>		
		</div>		 
	</nav> 		

<%
     
   }else if(session.getAttribute("uid") == null){
	   
%>
	<a class="navbar-brand" href="/homepage/homepage/home.jsp">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span></button>
	
	<ul class="nav">
		<li class="nav-item">
			<a class="nav-link" href="/homepage/homepage/loginPage.jsp">log in</a>
		</li>
	 	
	 	<li class="nav-item">
			<a class="nav-link" href="/homepage/homepage/joinPage.jsp">join</a>
		</li>	
	</ul>


<%	   
	   
   }
%>		 
		 

</body>
</html>