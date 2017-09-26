<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 작성 화면</title>
<link rel="stylesheet" href="login_css.css" media="screen">
	<style>
		table,input[type="text"]{
			width:auto;
			heigth:400px;
		}
	</style>
</head>
<body>
	<div align="center">
    <h2>주소록 작성화면</h2>
    <hr>
    [<a href=addrbook_list.jsp>주소록 목록으로</a>]<br>
    <p>
    <form name="form1" method="post" action="addrbook_control.jsp">
        <input type="hidden" name="action" value="insert">
        <table border="1" class="type03">
            <tr>
                <th>아이디</th>
                <td><input type="text" name="ab_id" maxlength="15"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="ab_password" maxlength="15"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="ab_name" maxlength="15"></td>
            </tr>
            <tr>
                <th>email</th>
                <td><input type="text" name="ab_email" maxlength="20"></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="text" name="ab_tel" maxlength="20"></td>
            </tr>
            <tr>
                <th>생일</th>
                <td><input type="text" name="ab_birth"></td>
            </tr>
            <tr>
                <th>회사</th>
                <td><input type="text" name="ab_comdept" maxlength="20"></td>
            </tr>
            <tr>
                <th>메모</th>
                <td><input type="text" name="ab_memo"></td>
            </tr>
            <tr>
                <th>프로필 사진 </th>
                <td><input type="file" name="ab_picture"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="저장">
                    <input type="reset" value="취소"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>