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
		String stKikanStr = request.getParameter("radiobutton");
		String stCountStr = request.getParameter("cnt");

		int stKikan = Integer.parseInt(stKikanStr);
		int stCount = Integer.parseInt(stCountStr);

		// セッションに保存
		HttpSession session = request.getSession();
		session.setAttribute("TagName", tnStr);
		session.setAttribute("WarningSetting", stKikan);
		session.setAttribute("WarningCount", stCount);

		int wstKikan = (Integer) session.getAttribute("WarningSetting");
		int wstCount = (Integer) session.getAttribute("WarningCount");

		int uid = (Integer) session.getAttribute("UserID");
		System.out.println(uid);

		insertTag(tnStr, uid, wstKikan, wstCount);

		//int tn = Integer.parseInt(tnStr);

		RequestDispatcher disp = request.getRequestDispatcher("registeredTag.jsp");
		disp.forward(request, response);
	}

	private void insertTag(String tnStr, int uid, int stKikan, int stCount) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();

		TagAddDao tad = new TagAddDao(con);
		//UserDao ud = new UserDao(con);

		TagAddBean bean = new TagAddBean();
		bean.setTagName(tnStr);
		bean.setWarningSetting(stKikan);
		bean.setWarningCount(stCount);

		//TagAddBean tabean = tad.insert(tnStr);
		tad.insertTagName(bean.getTagName());
		int tgidget = tad.getTagID();
		tad.insertTagSetting(bean.getWarningSetting(), bean.getWarningCount(), uid, tgidget);
	}
}
