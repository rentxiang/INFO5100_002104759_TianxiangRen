import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Main6 {

    public static void main(String[] args) throws Exception {
        // Symmetric Encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        byte[] iv = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
        String message = "Hello Bob!";
        byte[] encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
        System.out.println(new String(decryptedMessage, StandardCharsets.UTF_8));

        // Asymmetric Encryption
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        message = "Hello Bob, this is Alice!";
        encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        decryptedMessage = cipher.doFinal(encryptedMessage);
        System.out.println(new String(decryptedMessage, StandardCharsets.UTF_8));

        // Signing and Validation
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        message = "This message is from Alice.";
        signature.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = signature.sign();
        signature.initVerify(publicKey);
        signature.update(message.getBytes(StandardCharsets.UTF_8));
        boolean isVerified = signature.verify(signatureBytes);
        System.out.println("Signature verified: " + isVerified);
    }
}
