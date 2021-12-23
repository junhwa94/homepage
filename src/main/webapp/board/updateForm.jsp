<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<% pageContext.setAttribute("replaceChar", "\n"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/homepage/css/updateForm.css" rel="stylesheet">
</head>
<body>
	<c:set var="sessionId" value="${sessionScope.uid}"/> <!-- 로그인 유지, 사용자 아이디  -->
	<c:forEach var="contentlist" items="${contentlist}">  
	
	<div class="container">
	
			<form action="/homepage/BoardUpdate" method="post"> <!-- /프로젝트명/서블릿이름  -->
			<input type="hidden" name="bnum" value="${contentlist.bnum}">
				<h5>writer <input type="text" name="uid" size=10 value="${sessionId}" readonly="readonly"></h5><br>
				비밀글<input type="checkbox" name="checkbox" value="1">
				<input type="password" name="bpw" value="${contentlist.bpw}">
				<h5>title</h5>
				<input type="text" name="btitle" size=69 value="${contentlist.btitle}"><br><br>
				<h5>content</h5>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent"  placeholder="내용을 입력하세요" wrap="hard">${contentlist.bcontent}</textarea>
				<%-- <textarea class="form-control" rows="5" id="comment" name="bcontent"  placeholder="내용을 입력하세요" wrap="hard" value ="${fn:replace(contentlist.bcontent, replaceChar, '<br/>')}"></textarea>
 --%>
				
				<input type = "submit" value="수정하기" class="btn btn-primary">
			</form>

		</div>
		</c:forEach>

</body>
</html>