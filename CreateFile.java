import java.io.File;
import java.io.IOException;

import java.util.Scanner;
/**
 * CreateFile
 */
public class CreateFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("File Name: ");

        String fileName = sc.nextLine();
        fileName = "storage/" + fileName + ".txt";

        try {
            File fileObj = new File(fileName);
            if (fileObj.createNewFile()) {
                System.out.printf("Created \"%s\" \n", fileObj.getName());
            } else {
                System.out.printf("File Already Exists \n");
            }
        } catch (IOException e) {
            System.out.printf("An error occurred \n");
            e.printStackTrace();
        }
    }
}
