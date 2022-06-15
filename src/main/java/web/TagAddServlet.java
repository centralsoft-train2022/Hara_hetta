package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtil;
import dao.TagAddDao;

@WebServlet("/TagAddServlet")
public class TagAddServlet extends HttpServlet {
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 画面から入力したデータを取得する
		request.setCharacterEncoding("UTF-8");
		String tnStr = request.getParameter("tag");
		String kikan = request.getParameter("radiobutton");
		String cnt = request.getParameter("cnt");

		insertTag(tnStr);

		//int tn = Integer.parseInt(tnStr);

		RequestDispatcher disp = request.getRequestDispatcher("registeredTag.jsp");
		disp.forward(request, response);
	}

	private void insertTag(String tnStr) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		TagAddDao tad = new TagAddDao(con);
		tad.insert(tnStr);
	}
}
