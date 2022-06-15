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

import dao.DBUtil;
import dao.DishsaveDao;
import dao.TagDao;
import dao.TagVo;

@WebServlet("/MaindishServlet")

public class MaindishServlet extends HttpServlet
{

	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{

		// 画面から入力したデータを取得する
		// String dishDateStr = request.getParameter( "dishdate" );
		String	MorningdishName	= request.getParameter( "morningdishname" );
		String	NoondishName	= request.getParameter( "noondishname" );
		String	NightdishName	= request.getParameter( "nightdishname" );

		// 入力した食べ物をDBに保存
		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{

			DishsaveDao dishdao = new DishsaveDao( c );
			dishdao.DishInsert( MorningdishName );
			dishdao.DishInsert( NoondishName );
			dishdao.DishInsert( NightdishName );
		}
		catch( SQLException e )
		{
			e.printStackTrace( );
		}
		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher( "/registeredMain.jsp" );
		disp.forward( request, response );
	}

	// ①DBからタグのデータを取ってくる
	private List<TagVo> getTagVo()
	{

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ) )
		{
			TagDao		tgdao	= new TagDao( c );
			List<TagVo>	tgdeta	= tgdao.getTag( );

			return tgdeta;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}
}