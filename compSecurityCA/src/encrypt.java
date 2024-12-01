import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class encrypt {

    public static void encryptFile(Scanner kb) {
        try {
            // Prompt the user for the file name
            System.out.println("Please enter your file name: ");
            String fileName = kb.nextLine();

            // Check if the file exists
            File inputFile = new File(fileName);
            if (!inputFile.exists()) {
                System.out.println("File not found");
                return;
            }

            // Read the file content
            byte[] data = Files.readAllBytes(inputFile.toPath());

            // Generate a single encryption key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // AES-128
            SecretKey secretKey = keyGen.generateKey();

            // Encrypt the file content
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data);

            // Write the encrypted data to a new file
            File outputFile = new File("ciphertext.txt");
            Files.write(outputFile.toPath(), encryptedData);

            // Encode the key in Base64 and display it
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Encryption complete!");
            System.out.println("The encryption key (save this securely): " + encodedKey);
            System.out.println("Encrypted data written to ciphertext.txt");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        encryptFile(kb);
    }
}
