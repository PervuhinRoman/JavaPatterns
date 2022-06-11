package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    private static final String KEY = "9999999999999999";

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException {

        File clearFile = new File("Files/app.exe");
        System.out.println(clearFile.getName());
        System.out.println(clearFile.getName().split("\\.")[1]);
        System.out.println(clearFile.getPath());
        System.out.println(clearFile.getParent());
        System.out.println(clearFile.length() + " bytes");
        System.out.println(clearFile.toPath().toUri());
        System.out.println(clearFile.toURI());
        System.out.println(clearFile.getAbsolutePath() + "\n\n");

        Aes256.encodeFile(clearFile, KEY);
        System.out.println("Encode is done!");

        File encryptedFile = new File("EncryptedFiles/" + clearFile.getName());
        System.out.println(encryptedFile.getName());
        System.out.println(encryptedFile.getName().split("\\.")[1]);
        System.out.println(encryptedFile.getPath());
        System.out.println(encryptedFile.getParent());
        System.out.println(encryptedFile.length() + " bytes");
        System.out.println(encryptedFile.toPath().toUri());
        System.out.println(encryptedFile.toURI());
        System.out.println(encryptedFile.getAbsolutePath() + "\n\n");

        Aes256.decodeFile(encryptedFile, KEY);
        System.out.println("Decode is done!");

        File decryptedFile = new File("DecryptedFile/" + clearFile.getName());
        System.out.println(decryptedFile.getName());
        System.out.println(decryptedFile.getName().split("\\.")[1]);
        System.out.println(decryptedFile.getPath());
        System.out.println(decryptedFile.getParent());
        System.out.println(decryptedFile.length() + " bytes");
        System.out.println(decryptedFile.toPath().toUri());
        System.out.println(decryptedFile.toURI());
        System.out.println(decryptedFile.getAbsolutePath());

        // decrypt to custom directory
        Aes256.decodeFile(encryptedFile, "C:\\Users\\Acer\\Documents\\Programming", KEY);
    }
}
