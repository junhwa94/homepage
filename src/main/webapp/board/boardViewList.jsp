<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/homepage/css/boardViewList.css">
</head>
<body>


<div class="board">
	
		<table class="boardtable">
			<tr>
				<td colspan="5">
					<form action="/homepage/BoardSearch" method="post">
		
				<SELECT name="col"> 
			        <OPTION value="bwriter">이름</OPTION>
			        <OPTION value="btitle">제목</OPTION>
			        <OPTION value="bcontent">내용</OPTION>
			        <OPTION value="title_content">제목+내용</OPTION>
		     	</SELECT>
			      <input type="text" name="word" autocomplete="off">
			      <button type="submit" class="btn btn-outline-success">search</button>
			          
				</form>
				</td>
				
				<td>
					<div class="b_write_btn">
						<div>
							<button type="button" onclick="location.href='/homepage/homepage/insertFormPage.jsp'" class="btn btn-info" ">write</button>
						</div>	
					</div>
				</td>
			</tr>		
			
			<tr>
				<th class="b_no">no</th>
				<th class="b_writer">writer</th>
				<th class="b_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;title</th>				
				<th>views</th>
				<th class="date" colspan="5">date</th>
			</tr>
			
		<c:forEach var="boardList" items="${boardList}">
				<tr>
					<td class="b_no">${boardList.bnum}</td>
					<td>${boardList.bwriter}</td>
					
				
						<c:if test="${boardList.bpw != null}">
							<td><img src="/homepage/img/lock.png"><a href="BoardContent?bnum=${boardList.bnum}&bpw=${boardList.bpw}">${boardList.btitle}</a></td>
						</c:if>
						
						<c:if test= "${boardList.bpw == null}">
							<td><a href="BoardContent?bnum=${boardList.bnum}">${boardList.btitle}</a></td>
						</c:if>
						
				
					<td>${boardList.bviews}</td>
					<td colspan="5">${boardList.breg_date}</td>
					

				</tr>

		</c:forEach>
		
	</table>
	
<%-- 						<c:if test="${boardList.bpw == boardList.bpw}">
						<td><img src="/homepage/img/lock.png"><a href="BoardContent?bnum=${boardList.bnum}&bpw=${boardList.bpw}">${boardList.btitle}</a></td>
					</c:if>
					<c:if test="${boardList.bpw == null}">
						<td><a href="BoardContent?bnum=${boardList.bnum}">${boardList.btitle}</a></td>
					</c:if>

					<td>${boardList.bviews}</td>
					<td colspan="5">${boardList.breg_date}</td>	 --%>
					
					
					
					
			<%-- 		<c:choose>
						<c:when test="${boardList.bpw == boardList.bpw}">
							<td><img src="/homepage/img/lock.png"><a href="BoardContent?bnum=${boardList.bnum}&bpw=${boardList.bpw}">${boardList.btitle}</a></td>
						</c:when>
						
						<c:otherwise>
							<td><a href="BoardContent?bnum=${boardList.bnum}">${boardList.btitle}</a></td>
						</c:otherwise>
						
					</c:choose> --%>
</div>
</body>
</html>