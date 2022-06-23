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
<!--link rel="stylesheet" href="css/top.css"-->
</head>
<body>
		<div class ="content">
		<font color="white" size="5"><b>
		
		おはようございます。
		</b></font>
		<br>
		<br>
	
		<form  method="POST" action="CalendarServlet">
		<input type="submit" value="カレンダー表示"  style="width:150px;height:50px;background-color:#FFFFBB" >
		</form>	
		</div>
		
		
		<script type="text/javascript"
 src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js">
</script>
		<canvas id="chart_cv"></canvas>

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