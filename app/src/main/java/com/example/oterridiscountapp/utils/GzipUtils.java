package com.example.oterridiscountapp.utils;

import static javax.crypto.Cipher.DECRYPT_MODE;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class GzipUtils {

    public static String compress(String data) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
        gzipOutputStream.write(data.getBytes("UTF-8"));
        gzipOutputStream.close();
        byte[] compressedBytes = out.toByteArray();
        out.close();
        // Encode the compressed data to Base64 for safe transmission
        return Base64.encodeToString(compressedBytes, Base64.DEFAULT);
    }


    public static String decompress(String encodedData) throws IOException {
        // Decode the Base64 encoded data (if encoded before transmission)
        byte[] compressedData = Base64.decode(encodedData, Base64.DEFAULT);

        // Decompress the data
        ByteArrayInputStream in = new ByteArrayInputStream(compressedData);
        GZIPInputStream gzipInputStream = new GZIPInputStream(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        gzipInputStream.close();
        in.close();
        out.close();

        // Return the decompressed data as a String
        return out.toString("UTF-8");
    }

    public static String decrypt(String encryptedData) throws Exception {
        byte[] keyValue = "4c5cfefcc958f1748eb31dcc609736FK".getBytes();
        Key key = new SecretKeySpec(keyValue, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS7Padding");
        c.init(DECRYPT_MODE, key, new IvParameterSpec("K8Csuc2GiKvetPZg".getBytes()));
        byte[] decordedValue = Base64.decode(encryptedData.getBytes(), Base64.DEFAULT);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

}
