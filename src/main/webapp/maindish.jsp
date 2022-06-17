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

	<form method="POST" action="RegisteredMainServlet">
	<p>
		朝：<input type="text" name="morningdishname">
	</p>
	<select name="morning1">
	<option value="0"></option>
	<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
<select name="morning2">
<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="morning3">
	<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<p>
		昼：<input type="text" name="noondishname">
	</p>
	<select name="noon1">
			<option value="0"></option>
	
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="noon2">
	<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="noon3">
	<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>

	<p>
		夜：<input type="text" name="nightdishname">
	</p>
	<select name="night1">
	<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
<select name="night2">
<option value="0"></option>
		<% for( dao.TagVo tag:  bean.getTagList(  )){ %>
		<option value="<%=tag.getTagID()%>"><%=tag.getTagName()%></option>
		
	<% }%>
	</select>
	<select name="night3">
	<option value="0"></option>
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
</div>
		<input type="submit" value="追加">
	</form>
	
	 <form method="POST" action="addTag.jsp">
		 <input type="submit"value="タグ追加">
	</form>
	





</body>
</html>