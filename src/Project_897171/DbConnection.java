package Project_897171;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	 public static Connection getConnection() throws SQLException {
	     String url = "jdbc:mysql://localhost:3306/";
	     String db = "ebookshop";
	     String driver = "com.mysql.cj.jdbc.Driver";

	     try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	     return DriverManager.getConnection(url + db, "root", "admin");
	 }
}
