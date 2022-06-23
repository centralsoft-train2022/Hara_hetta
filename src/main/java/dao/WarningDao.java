package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarningDao
{

	private Connection con;

	private static final String SELECT_WARNING1_SQL = "select\n"
	        + "tag.TagName\n"
	        + ",tagwarningpattern.WarningCount\n"
	        + "from\n"
	        + "tagwarningpattern\n"
	        + "join\n"
	        + "tag\n"
	        + "on TagWarningPattern.Tag_TagID = tag.TagID\n"
	        + "join\n"
	        + "maindish\n"
	        + "on TagWarningPattern.tag_tagid = maindish.Tag_TagID\n"
	        + "where\n"
	        + "tagwarningpattern.WarningSetting = 1 and maindish.DishDate > DATE_SUB(now(), INTERVAL 7 day)\n"
	        + "group by\n"
	        + "maindish.Tag_TagID\n"
	        + "having\n"
	        + "count(*) >= WarningCount\n";

	private static final String SELECT_WARNING2_SQL = "select\n"
	        + "tag.TagName\n"
	        + ",tagwarningpattern.WarningCount\n"
	        + "from\n"
	        + "tagwarningpattern\n"
	        + "join\n"
	        + "tag\n"
	        + "on TagWarningPattern.Tag_TagID = tag.TagID\n"
	        + "join\n"
	        + "maindish\n"
	        + "on TagWarningPattern.tag_tagid = maindish.Tag_TagID\n"
	        + "where\n"
	        + "tagwarningpattern.WarningSetting = 2 and maindish.DishDate > DATE_SUB(now(), INTERVAL 14 day)\n"
	        + "group by\n"
	        + "maindish.Tag_TagID\n"
	        + "having\n"
	        + "count(*) >= WarningCount\n";

	private static final String SELECT_WARNING3_SQL = "select\n"
	        + "tag.TagName\n"
	        + ",tagwarningpattern.WarningCount\n"
	        + "from\n"
	        + "tagwarningpattern\n"
	        + "join\n"
	        + "tag\n"
	        + "on TagWarningPattern.Tag_TagID = tag.TagID\n"
	        + "join\n"
	        + "maindish\n"
	        + "on TagWarningPattern.tag_tagid = maindish.Tag_TagID\n"
	        + "where\n"
	        + "tagwarningpattern.WarningSetting = 3 and maindish.DishDate > DATE_SUB(now(), INTERVAL 1 month)\n"
	        + "group by\n"
	        + "maindish.Tag_TagID\n"
	        + "having\n"
	        + "count(*) >= WarningCount\n";

	public WarningDao( Connection c )
	{

		super( );
		this.con = c;
	}

	public List<WarningVo> getWarning1() throws SQLException
	{

		WarningVo warning = null;

		List<WarningVo> warningList1 = new ArrayList<WarningVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_WARNING1_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					warning = new WarningVo( );

					warning.setWarningCount( rset.getInt( "WarningCount" ) );
					warning.setTagName( rset.getString( "TagName" ) );

					warningList1.add( warning );

				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return warningList1;
		}

	}

	public List<WarningVo> getWarning2() throws SQLException
	{

		WarningVo warning = null;

		List<WarningVo> warningList2 = new ArrayList<WarningVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_WARNING2_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					warning = new WarningVo( );

					warning.setWarningCount( rset.getInt( "WarningCount" ) );
					warning.setTagName( rset.getString( "TagName" ) );

					warningList2.add( warning );

				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return warningList2;
		}

	}

	public List<WarningVo> getWarning3() throws SQLException
	{

		WarningVo warning = null;

		List<WarningVo> warningList3 = new ArrayList<WarningVo>( );

		try( PreparedStatement stmt = this.con.prepareStatement( SELECT_WARNING3_SQL ) )
		{

			/* ｓｑｌ実行 */
			try( ResultSet rset = stmt.executeQuery( ); )
			{

				while( rset.next( ) )
				{

					warning = new WarningVo( );

					warning.setWarningCount( rset.getInt( "WarningCount" ) );
					warning.setTagName( rset.getString( "TagName" ) );

					warningList3.add( warning );

				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return warningList3;
		}

	}
}