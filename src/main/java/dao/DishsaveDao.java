package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DishsaveDao
{

	private Connection con;

	private static final String INSERT_DISH_SQL = "insert"
	        + " INTO"
	        + " MAINDISH"
	        + " ("
	        + " DISHNAME"
	        + " ,USER_USERID"
	        + " ,TAG_TAGID"
	        + " ,DISHDATE"
	        + " ,morningdaynightdivide"
	        + " )"
	        + " VALUES"
	        + "("
	        + " ? "
	        + " ,3"
	        + " ,? "
	        + " ,19970612 "
	        + " ,1"
	        + ")";

	public DishsaveDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public void DishInsert( String dishName, Integer tagid )
	{

		try( PreparedStatement stmt = this.con.prepareStatement( INSERT_DISH_SQL ) )
		{

			stmt.setString( 1, dishName );
			stmt.setInt( 2, tagid );
			/* ｓｑｌ実行 */
			stmt.executeUpdate( );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}

}
