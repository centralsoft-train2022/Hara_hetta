<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form  method="POST" action="LoginServlet">
		正しい情報を入力してください<br>
			ID： <input name="ID" type="text" ><br>
			PW： <input name="PW" type="text" > <br>
		
			<input type="submit" value="LOGIN">
		</form>		

</body>
</html>