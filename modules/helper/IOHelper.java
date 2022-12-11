package modules.helper;

import modules.Password;
import modules.helper.ArrayHelper;
import modules.helper.ErrorMessageHelper;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * IOHelper
 */
public class IOHelper {

    public int checkInputValidity(String[] array, int input) {
        ErrorMessageHelper errMsg = new ErrorMessageHelper();
        int length = array.length - 1;
        if (input > length || input < 0) {
            System.out.printf("\n");
            errMsg.notAnOptionError();
            System.exit(0);

            return 0;
        } else return input;
    }
    public void hasPassword(String[] array) {
        ErrorMessageHelper errMsg = new ErrorMessageHelper();
        if (array.length == 0) {
            errMsg.noPasswords();
            System.exit(0);
        } 
        return;
    }
    public int inputMismatch(Scanner sc) {
        ErrorMessageHelper errMsg = new ErrorMessageHelper();
        try {
            int input = sc.nextInt();
            System.out.printf("\n");
            return input;
        } catch (InputMismatchException e) {
            System.out.printf("\n");
            errMsg.notANumberError();
            System.exit(0);
        }
        return 0;
    }
    public String makePassword(int passwordMethod, Scanner sc) {
        ErrorMessageHelper errMsg = new ErrorMessageHelper();
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
                errMsg.notAnOptionError();
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
