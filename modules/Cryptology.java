package modules;

import modules.helper.ArrayMethods;
/**
 * Encryption
 */
public class Cryptology {

    static void genericPrintArray(char[] elements) {
        System.out.printf("{");
        for(char element: elements) {
            System.out.printf("%s,", element);
        }
        System.out.printf("} \n");
    }

    static char[] encryptCharArray(char[] array) {
        ArrayMethods arrMethods = new ArrayMethods();
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = 5 * charInt + 5;

            char newChar = (char) charInt;

            newArray = arrMethods.pushChar(newArray, newChar);
        }
        return newArray; 
    }

    static char[] decryptCharArray(char[] array) {
        ArrayMethods arrMethods = new ArrayMethods();
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = (charInt - 5) / 5;

            char newChar = (char) charInt;

            newArray = arrMethods.pushChar(newArray, newChar);
        }
        return newArray; 
    }
}

