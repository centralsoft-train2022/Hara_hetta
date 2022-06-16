package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TagAddBean;
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

		// セッションに保存
		HttpSession session = request.getSession();
		session.setAttribute("TagName", tnStr);
		//		String kikan = request.getParameter("radiobutton");
		//		String cnt = request.getParameter("cnt");

		insertTag(tnStr);

		//int tn = Integer.parseInt(tnStr);

		RequestDispatcher disp = request.getRequestDispatcher("registeredTag.jsp");
		disp.forward(request, response);
	}

	private void insertTag(String tnStr) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();

		TagAddDao tad = new TagAddDao(con);

		TagAddBean bean = new TagAddBean();
		bean.setTagName(tnStr);

		//TagAddBean tabean = tad.insert(tnStr);
		tad.insert(bean.getTagName());
	}
}
