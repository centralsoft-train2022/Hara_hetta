package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
public class TagAddServlet extends HttpServlet
{
	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		// 画面から入力したデータを取得する
		request.setCharacterEncoding( "UTF-8" );
		String	tnStr		= request.getParameter( "tag" );
		String	stKikanStr	= request.getParameter( "radiobutton" );
		String	stCountStr	= request.getParameter( "cnt" );

		if( tnStr.equals( "" ) || stKikanStr.equals( "" ) || stCountStr.equals( "" ) )
		{
			RequestDispatcher disp = request.getRequestDispatcher( "addTag.jsp" );
			disp.forward( request, response );

		}
		else
		{
			int	stKikan	= Integer.parseInt( stKikanStr );
			int	stCount	= Integer.parseInt( stCountStr );

			// セッションに保存
			HttpSession session = request.getSession( );
			session.setAttribute( "TagName", tnStr );
			session.setAttribute( "WarningSetting", stKikan );
			session.setAttribute( "WarningCount", stCount );

			// セッションのObject型からint型への変換
			int	wstKikan	= (Integer) session.getAttribute( "WarningSetting" );
			int	wstCount	= (Integer) session.getAttribute( "WarningCount" );

			// LoginServletのセッションからuserIDを取得
			int uid = (Integer) session.getAttribute( "UserID" );
			System.out.println( uid );

			insertTag( tnStr, uid, wstKikan, wstCount );

			TagAddBean bean = new TagAddBean( );
			bean.setTagName( tnStr );
			bean.setWarningSetting( stKikan );
			bean.setWarningCount( wstCount );
			bean.setWarningSetingName( stCountStr );

			request.setAttribute( "bean", bean );

			// 次の画面に遷移
			RequestDispatcher disp = request.getRequestDispatcher( "registeredTag.jsp" );
			disp.forward( request, response );
		}
	}

	// Cnnection取得
	private void insertTag( String tnStr, int uid, int stKikan, int stCount )
	{
		DBUtil db = new DBUtil( );

		try( Connection con = db.getConnection( ) )
		{

			TagAddDao tad = new TagAddDao( con );

			// Beanに保存
			TagAddBean bean = new TagAddBean( );
			bean.setTagName( tnStr );
			bean.setWarningSetting( stKikan );
			bean.setWarningCount( stCount );

			// 3種類のSQL実行しているメソッドのそれぞれを呼び出し
			tad.insertTagName( bean.getTagName( ) );
			int tgidget = tad.getTagID( );
			tad.insertTagSetting( bean.getWarningSetting( ), bean.getWarningCount( ), uid, tgidget );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
	}
}
