<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.TagAddBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タグ追加登録完了画面</title>
</head>
<body>
		
		追加完了しました✓<br><br>
		
		追加したタグ名：<%=bean.getTagName(  ) %><br><br>
		警告設定：<%=bean.getWarningSttingName(  ) %>の間<br>
	  	　　　　　<%=bean.getWarningCount(  ) %>回食べた場合<br><br>
	  	
	  	警告します
		
	
		<form  method="GET" action="MaindishServlet">
		<input type="submit" value="入力に戻る">
		</form>	
		
		<form  method="POST" action="addTag.jsp">
		<input type="submit" value="タグ登録に戻る">
		</form>	
		

</body>
</html>