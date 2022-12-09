package modules;

import modules.helper.ArrayHelper;
import java.lang.Math;
/**
 * Generator
 */
public class Password {

    public String genPassword() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] characters = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '/', '?'};

        char[] emptyPassword = {};

        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasChar = false;

        ArrayHelper arrMethods = new ArrayHelper();

        for (int i = 0; i < 16; i++) {
            int index = 0;
            int whatArray = (int) Math.round(Math.random() * 2);

            if (!hasLetter) {
                index = (int) Math.round(Math.random() * (letters.length-1));
                emptyPassword = arrMethods.pushChar(emptyPassword, letters[index]);
                hasLetter = true;
                continue;
            }
            if (!hasNumber) {
                index = (int) Math.round(Math.random() * (numbers.length-1));
                emptyPassword = arrMethods.pushChar(emptyPassword, numbers[index]);
                hasNumber = true;
                continue;
            }
            if (!hasChar) {
                index = (int) Math.round(Math.random() * (characters.length-1));
                emptyPassword = arrMethods.pushChar(emptyPassword, characters[index]);
                hasChar = true;
                continue;
            }

            switch (whatArray) {
                case 0:
                    index = (int) Math.round(Math.random() * (letters.length-1));
                    emptyPassword = arrMethods.pushChar(emptyPassword, letters[index]);
                    break;
                case 1:
                    index = (int) Math.round(Math.random() * (numbers.length-1));
                    emptyPassword = arrMethods.pushChar(emptyPassword, numbers[index]);
                    break;
                case 2:
                    index = (int) Math.round(Math.random() * (characters.length-1));
                    emptyPassword = arrMethods.pushChar(emptyPassword, characters[index]);
                    break;
                default:
            }
        }
        String newPassword = new String(emptyPassword);

        return newPassword;
    }

    public boolean checker(String password) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] characters = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '/', '?'};

        char[] passChar = password.toCharArray();

        boolean hasNumber = false;
        boolean hasLetter = false;
        boolean hasChar = false;
        boolean hasLength = true;

        for (char item: passChar) {
            if (hasNumber) break;
            for (char compare: numbers) {
                if (item == compare) {
                    hasNumber = true;
                    break;
                }
            }
        }
        for (char item: passChar) {
            if (hasLetter) break;
            for (char compare: letters) {
                if (item == compare) {
                    hasLetter = true;
                    break;
                }
            }
        }
        for (char item: passChar) {
            if (hasChar) break;
            for (char compare: characters) {
                if (item == compare) {
                    hasChar = true;
                    break;
                }
            }
        }
        
        int arrLength = passChar.length;

        if (arrLength >= 16) hasLength = true;
        if (hasNumber == false) return false;
        if (hasLetter == false) return false;
        if (hasChar == false) return false;
        if (hasLength == false) return false;

        return true;
    }
}
