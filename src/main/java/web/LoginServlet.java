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

import bean.LoginBean;
import dao.DBUtil;
import dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		// 画面から入力したデータを取得する
		String	idStr	= request.getParameter( "ID" );
		String	pwStr	= request.getParameter( "PW" );

		int id = Integer.parseInt( idStr );

		// セッションに保存
		HttpSession session = request.getSession( );
		session.setAttribute( "UserID", id );
		session.setAttribute( "Pass", pwStr );

		DBUtil util = new DBUtil( );

		Connection con = util.getConnection( );

		UserDao		userDao		= new UserDao( con );
		LoginBean	loginBean	= userDao.getAccount( id, pwStr );

		request.setAttribute( "bean", loginBean );

		if( loginBean == null )
		{
			RequestDispatcher disp = request.getRequestDispatcher( "login.jsp" );
			disp.forward( request, response );

		}
		else
		{

			RequestDispatcher disp = request.getRequestDispatcher( "top.jsp" );
			disp.forward( request, response );

		}

	}

}