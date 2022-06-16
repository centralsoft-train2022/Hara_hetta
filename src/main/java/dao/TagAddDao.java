package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagAddDao {
	private Connection c;
	ResultSet rset = null;

	public TagAddDao(Connection con) {
		super();
		this.c = con;
	}

	private static final String INSERT_TAG_SQL = "insert\n"
			+ " into tag\n"
			+ " (\n"
			+ " tagname\n"
			+ " )\n"
			+ " values\n"
			+ " (\n"
			+ "  ?\n"
			+ " )";

	public void insertTagName(String tn) {

		try (PreparedStatement stmt = this.c.prepareStatement(INSERT_TAG_SQL)) {

			stmt.setString(1, tn);

			/* ｓｑｌ実行 */
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private static final String SELECT_TAGID_SQL = "SELECT\n"
			+ " max(tagid)\n"
			+ " FROM\n"
			+ " hara_hetta.tag\n";

	public int getTagID() {
		try (PreparedStatement stmt = this.c.prepareStatement(SELECT_TAGID_SQL)) {
			TagVo tgv = new TagVo();

			rset = stmt.executeQuery();

			tgv.setTagID(rset.getInt(1));

			int tagget = tgv.getTagID();
			return tagget;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static final String INSERT_WARNING_SQL = "insert\n"
			+ "into tagwarningpattern\n"
			+ "(\n"
			+ " warningsetting,\n"
			+ " user_userid,\n"
			+ " tag_tagid,\n"
			+ " warningcount\n"
			+ " )\n"
			+ " values\n"
			+ " (\n"
			+ "  ?,\n"
			+ "  ?,\n"
			+ "  ?,\n"
			+ "  ?\n"
			+ "  )\n";

	public void insertTagSetting(int ts, int tw, int uid, int tgidget) {

		try (PreparedStatement stmt = this.c.prepareStatement(INSERT_WARNING_SQL)) {

			stmt.setInt(1, ts); //期間設定
			stmt.setInt(2, uid); //ユーザーID
			stmt.setInt(3, tgidget); //タグID
			stmt.setInt(4, tw); //期間中に何回かというカウント

			/* ｓｑｌ実行 */
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}