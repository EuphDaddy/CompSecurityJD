import java.util.Scanner;

public class handleUserInput {
    public static int handleUserInput(Scanner kb) {
        try {
            return Integer.parseInt (kb.nextLine().trim());

        }
        catch (NumberFormatException e){
            return -1;
        }
    }
}
