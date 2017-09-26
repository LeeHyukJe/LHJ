<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="join_css.css">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>MyHome</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

	<div class="w3-top">
		<div class="w3-bar w3-black w3-card-2">
			<a href="index.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">HOME</a>
			<a href="javascript:void(0)"
				class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
				class="fa fa-search"></i></a>
		</div>
	</div>

	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">HOME</a>

	</div>

	<form action="join_action.jsp" style="border: 1px solid #ccc; margin: 50px 0 0 80px; width: 80%;">
		<div class="container">
			<label><b>아이디</b></label> 
			<input type="text" placeholder="아이디를 입력하세요" name="user_id" required> 
				<label><b>비밀번호</b></label> <input
				type="password" placeholder="비밀번호를 입력하세요" name="user_password" required> 
				<label><b>이름</b></label> <input type="text" placeholder="이름을 입력하세요" name="user_name">
				 <label><b>이메일</b></label>
			<input type="text" placeholder="이메일을 입력하세요" name="user_email">

			<label><b>학교</b></label> 
			<input type="text" placeholder="학교를 입력하세요" name="user_college"> 
			<label><b>프로필사진</b></label> 
			<input type="file" name="user_picture"> 
			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>

</body>
</html>
