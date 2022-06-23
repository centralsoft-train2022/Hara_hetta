<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="dao.DishVo"%>
    <jsp:useBean id="bean" class="bean.DishTagAllBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>

<style>
		body{
			color:gray;
			text-align: center;
			background-color: #fffbf4; 
			margin-top:100px;
			font-size:35px;
		}
		table{
			margin-left:auto;
			margin-right:250px;
		}
		.sort{
			position: absolute; 
			left: 18%; 
			top: 35%;
			
		}
		.time{
			position: absolute; 
			left: 22%; 
			top: 35%;
			
		}
		
		
</style>
</head>
<body>
		
		
		<table>
	   <tr>
	   		<td>
		<b>おなかすいた…ってコト⁉</b>
	
		<br>
	
		<form  method="POST" action="CalendarServlet">
		<input type="submit" value="カレンダー表示"  style="width:150px;height:50px;background-color:#FFFFBB" >
		</form>	
			</td>
   	   		<td>&nbsp;</td>
   	   		<td><img src="はらへり.png" width="295"></td>
   	   		
   	   </tr>
   	</table>
   	
   	<form method="POST" action="login.html">
	<select name="sort" class="sort">
			<option value="1">昇順</option>
			<option value="2">降順</option>	
	</select>
	
	<select name="time" class="time">
			<option value="3">朝</option>
			<option value="4">昼</option>
			<option value="5">夜</option>
	</select>	
			<input type="submit" value="表示" style="position: absolute; left: 26%; top: 35%; background-color:#FFCCCC"/>
	</form>	
		<script type="text/javascript"
 src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js">
</script>
		<div style="position:relative;top:100px;left:250px;width:1000px;height:500px;">
		<canvas id="chart_cv"></canvas>
		</div>
		

<script type="text/javascript">
  // データ --- (*1)
   
  const data = {
	
		  
    labels: [ 
    	<% for( dao.DishVo dishTag:  bean.getTagList(  )){ %>
    	    
    	'<%=dishTag.getTagName()%>',
    	
    	<%}%>
    	],
    datasets: [{
      label: 'グラフ',
      
      data: [ 
    	  <% for( dao.DishVo dishTag:  bean.getTagList(  )){ %>
    	  
    	  <%=dishTag.getTagCount()%>,
    	  
    	  <%}%>
    	  ]
    
    
    }]}
  // グラフを描画 --- (*2)
  const ctx = document.getElementById('chart_cv')
  const chart_cv = new Chart(ctx, {
    type: 'bar', // グラフの種類
    data: data, // データ
    	
    	options: {
    	    scales: {
    	        yAxes: [           // Ｙ軸 
    	            {
    	                ticks: {     // 目盛り        
    	                    min: 0,      // 最小値
    	                      // beginAtZero: true でも同じ
    	                    max: 25,     // 最大値
    	                    stepSize: 5  // 間隔
    	                }
    	            }
    	        ]
            }}})

  
</script>

</body>
</html>