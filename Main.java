import modules.Cryptology;
import modules.FileHandling;
import modules.Password;

import modules.helper.ArrayHelper;
import modules.helper.IOHelper;

import java.util.Scanner;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.printf("\n");

        // File Handling
        FileHandling fileHandler = new FileHandling();

        // Helper Classes
        ArrayHelper arrMethods = new ArrayHelper();
        IOHelper ioHelper = new IOHelper();

        // Password Related Tools
        Cryptology cryptology = new Cryptology();
        Password passTool = new Password();

        // Initialize Storage for Password Files
        fileHandler.initStorage();

        // Initialize Variables
        int action = 0;
        int passwordMethod = 0;
        int serviceIndex = 0;

        int[] choices = {};
        
        String password = "";
        String service = "";

        String[] passwordInformation;
        String[] files = fileHandler.fetchFiles();

        /*
         * Start of Program
        */
        System.out.printf("Actions: [0] View all Passwords, [1] Create a Password, [2], Edit a Password, [3] See a Password, [4] Delete a Password, [5] Delete all Passwords, [6] Quit \n");
        System.out.printf("Enter Action: ");
        Scanner scanner = new Scanner(System.in);
         
        action = ioHelper.inputMismatch(scanner);

        switch (action) {
            // View All Files
            case 0:
                arrMethods.printStringArr(files);
                break;
            // Create a Password File
            case 1:
                ioHelper.choosePasswordMethod();
                passwordMethod = ioHelper.inputMismatch(scanner);

                System.out.printf("Name of Service: ");
                service = scanner.next() + ".txt";

                password = ioHelper.makePassword(passwordMethod, scanner);

                fileHandler.createFile(service, password);
                fileHandler.printFile(service);
                break;
            // Edit a Password File
            case 2: 
                ioHelper.hasPassword(files);
                ioHelper.displayFiles(files);

                service = ioHelper.selectFile(files, scanner);

                ioHelper.choosePasswordMethod();

                passwordMethod = ioHelper.inputMismatch(scanner);
                password = ioHelper.makePassword(passwordMethod, scanner);

                fileHandler.editFile(service, password);
                fileHandler.printFile(service);

                break;
            // See a Password
            case 3: 
                ioHelper.hasPassword(files);
                ioHelper.displayFiles(files);

                service = ioHelper.selectFile(files, scanner);

                fileHandler.printFile(service);
                break;
            // Delete a Password
            case 4: 
                ioHelper.hasPassword(files);
                ioHelper.displayFiles(files);

                service = ioHelper.selectFile(files, scanner);

                fileHandler.deleteFile(service);
                files = fileHandler.fetchFiles();

                System.out.printf("\n");

                arrMethods.printStringArr(files);
                break;
            // Delete All Passwords
            case 5:
                ioHelper.hasPassword(files);

                System.out.printf("Are you sure you want to delete all passwords? [0] No, [1] Yes \n");
                System.out.printf("Confirm: ");
                int confirm = ioHelper.inputMismatch(scanner);

                switch (confirm) {
                    case 0:
                        System.out.printf("[Aborting Operation] \n");
                        break;
                    case 1:
                        for (String item: files) {
                            fileHandler.deleteFile(item);
                        }
                        break;
                    default:
                        System.out.printf("[ERROR][Not an option] \n"); 
                        System.exit(0);
                }
                break;
            // Quit the Program
            case 6:
                System.out.printf("[Quitting Program] \n");
                break;
            default:
                System.out.printf("[ERROR][Not an option] \n"); 
                break;
        }
    }
}
