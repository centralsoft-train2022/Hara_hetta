package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDao
{

	private Connection con;

	private static final String SELECT_TAG_SQL = "select"
	        + " TAGID"
	        + ",TAGNAME"
	        + " from"
	        + " TAG";

	public TagDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public List<TagVo> getTag() throws SQLException
	{

		TagVo tg = null;

		List<TagVo> list = new ArrayList<TagVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_TAG_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					tg = new TagVo( );

					tg.setTagID( rset.getInt( "TagID" ) );
					tg.setTagName( rset.getString( "TagName" ) );

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