package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TagAddServlet")
public class TagAddServlet extends HttpServlet {
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 画面から入力したデータを取得する
		String tnStr = request.getParameter("tagName");

		int tn = Integer.parseInt(tnStr);

		RequestDispatcher disp = request.getRequestDispatcher("addTag");
		disp.forward(request, response);
	}
}