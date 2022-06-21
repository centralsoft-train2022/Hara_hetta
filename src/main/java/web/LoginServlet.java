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
import javax.servlet.http.HttpSession;

import bean.DishTagAllBean;
import bean.LoginBean;
import dao.DBUtil;
import dao.DishTagIdDao;
import dao.DishVo;
import dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	// ログイン認証のメインロジック
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
	        throws ServletException, IOException
	{
		// 文字コードの設定
		response.setContentType( "text/html; charset=UTF-8" );
		request.setCharacterEncoding( "UTF-8" );

		// 画面から入力したデータを取得する
		String	idStr	= request.getParameter( "ID" );
		String	pwStr	= request.getParameter( "PW" );

		try
		{

			int id = Integer.parseInt( idStr );

			// セッションに保存
			HttpSession session = request.getSession( );
			session.setAttribute( "UserID", id );
			session.setAttribute( "Pass", pwStr );

			DBUtil util = new DBUtil( );

			Connection con = util.getConnection( );

			UserDao		userDao		= new UserDao( con );
			LoginBean	loginBean	= userDao.findUser( id, pwStr );

			boolean isLogin = (loginBean != null & idStr.equals( loginBean.getUserID( ) ) &&
			        pwStr.equals( loginBean.getPassword( ) ));

			session.setAttribute( "isLogin", isLogin );

			request.setAttribute( "bean", loginBean );

			if( !isLogin )
			{
				DishTagAllBean bean = new DishTagAllBean( );
				bean.setTagList( getTag_TagId( ) );

				request.setAttribute( "bean", bean );
				
				RequestDispatcher disp = request.getRequestDispatcher( "top.jsp" );
				disp.forward( request, response );
			}
			else
			{

				RequestDispatcher disp = request.getRequestDispatcher( "login.jsp" );
				disp.forward( request, response );
			}
		}
		catch( NullPointerException e )
		{

			RequestDispatcher disp = request.getRequestDispatcher( "login.jsp" );
			disp.forward( request, response );
		}

		catch( NumberFormatException e )

		{
			RequestDispatcher disp = request.getRequestDispatcher( "login.jsp" );
			disp.forward( request, response );
		}

	}
	private List<DishVo> getTag_TagId()
	{

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{
			DishTagIdDao	tgAlldao		= new DishTagIdDao( c );
			List<DishVo>	tgDishAllList	= tgAlldao.getDishTagId( );

			return tgDishAllList;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}
	
}