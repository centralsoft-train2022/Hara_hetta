package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CalenderBean;
import bean.WarningBean;
import dao.DBUtil;
import dao.DishVo;
import dao.DishsaveDao;
import dao.WarningDao;
import dao.WarningVo;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet
{
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
	        throws ServletException, IOException
	{

		WarningBean bean = new WarningBean( );
		bean.setWarningList( getWarning( ) );

		request.setAttribute( "bean", bean );

		sql( );
		Map<String, String[]> foodName = new HashMap<String, String[]>( );
		foodName.put( "2022-6-16", new String[]
		{ "ラーメン", "寿司", "カレー" } );
		foodName.put( "2022-6-17", new String[]
		{ "塩ラーメン", "サーモン", "カツカレー" } );
		foodName.put( "2022-6-18", new String[]
		{ "チロル", "アルフォート", "おにぎり" } );
		request.setAttribute( "foodName", foodName );

		RequestDispatcher disp = request.getRequestDispatcher( "calendar.jsp" );
		disp.forward( request, response );
	}

	private void sql()
	{
		DBUtil util = new DBUtil( );

		Connection con = util.getConnection( );

		DishsaveDao savedao = new DishsaveDao( con );
		// CalenderBean caBean = savedao.getDish();
		// request.setAttribute("bean", caBean);
		DishVo dishVo = savedao.getDish( );

		String	getdn	= dishVo.getDishName( );
		String	getdb	= dishVo.getDishBikou( );
		Date	getdd	= dishVo.getDishDate( );

		CalenderBean bean = new CalenderBean( );
		bean.setDishName( getdn );
		bean.setBikou( getdb );
		bean.setDishDate( getdd );

		System.out.println( bean.getBikou( ) );
		System.out.println( bean.getDishName( ) );
		System.out.println( bean.getDishDate( ) );

	}

	private List<WarningVo> getWarning()
	{

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{
			WarningDao		warningdao	= new WarningDao( c );
			List<WarningVo>	WarningList	= warningdao.getWarning( );

			return WarningList;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}
}
