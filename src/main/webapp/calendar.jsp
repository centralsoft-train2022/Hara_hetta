<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="dao.WarningVo"%>
    <jsp:useBean id="bean" class="bean.WarningBean" scope="request" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カレンダー表示</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
<% com.fasterxml.jackson.databind.ObjectMapper a= new com.fasterxml.jackson.databind.ObjectMapper();%>
var foodName= <%= a.writeValueAsString(request.getAttribute("foodName")) %>;
</script>
<style>
		body{
			color:gray;
			background-color: #fffbf4; 
			}
		table{
			margin-left:auto;
			margin-right:320px;
		}	
		
</style>
</head>
<body>
<body>
	<h1 class="cauntion" >警告メッセージ</h1>	
	<div class ="content">
	<% for( dao.WarningVo warning:  bean.getWarningList(  )){ %>
		<font color="black" size="5"><b>
		[警告]
		'<%=warning.getTagName()%>'を'<%=warning.getWarningCount()%>'回以上食べてます
		</b></font>
	</div>
	<%} %>
	
	
	<div class="container-calendar">
		<h4 id="monthAndYear"></h4>
		<div class="button-container-calendar">
			<button id="previous" onclick="previous()">‹</button>
			<button id="next" onclick="next()">›</button>
		</div>

		<table class="table-calendar" id="calendar" data-lang="ja">
			<thead id="thead-month"></thead>
			<tbody id="calendar-body"></tbody>
		</table>

		<div class="footer-container-calendar">
			<label for="month">日付指定：</label> <select id="month" onchange="jump()">
				<option value=0>1月</option>
				<option value=1>2月</option>
				<option value=2>3月</option>
				<option value=3>4月</option>
				<option value=4>5月</option>
				<option value=5>6月</option>
				<option value=6>7月</option>
				<option value=7>8月</option>
				<option value=8>9月</option>
				<option value=9>10月</option>
				<option value=10>11月</option>
				<option value=11>12月</option>
			</select> <select id="year" onchange="jump()"></select>
		</div>
	</div>
	<script src="js/calendar.js" type="text/javascript"></script>

	
	<table>
	   <tr>
	   		<td>
	<div style="display:inline-flex">
	<form method="GET" action="MaindishServlet">
		<input type="submit" value="追加" style="width:130px;height:50px;background-color:#FFFFBB">
	</form>

	<br>

	<form method="POST" action="top.jsp">
		<input type="submit" value="ホームに戻る" style="width:130px;height:50px;background-color:#FFFFBB">
	</form>
	</div>
	</td>
   	   		<td>&nbsp;</td>
   	   		<td><img src="ホットケーキ.png" width="280"></td>
   	   		
   	   </tr>
   	</table>


</body>
</html>