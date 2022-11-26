import modules.InitApp;
import modules.FileSystem;
import modules.Cryptology;
import modules.FileHandling;
import modules.StrengthChecker;
import modules.Generator;

import modules.helper.ArrayMethods;

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

        Cryptology cryptology = new Cryptology();
        StrengthChecker check = new StrengthChecker();
        Generator generator = new Generator();

        String[] files = fileSys.fetchFiles();

        System.out.printf("Actions: [0] View all Passwords, [1] Create a Password, [2], Edit a Password, [3] See a Password, [4] Delete a Password \n");

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Action: ");

        int action = sc.nextInt();

        System.out.printf("\n");

        switch (action) {
            case 0:
                arrMethods.printStringArr(files);
                break;
            case 1:
                Scanner scService = new Scanner(System.in);
                System.out.printf("Name of Service: ");
                
                String service = scService.nextLine();
                service = service + ".txt";
                
                Scanner scPassword = new Scanner(System.in);
                System.out.printf("Password: ");

                String password = scPassword.nextLine();

                fileHandler.createFile(service, cryptology.encryptString(password));
                fileHandler.printFile(service);
                break;
            case 2: 
                System.out.printf("Choose a service to edit: ");
                arrMethods.printStringArr(files);

                Scanner scServiceEdit = new Scanner(System.in);
                System.out.printf("Enter Action: ");

                int serviceIndex = scServiceEdit.nextInt();
                String serviceEdit = files[serviceIndex];

                Scanner scNewPassword = new Scanner(System.in);
                System.out.printf("New Password: ");

                String newPassword = scNewPassword.nextLine();

                fileHandler.editFile(serviceEdit, cryptology.encryptString(newPassword));
                fileHandler.printFile(serviceEdit);
                break;
            case 3: 
                System.out.printf("Choose a service to edit: ");
                arrMethods.printStringArr(files);

                Scanner scReadService = new Scanner(System.in);
                System.out.printf("Enter Action: ");

                int readServiceIndex = scReadService.nextInt();
                String readService = files[readServiceIndex];

                fileHandler.printFile(readService);
                break;
            case 4: 
                System.out.printf("Choose a service to edit: ");
                arrMethods.printStringArr(files);

                Scanner scDeleteService = new Scanner(System.in);
                System.out.printf("Enter Action: ");

                int deleteServiceIndex = scDeleteService.nextInt();
                String deleteService = files[deleteServiceIndex];
               
                fileHandler.deleteFile(deleteService);

                files = fileSys.fetchFiles();

                System.out.printf("\n");

                arrMethods.printStringArr(files);
                break;
        }
    }
}
