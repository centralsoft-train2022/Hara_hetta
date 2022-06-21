<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.TagAddBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>タグ追加登録完了画面</title>
</head>
		<style>
		body{
			color:gray;
			text-align: center;
			background-color: #fffbf4; 
			margin-top:50px;
			font-size:30px;
		}
		p1{
			color:#f89174;
			font-size:35px;
		}
		p3{
			font-size:35px;
		}
		
		</style>
<body>
		
		<p1><b>追加完了しました✓</b></p1><br><br>
		
		＜追加したタグ名＞<br><p3><%=bean.getTagName(  ) %></p3><br><br>
		＜警告設定＞<br><p3><%=bean.getWarningSetingName(  ) %>の間</p3><br>
	  	<p3><%=bean.getWarningCount(  ) %>回食べた場合</p3><br><br>
	  	
	  	警告します
		
	
		<form  method="GET" action="MaindishServlet">
		<input type="submit" value="入力に戻る" class="nyuryoku">
		</form>	
		
		<form  method="POST" action="addTag.jsp">
		<input type="submit" value="タグ登録に戻る" class="modoru"><br>
		<img src="ちいかわいや.png" width="200">
		</form>	
		
		

</body>
</html>