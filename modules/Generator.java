package modules;

import modules.helper.ArrayMethods;
import java.lang.Math;
/**
 * Generator
 */
public class Generator {

    public String genPassword() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] characters = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '/', '?'};

        char[] emptyPassword = {};

        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasChar = false;

        ArrayMethods arrMethods = new ArrayMethods();

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
}
