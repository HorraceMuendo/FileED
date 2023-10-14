package encrypt_Decrypt;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypt {


    public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv, File inputFile, File outputFile) throws IOException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,key,iv);
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        byte [] buffer = new byte[16];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1){
            byte [] output = cipher.update(buffer,0,bytesRead);
            if (output != null){
                outputStream.write(output);
            }
        }
        byte [] outputBytes = cipher.doFinal();
        if (outputBytes != null){
            outputStream.write(outputBytes);
        }
        inputStream.close();
        outputStream.close();
    }

}
