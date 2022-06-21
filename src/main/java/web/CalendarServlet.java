package web;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CalenderBean;
import dao.DBUtil;
import dao.DishsaveDao;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	protected void doPost( HttpServletRequest request,HttpServletResponse response	) 
		throws ServletException, IOException{
		
		
		DBUtil util = new DBUtil();

		Connection con = util.getConnection();

		DishsaveDao savedao = new DishsaveDao(con);
		CalenderBean caBean = savedao.getDish(getServletName(), getServletInfo(), 0);
		request.setAttribute("bean", caBean);
		
		CalenderBean bean = new CalenderBean();
		bean.getDishName();

				System.out.println(bean.getBikou());
				System.out.println(bean.getDishName());

		Map<String, String[]> foodName = new HashMap<String, String[]>();
		foodName.put("2022-6-16", new String[] { "ラーメン", "寿司", "カレー" });
		foodName.put("2022-6-17", new String[] { "塩ラーメン", "サーモン", "カツカレー" });
		foodName.put("2022-6-18", new String[] { "チロル", "アルフォート", "おにぎり" });
		request.setAttribute("foodName", foodName);

		RequestDispatcher disp = request.getRequestDispatcher("calendar.jsp");
		disp.forward(request, response);
		}

}

