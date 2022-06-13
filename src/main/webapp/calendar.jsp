<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カレンダー表示</title>
 <link rel="stylesheet" href="css/style.css">
</head>
<body>
<body>
	<div class="calendar-container">
		<h1>October 2020</h1>
		<table class="calendar">
			<tr>
				<th>SUN</th>
				<th>MON</th>
				<th>TUE</th>
				<th>WED</th>
				<th>THU</th>
				<th>FRI</th>
				<th>SAT</th>
			</tr>
			<tr class="day">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
			</tr>
			<tr class="day">
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>8</td>
				<td>9</td>
				<td>10</td>
			</tr>
			<tr class="day">
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>14</td>
				<td>15</td>
				<td>16</td>
				<td>17</td>
			</tr>
			<tr class="day">
				<td>18</td>
				<td>19</td>
				<td>20</td>
				<td>21</td>
				<td>22</td>
				<td>23</td>
				<td>24</td>
			</tr>
			<tr class="day">
				<td>25</td>
				<td>26</td>
				<td>27</td>
				<td>28</td>
				<td>29</td>
				<td>30</td>
				<td>31</td>
			</tr>
		</table>
	</div>
	<form method="POST" action="maindish.jsp">
		<input type="submit" value="追加">
	</form>

	<br>

	<form method="POST" action="top.jsp">
		<input type="submit" value="ホームに戻る">
	</form>


</body>
</html>