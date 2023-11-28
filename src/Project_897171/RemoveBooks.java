package Project_897171;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RemoveBooks {
    public static void removeBookById() {
        System.out.println("Enter the book ID to remove:");
        Scanner scanner = new Scanner(System.in);

        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Connection con = null;

        try {
            con = DbConnection.getConnection();

            try {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Books WHERE id = " + bookId;

                int rowsAffected = st.executeUpdate(sql);

                if (rowsAffected > 0) {
                    System.out.println("Book with ID " + bookId + " removed successfully!");
                } else {
                    System.out.println("No book found with ID " + bookId + ". Nothing was removed.");
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
