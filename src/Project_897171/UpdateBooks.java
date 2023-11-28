package Project_897171;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBooks {
    public static void updateBookById() {
        System.out.println("Enter the book ID to update:");
        Scanner scanner = new Scanner(System.in);

        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Connection con = null;

        try {
            con = DbConnection.getConnection();

            try {
                Statement st = con.createStatement();

                // Check if the book with the given ID exists
                String checkSql = "SELECT * FROM Books WHERE id = " + bookId;
                ResultSet resultSet = st.executeQuery(checkSql);

                if (resultSet.next()) {
                    System.out.println("Enter the new book title:");
                    String newTitle = scanner.nextLine();

                    System.out.println("Enter the new book author:");
                    String newAuthor = scanner.nextLine();

                    System.out.println("Enter the new book price:");
                    float newPrice = scanner.nextFloat();

                    System.out.println("Enter the new book quantity:");
                    int newQty = scanner.nextInt();

                    // Execute the update
                    String updateSql = "UPDATE Books SET title = '" + newTitle + "', " +
                            "author = '" + newAuthor + "', " +
                            "price = " + newPrice + ", " +
                            "qty = " + newQty + " WHERE id = " + bookId;

                    int rowsAffected = st.executeUpdate(updateSql);

                    if (rowsAffected > 0) {
                        System.out.println("Book with ID " + bookId + " updated successfully!");
                    } else {
                        System.out.println("Failed to update the book. Please try again.");
                    }
                } else {
                    System.out.println("No book found with ID " + bookId + ". Nothing was updated.");
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
            scanner.close();
        }
    }
}