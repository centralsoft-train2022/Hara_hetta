package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishVo;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet
{
	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response	
	) throws ServletException, IOException
	{
		
		DishVo vo = new DishVo();
		vo.getDishDate();
		vo.getDishName();
		vo.getDishBikou();
		
		System.out.println(vo.getDishName());
		
		
		Map<String, String[]>foodName= new HashMap<String,String[]>();
		foodName.put("2022-6-16", new String[] {"ラーメン","寿司","カレー"});
		foodName.put("2022-6-17", new String[] {"塩ラーメン","サーモン","カツカレー"});
		foodName.put("2022-6-18", new String[] {"チロル","アルフォート","おにぎり"});
		request.setAttribute("foodName", foodName);
		
		RequestDispatcher disp = request.getRequestDispatcher( "calendar.jsp" );
		disp.forward( request, response );
	}
	
//	private void seclectCalender(Date bidate, String biname, String bibiko) {
//		DBUtil db = new DBUtil();
//		try (Connection con = db.getConnection()) {
//			
//			CalenderBean bean = new CalenderBean();
//			bean.setDishDate(bidate);
//			bean.setDishname(biname);
//			bean.setBikou(bibiko);
//			
//			CalenderDao dao = new CalenderDao(con);
//			
//			dao.selectCalender(bidate, biname, bibiko);
//			
//			
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
	}
