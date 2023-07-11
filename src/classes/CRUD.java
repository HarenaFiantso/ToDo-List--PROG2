/*
* Cette classe Java permet d'exécuter les requêtes SQL selon le choix de l'Utilisateur dans le menu d'interface dans la
* console.
* */

package src;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    public static void createTableIfNotExists(Connection connection) throws SQLException {
        /*==========CREATE THE TABLE todos IF IT IS NOT EXISTED==========*/
        Statement statement = connection.createStatement();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS todos (id SERIAL PRIMARY KEY, title VARCHAR(255), description VARCHAR(255))";
        statement.executeUpdate(createTableQuery);
        statement.close();
    }
    public static void addTodoItem(Scanner scanner, Connection connection) throws SQLException {
        /*==========TITLE OF THE Todo TO ADD==========*/
        System.out.print("Please enter the title of the TODO to add for : ");
        String title = scanner.nextLine();

        /*==========DESCRIPTION OF THE Todo TO ADD==========*/
        System.out.print("Please enter the description of the TODO to add for : ");
        String description = scanner.nextLine();

        /*==========INSERT QUERY OF THE addTodoItem==========*/
        String insertQuery = "INSERT INTO todos (title, description) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, title);
        statement.setString(2, description);
        statement.executeUpdate();
        statement.close();

        System.out.println("The Todo that you created is added successfully");
    }

    public static void findTodoItem(Scanner scanner, Connection connection) throws SQLException {
        /*==========TITLE OF THE Todo TO FIND==========*/
        System.out.print("Please the title of the Todo to search for : ");
        String title = scanner.nextLine();

        /*==========SELECT QUERY OF THE Todo TO FIND==========*/
        String selectQuery = "SELECT * FROM todos WHERE title = ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();

        /*
        * Essaie de donner à l'utilisateur les informations nécessaires du Todo à chercher
        * */
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String description = resultSet.getString("description");

            System.out.println("The Todo is found : ");
            System.out.println("Identifier : " + id);
            System.out.println("Title : " + title);
            System.out.println("Description : " + description);
        }

        resultSet.close();
        statement.close();
    }

    public static void showAllTodoItem(Connection connection) throws SQLException {
        /*==========SELECT QUERY OF THE Todo TO SHOW==========*/
        String selectQuery = "SELECT * FROM todos";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);

        /*
         * Essaie de donner à l'utilisateur les informations nécessaires du Todo à afficher
         * */
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");

            System.out.println("Identifier : " + id);
            System.out.println("Title : " + title);
            System.out.println("Description : " + description);
        }

        resultSet.close();
        statement.close();
    }

    public static void updateTodoItem(Scanner scanner, Connection connection) throws SQLException {
        /*==========PROMPT THE USER TO ENTER THE ID OF THE Todo TO UPDATE==========*/
        System.out.print("Please enter the identifier of the Todo to update : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // CONSOMME LE CARACTERE DE SAUT DE LIGNE

        /*==========UPDATE THE Todo WITH THE FOLLOWING PROMPT==========*/
        /*==========NEW TITLE==========*/
        System.out.print("Please enter the new title of the Todo : ");
        String newTitle = scanner.nextLine();

        /*==========NEW DESCRIPTION==========*/
        System.out.print("Please enter the new description of the Todo : ");
        String newDescription = scanner.nextLine();

        /*==========UPDATE QUERY OF THE Todo TO UPDATE==========*/
        String updateQuery = "UPDATE todos SET title = ?, description = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, newTitle);
        statement.setString(2, newDescription);
        statement.setInt(3, id);
        statement.executeUpdate();
        statement.close();

        System.out.println("Todo is updated successfully ! ");
    }

    public static void deleteTodoItem(Scanner scanner, Connection connection) throws SQLException {
        /*==========PROMPT THE USER TO ENTER THE ID OF THE Todo TO DELETE==========*/
        System.out.print("Please enter the identifier of the Todo to delete : ");
        int id = scanner.nextInt();

        /*==========DELETE QUERY OF THE Todo TO SHOW==========*/
        String deleteQuery = "DELETE FROM todos WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

        System.out.println("Todo is deleted successfully ! ");
    }
}
