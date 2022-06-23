package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CalenderBean;
import dao.DBUtil;
import dao.DishVo;
import dao.DishsaveDao;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DishVo> list = sql();

		CalenderBean bean = new CalenderBean();
		List<DishVo> dishList = sql();

		bean.setDishList(dishList);

		for (dao.DishVo vo : bean.getDishList()) {
			bean.setDishName(vo.getDishName());
			bean.setDishDate(vo.getDishDate());

		}

		Map<String, List> foodMap = new HashMap<String, List>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d");
		for (DishVo dishVo : dishList) {
			String str = formatter.format(dishVo.getDishDate());
			List<String> foodNameList = foodMap.get(str);
			if (foodNameList == null) {
				foodNameList = new ArrayList<String>();
			}
			foodNameList.add(dishVo.getDishName());
			foodMap.put(str, foodNameList);

		}

		Map<String, String[]> foodName = new HashMap<String, String[]>();

		for (String key : foodMap.keySet()) {
			List<String> foodValues = foodMap.get(key);
			foodName.put(key, foodValues.toArray(new String[foodValues.size()]));
		}

		request.setAttribute("foodName", foodName);

		RequestDispatcher disp = request.getRequestDispatcher("calendar.jsp");
		disp.forward(request, response);
	}

	private static List<DishVo> sql() {
		List<DishVo> dishList = new ArrayList<DishVo>();

		DBUtil util = new DBUtil();

		try (Connection con = util.getConnection();) {

			DishsaveDao dao = new DishsaveDao(con);

			dishList = dao.getDish();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return dishList;
	}

}
