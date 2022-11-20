/**
 * Encryption
 */
public class Encryption {

    static void genericPrintArray(char[] elements) {
        System.out.printf("{");
        for(char element: elements) {
            System.out.printf("%s,", element);
        }
        System.out.printf("} \n");
    }

    static char[] pushChar(char[] array, char element) {
        char[] newArray = new char[array.length + 1];
        int index = 0;

        for (char item: array) {
            newArray[index] = array[index];
            index++;
        }
        newArray[array.length] = element;
        return newArray;
    }

    static char[] encryptCharArray(char[] array) {
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = 5 * charInt + 5;

            char newChar = (char) charInt;

            newArray = pushChar(newArray, newChar);
        }
        return newArray; 
    }

    static char[] decryptCharArray(char[] array) {
        char[] newArray = {};

        for (char item: array) {
            int charInt = (int)item;
            charInt = (charInt - 5) / 5;

            char newChar = (char) charInt;

            newArray = pushChar(newArray, newChar);
        }
        return newArray; 
    }

    public static void main(String[] args) {
        String sample = "This is a Password";
        char[] charArray = sample.toCharArray();

        char[] encryptArray = encryptCharArray(charArray);
        char[] decryptArray = decryptCharArray(encryptArray);

        String encryptString = new String(encryptArray);
        String decryptString = new String(decryptArray);

        System.out.printf("Original String: %s \n", sample);
        System.out.printf("Encrypt String: %s \n", encryptString);
        System.out.printf("Decrypt String: %s \n", decryptString);
    }
}
