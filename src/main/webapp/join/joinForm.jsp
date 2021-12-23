<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/homepage/css/joinForm.css" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
</head>
<body>
	<form action="../join" method="post">
	 	
	 	<div id="header1"></div>
	
	       		 <div id="wrapper">
	
	           		<div id="content">
	
	                	<div>
	               
	                    	<h3 class="join_title">
	                    			
	                        	<label for="id">아이디*</label>
	                        	
	                    	</h3>  
	                    	
	                    		<span class="box int_id">
	                    		
		              			<input type="text" id="uid" class="int" maxlength="20" name="uid" required="required">
		              			 
	                    		</span>
	                    		<div id = bid>
	                    		<input type ="button" value="중복확인" id="idcheck" name="idcheck"></div>
	                   		 	<!-- <span class="error_next_box"></span> -->
	                   		 	
	                	</div>
							
	               		 <div>
	               		 		
	                   	<h3 class="join_title"><label for="upassword1">비밀번호*</label></h3>  
	                    	<span class="box int_pass">
		                        <input type="password" id="upassword1" class="int" maxlength="20" name="upassword" required="required">
		                        <span id="alertTxt">사용불가</span>
		                       <!--  <img src="" id="pswd1_img1" class="pswdImg"> -->
	                    	</span>
	                    <span class="error_next_box"></span>
	               	 </div>
	
	               <div>
	                    <h3 class="join_title"><label for="upassword2">비밀번호 재확인*</label></h3>
	                    <span class="box int_pass_check">
	                        <input type="password" id="upassword2" class="int" maxlength="20">
	                        <!-- <img src="" id="pswd2_img1" class="pswdImg"> -->
	                    </span>
	                    <span class="error_next_box2"></span>
	                </div>
	
	                <div>
	                    <h3 class="join_title"><label for="uname">이름*</label></h3>
	                    <span class="box int_name">
	                        <input type="text" id="uname" class="int" maxlength="20" name="uname" required="required">
	                    </span>
	                    <span class="error_next_box"></span>
	                </div>
	
	                <div>
	                    <h3 class="join_title"><label for="yy">생년월일(선택)</label></h3>
	
	                    <div id="bir_wrap">
	                        
	                        <div id="bir_yy">
	                            <span class="box">
	                                <input type="text" id="yy" class="int" maxlength="4" placeholder="년(4자)" name="year">
	                            </span>
	                        </div>
	
	                        <div id="bir_mm">
	                            <span class="box">
	                             <input type="text" id="mm" class="int" maxlength="2" placeholder="월" name="month">
	                            </span>
	                        </div>
	
	                        <div id="bir_dd">
	                            <span class="box">
	                                <input type="text" id="dd" class="int" maxlength="2" placeholder="일" name="day">
	                            </span>
	                        </div>
	
	                    </div>
	                    <span class="error_next_box"></span>    
	                </div>
	
	                <div>
	                    <h3 class="join_title"><label for="ugender">성별(선택)</label></h3>
	                    <span class="box gender_code">
	                        <select id="ugender" class="sel" name="ugender">
	                            <option>성별</option>
	                            <option value="M">남자</option>
	                            <option value="F">여자</option>
	                        </select>                            
	                    </span>
	                   
	                </div>
	
	                <!-- EMAIL -->
	                <div>
	                    <h3 class="join_title"><label for="uemail">본인확인 이메일<span class="optional">(선택)</span></label></h3>
	                    <span class="box int_email">
	                        <input type="text" id="uemail" class="int" maxlength="100" placeholder="선택입력" name="uemail">
	                    </span>
	                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
	                </div>
	
	                <!-- MOBILE -->
	                <div>
	                    <h3 class="join_title"><label for="uphone">휴대전화(선택)</label></h3>
	                    <span class="box int_mobile">
	                        <input type="tel" id="uphone" class="int" maxlength="16" placeholder="전화번호 입력" name="uphone">
	                    </span>
	                    <span class="error_next_box"></span>    
	                </div>
	
	
	                <div class="btn_area">
	                    <input type="submit" id="btnJoin" value="가입하기">
	                  
	                 
	                </div>
	
	            </div> 
	
	        </div> 
        </form>
 
        
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function() {
		
			$("#idcheck").click(function() {
			
				var uid = $("#uid").val();
		
					$.ajax({				
						url : "../idcheck", 
						type : "POST",
						data : {uid:uid},
						success : function(data) {
							//alert(data);
							
							if(data == 1){
								alert("아이디가 중복됩니다.");
							}else if(data == 2){
								alert("아이디를 입력해주세요");						
							}else if(data == 0){
								alert("사용가능한 아이디입니다.");
							}
							
							
						}, 				
						error : function(request, status, error) {
							alert("에러");
							alert("code:" + request.status);					
						}
						
					})
					
				})
				
			$("#btnJoin").click(function() {
				var uid = $("#uid").val();
				var upassword = $("#upassword1").val();
				var uname = $("#uname").val();
				
				if(uid == null || uid == undefined || uid == ""){
					alert("아이디를 입력해주세요.");
					$("#uid").foucs();
					return;
				}
				if(upassword == null || upassword == undefined || upassword == ""){
					alert("비밀번호를 입력해주세요.");
					$("#upassword1").foucs();
					return;
				}
				if(uname == null || uname == undefined || uname == ""){
					alert("이름을 입력해주세요.");
					$("#uname").foucs();
					return;
					
				}else{
					alert("가입을 축하드립니다.");
					location.href="/homepage/homepagw/home.jsp";
				}
			})	
				
		})
			
		
		$("#upassword2").on("keyup", function(){
		        if($("#upassword1").val() != $("#upassword2").val()){
		                            
		        $(".error_next_box2").text("비밀번호가 일치하지 않습니다.").css({
		         	"color" : "red",
		           "font-size" : "small" 
		        })
		        }else{
		           $(".error_next_box2").empty();
		        }
		        
		       /*  $("#btnJoin").click(function() {
					alert("가입을 축하드립니다!")
				})  */
		    })
	</script>
        
</body>
</html>