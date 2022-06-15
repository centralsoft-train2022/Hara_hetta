<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タグ追加画面</title>
</head>
<body>
		<form action="TagAddServlet" method="post">
		追加するタグ名<br>
		<input name="tag" type="text" ><br>
		
		<br>
		
		警告設定<br>

   	 	<input type="radio" name="radiobutton" value="1week"> 1週間<br>
   		 <input type="radio" name="radiobutton" value="2week"> 2週間<br>
   		 <input type="radio" name="radiobutton" value="1mouth"> 1ヵ月<br>
   		 
   		 <br>
   		 
   		 に<input name="cnt" type="text" size="2">回食べたら警告します🔔<br>
   		 <input type="submit" value="登録">
		</form>	
		
		<br>
		
		
			
		
		<br>
		
		<form  method="POST" action="maindish.jsp">
		<input type="submit" value="追加に戻る">
		</form>	
		

</body>
</html>