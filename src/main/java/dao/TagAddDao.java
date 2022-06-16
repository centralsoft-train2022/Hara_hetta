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

	private static final String INSERT_TAG_SQL = "insert\n"
			+ " into tag\n"
			+ " (\n"
			+ " tagname\n"
			+ " )\n"
			+ " values\n"
			+ " (\n"
			+ "  ?\n"
			+ " )";

	//	private static final String INSERT_WARNING_SQL = "";

	public void insert(String tn) {

		System.out.println(tn);

		try (PreparedStatement stmt = this.c.prepareStatement(INSERT_TAG_SQL)) {

			stmt.setString(1, tn);

			/* ｓｑｌ実行 */
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}