package Project_897171;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllBooks {
	
	 public static void getAll() {
        System.out.println("Getting all books");
        Connection con = null;

        try {
            con = DbConnection.getConnection();

            try {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Books";

                ResultSet resultSet = st.executeQuery(sql);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    float price = resultSet.getFloat("price");
                    int qty = resultSet.getInt("qty");

                    System.out.println("Book ID: " + id);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty);
                    System.out.println("-----------------------------");
                }

                resultSet.close();
            } catch (SQLException s) {
                System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
