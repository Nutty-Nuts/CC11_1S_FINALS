import modules.InitApp;
import modules.FileSystem;
import modules.Cryptology;
import modules.FileHandling;
import modules.StrengthChecker;
import modules.Generator;

import modules.helper.ArrayMethods;
import modules.helper.IOHelper;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        // Initialize App
        InitApp init = new InitApp();
        if (init.checkInit()) {
            // do nothing
        } else {
            init.initStorage();
        }

        // File System
        FileSystem fileSys = new FileSystem();
        FileHandling fileHandler = new FileHandling();

        // Printing Arrays
        ArrayMethods arrMethods = new ArrayMethods();
        IOHelper ioHelper = new IOHelper();

        Cryptology cryptology = new Cryptology();
        StrengthChecker check = new StrengthChecker();
        Generator generator = new Generator();

        String[] files = fileSys.fetchFiles();

        System.out.printf("Actions: [0] View all Passwords, [1] Create a Password, [2], Edit a Password, [3] See a Password, [4] Delete a Password, [5] Delete all Passwords, [6] Quit \n");
        System.out.printf("Enter Action: ");
        Scanner scanner = new Scanner(System.in);

        int action = 0;

        try {
            action = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("\n");
            System.out.printf("[ERROR][Please enter a number] \n"); 
            System.exit(0);
        }

        int passwordMethod = 0;
        int serviceIndex = 0;

        int[] choices = {};
        
        String password = "";
        String service = "";

        System.out.printf("\n");

        switch (action) {
            case 0:
                arrMethods.printStringArr(files);
                break;
            case 1:
                System.out.printf("Password Method: [0] Type Password, [1] Generate Password \n");
                System.out.printf("Method: ");
                passwordMethod = ioHelper.inputMismatch(scanner);

                System.out.printf("\n");

                switch (passwordMethod) {
                    case 0:
                        System.out.printf("Name of Service: ");
                        service = scanner.next() + ".txt";

                        System.out.printf("Password: ");
                        password = scanner.next();
                        break;
                    case 1:
                        System.out.printf("Name of Service: ");
                        service = scanner.next() + ".txt";

                        password = generator.genPassword();
                        break;
                    default:
                        System.out.printf("[ERROR][Not an option] \n"); 
                        System.exit(0);

                }
                System.out.printf("\n");

                fileHandler.createFile(service, cryptology.encryptString(password));
                fileHandler.printFile(service);
                break;

            case 2: 
                ioHelper.hasPassword(files);

                System.out.printf("Choose a service to edit: ");
                arrMethods.printStringArr(files);

                System.out.printf("Enter Action: ");
                serviceIndex = ioHelper.checkInputValidity(files, scanner.nextInt());
                service = files[serviceIndex]; 

                System.out.printf("Password Method: [0] Type Password, [1] Generate Password \n");
                System.out.printf("Method: ");
                passwordMethod = scanner.nextInt();

                System.out.printf("\n");

                switch (passwordMethod) {
                    case 0:
                        System.out.printf("Password: ");
                        password = scanner.next();
                        break;
                    case 1:
                        password = generator.genPassword();
                        break;
                    default:
                        System.out.printf("[ERROR][Not an option] \n"); 
                        System.exit(0);
                }
                System.out.printf("\n");

                fileHandler.editFile(service, cryptology.encryptString(password));
                fileHandler.printFile(service);
                break;
            case 3: 
                ioHelper.hasPassword(files);

                System.out.printf("Choose a service to read: ");
                arrMethods.printStringArr(files);

                System.out.printf("Enter Action: ");
                serviceIndex = ioHelper.checkInputValidity(files, ioHelper.inputMismatch(scanner));
                service = files[serviceIndex]; 

                fileHandler.printFile(service);
                break;
            case 4: 
                ioHelper.hasPassword(files);

                System.out.printf("Choose a service to delete: ");
                arrMethods.printStringArr(files);

                System.out.printf("Enter Action: ");
                serviceIndex = ioHelper.checkInputValidity(files, ioHelper.inputMismatch(scanner));
                service = files[serviceIndex]; 
               
                fileHandler.deleteFile(service);
                files = fileSys.fetchFiles();

                System.out.printf("\n");

                arrMethods.printStringArr(files);
                break;
            case 5:
                ioHelper.hasPassword(files);

                System.out.printf("Are you sure you want to delete all passwords? [0] No, [1] Yes \n");
                System.out.printf("Confirm: ");
                int confirm = ioHelper.inputMismatch(scanner);

                System.out.printf("\n");
                
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
            case 6:
                System.out.printf("[Quitting Program] \n");
                break;
            default:
                System.out.printf("[ERROR][Not an option] \n"); 
                break;
        }
    }
}
