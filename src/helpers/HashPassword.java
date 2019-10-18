package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static String md5(String password) {

        MessageDigest messageDigest;
        byte[] digests = new byte[0];

        try {

            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digests = messageDigest.digest();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        }

        BigInteger bigInteger = new BigInteger(1, digests);
        String hex = bigInteger.toString(16);

        while (hex.length() < 32) {

            hex = "0" + hex;

        }

        return hex;

    }
}
