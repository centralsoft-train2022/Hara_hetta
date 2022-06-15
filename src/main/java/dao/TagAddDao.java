package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TagAddDao {
	private Connection c;

	public TagAddDao(Connection con) {
		super();
		this.c = con;
	}

	private static final String INSERT_TAG_SQL = "INSERT"
			+ "INTO"
			+ "TAG"
			+ "TAGNAME"
			+ "VALUES"
			+ "("
			+ "?"
			+ ")";

	public void insert(TagVo tagData) {

		try (PreparedStatement stmt = this.c.prepareStatement(INSERT_TAG_SQL)) {

			stmt.setString(1, tagData.getTagName());

			/* ｓｑｌ実行 */
			stmt.executeLargeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}