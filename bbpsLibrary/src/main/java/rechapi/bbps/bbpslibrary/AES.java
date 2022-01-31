package rechapi.bbps.bbpslibrary;


import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

        private static final String ALGORITHM = "AES";
        //private static final byte[] SALT = "tHeApAcHe6410111".getBytes();// THE KEY MUST BE SAME

        public static String getEncrypted(String plainText,String key) {



            byte[] SALT = key.getBytes();// THE KEY MUST BE SAME
            if (plainText == null) {
                return null;
            }

            Key salt = new SecretKeySpec(SALT, ALGORITHM);

            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, salt);
                byte[] encodedValue = cipher.doFinal(plainText.getBytes());
                return Base64.encodeToString(encodedValue,Base64.DEFAULT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new IllegalArgumentException("Failed to encrypt data");
        }

        public static String getDecrypted(String encodedText,String key) {
            if (encodedText == null) {
                return null;
            }
            byte[] SALT = key.getBytes();//
            Key salt = new SecretKeySpec(SALT, ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, salt);
                byte[] decodedValue = Base64.decode(encodedText, Base64.DEFAULT);
                byte[] decValue = cipher.doFinal(decodedValue);
                return new String(decValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


    }

