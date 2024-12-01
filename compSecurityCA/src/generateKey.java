import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class generateKey {
    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(n);
        SecretKey key = keygen.generateKey();
        return key;
    }
}
