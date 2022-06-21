<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.RegisteredMainBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食べ物追加完了画面</title>
</head>
<body>
		追加完了しました
		
		朝：<%=bean.getMorningDishName1(  ) %><br><br>
		<%=bean.getMorningDishName2(  ) %><br><br>
		<%=bean.getMorningDishName3(  ) %><br><br>
		
		昼：<%=bean.getNoonDishName1(  ) %><br><br>
		<%=bean.getNoonDishName2(  ) %><br><br>
		<%=bean.getNoonDishName3(  ) %><br><br>
		
		夜：<%=bean.getNightDishName1(  ) %><br><br>
		<%=bean.getNightDishName2(  ) %><br><br>
		<%=bean.getNightDishName3(  ) %><br><br>
		
		
		備考<%=bean.getBikou(  ) %><br><br>
		
		
		
		
		<form  method="POST" action="CalendarServlet">
		<input type="submit" value="カレンダーに戻る">
		</form>	

</body>
</html>