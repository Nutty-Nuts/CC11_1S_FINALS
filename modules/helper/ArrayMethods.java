package modules.helper;

/**
 * ArrayMethods
 */
public class ArrayMethods {

    public char[] pushChar(char[] array, char element) {
        char[] newArray = new char[array.length + 1];
        int index = 0;

        for (char item: array) {
            newArray[index] = array[index];
            index++;
        }
        newArray[array.length] = element;
        return newArray;
    }

    public String[] pushString(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        int index = 0;

        for (String item: array) {
            newArray[index] = array[index];
            index++;
        }
        newArray[array.length] = element;
        return newArray;
    }

    public void printStringArr(String[] array) {
        int index = 0;
        if (array.length == 0) {
            System.out.printf("[WARNING][You have no Passwords]");
        }
        for (String item: array) {
            System.out.printf("[%d] %s, ",index, item);
            index++;
        }
        System.out.printf("\n");
    }
}
