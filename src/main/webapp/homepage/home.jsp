<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/homepage/css/home.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.fakeimg1 {
    height: 500px;
    background: url('../img/p2.jpg');
  }  
.fakeimg2 {
    height: 200px;
    background: url('../img/p3.jpg') no-repeat;    
  }  
.fakeimg3 {
    height: 200px;
    background: url('../img/p4.jpg') no-repeat;    
  }  
</style>
</head>
<body>
	<div class = "header">
	
		<jsp:include page="/homepage/header.jsp" flush="false"/>
	</div>	
	
	<div class="container" style="margin-top:30px">
		<div class="row">
			
			<div class="col-sm-4">
				<h2>Hello Stranger</h2>
				<!-- <h5>Photo of me:</h5> -->
				<div class="fakeimg1"></div>
				<p>One touch and you got me stoned</p>
				
				<h3>Some Links</h3>				 			
	 			<ul class="nav nav-pills flex-column">
					<li class="nav-item">
						<a class="nav-link" href="#">no-function</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link" href="#">no-function</a>
	 				</li>
					
					<li class="nav-item">
						<a class="nav-link" href="#">no-function</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link disabled" href="#">no-function</a>
					</li>
				</ul>
				
				<hr class="d-sm-none">
			</div>
			
			<div class="col-sm-8">
				<h2>TITLE HEADING</h2>
				<h5>Project start date, Oct 1, 2021</h5>
				<div class="fakeimg2"></div>
				<p>Some text..</p>
				<p>Your touch blurred my vision
				 Even sober I'm not thinkin' straight.</p>
				<br>
				
				<h2>TITLE HEADING</h2>
				<h5>The last date of the project, Oct 29, 2021</h5>
				<div class="fakeimg3"></div>
				<p>Some text..</p>
				<p>I still have a long way to go, but I still want to do well.</p>
			</div>
		</div>
	</div>
	
	<div class = "footer">
		<jsp:include page="footer.jsp" flush="false"/>
	</div> 

		
</body>
</html>