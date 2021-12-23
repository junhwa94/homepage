<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/loginForm.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
		<div id="loginForm">
		<!-- <form action="../login" method="post" id="loginForm"> 에이젝스 사용 시 폼태그 절대 사용금지--> 
		      <h2>Login</h2>
		      <div class="idForm">
		        <input type="text" class="id" placeholder="ID" required="required" name="uid" id="uid">
		      </div>
		      <div class="passForm">
		        <input type="password" class="pw" placeholder="PW" required="required" name="upassword" id="upassword">
		      </div>
		      <input type="button" class="btn" value="LOG IN" id="loginBtn">
		    	
		      <div class="bottomText">
		        Don't you have ID? <a href="../join/joinForm.jsp">sign up</a>
	      </div>
 <!--  </form> -->
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		 $(function() {
			
			$("#loginBtn").click(function() {
			
				var uid = $("#uid").val();
				var upassword = $("#upassword").val();
		
					$.ajax({				
						url : "../login", 
						type : "POST",
						data : {uid:uid, upassword:upassword},
						success : function(data) {
							//alert(data);
							
							if(data == 1){
								alert("오늘도 좋은 하루 되세요!");
								location.href="../homepage/home.jsp";
							}else if(data == 2){
								alert("비밀번호가 틀렸습니다.");	
								location.href="../login/loginForm.jsp";
							}else{
								alert("아이디 확인해주세요.");
								location.href="../login/loginForm.jsp";
							}
							
							
						}, 				
						error : function(request, status, error) {
							alert("에러");
							alert("code:" + request.status);					
						}
						
					})
					
				})
				
		}) 
		

	</script>
</body>
</html>