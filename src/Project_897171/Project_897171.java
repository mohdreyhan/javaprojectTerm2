package Project_897171;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Project_897171 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String userInputUsername = scanner.nextLine();

        System.out.println("Enter your password:");
        String userInputPassword = scanner.nextLine();

        Connection con = null;

        try {
            con = DbConnection.getConnection();

            try {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM User_Signup WHERE username = '" + userInputUsername + "'";

                ResultSet resultSet = st.executeQuery(sql);

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");

                    if (username.equals(userInputUsername) && password.equals(userInputPassword)) {
                    	ifLoginSuccess();
                    } else {
                        System.out.println("Invalid username or password");
                    }
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
        scanner.close();
    }
    
	private static void ifLoginSuccess() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Select an option:");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book by id");
        System.out.println("3. Get All");
        System.out.println("4. Remove Book by id");

        int option = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (option) {
        case 1:
            AddBooks.addBook();
            break;
        case 2:
        	UpdateBooks.updateBookById();
        break;
        case 3:
        	GetAllBooks.getAll();
            break;
        case 4:
        	RemoveBooks.removeBookById();
        	break;
        default:
            System.out.println("Invalid choice. Please select from the above choice");
            break;
            }
        
        scanner.close();
        }
}
