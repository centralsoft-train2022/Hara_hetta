<%@page import="dao.TagVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="bean" class="bean.MaindishBean" scope="request" />
	
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
	<select name="morning1">
	<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
<select name="morning2">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="morning3">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<p>
		昼：<input type="text" name="noon">
	</p>
	<select name="noon1">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="noon2">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="noon3">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>

	<p>
		夜：<input type="text" name="night">
	</p>
	<select name="night1">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
<select name="night2">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="night3">
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<br>
	<br>
	<p>
		備考：<input type="text" name="bikou">
	</p>


	

	
	<div style="display:inline-flex">
	<form method="POST" action="registeredMainServlet">
		<input type="submit" value="追加">
	</form>
	
	 <form method="POST" action="addTag.jsp">
		 <input type="submit"value="タグ追加">
	</form>
	</div>





</body>
</html>