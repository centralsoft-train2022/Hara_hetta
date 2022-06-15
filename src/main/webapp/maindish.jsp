<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>追加・変更画面</title>
</head>
<body>
	主食を入力してください

	<p>
		朝：<input type="text" name="morning">
	</p>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<p>
		昼：<input type="text" name="noon">
	</p>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>

	<p>
		夜：<input type="text" name="night">
	</p>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<select name="example">
		<option value="サンプル1">サンプル1</option>
		<option value="サンプル2">サンプル2</option>
		<option value="サンプル3">サンプル3</option>
	</select>
	<br>
	<br>
	<p>
		備考：<input type="text" name="bikou">
	</p>


	

	
	<div style="display:inline-flex">
	<form method="POST" action="MaindishServlet">
		<input type="submit" value="追加">
	</form>
	
	 <form method="POST" action="addTag.jsp">
		 <input type="submit"value="タグ追加">
	</form>
	</div>





</body>
</html>