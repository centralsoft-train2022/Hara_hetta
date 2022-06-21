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

import bean.RegisteredMainBean;
import dao.DBUtil;
import dao.DishsaveDao;

@WebServlet("/RegisteredMainServlet")

public class RegisteredMainServlet extends HttpServlet
{
//	List<Integer>	morningList	= new ArrayList<Integer>( );
//	List<Integer>	noonList	= new ArrayList<Integer>( );
//	List<Integer>	nightList	= new ArrayList<Integer>( );

	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{
		List<Integer>	morningList	= new ArrayList<Integer>( );
		List<Integer>	noonList	= new ArrayList<Integer>( );
		List<Integer>	nightList	= new ArrayList<Integer>( );

		// 画面から入力したデータを取得する
		// String dishDateStr = request.getParameter( "dishdate" );
		request.setCharacterEncoding( "UTF-8" );
		String morningdishName = request.getParameter( "morningdishname" );

		String[] morningDishNames = morningdishName.split( "," );

		String noondishName = request.getParameter( "noondishname" );

		String[] noonDishNames = noondishName.split( "," );

		String nightdishName = request.getParameter( "nightdishname" );

		String[] nightDishNames = nightdishName.split( "," );

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

		savetag( morningDishNames, noonDishNames, nightDishNames, bikou, morningList, noonList, nightList );

		RegisteredMainBean bean = this.setUpBean( morningDishNames, noonDishNames, nightDishNames, bikou );

		request.setAttribute( "bean", bean );

		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher( "/registeredMain.jsp" );
		disp.forward( request, response );
	}

	// 入力した食べ物をDBに保存
	private void savetag(
	        String[] morningDishNames, String[] noonDishNames, String[] nightDishNames, String bikou,
	        List<Integer> morningList, List<Integer> noonList, List<Integer> nightList
	)
	{

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{

			DishsaveDao dishdao = new DishsaveDao( c );

			int	size	= morningDishNames.length;
			int	asa		= 1;

			switch (size)
			{
				case 0:

					break;
				case 1:
					if( !morningDishNames[0].equals( "" ) )
					{
						dishdao.DishInsert( morningDishNames[0], morningList.get( 0 ), asa, bikou );
					}
					break;
				case 2:

					dishdao.DishInsert( morningDishNames[0], morningList.get( 0 ), asa, bikou );
					dishdao.DishInsert( morningDishNames[1], morningList.get( 1 ), asa, bikou );
					break;
				case 3:
					dishdao.DishInsert( morningDishNames[0], morningList.get( 0 ), asa, bikou );
					dishdao.DishInsert( morningDishNames[1], morningList.get( 1 ), asa, bikou );
					dishdao.DishInsert( morningDishNames[2], morningList.get( 2 ), asa, bikou );
					break;

			}

			size = noonDishNames.length;
			int hiru = 2;

			switch (size)
			{
				case 0:

					break;
				case 1:
					if( !noonDishNames[0].equals( "" ) )
					{
						dishdao.DishInsert( noonDishNames[0], noonList.get( 0 ), hiru, bikou );
					}

					break;
				case 2:
					dishdao.DishInsert( noonDishNames[0], noonList.get( 0 ), hiru, bikou );
					dishdao.DishInsert( noonDishNames[1], noonList.get( 1 ), hiru, bikou );
					break;
				case 3:
					dishdao.DishInsert( noonDishNames[0], noonList.get( 0 ), hiru, bikou );
					dishdao.DishInsert( noonDishNames[1], noonList.get( 1 ), hiru, bikou );
					dishdao.DishInsert( noonDishNames[2], noonList.get( 2 ), hiru, bikou );
					break;

			}

			size = nightDishNames.length;
			int yoru = 3;

			switch (size)
			{
				case 0:

					break;
				case 1:
					if( !nightDishNames[0].equals( "" ) )
					{
						dishdao.DishInsert( nightDishNames[0], nightList.get( 0 ), yoru, bikou );
					}

					break;
				case 2:
					dishdao.DishInsert( nightDishNames[0], nightList.get( 0 ), yoru, bikou );
					dishdao.DishInsert( nightDishNames[1], nightList.get( 1 ), yoru, bikou );
					break;
				case 3:
					dishdao.DishInsert( nightDishNames[0], nightList.get( 0 ), yoru, bikou );
					dishdao.DishInsert( nightDishNames[1], nightList.get( 1 ), yoru, bikou );
					dishdao.DishInsert( nightDishNames[2], nightList.get( 2 ), yoru, bikou );
					break;

			}

			c.commit( );
		}
		catch( SQLException e )
		{
			e.printStackTrace( );
		}

	}

	private RegisteredMainBean setUpBean(
	        String[] morningDishNames, String[] noonDishNames, String[] nightDishNames, String bikou
	)
	{

		RegisteredMainBean bean = new RegisteredMainBean( );

		int size = morningDishNames.length;

		switch (size)
		{
			case 0:
				bean.setMorningDishName1( "" );
				bean.setMorningDishName2( "" );
				bean.setMorningDishName3( "" );
				break;
			case 1:
				bean.setMorningDishName1( morningDishNames[0] );
				bean.setMorningDishName2( "" );
				bean.setMorningDishName3( "" );
				break;
			case 2:
				bean.setMorningDishName1( morningDishNames[0] );
				bean.setMorningDishName2( morningDishNames[1] );
				bean.setMorningDishName3( "" );
				break;
			case 3:
				bean.setMorningDishName1( morningDishNames[0] );
				bean.setMorningDishName2( morningDishNames[1] );
				bean.setMorningDishName3( morningDishNames[2] );
				break;

		}

		size = noonDishNames.length;

		switch (size)
		{
			case 0:
				bean.setNoonDishName1( "" );
				bean.setNoonDishName1( "" );
				bean.setNoonDishName1( "" );
				break;
			case 1:
				bean.setNoonDishName1( noonDishNames[0] );
				bean.setNoonDishName2( "" );
				bean.setNoonDishName3( "" );
				break;
			case 2:
				bean.setNoonDishName1( noonDishNames[0] );
				bean.setNoonDishName2( noonDishNames[1] );
				bean.setNoonDishName3( "" );
				break;
			case 3:
				bean.setNoonDishName1( noonDishNames[0] );
				bean.setNoonDishName2( noonDishNames[1] );
				bean.setNoonDishName3( noonDishNames[2] );
				break;

		}

		size = nightDishNames.length;

		switch (size)
		{
			case 0:
				bean.setNightDishName1( "" );
				bean.setNightDishName2( "" );
				bean.setNightDishName3( "" );

				break;
			case 1:
				bean.setNightDishName1( nightDishNames[0] );
				bean.setNightDishName2( "" );
				bean.setNightDishName3( "" );

				break;
			case 2:
				bean.setNightDishName1( nightDishNames[0] );
				bean.setNightDishName2( nightDishNames[1] );
				bean.setNightDishName3( "" );

				break;
			case 3:

				bean.setNightDishName1( nightDishNames[0] );
				bean.setNightDishName2( nightDishNames[1] );
				bean.setNightDishName3( nightDishNames[2] );

				break;

		}

		bean.setBikou( bikou );

		return bean;

	}

}
