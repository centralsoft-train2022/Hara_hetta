package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DishTagAllBean;
import dao.DBUtil;
import dao.DishTagIdDao;
import dao.DishVo;

@WebServlet("/cKaraHomeServlet")
public class cKaraHomeServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	// ログイン認証のメインロジック
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sort = "1";
		String time = "1";
		DishTagAllBean bean = new DishTagAllBean();
		bean.setTagList(getTag_TagId(sort, time));
		bean.setSort(sort);
		bean.setTime(time);

		request.setAttribute("bean", bean);

		RequestDispatcher disp = request.getRequestDispatcher("top.jsp");
		disp.forward(request, response);

	}

	private List<DishVo> getTag_TagId(String sort, String time) {

		DBUtil db = new DBUtil();

		try (Connection c = db.getConnection()) {
			DishTagIdDao tgAlldao = new DishTagIdDao(c);
			List<DishVo> tgDishAllList = tgAlldao.getDishTagId(sort, time);

			return tgDishAllList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}