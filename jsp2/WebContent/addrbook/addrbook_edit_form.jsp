<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jspbook.addrbook.*"%>
<jsp:useBean id="ab" scope="request" class="jspbook.addrbook.AddrBook" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function goback() {
		history.go(-1);
	}

	function delcheck() {
		var result = confirm("정말 삭제하시겠습니까?");

		if (result) {
			document.form1.action.value = "delete";
			document.form1.submit();
		} else
			return;
	}
</script>
</head>
<body>
	<form name="form1" method="post" action="addrbook_control.jsp">
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="ab_name"
					value="<%=ab.getAb_name()%>"></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="text" name="ab_email"
					value="<%=ab.getAb_email()%>"></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="text" name="ab_tel"
					value="<%=ab.getAb_birth()%>"></td>
			</tr>
			<tr>
				<th>학교</th>
				<td><input type="text" name="ab_comdept"
					value="<%=ab.getAb_comdept()%>"></td>
			</tr>
			<tr>
				<th>메모</th>
				<td><input type="text" name="ab_memo"
					value="<%=ab.getAb_memo()%>"></td>
			</tr>
			<tr>
				<th>프로필 사진 업로드</th>
				<td><input type="file" name="ab_picture" placeholder="자신만의 사진을 올려보세요!"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="저장">
				<input type="reset" value="취소" onclick="goback()">
				 <input	type="button" value="삭제" onclick="delcheck()"></td>
			</tr>
		</table>
		<input type="hidden" name="ab_id" value="<%=ab.getAb_id()%>">
		<input type="hidden" name="action" value="update">
	</form>
</body>
</html>