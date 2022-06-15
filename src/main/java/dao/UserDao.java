package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;

public class UserDao
{

	private Connection con;

//	private static final String SELECT_USER_SQL = "SELECT"
//	        + "UserID"
//	        + ",Password"
//	        + "FROM"
//	        + "user"
//	        + "WHERE"
//	        + "UserID "
//	        + "="
//	        + "1"
//	        + "AND"
//	        + "Password "
//	        + "= "
//	        + "aaaaa";

	private static final String SELECT_USER_SQL2 = "SELECT UserID ,Password FROM user WHERE UserID= 1 AND Password='aaaaa'";

	public UserDao( Connection con )
	{
		super( );
		this.con = con;
	}

	public LoginBean getAccount( int id, String pass )
	{
		LoginBean loginBean = null;
//		LoginBean loginBean = new LoginBean( );
//		
//		loginBean.setId("1");
//		loginBean.setPass("1");

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_USER_SQL2 ) )
		{
//			stmt.setInt( 1, id );

			try( ResultSet rset = stmt.executeQuery( ); )
			{
				loginBean = new LoginBean( );

				/* 取得したデータをインスタンスにまとめます */
				while( rset.next( ) )
				{

					loginBean.setId( rset.getInt( "UserID" ) );
					loginBean.setPass( rset.getString( "Password" ) );

				}
				return loginBean;

			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

	}
}
