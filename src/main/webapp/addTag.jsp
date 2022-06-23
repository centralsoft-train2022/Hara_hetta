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
			padding-right:10px;
		}
		p2{
			color:#f89174
		}
		table{
			margin-left:auto;
			margin-right:auto;
		}
		.tuika{
			width:150px;
			height:60px;
			background-color:#FFFFBB;
		}
		.touroku{
			width:150px;
			height:60px;
			background-color:#FFFFBB;
		}
		
		</style>
</head>
<body>


		<form action="TagAddServlet" method="post">
		<p1><b>追加するタグ名</b></p1><br>
		<input name="tag" type="text" ><br>
		
		<br>
	<table>
	   <tr>
	   		<td>
			   <div><p2><b>警告設定<br></b></p2>
		   	 	 <input type="radio" name="radiobutton" value="1"> 1週間<br>
		   		 <input type="radio" name="radiobutton" value="2"> 2週間<br>
		   		 <input type="radio" name="radiobutton" value="3"> 1ヵ月<br></div>
	   	   	</td>
   	   		<td>&nbsp;</td>
   	   		<td><img src="ちいかわ料理長.png" width="200"></td>
   	   		
   	   </tr>
   	</table>
   		 <br>
   		 
   		 に<input name="cnt" type="text" size="2">回食べたら警告します🔔<br><br>
   		 
   		 <div style="display:inline-flex">
	   		 <input type="submit" value="登録" class="touroku">
			</form>	
			
			<br>
			
			
			<form  method="GET" action="MaindishServlet">
			<input type="submit" value="追加に戻る" class="tuika">
			</form>	
		 </div>
			

</body>
</html>