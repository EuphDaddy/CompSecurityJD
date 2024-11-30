import java.util.Scanner;

public class menu {
    public static void menu () {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please input an option to select: ");
        System.out.println(" 1: Encrypt the file \n 2: Decrypt the file \n 3: Exit");
        int user_input = handleUserInput.handleUserInput(kb);
        switch (user_input) {
            case 1 ->
                encrypt.encryptFile(kb);
            case 2 ->
                decrypt.decryptFile(kb);
            case 3 ->{
                System.out.println("Application Aborted");
                return;
            }

            default -> System.out.println("Invalid option");
            }
        }
    }

