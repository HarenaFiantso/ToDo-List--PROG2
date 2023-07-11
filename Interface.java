import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        while (numberChoosen > 0) {
            System.out.println("1. Add a new Todo");
            System.out.println("2. Find a Todo");
            System.out.println("3. Show all Todos");
            System.out.println("4. Update a Todo");
            System.out.println("5. Delete a Todo");
            System.out.println("6. Quit");

            Scanner sc = new Scanner(System.in);
            System.out.print("Veuillez choisir : ");

            int numberChoosen = sc.nextInt();

            if (numberChoosen > 0 && numberChoosen <= 6) {
                System.out.println("You have choosen : " + numberChoosen);
            }
        }
        }
}
