package modules.helper;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * IOHelper
 */
public class IOHelper {

    public int checkInputValidity(String[] array, int input) {
        int length = array.length - 1;
        if (input > length || input < 0) {
            System.out.printf("\n");
            System.out.printf("\u001B[41m\u001B[30m ERROR \u001B[0m\u001B[31m [Not an option] \n"); 
            System.exit(0);

            return 0;
        } else {
            return input;
        }
    }

    public void hasPassword(String[] array) {
        if (array.length == 0) {
            System.out.printf("\u001B[43m\u001B[30m WARNING \u001B[0m\u001B[33m You have no Passwords \n");
            System.exit(0);
        } 
        return;
    }

    public int inputMismatch(Scanner sc) {
        try {
            int input = sc.nextInt();
            return input;
        } catch (InputMismatchException e) {
            System.out.printf("\n");
            System.out.printf("\u001B[41m\u001B[30m ERROR \u001B[0m\u001B[31m Please enter a number \n"); 
            System.exit(0);
        }
        return 0;
    }
}
