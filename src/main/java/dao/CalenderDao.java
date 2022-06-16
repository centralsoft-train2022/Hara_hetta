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
	        + " DISHNAME"
	        + ",DISHBIKOU"
	        + " from"
	        + " MAINDISH";

	public CalenderDao( Connection c )
	{

		super( );
		this.con = c;
	}
	
	public List<DishVo> getTag() throws SQLException
	{

		DishVo tg = null;

		List<DishVo> list = new ArrayList<DishVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_DISH_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					tg = new DishVo( );

					tg.setDishID( rset.getInt( "DishID" ) );
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
