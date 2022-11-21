package modules;

import modules.helper.ArrayMethods;
/**
 * Encryption
 */
public class Cryptology {

    public String encryptString(String password) {
        ArrayMethods arrMethods = new ArrayMethods();

        char[] array = password.toCharArray();
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = 5 * charInt + 5;

            char newChar = (char) charInt;

            newArray = arrMethods.pushChar(newArray, newChar);
        }
        String encrpytedPassword = new String(newArray);
        return encrpytedPassword;
    }

    public String decryptString(String password) {
        ArrayMethods arrMethods = new ArrayMethods();

        char[] array = password.toCharArray();
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = (charInt - 5) / 5;

            char newChar = (char) charInt;

            newArray = arrMethods.pushChar(newArray, newChar);
        }
        String decryptedPassword = new String(newArray);
        return decryptedPassword;
    }
}

