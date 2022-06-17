package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtil;
import dao.DishsaveDao;

@WebServlet("/registeredMainServlet")

public class registeredMainServlet extends HttpServlet
{
	List<Integer>	morningList	= new ArrayList<Integer>( );
	List<Integer>	noonList	= new ArrayList<Integer>( );
	List<Integer>	nightList	= new ArrayList<Integer>( );

	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		// 画面から入力したデータを取得する
		// String dishDateStr = request.getParameter( "dishdate" );
		request.setCharacterEncoding( "UTF-8" );
		String	morningdishName	= request.getParameter( "morningdishname" );
		String	noondishName	= request.getParameter( "noondishname" );
		String	nightdishName	= request.getParameter( "nightdishname" );

		String bikou = request.getParameter( "bikou" );
		// カンマごとに食べ物をリストにいれる
//		String[]	morningList	= morningdishName.split( "," );
//		String[]	noonList	= noondishName.split( "," );
//		String[]	nightList	= nightdishName.split( "," );
		// タグ
		String	morning1	= request.getParameter( "morning1" );
		String	morning2	= request.getParameter( "morning2" );
		String	morning3	= request.getParameter( "morning3" );

		String	noon1	= request.getParameter( "noon1" );
		String	noon2	= request.getParameter( "noon2" );
		String	noon3	= request.getParameter( "noon3" );

		String	night1	= request.getParameter( "night1" );
		String	night2	= request.getParameter( "night2" );
		String	night3	= request.getParameter( "night3" );

		int	morning1Int	= Integer.parseInt( morning1 );
		int	morning2Int	= Integer.parseInt( morning2 );
		int	morning3Int	= Integer.parseInt( morning3 );

		int	noon1Int	= Integer.parseInt( noon1 );
		int	noon2Int	= Integer.parseInt( noon2 );
		int	noon3Int	= Integer.parseInt( noon3 );

		int	night1Int	= Integer.parseInt( night1 );
		int	night2Int	= Integer.parseInt( night2 );
		int	night3Int	= Integer.parseInt( night3 );

		if( morning1Int != 0 )
		{
			morningList.add( morning1Int );
		}

		if( morning2Int != 0 )
		{
			morningList.add( morning2Int );
		}

		if( morning3Int != 0 )
		{
			morningList.add( morning3Int );
		}

		if( noon1Int != 0 )
		{
			noonList.add( noon1Int );
		}

		if( noon2Int != 0 )
		{
			noonList.add( noon2Int );
		}

		if( noon3Int != 0 )
		{
			noonList.add( noon3Int );
		}

		if( night1Int != 0 )
		{
			nightList.add( night1Int );
		}

		if( night2Int != 0 )
		{
			nightList.add( night2Int );
		}

		if( night3Int != 0 )
		{
			nightList.add( night3Int );
		}

		savetag( morningdishName, noondishName, nightdishName, bikou );

		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher( "/registeredMain.jsp" );
		disp.forward( request, response );
	}

	// 入力した食べ物をDBに保存
	private void savetag( String morningdishName, String noondishName, String nightdishName, String bikou )
	{

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{

			DishsaveDao dishdao = new DishsaveDao( c );

			if( !morningdishName.equals( "" ) )
			{

				for( int i = 0; i < morningList.size( ); i++ )
				{
					int asa = 1;
					dishdao.DishInsert( morningdishName, morningList.get( i ), asa, bikou );
				}

			}

			if( !noondishName.equals( "" ) )
			{

				for( int i = 0; i < noonList.size( ); i++ )
				{
					int hiru = 2;
					dishdao.DishInsert( noondishName, noonList.get( i ), hiru, bikou );
				}
			}

			if( !nightdishName.equals( "" ) )
			{

				for( int i = 0; i < nightList.size( ); i++ )
				{
					int yoru = 3;
					dishdao.DishInsert( nightdishName, nightList.get( i ), yoru, bikou );
				}
			}
			c.commit( );
		}
		catch( SQLException e )
		{
			e.printStackTrace( );
		}

	}

}
