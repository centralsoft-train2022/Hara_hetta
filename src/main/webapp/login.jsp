<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
		<div class ="content">
		<font color="red" size = "5">
		
		<b>正しい情報を入力してください。</b>
		</font><br>
		
		<form  method="POST" action="LoginServlet">
			<font color="white" size="4">
			
			<b> ID  ： <input name="ID" type="text" ><br>
			    PW： <input name="PW" type="text" > </b><br>
			
			</font>
			
			<input type="submit" value="LOGIN">
		</form>		
		</div>
		

</body>
</html>