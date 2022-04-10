package com.dokupay.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class JbossDbPasswordUtils
{
    private static final byte[] jbossKey = "jaas is the way".getBytes();
    private static final SecretKeySpec key = new SecretKeySpec(jbossKey, "Blowfish");

    public static String encrypt(String plaintext) throws Exception
    {
        byte[] encoding = new BigInteger(plaintext.getBytes(StandardCharsets.UTF_8)).toByteArray();

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] decode = cipher.doFinal(encoding);
        return new BigInteger(decode).toString(16);
    }
}
