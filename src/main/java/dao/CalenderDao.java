package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalenderDao
{

	private Connection con;

	private static final String SELECT_DISH_SQL = "select"
			+ " DISHDATE"
	        + " DISHNAME"
	        + ",DISHBIKOU"
	        + " from"
	        + " MAINDISH";

	public CalenderDao( Connection c )
	{

		super( );
		this.con = c;
	}
	
	public List<CalenderVo> getTag() throws SQLException
	{

		CalenderVo tg = null;

		List<CalenderVo> list = new ArrayList<CalenderVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_DISH_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					tg = new CalenderVo( );

					tg.setDishDate(rset.getDate("DishDate"));
					tg.setDishName( rset.getString( "DishName" ) );
					tg.setDishBikou(rset.getString( "DishBikou" ) );
					
					list.add( tg );

				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return list;

		}
	}
}
