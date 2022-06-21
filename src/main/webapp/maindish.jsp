<%@page import="dao.TagVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="bean" class="bean.MaindishBean" scope="request" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>追加・変更画面</title>

<style>
		body{
			color:gray;
			text-align: center;
			background-color: #fffbf4; 
			margin-top:100px;
			font-size:30px;
			
			
		}
		p1{
			font-size:40px;
		}
		
		
		table{
			margin-left:auto;
			margin-right:250px;
		}
		
</style>

</head>
<body>
	<p1><b>主食を入力してください。</b></p1><br>

	<form method="POST" action="RegisteredMainServlet">
	
	<table>
		<tr>
			<td>
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
	</td>
		 	<td>&nbsp;</td>
		 		
		<td> <img src="シュー.png" width="400"></td>
		
		</tr>
		</table>
	<p>
		備考：<input type="text" name="bikou">
	</p>


	

	
	<div style="display:inline-flex">

		<input type="submit" value="追加" style="width:150px;height:60px;background-color:#FFFFBB">
	</form>
	
	 <form method="POST" action="addTag.jsp">
		 <input type="submit"value="タグ追加" style="width:150px;height:60px;background-color:#FFFFBB">
	</form>
	
	 <form method="POST" action="calendar.jsp">
		 <input type="submit"value="戻る" style="width:150px;height:60px;background-color:#FFFFBB">
	</form>
	</div>





</body>
</html>