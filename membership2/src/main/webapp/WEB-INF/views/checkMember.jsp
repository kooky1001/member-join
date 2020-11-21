<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
	  box-sizing: border-box;
	  font-family: "맑은 고딕";
	  color: #5D5D5D;
	}
	
	.mypage_menu{
		margin :0px;
		padding :0px;
		width: 819px;
		height: 800px;
		border: 1px solid #EAEAEA;
		z-index: 5px;
		margin-top: 200px;
	
	}
	

	
	#mypage_title{
		text-align: center;
		height: 80px;
		padding-top: 20px;
		
			
	}

		
	.mypage_detail_under{
		width: 817px;
		margin-left: 26px;
		margin-top: 1px;
		
	}
	
	
	#mypage_title_sub{
		width: 760px;
		height: 350px;
		border: 1px solid #EAEAEA;
		border-top: 3px solid #94CCC4;
		border-bottom: 3px solid #94CCC4;
		padding-left: 5%;
		padding-right: 5%;
		display: table;
	}
	
	.mypage_detail_under h3{
		text-align: center;
		color: #5D5D5D;
		font-weight: bold;
		padding-top: 30px;
		padding-bottom: 30px;
		padding-right: 50px;
	
	}
	
	
	.pw_input{
		width: 200px;
		height: 40px;
		border: 1px solid #EAEAEA;
	}
	.tel_input{
		width: 100px;
		height: 40px;
		border: 1px solid #EAEAEA;
	}
	
	#mypage_title_btn{
		text-align: center;
		width: 760px;
		height: 150px;
	}
	
	.mypage_title_btn1{
		border-radius: 10px;
		width: 150px;
		height: 35px;
		border: 1px solid #94CCC4;
		background-color: #94CCC4;
		color: #ffffff;
		font-weight: bold;
		margin-top: 55px;
	}
	
	.mypage_title_btn3{
		border-radius: 10px;
		width: 120px;
		height: 35px;
		border: 1px solid #94CCC4;
		background-color: #94CCC4;
		color: #ffffff;
		font-weight: bold;
		margin-left: 30px;
	}
	
	.mypage_title_btn2{
		border-radius: 10px;
		width: 150px;
		height: 35px;
		border: 1px solid #94CCC4;
		background-color: #ffffff;
		color: #94CCC4;
		font-weight: bold;
		margin-top: 55px;
	}
	
	
	#container .column-side-left .column-side-right .column-middle{
		width: 1200px;
		margin: 0px auto;
		padding: 20px;
		justify-content: center;
		display: flex;
		/*border: 1px solid #bcbcbc;*/
	}
	

	
	/* Create three unequal columns that floats next to each other */
	.column {
	  float: left;
	  padding: 10px;
	  height: 300px; /* Should be removed. Only for demonstration */
	}
	
	/* Left and right column */
	#column-side-left {
	width: 160px;
	padding: 20px;
	margin-right: 20px;	
	float: left;
	/*border: 1px solid #bcbcbc;*/
	}
	
	#column-side-right {
	width: 160px;
	padding: 20px;
	margin-bottom: 20px;	 
	position: relative;
	float: left;
	/*border: 1px solid #bcbcbc;*/
	}
	
	/* Middle column */
	.column-middle {
	width: 880px;
	margin: 20px auto;
	 
	position: relative;
	

	}	


	
	/* Clear floats after the columns */
	.row:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
	/* Style the footer */
	.footer {
	  background-color: #f1f1f1;
	  padding: 10px;
	  text-align: center;
	}
	
	/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
	@media (max-width: 600px) {
	  .column.side, .column.middle {
	    width: 100%;
	  }  
	  
	}
	
	.tr{
		display: table-row;
	}
	
	#mypage_title_sub span{
		display: table-cell;
		padding-top: 30px;
		padding-bottom: 30px;
	}
	#mypage_title_sub strong{
		display: table-cell;
		padding-left: 30px;
		padding-right: 30px;
	}
	
	kkk{
		font-size: 13px;
		color: #94CCC4;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	var checkAlready = true;
	var checkRR = true;
$(function(){

// 	var telcheck;
	
	$("#btnSubmit").click(function(){
		var tel1 = $("#tel1").val();
		var tel2 = $("#tel2").val();
		var tel3 = $("#tel3").val();
		$("#tel").val(tel1+"-"+tel2+"-"+tel3);
		
		var rr_no1 = $("#rr_no1").val();
		var rr_no2 = $("#rr_no2").val();
		var rr = rr_no1+"-"+rr_no2;

		$.ajax({
		    url: "/checkRR",
		    method: "POST",
		    dataType: "text",
		    async: false,
		    data: {rr_no:rr, rr_check:rr_no1+rr_no2},
		    success: function(data) {
				data = JSON.parse(data);
				
			    if(data.already == 0){
			    	checkAlready = false;
				}
				
			    if(data.re == "o"){
					checkRR = false;
				}
		    }
		});

// 		if(telcheck != tel1+tel2+tel3){
// 			alert("전화번호를 확인해주세요.");
// 			return false;
// 		}
		
		$("#rr_no").val(rr_no1+"-"+rr_no2);

		if($("#checkTel").val() != checkT){
			alert("인증번호를 확인해주세요.");
			return false;
		}
		
		if(checkRR){
			alert("잘못된 주민등록번호입니다. 주민등록번호를 확인해주세요.");
			return false;
		}

		if(checkAlready){
			alert("이미 가입된 주민등록번호입니다.");
			return false;
		}
		
	});

	var checkT;
	$("#btnTel").click(function(){
		var tel1 = $("#tel1").val();
		var tel2 = $("#tel2").val();
		var tel3 = $("#tel3").val();
		var tel = tel1+tel2+tel3;

		$.ajax({
		    url: "/checkTel",
		    method: "POST",
		    dataType: "text",
		    data: {tel:tel},
		    success: function(data) {
			    data = JSON.parse(data);
				if(data.send > 0){
				    alert("인증번호를 발송하였습니다.");
				    checkT = data.msg;
// 				    telcheck = tel;
				} else {
					alert("인증번호 발송에 실패하였습니다. 전화번호를 확인해주세요.");
				    checkT = data.msg;
				}
		    }
		  });
		
	});
});
</script>
</head>
<body>
	<div class="column-side-left"></div>
	  
	  <!-- 메인 -->
	<div id="container">
	<div class="column-middle">
		<div class="mypage_menu">
		  	
		  	<div class="mypage_detail">
<!-- 			  	<div id="mypage_box"> -->
<!-- 	                <a href="/myPage_2"> <div id="mypage_box_div1">개인정보수정</div></a> -->
<!-- 	                 <div id="mypage_box_empty"></div> -->
<!-- 	                  <a href="/myPage_3"><div id="mypage_box_div2">비밀번호 변경</div></a> -->
<!-- 	              </div> -->
		  		<div id="mypage_title">
		  			<h2>본인 인증</h2>
		  		</div>
		  	<div class="mypage_detail_under">
		  			<h3>회원님의 개인정보보호와 더욱 안정된 서비스를 위해 최선을 다하겠습니다.</h3>
				<form action="/checkMember" method="post">
		  		<div id="mypage_title_sub">
		  			<div class="tr">
		  			<strong>이름</strong>
		  			<span><input type="text" name="name" id="name" required="required" class="pw_input">
		  			<br><kkk>※ 인증 후 자동으로 이름이 입력됩니다.</kkk>
		  			</span>
		  			</div>
		  			<div class="tr">
		  			<strong>주민등록번호</strong>
		  			<span>
		  			<input type="text" name="rr_no1" id="rr_no1" maxlength="6" minlength="6" required="required" class="pw_input"> - 
		  			<input type="password" name="rr_no2" id="rr_no2" maxlength="7" minlength="7" required="required" class="pw_input">
					<input type="hidden" name="rr_no" id="rr_no"><br>
					<kkk>※ 병원 환자정보 확인을 위해 정확히 입력해 주십시오.</kkk>
		  			</span>
		  			</div>
		  			<div class="tr">
		  			<strong>전화번호</strong>
		  			<span>		  			
		  			<select id="tel1" name="tel1" class="tel_input">
						<option value="010" selected="selected">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select> - 
					<input type="text" id="tel2" name="tel2" placeholder="0000" class="tel_input" maxlength="4"> - 
				  	<input type="text" id="tel3" name="tel3" placeholder="0000" class="tel_input" maxlength="4">
				  	<input type="hidden" id="tel" name="tel" class="tel_input">
		  			<button id="btnTel" type="button" class="mypage_title_btn3">인증번호 받기</button>
		  			</span>
		  			</div>
		  			<div class="tr">
		  			<strong>인증번호</strong>
		  			<span><input type="text" name="checkTel" id="checkTel" class="pw_input"></span>
		  			</div>
		  		</div>
		  		<div id="mypage_title_btn">
		  			<button class="mypage_title_btn1" id="btnSubmit">확인</button>
		  			<button class="mypage_title_btn2" type="reset">취소</button>
		  		</div>
			</form>
		  		  	
		  	</div>
		  	</div>	
		  	
	  	</div>
	  		
	</div>
	</div>


</body>
</html>