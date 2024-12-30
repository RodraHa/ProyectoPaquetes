/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Properties;
import java.util.Base64;
import javax.crypto.CipherInputStream;
/**
 *
 * @author migue
 */
public class ConfigManager {
    private  Properties properties = new Properties();
    private  final String ALGORITHM = "AES";
    private  final String ENCRYPTED_FILE = "src/basededatos/config_encrypted.properties";

    
    public ConfigManager() {
        try {
            // Obtén la clave desde una variable de entorno
            String keyBase64 = System.getenv("AES_SECRET_KEY");
            if (keyBase64 == null || keyBase64.isEmpty()) {
                throw new RuntimeException("La clave AES no está configurada en las variables de entorno.");
            }

            SecretKey key = stringToKey(keyBase64);
            File decryptedFile = File.createTempFile("config", ".properties");
            decryptFile(ENCRYPTED_FILE, decryptedFile.getAbsolutePath(), key);
            try (FileInputStream fis = new FileInputStream(decryptedFile)) {
                properties.load(fis);
            }
            decryptedFile.deleteOnExit(); // Eliminar archivo temporal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void decryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private SecretKey stringToKey(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, ALGORITHM);
    }
}