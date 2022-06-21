package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishTagIdDao
{

	private Connection con;

	private static final String SELECT_DISHTAGID_SQL = "select"
	        + " maindish.Tag_TagID"
	        + " ,count(*)"
	        + " ,TagName"
	        + " from"
	        + " maindish"
	        + " join"
	        + " tag"
	        + " on maindish.Tag_TagID = tag.TagID"
	        + " group by"
	        + " Tag_TagID";

	public DishTagIdDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public List<DishVo> getDishTagId() throws SQLException
	{

		DishVo tgAll = null;

		List<DishVo> tgAllList = new ArrayList<DishVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_DISHTAGID_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					tgAll = new DishVo( );

					tgAll.setTag_TagID( rset.getInt( "maindish.Tag_TagID" ) );
					tgAll.setTagCount( rset.getInt( "count(*)" ) );
					tgAll.setTagName( rset.getString( "TagName" ) );
					// System.out.println( tgAll.getTag_TagID( ) );
					tgAllList.add( tgAll );

				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return tgAllList;
		}

	}

}