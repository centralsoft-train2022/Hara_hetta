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

import bean.MaindishBean;
import dao.DBUtil;
import dao.TagDao;
import dao.TagVo;

@WebServlet("/MaindishServlet")

public class MaindishServlet extends HttpServlet
{

	protected void doGet(
	        HttpServletRequest request,
	        HttpServletResponse response
	) throws ServletException, IOException
	{
		MaindishBean bean = new MaindishBean( );
		bean.setTagList( getTagVo( ) );
		bean.setUsername( "まえだ" );

		request.setAttribute( "bean", bean );

		RequestDispatcher dispatcher = request.getRequestDispatcher( "maindish.jsp" );
		dispatcher.forward( request, response );
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