<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo</title>
</head>
<body>

   <h1>Login at CI/CD Workshop 2022/10/28</h1>

	<form action="${pageContext.request.contextPath}/login">
		<table>
		<tr>
		    <td>Username</td>
		    <td><input type="text" id="user" name="user"></td>
		</tr>
		<tr>
            <td>Password</td>
            <td><input type="password" id="pin" name="pin"></td>
        </tr>
		 <tr>
		    <td></td>
		    <td>
		    <input type="submit" id="login" value="Sign in">
		    </td>
		</tr>
		</table>
	</form>

</body>
</html>
