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
	        + " ,DISHID"
	        + " ,USER_USERID"
	        + " ,TAG_TAGID"
	        + " )"
	        + " VALUES"
	        + "("
	        + " ? "
	        + " ,10 "
	        + " ,4 "
	        + " ,101 "
	        + ")";

	public DishsaveDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public void DishInsert( String morningdishname )
	{

		try( PreparedStatement stmt = this.con.prepareStatement( INSERT_DISH_SQL ) )
		{

			stmt.setString( 1, morningdishname );
			// stmt.setDate( 2, dishDateStr );

			/* ｓｑｌ実行 */
			stmt.executeUpdate( );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}

}
