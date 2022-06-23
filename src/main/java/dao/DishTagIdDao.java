package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishTagIdDao {

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

	public DishTagIdDao(Connection c) {

		super();
		this.con = c;
	}

	public List<DishVo> getDishTagId(String sort) throws SQLException {

		DishVo tgAll = null;
		final String SQL_DESC = "SELECT_DISHTAGID_SQL" + "order by" + "desc";
		final String SQL_ASC = "SELECT_DISHTAGID_SQL" + "order by" + "asc";

		List<DishVo> tgAllList = new ArrayList<DishVo>();

		if (sort.equals("1")) {
			try (PreparedStatement stmt = this.con.prepareStatement(SQL_DESC)) {
				/* ｓｑｌ実行 */
				try (ResultSet rset = stmt.executeQuery();) {

					while (rset.next()) {

						tgAll = new DishVo();

						tgAll.setTag_TagID(rset.getInt("maindish.Tag_TagID"));
						tgAll.setTagCount(rset.getInt("count(*)"));
						tgAll.setTagName(rset.getString("TagName"));

						tgAllList.add(tgAll);

					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			try (PreparedStatement stmt = this.con.prepareStatement(SQL_ASC)) {
				/* ｓｑｌ実行 */
				try (ResultSet rset = stmt.executeQuery();) {

					while (rset.next()) {

						tgAll = new DishVo();

						tgAll.setTag_TagID(rset.getInt("maindish.Tag_TagID"));
						tgAll.setTagCount(rset.getInt("count(*)"));
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