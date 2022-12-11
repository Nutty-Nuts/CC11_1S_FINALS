package modules.helper;
import modules.helper.ErrorMessageHelper;

/**
 * ArrayMethods
 */
public class ArrayHelper {

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
        ErrorMessageHelper errMsg = new ErrorMessageHelper();
        int index = 0;
        if (array.length == 0) {
            errMsg.noPasswords();
        }
        for (String item: array) {
            System.out.printf("[%d] %s\n, ",index, item);
            index++;
        }
    }
}
