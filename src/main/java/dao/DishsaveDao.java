package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CalenderBean;

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
	        + " ,DISHBIKOU"
	        + " )"
	        + " VALUES"
	        + "("
	        + " ? "
	        + " ,1"
	        + " ,? "
	        + " ,? "
	        + " ,?"
	        + " ,?"
	        + ")";

	private static final String SELECT_DISH_SQL = "SELECT"
	        + "DishName"
	        + ",DishBikou"
	        + ",MorningDayNightDivide"
	        + "FROM"
	        + "maindish";

	public DishsaveDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public void DishInsert( String dishName, Integer tagid, int asahiruyoru, String bikou )
	{

		try( PreparedStatement stmt = this.con.prepareStatement( INSERT_DISH_SQL ) )
		{

			long	miliseconds	= System.currentTimeMillis( );
			Date	date		= new Date( miliseconds );

			stmt.setString( 1, dishName );
			stmt.setInt( 2, tagid );
			stmt.setDate( 3, date );
			stmt.setInt( 4, asahiruyoru );
			stmt.setString( 5, bikou );

			/* ｓｑｌ実行 */
			stmt.executeUpdate( );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}

	public CalenderBean getDish( String dishName, String bikou, int toDayDish )
	{
		CalenderBean calendar = new CalenderBean( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_DISH_SQL ) )
		{

			stmt.setString( 1, dishName );
			stmt.setString( 2, bikou );
			stmt.setInt( 3, toDayDish );
			ResultSet resultSet = stmt.executeQuery( );

			calendar.setDishName( resultSet.getString( "DishName" ) );
			calendar.setBikou( resultSet.getString( "DishBikou" ) );
			calendar.setToDayDish( resultSet.getInt( "MorningDayNightDivide" ) );
			
		}
		catch( SQLException e )
		{
			e.printStackTrace( );
		}

		return calendar;

	}

}
