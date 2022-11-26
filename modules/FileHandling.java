package modules;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

import modules.Cryptology;
/**
 * FileHandling
 */
public class FileHandling {
    public void createFile(String fileName, String password) {
        fileName = "storage/" + fileName + ".txt";
        try {
            File fileObj = new File(fileName);

            if (fileObj.createNewFile()) {
                System.out.printf("New password created \n");
            } else {
                System.out.printf("Password for this service already exists \n");
            }
        } catch (IOException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }
    }
    public void deleteFile(String fileName) {
        fileName = "storage/" + fileName;
        File fileObj = new File(fileName);

        if(fileObj.delete()) {
            System.out.printf("Deleted %s \n", fileObj.getName());
        } else {
            System.out.printf("Failed to delete file \n");
        }
    }
    public void editFile(String fileName, String newPassword) {
        fileName = "storage/" + fileName;
        File fileObj = new File(fileName);

        if(fileObj.delete()) {
            // do nothing
        } else {
            System.out.printf("Failed to edit file \n");
        }

        try {
            if (fileObj.createNewFile()) {
                System.out.printf("Password has been changed \n");
            } else {
                System.out.printf("Failed to edit file \n");
            }
        } catch (IOException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(newPassword);
            writer.close();
        } catch (IOException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }
    }
    public void printFile(String fileName) {
        try {
            fileName = "storage/" + fileName;

            File fileObj = new File(fileName);
            Scanner scanner = new Scanner(fileObj);

            Cryptology crypt = new Cryptology();

            System.out.printf("\n");

            System.out.printf("Service: %s \n", fileObj.getName());
            System.out.printf("Password: %s \n", crypt.decryptString(scanner.nextLine()));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }
    }
}
