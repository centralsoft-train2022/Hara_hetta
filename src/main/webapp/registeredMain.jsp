<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.RegisteredMainBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食べ物追加完了画面</title>

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
		
		table{
			margin-left:auto;
			margin-right:250px;
		}
		
		</style>
</head>
<body>
		
		
		<p1><b>追加完了しました✓</b></p1><br><br>
		
	<table>
		<tr>
			<td>
			
		<div>
		朝：<%=bean.getMorningDishName1(  ) %><br>
		  　　<%=bean.getMorningDishName2(  ) %><br>
		  　　<%=bean.getMorningDishName3(  ) %><br>
		
		昼：<%=bean.getNoonDishName1(  ) %><br>
		  　　<%=bean.getNoonDishName2(  ) %><br>
		  　　<%=bean.getNoonDishName3(  ) %><br>
		
		夜：<%=bean.getNightDishName1(  ) %><br>
		  　　<%=bean.getNightDishName2(  ) %><br>
		  　　<%=bean.getNightDishName3(  ) %><br><br>
		</td>
		 	<td>&nbsp;</td>
		 		
		<td> <img src="くり.png" width="400"></td>
		
		</tr>
		</table>
		
		
		備考:<%=bean.getBikou(  ) %><br><br>
		</div>
		 	
		
		<form  method="POST" action="CalendarServlet">
		<input type="submit" value="カレンダーに戻る" style="width:200px;height:70px;background-color:#FFFFBB">
		</form>	

</body>
</html>