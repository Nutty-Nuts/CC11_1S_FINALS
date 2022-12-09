package modules.helper;

import modules.Password;
import modules.helper.ArrayHelper;

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
            System.out.printf("[ERROR][Not an option] \n"); 
            System.exit(0);

            return 0;
        } else return input;
    }
    public void hasPassword(String[] array) {
        if (array.length == 0) {
            System.out.printf("[WARNING][You have no Passwords] \n");
            System.exit(0);
        } 
        return;
    }
    public int inputMismatch(Scanner sc) {
        try {
            int input = sc.nextInt();
            System.out.printf("\n");
            return input;
        } catch (InputMismatchException e) {
            System.out.printf("\n");
            System.out.printf("[ERROR][Please enter a number] \n"); 
            System.exit(0);
        }
        return 0;
    }
    public String makePassword(int passwordMethod, Scanner sc) {
        Password passTool = new Password();
        String password = "";

        switch (passwordMethod) {
            case 0:
                System.out.printf("Password: ");
                password = sc.next();
                System.out.printf("\n");
                break;
            case 1:
                password = passTool.genPassword();
                break;
            default:
                System.out.printf("[ERROR][Not an option] \n"); 
                System.exit(0);
        }
        return password;
    }
    public String selectFile(String[] files, Scanner scanner) {
        System.out.printf("Enter Action: ");
        int serviceIndex = checkInputValidity(files, inputMismatch(scanner));
        String service = files[serviceIndex]; 

        return service;
    }
    public void choosePasswordMethod() {
        System.out.printf("Password Method: [0] Type Password, [1] Generate Password \n");
        System.out.printf("Method: ");
    }
    public void displayFiles(String[] files) {
        ArrayHelper arrMethods = new ArrayHelper();

        System.out.printf("Choose a service to read: ");
        arrMethods.printStringArr(files);
    }
}
