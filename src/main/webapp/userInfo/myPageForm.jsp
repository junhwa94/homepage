<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link href="/homepage/css/joinForm.css" rel="stylesheet" type="text/css">
</head>
<body>

	<c:forEach var="userList" items="${userList}">
	<input type="hidden" id="unum" value="${userList.unum}">
	
	 <form action="#"> 
	       <div id="header"></div>
		
		       		 <div id="wrapper">
		
		           		<div id="content">
		
		                	<div>
		               
		                    	<h3 class="join_title">
		                    			
		                        	<label for="id">아이디</label>
		                        	
		                    	</h3>  
		                    	
		                    		<span class="box int_id">
		                    	
			              			<input type="text" id="uid" class="int" maxlength="20" name="uid" value="${userList.uid}" readonly="readonly">
			              			 
		                    		</span>
		                    	
		                   		 	
		                	</div>
								
		               		 <div>
		               		 		
		                   	<h3 class="join_title"><label for="upassword1">비밀번호</label></h3>  
		                    	<span class="box int_pass">
			                        <input type="password" id="upassword1" class="int" maxlength="20" name="upassword" value="${userList.upassword}">
			                        <span id="alertTxt">사용불가</span>
			                        <img src="" id="pswd1_img1" class="pswdImg">
		                    	</span>
		                    <span class="error_next_box"></span>
		               	 </div>
		
		               <div>
		                    <h3 class="join_title"><label for="upassword2">비밀번호 재확인</label></h3>
		                    <span class="box int_pass_check">
		                        <input type="password" id="upassword2" class="int" maxlength="20">
		                        <img src="" id="pswd2_img1" class="pswdImg">
		                    </span>
		                    <span class="error_next_box2"></span>
		                </div>
		
		                <div>
		                    <h3 class="join_title"><label for="uname">이름</label></h3>
		                    <span class="box int_name">
		                        <input type="text" id="uname" class="int" maxlength="20" name="uname" value="${userList.uname}">
		                    </span>
		                    <span class="error_next_box"></span>
		                </div>
		
		                <div>
		                
		                    <h3 class="join_title"><label for="yy">생년월일</label></h3>
						
		                    <div id="bir_wrap">
		                        
		                        <div id="bir_yy">
		                            <span class="box">
		                                <input type="text" id="yy" class="int" maxlength="4" name="year" value="${fn:substring(userList.ubirth,0,4)}">
		                               <!--  <input type="text" id="yy" class="int" maxlength="4" name="year" value=""> -->
		                             
		                            </span>
		                        </div>
		
		                        <div id="bir_mm">
		                            <span class="box">
		                  
		                               <input type="text" id="mm" class="int" maxlength="2" placeholder="월" name="month" value="${fn:substring(userList.ubirth,5,7)}">
		                            
		                            </span>
		                        </div>
		
		                        <div id="bir_dd">
		                            <span class="box">
		                                <input type="text" id="dd" class="int" maxlength="2" placeholder="일" name="day" value="${fn:substring(userList.ubirth,8,10)}">
		                            </span>
		                        </div>
		
		                    </div>
		                    <span class="error_next_box"></span>    
		                </div>
		
		                <div>
		                    <h3 class="join_title"><label for="ugender">성별</label></h3>
		                    <span class="box gender_code">
		                    
		                    	<c:if test="${userList.ugender eq 'M'}">
			                        <select id="ugender" class="sel" name="ugender">		                     
			                            <option value="">성별</option>
			                            <option value="M" selected="selected">남자</option>
			                            <option value="F">여자</option>
			                        </select>   
		                        </c:if>
		                        
		                        <c:if test="${userList.ugender eq 'F'}">
			                        <select id="ugender" class="sel" name="ugender">		                     
			                            <option value="">성별</option>
			                            <option value="M">남자</option>
			                            <option value="F" selected="selected">여자</option>
			                        </select>   
		                        </c:if>
		                                                 
		                    </span>
		                    <span class="error_next_box">필수 정보입니다.</span>
		                </div>
		
		               <!-- <h3> EMAIL</h3> -->
		                <div>
		                    <h3 class="join_title"><label for="uemail">본인확인 이메일<span class="optional">(선택)</span></label></h3>
		                    <span class="box int_email">
		                        <input type="text" id="uemail" class="int" maxlength="100" placeholder="선택입력" name="uemail" value="${userList.uemail}">
		                    </span>
		                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
		                </div>
		
		               <!--  <h3>MOBILE</h3> -->
		                <div>
		                    <h3 class="join_title"><label for="uphone">휴대전화</label></h3>
		                    <span class="box int_mobile">
		                        <input type="tel" id="uphone" class="int" maxlength="16" placeholder="전화번호 입력" name="uphone" value="${userList.uphone}">
		                    </span>
		                    <span class="error_next_box"></span>    
		                </div>
		
		
		                <div class="btn_area">
		                    <input type="submit" id="btnJoin" class="btnup" value="회원수정">
		                    <input type="button" id="btnJoin" class="btndel" value="탈퇴하기">
		 
		                </div>
		
		            </div> 
		
		        </div> 
	        </form> 
	
	</c:forEach>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>

