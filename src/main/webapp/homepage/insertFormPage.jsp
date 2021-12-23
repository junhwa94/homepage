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
	<div class = "header">
		<jsp:include page="/homepage/header.jsp" flush="false"/>
	</div>
	<div class = "content">
		<jsp:include page="/board/insertForm.jsp" flush="false"/>
	</div>
	<div class = "footer">
		<jsp:include page="/homepage/footer.jsp" flush="false"/>
	</div>
</body>
</html>