package modules;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

import modules.Cryptology;
import modules.helper.ArrayHelper;
/**
 * FileHandling
 */
public class FileHandling {
    public void initStorage() {
        File initDir = new File("./storage");
        if (!initDir.exists()) {
            System.out.printf("Data Storage has not been Initialized \n"); 
            System.out.printf("Generating Storage... \n");

            initDir.mkdir(); 

            System.out.printf("Storage Generated \n\n");
            return; 
        } else {
            System.out.printf("Data Storage Exists \n\n");
            return;
        }
    }
    public String[] fetchFiles() {
        File dir = new File("./storage");
        File[] dirListing = dir.listFiles();

        ArrayHelper arrMethods = new ArrayHelper();

        String[] fileListing = {};

        if (dirListing != null) {
            for (File child: dirListing) {
                fileListing = arrMethods.pushString(fileListing, child.getName());
            }
        }
        return fileListing;
    }
    public void createFile(String fileName, String password) {
        Cryptology cryptology = new Cryptology();
        fileName = "storage/" + fileName;
        try {
            File fileObj = new File(fileName);

            if (fileObj.createNewFile()) {
                System.out.printf("New password created \n\n");
            } else {
                System.out.printf("Password for this service already exists \n");
                return;
            }
        } catch (IOException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(cryptology.encryptString(password));
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
        Cryptology cryptology = new Cryptology();
        String newFileName = "storage/" + fileName;
        File fileObj = new File(newFileName);

        if(fileObj.delete());
        else System.out.printf("Failed to edit file \n");

        createFile(fileName, newPassword);
    }
    public void printFile(String fileName) {
        try {
            fileName = "storage/" + fileName;

            File fileObj = new File(fileName);
            Scanner scanner = new Scanner(fileObj);
            Cryptology crypt = new Cryptology();

            System.out.printf("Service: %s \n", fileObj.getName());
            System.out.printf("Password: %s \n", crypt.decryptString(scanner.nextLine()));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.printf("An error has occured \n");
            e.printStackTrace();
        }
    }
}
