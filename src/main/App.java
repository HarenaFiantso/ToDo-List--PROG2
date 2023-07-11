/*
* Cette classe est la classe principale qui permettra d'exécuter l'application
* ENJOYYYYY! Fiantso Harena
* */

package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static classes.CRUD.*;
import static classes.Credentials.*;
import static classes.Menu.printMenu;

public class App {
    public static void main(String[] args) {
       try {
           /*==========INITIALIZE THE CONNECTION WITH THE DATABASE==========*/
           Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
           createTableIfNotExists(connection);

           /*==========PROMPT THE USER TO CHOOSE A CHOICE==========*/
           Scanner scanner = new Scanner(System.in);
           int userMenuChoice;

           do {
               printMenu();
               userMenuChoice = scanner.nextInt();
               scanner.nextLine(); // CONSOMME LE CARACTERE DE SAUT DE LIGNE

               switch (userMenuChoice) {
                   case 1 -> addTodoItem(scanner, connection);
                   case 2 -> findTodoItem(scanner, connection);
                   case 3 -> showAllTodoItem(connection);
                   case 4 -> updateTodoItem(scanner, connection);
                   case 5 -> deleteTodoItem(scanner, connection);
                   case 6 -> System.out.println("Thanks for passing, GoodBye :) !");
                   default -> System.out.println("Invalid choice. Please try again.");
               }
           } while (userMenuChoice != 6);

           connection.close();

       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
}