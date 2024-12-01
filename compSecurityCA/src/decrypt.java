import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class decrypt {
    public static void decryptFile(Scanner kb) {
        try {
            // Prompt the user for the encrypted file name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the filename to decrypt: ");
            String encryptedFilename = scanner.nextLine();

            // Check if the file exists
            File encryptedFile = new File(encryptedFilename);
            if (!encryptedFile.exists()) {
                System.out.println("Encrypted file not found!");
                return;
            }

            // Prompt the user for the decryption key
            System.out.print("Enter the decryption key (Base64-encoded): ");
            String encodedKey = scanner.nextLine();

            // Decode the Base64-encoded key
            byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
            SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "AES");

            // Read the encrypted file content
            byte[] encryptedData = Files.readAllBytes(encryptedFile.toPath());

            // Configure the Cipher for decryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decrypt the data
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Write the decrypted data to plaintext.txt
            File plaintextFile = new File("plaintext.txt");
            Files.write(plaintextFile.toPath(), decryptedData);

            // Notify the user
            System.out.println("Decryption complete!");
            System.out.println("Decrypted data written to plaintext.txt");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println("Ensure the key is correct and matches the one used for encryption.");
        }
    }
}

