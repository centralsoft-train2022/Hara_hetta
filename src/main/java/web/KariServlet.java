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

import bean.DishTagAllBean;
import dao.DBUtil;
import dao.DishTagIdDao;
import dao.DishVo;

@WebServlet("/KariServlet")
public class KariServlet extends HttpServlet
{

	protected void doGet(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		DishTagAllBean bean = new DishTagAllBean( );
		bean.setTagList( getTag_TagId( ) );

		request.setAttribute( "bean", bean );

		RequestDispatcher dispatcher = request.getRequestDispatcher( "" );
		dispatcher.forward( request, response );
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