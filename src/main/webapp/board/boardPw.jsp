<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/homepage/css/passwordForm.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	
	<input type="hidden" id = "b_bnum" value="<%= request.getAttribute("bnum") %>">
	<input type="hidden" id = "b_bpw" value="<%= request.getAttribute("bpw") %>">
	<div class="test">
	<div class="passwordForm">
		<div id="update">
			<div class="passwordBox text-center">
				<div><h3>암호를 입력하세요</h3></div> <br>
							
				<input type="password" name="bpw" id="bpw"> <br>
				<div class="btnWrapper text-center"><br>				
				<input class="btn btn-outline-danger" type="button" value="확인" id="b_btn">
				<button class="btn btn-outline-primary" onclick="location.href='/homepage/BoardViewList'">취소</button>
				</div>
							
	        </div>
	    </div>
	  </div>
	    </div>  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		
		$("#b_btn").click(function() {
	
			var bpw = $("#bpw").val();
			var b_bnum = $("#b_bnum").val();
			var b_bpw = $("#b_bpw").val();
	
			
				$.ajax({				
					url : "/homepage/BoardPwCheck", 
					type : "post",
					data : {bpw:bpw},
					success : function(data) {
						
						if(data == 1){
							
							location.href="/homepage/BoardContent1?b_bnum="+b_bnum+"&b_bpw="+b_bpw;
						}else if(data == 2){
							alert("비밀번호를 입력해주세요.");	
						}else{
							alert("비밀번호 확인해주세요.");
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