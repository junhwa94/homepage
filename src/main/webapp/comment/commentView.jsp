<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/homepage/css/comment.css" rel="stylesheet">
</head>
<body>
	<div class="c_insertForm">
		<c:set var="sessionId" value="${sessionScope.uid}"/>
		
		<c:forEach var="contentlist" items="${contentlist}">
		
				<input type="hidden" name="bnum" value="${contentlist.bnum}" id="bnum">
			 	 <input type="hidden" name="c_id" value="${sessionId}" id ="sessionId">
			   		<br>
			  	<textarea rows="5" cols="80" name="c_content" id="c_content" placeholder="댓글을 작성하세요."></textarea>
		      		<br>
		      	<button type="button" class="btn btn-info btn-sm" id="insertCommentBtn">댓글작성</button>
		
		</c:forEach>
	</div> 
	
	<div class="commentView">
		<table id="cmtListTable" class="cmtTable" border="1">
	   
	   </table>
	</div>
	
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>		
$(document).ready(function(){
	
	
   var bnum = $("#bnum").val();
   var sessionId = $("#sessionId").val();
   
   $.ajax({
      url : "/homepage/commentView",
      type : "POST",
      data : {bnum:bnum},
      success : function(data) {
     
   
      var tableElement = "<tr>"; 
      
      if(data.length < 1){
         tableElement += "<td>등록된 댓글이 없습니다.<td></tr>";
      }else{
    	  tableElement += "<th>no</th>"
 			 + "<th>작성자</th>"
 			 + "<th>댓글내용</th>"
 			 + "<th>날짜</th>"
 			 + "<th></th>"
 			 + "<th></th>"
 			 + "</tr>"
 			 + "<tr>";
    	  
         $.each(data, function(i){
            
            var c_num = data[i].c_num;
            var c_id = data[i].c_id;
            var c_date = data[i].c_date;
            var c_content = data[i].c_content;
            var bnum = data[i].bnum;
            var delete_c_num = "delete"+c_num;
            var update_c_num = "update"+c_num;
            
            tableElement += "<td>" + c_num + "</td>"
            			 + "<td>" + c_id + "</td>"
            			 + "<td>" + c_content + "</td>"
            			 + "<td>" + c_date + "</td>"
            			 + "<td class='cmt2Up'><a href='#' id='" + c_num + "'>수정</a></td>"
                         + "<td class='cmt2Del'><a href='#' id='" + delete_c_num + "'>삭제</a></td>"
                         + "</tr>";
            			 
            
           $(document).on("click", "#"+delete_c_num, function(){
               if(confirm("정말 삭제하시겠습니까?")){
                  alert("댓글이 삭제되었습니다.");
                  location.href="/homepage/commentDelete?bnum="+bnum+"&c_num="+c_num;
               }else{
                  alert("취소되었습니다.");
               }   
            })
                   
            
            /* $(document).on("click", "#"+update_c_no, function(){
               
               alert("기능 미구현");
               
            }) */
            
         })
         
      }  
         $("#cmtListTable").append(tableElement);
          
         
      },
      error : function(request, status, error) {
         alert("에러");
         alert("code:"+request.status);
      }
      
   });
   
   $("#insertCommentBtn").click(function() {
       var c_id = $("#sessionId").val();
       var c_content = $("#c_content").val();
       var bnum = $("#bnum").val();
       
       if(confirm("댓글을 작성하시겠습니까?")){
          $.ajax({
             url : "/homepage/commentInsert",
             type : "POST",
             data : {c_id:c_id, c_content:c_content, bnum:bnum},
             success : function(data) {
                alert("댓글이 등록되었습니다.");
                location.reload();
             },
             error : function(request, status, erro) {
                alert("에러");
                alert("code:"+request.status);
             }
          });
          
       }else{
          alert("취소되었습니다.");
       }
       
    })
})  
   
</script>
</body>
</html>