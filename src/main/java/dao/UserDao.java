package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;

public class UserDao
{

	private Connection con;

	private static final String SELECT_USER_SQL2 = "SELECT UserID ,Password FROM user WHERE UserID=? AND Password=?";

	public UserDao( Connection con )
	{
		super( );
		this.con = con;
	}

	private static void allClose( PreparedStatement statement, Connection connection )
	{

		if( statement != null )
		{

			try
			{
				statement.close( );
			}
			catch( SQLException e )
			{
				e.printStackTrace( );
			}
		}

		if( connection != null )
		{

			try
			{
				connection.close( );
			}
			catch( SQLException e )
			{
				e.printStackTrace( );
			}
		}

	}

	static Connection			connection;
	static PreparedStatement	statement	= null;

	public LoginBean findUser( int UserID, String Password )
	{
		LoginBean user = new LoginBean( );

		try
		{
			DBUtil utl = new DBUtil( );
			connection = utl.getConnection( );

			statement = connection.prepareStatement( SELECT_USER_SQL2 );
			statement.setInt( 1, UserID );
			statement.setString( 2, Password );

			ResultSet resultSet = statement.executeQuery( );

			if( !resultSet.next( ) )
			{
				return null;
			}

			user.setUserID( resultSet.getInt( "UserID" ) );
			user.setPassword( resultSet.getString( "Password" ) );

		}
		catch( SQLException e )
		{
			e.printStackTrace( );
		}
		finally
		{
			allClose( statement, connection );
		}
		return user;

	}

}
