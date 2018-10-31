<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo</title>
</head>
<body>

   <h1>Customer Information</h1>

	<form action="/demo/login">
		<table>
		<tr>
		    <td>First name</td>
		    <td><input type="text" id="firstname" name="firstname"></td>
		</tr>
		<tr>
            <td>Last name</td>
            <td><input type="text" id="lastname" name="lastname"></td>
        </tr>
		 <tr>
		    <td></td>
		    <td>
		    <input type="submit" id="next" value="Next">
		    </td>
		</tr>
		</table>
	</form>

</body>
</html>
