package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishTagIdDao {

	private Connection con;

	private static final String SELECT_DISHTAGID_SQL = "select\n"
			+ "count(maindisha.Tag_TagID)\n"
			+ " ,TagName\n"
			+ " ,maindisha.morningdaynightdivide\n"
			+ " ,maindisha.Tag_TagID\n"
			+ " from\n"
			+ "  (\n"
			+ "  select\n"
			+ "   *\n"
			+ "  from\n"
			+ "   maindish\n"
			+ "  where\n"
			+ "   maindish.morningdaynightdivide = ?\n"
			+ ") as maindisha\n"
			+ " join\n"
			+ " tag\n"
			+ " on maindisha.Tag_TagID = tag.TagID\n"
			+ " group by\n"
			+ " maindisha.Tag_TagID";

	public DishTagIdDao(Connection c) {

		super();
		this.con = c;
	}

	public List<DishVo> getDishTagId(String sort, String time) throws SQLException {

		DishVo tgAll = null;
		final String SQL_DESC = SELECT_DISHTAGID_SQL + " order by " + "count(*) " + "desc";
		final String SQL_ASC = SELECT_DISHTAGID_SQL + " order by " + "count(*) " + "asc";

		List<DishVo> tgAllList = new ArrayList<DishVo>();

		if (sort.equals("1")) {
			try (PreparedStatement stmt = this.con.prepareStatement(SQL_DESC)) {

				stmt.setString(1, time);
				/* ｓｑｌ実行 */
				try (ResultSet rset = stmt.executeQuery();) {

					while (rset.next()) {

						tgAll = new DishVo();

						tgAll.setTag_TagID(rset.getInt("maindisha.Tag_TagID"));
						tgAll.setTagCount(rset.getInt("count(maindisha.Tag_TagID)"));
						tgAll.setTagName(rset.getString("TagName"));

						tgAllList.add(tgAll);

					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			try (PreparedStatement stmt = this.con.prepareStatement(SQL_ASC)) {

				stmt.setString(1, time);
				/* ｓｑｌ実行 */
				try (ResultSet rset = stmt.executeQuery();) {

					while (rset.next()) {

						tgAll = new DishVo();

						tgAll.setTag_TagID(rset.getInt("maindisha.Tag_TagID"));
						tgAll.setTagCount(rset.getInt("count(maindisha.Tag_TagID)"));
						tgAll.setTagName(rset.getString("TagName"));

						tgAllList.add(tgAll);

					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

		}
		return tgAllList;

	}

}