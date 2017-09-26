<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jspbook.addrbook.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="addrbook" scope="page"
	class="jspbook.addrbook.AddrBook" />
<jsp:useBean id="addrbean" scope="page"
	class="jspbook.addrbook.AddrBean" />
<%
	ArrayList<AddrBook> list = addrbean.getDBList();
	String[] pic_list = new String[list.size()];
	Iterator<AddrBook> it = list.iterator();
	for (int i = 0; it.hasNext(); i++) {
		pic_list[i] = it.next().getAb_picture();
	}
	String memberId = (String) session.getAttribute("memberid");
	
	if(memberId!=null){
		AddrBook user_pic=addrbean.getDB(memberId);
		String user_pic2=user_pic.getAb_picture();
	}
	//git test
%>


<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MyHome</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body{
            font-family:"Lato", sans-serif;}
        .myslides{
            display:none;}
    </style>
</head>
<body>
<!--navBar!-->
<div class="w3-top">
    <div class="w3-bar w3-black w3-card-2">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="index2.jsp" class="w3-bar-item w3-button w3-padding-large">HOME</a>
        <%
        	if(memberId==null){
        %>
        <a href="login_form.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">로그인</a>
        <%
        	}else{
        %>
         <a href="logout.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">로그아웃</a>
         <%
        }
         %>
        <a href="addrbook_list.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">회원 리스트</a>
        <a href="addrbook_form.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">회원가입</a>
        <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
    </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
    <a href="#band" class="w3-bar-item w3-button w3-padding-large">BAND</a>
    <a href="#tour" class="w3-bar-item w3-button w3-padding-large">TOUR</a>
    <a href="#contact" class="w3-bar-item w3-button w3-padding-large">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">MERCH</a>
</div>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

    <!-- Automatic Slideshow Images -->
    <div class="mySlides w3-display-container w3-center">
    
   
        <img src="<%=pic_list[0]%>" style="width: 100%; height:600px">
        <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h3>회원님이 올리신 사진</h3>
            <p><b>아이유~!</b></p>
        </div>
    </div>
    <div class="mySlides w3-display-container w3-center">
        <img src="<%=pic_list[1]%>" style="width: 100%; height:600px">
        <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h3>회원님이 올리신 사진</h3>
            <p><b>아이유~!</b></p>
        </div>
    </div>
    
   
</div>
<script>
// Automatic Slideshow - change image every 4 seconds
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);    
}

// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

// When the user clicks anywhere outside of the modal, close it
var modal = document.getElementById('ticketModal');
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
</body>
</html>