<script type="text/javascript">

	$(function () {
		
		$(".btndel").on("click", function(){
	         var uid = $("#uid").val();
	         var upassword = prompt("비밀번호를 입력하세요");
	         
	         if(upassword == $("#upassword1").val()){
	            if(confirm("정말 탈퇴하시겠습니까?")){
	               alert("탈퇴가 처리되었습니다.");
	               location.href="/homepage/userDelete?upassword="+$("#upassword1").val();
	            }else{
	               alert("취소되었습니다.");
	            }
	         }else if(upassword == null || upassword == undefined || upassword == ""){
	        	 alert("비밀번호를 입력해주세요.");
	         }else{
	            alert("비밀번호가 일치하지 않습니다.");
	         }
	         
	      })

		
		$(".btnup").on("click", function(){
			 var uid = $("#uid").val();
	         var upassword1 = prompt("비밀번호를 입력하세요");
			
	         var upassword = $("#upassword1").val();
	         var uname = $("#uname").val();
	         var year = $("#yy").val();
	         var month = $("#mm").val();
	         var day = $("#dd").val();
	         var ugender = $("#ugender").val();
	         var uemail = $("#uemail").val();
	         var uphone = $("#uphone").val();
	  
	         
	         if(upassword1 == $("#upassword1").val()){
	            if(confirm("정말 수정하시겠습니까?")){
	               alert("회원정보가 수정되었습니다.");
	               location.href="/homepage/userUpdate?upassword="+upassword+"&uname="+uname+"&year="+year+"&month="+month+"&day="+day+"&ugender="+ugender+"&uemail="+uemail+"&uphone="+uphone;
	            }else{
	               alert("취소되었습니다.");
	            }
	         }else if(upassword1 == null || upassword1 == undefined || upassword1 == ""){
	        	 alert("비밀번호를 입력해주세요.");
	        	
	         }else{
	            alert("비밀번호가 일치하지 않습니다.");
	         }
	         
	      })
	      
	      
	      
		/* $(".btndel").click(function() {
			//btndel 버튼을 눌렀을 때 실행
			var unum = $("#unum").val();
			
			alert("정말로 탈퇴하시겠습니까?");
			
			//unum 변수에 폼태그 안에 숨겨놓은 unum 값을 담는다.
			$.ajax({		//ajax불러오기		
				url : "/homepage/userDelete", 
				type : "POST",
				data : {unum:unum}, //데이터 이름과 변수
				success : function(data) {
					
					if(data==1){
						location.href="/homepage/homepage/home.jsp"
					}
	
					
				}, 				
				error : function(request, status, error) {
					alert("에러");
					alert("code:" + request.status);					
				}
				
			}) */
			
	//	})
		
		/* $(".btndel").click(function() {
			//btndel 버튼을 눌렀을 때 실행
			var unum = $("#unum").val();
			
			alert("정말로 탈퇴하시겠습니까?");
			
			//unum 변수에 폼태그 안에 숨겨놓은 unum 값을 담는다.
			$.ajax({		//ajax불러오기		
				url : "/homepage/userDelete", 
				type : "POST",
				data : {unum:unum}, //데이터 이름과 변수
				success : function(data) {
					
					if(data==1){
						location.href="/homepage/homepage/home.jsp"
					}
	
					
				}, 				
				error : function(request, status, error) {
					alert("에러");
					alert("code:" + request.status);					
				}
				
			})
			
		}) */
		
		
	});


</script>







</html>