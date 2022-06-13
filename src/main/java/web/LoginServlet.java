package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		// 画面から入力したデータを取得する
		String idStr = request.getParameter( "ID" );
//		String	peStr	= request.getParameter( "PW" );

		int id = Integer.parseInt( idStr );

		RequestDispatcher disp = request.getRequestDispatcher( "top.jsp" );
		disp.forward( request, response );
	}
}