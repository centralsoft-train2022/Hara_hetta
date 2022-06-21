<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>タグ追加画面</title>
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
		div{
			padding-right:190px;
		}
		p2{
			color:#f89174
		}
		
		</style>
</head>
<body>


		<form action="TagAddServlet" method="post">
		<p1><b>追加するタグ名</b></p1><br>
		<input name="tag" type="text" ><br>
		
		<br>
		
		<div><p2><b>警告設定<br></b></p2>

   	 	<input type="radio" name="radiobutton" value="1"> 1週間<br>
   		 <input type="radio" name="radiobutton" value="2"> 2週間<br>
   		 <input type="radio" name="radiobutton" value="3"> 1ヵ月<br></div>
   		 
   		 <br>
   		 
   		 に<input name="cnt" type="text" size="2">回食べたら警告します🔔<br>
   		 <input type="submit" value="登録">
		</form>	
		
		<br>
		
		
			
		
		<br>
		
		<form  method="GET" action="MaindishServlet">
		<input type="submit" value="追加に戻る">
		</form>	
		

</body>
</html>