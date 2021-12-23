<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/homepage/css/insertForm.css" rel="stylesheet">
</head>
<body>

<c:set var="sessionId" value="${sessionScope.uid}"/>

	<div class="container">
		
				<form action="/homepage/BoardInsert" method="post"> <!-- /프로젝트명/서블릿이름  -->
				
					<h5>writer
						<input type="text" name="bwriter" size=10 value="${sessionId}" readonly="readonly">
					</h5><br>
					비밀글
						<input type="checkbox" name="checkbox" value="1">
						<input type="password" name="bpw"><br><br>
					<h5>title
						<input type="text" name="btitle" size=69 autocomplete="off">
					</h5>
					<h5>content
						<textarea class="form-control" rows="10" cols="70" id="comment" name="bcontent"  placeholder="내용을 입력하세요" wrap="hard"></textarea>
					</h5>			
					<br>
					<input type = "submit" value="등록하기" class="btn btn-primary">
					
				</form>
	</div>
	
</body>
</html>