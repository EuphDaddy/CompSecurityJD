
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner kb = new Scanner(System.in);
        boolean isRunning = true;
        //restart the menu if invalid option is inputted
        while (isRunning) {
            //print menu
            System.out.println("Please input an option to select: ");
            System.out.println(" 1: Encrypt the file \n 2: Decrypt the file \n 3: Exit");
            int userInput = handleUserInput.handleUserInput(kb);
            if (userInput < 1 || userInput > 3) {
                System.out.println("Please enter a valid option (1, 2, or 3).");
                continue;
            }
            switch (userInput) {
                case 1 -> Encrypt.encryptFile(kb);
                case 2 -> Decrypt.decryptFile(kb);
                case 3 -> {
                    System.out.println("Exiting the application...");
                    isRunning = false;
                }

                default -> System.out.println("Invalid input. Please select 1, 2, or 3.");
            }
        }
    }
}

