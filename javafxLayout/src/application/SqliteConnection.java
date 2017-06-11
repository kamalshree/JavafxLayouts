package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
	public static Connection ConnectionArea() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:CourseDB.sqlite");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
