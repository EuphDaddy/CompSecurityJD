import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Encrypt {

    public static void encryptFile(Scanner kb) {
        //Havent considered using different characters in txt file besides letters
        try {
            // Prompt the user for the file name
            System.out.println("Please enter your file name: ");
            String inputFileName = kb.nextLine();

            // Check if the file exists before proceeding
            File inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
                System.out.println("File not found");
                return;
            }

            // Read the file content
            byte[] data = Files.readAllBytes(inputFile.toPath());

            // Generate a unique and secure key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // AES-128
            SecretKey secretKey = keyGen.generateKey();

            // Encrypt the file content using cipher class
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            //Encrypts the file using cipher as declared above
            byte[] encryptedData = cipher.doFinal(data);

            // Write the encrypted data to a new file, this is hard coded as cipherText, maybe i should replace with a variable
            File outputFile = new File("ciphertext.txt");
            Files.write(outputFile.toPath(), encryptedData);

            // Encode the key in Base64 and print key
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Encryption complete!");
            System.out.println("The encryption key (Copy and save this): " + encodedKey);
            System.out.println("Encrypted data written to ciphertext.txt");

        }
        catch (NoSuchAlgorithmException e) {
            System.err.println("Encryption algorithm not supported. " +
                    "Please ensure your environment supports AES.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        //reprint menu
        System.out.println("Returning to main menu...");
        Menu.menu();
    }

}
