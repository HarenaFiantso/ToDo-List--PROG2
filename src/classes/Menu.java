/*
* Cette classe permet de créer un petite interface dans la console pour permettre d'éxecuter l'application
* */

package src;

public class Menu {
    public static void printMenu() {
        System.out.println("Hello ! Welcome to our Todo Application !");
        System.out.println("====================");
        System.out.println("1. Add a new Todo");
        System.out.println("2. Find a Todo");
        System.out.println("3. Show all Todos");
        System.out.println("4. Update a Todo");
        System.out.println("5. Delete a Todo");
        System.out.println("6. Quit");
        System.out.println("====================");
        System.out.print("Please choose an option : ");
    }
}
