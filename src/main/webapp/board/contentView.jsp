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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="/homepage/css/content.css" rel="stylesheet">
</head>
<body>
	<%-- <%= session.getAttribute("uid") %> //로그인 된 아이디 확인 --%>
	
	<c:set var="sessionId" value="${sessionScope.uid}" />
	
		<div class="bcontentWrap">	
			
				<c:forEach var="contentlist" items="${contentlist}">
	  					
				<div class="container">
					
			        <table class="table">
				        <thead> 
			        
				        <c:if test="${sessionId != contentlist.bwriter}">
				        
				        	<tr>
				        		<td></td>
				        	</tr>
				        </c:if>
				        
				         <c:if test="${sessionId == contentlist.bwriter}">
				        
					         <tr>
					       		<td style="border-top: none" colspan="6">
						       		<a href="/homepage/BoardDelete?bnum=${contentlist.bnum}" class="btn btn-dark">delete</a>
						       		<a href="/homepage/BoardContent?bnum=${contentlist.bnum}&update=1" class="btn btn-dark">edit</a>
						       		<%-- <a href="/homepage/board/updateForm.jsp?bnum=${contentlist.bnum}&bviews=${contentlist.bviews}" class="btn btn-dark">edit</a> --%>
					       		</td>
					         </tr>
				        </c:if>
				        
		            
			             <tr>
			                <th>번호</th>
			                <th>${contentlist.bnum}</th>                    
			                <th>조회수</th>
			                <th>${contentlist.bviews}</th>
			                <th>작성날짜</th>
			                <th>${contentlist.breg_date}</th>
			             </tr>
			              </thead>
			              <tbody> 
			                <tr>
			                	<th>작성자</th>
			                	<th>${contentlist.bwriter}</th>
			                    <th>제목</th>	                   
			                    <th colspan="5">${contentlist.btitle}</th>
			                </tr>
			                <tr>
			                     <td colspan="6" height="400">${fn:replace(contentlist.bcontent, replaceChar, "<br/>")}</td>			                 
			                </tr>
			             </tbody>	           
			        </table>
			        </div>
			       
			   </c:forEach>
		</div>			
	
	 

	
</body>
</html>