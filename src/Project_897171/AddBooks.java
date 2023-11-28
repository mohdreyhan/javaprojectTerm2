package Project_897171;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBooks {
	
	public static void addBook() {
        System.out.println("adding");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter book title:");
        String title = scanner.nextLine();

        System.out.println("Enter book author:");
        String author = scanner.nextLine();

        System.out.println("Enter book price:");
        float price = scanner.nextFloat();

        System.out.println("Enter book qty:");
        int qty = scanner.nextInt();

        Connection con = null;

        try {
            con = DbConnection.getConnection();

            try {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Books (id, title, author, price, qty) VALUES (" +
                        id + ", '" + title + "', '" + author + "', " + price + ", " + qty + ")";

                int rowsAffected = st.executeUpdate(sql);

                if (rowsAffected > 0) {
                    System.out.println("Book added successfully!");
                } else {
                    System.out.println("Failed to add the book. Please try again.");
                }
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
            scanner.close();
        }
    }

}
