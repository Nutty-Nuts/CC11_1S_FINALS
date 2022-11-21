import modules.InitApp;
import modules.FileSystem;
import modules.Cryptology;

import modules.helper.ArrayMethods;

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
        String[] files = fileSys.fetchFiles();

        // Printing Arrays
        ArrayMethods arrMethods = new ArrayMethods();
        arrMethods.printStringArr(files);

        Cryptology cryptology = new Cryptology();
        System.out.printf("%s \n", cryptology.encryptString("Password"));
        System.out.printf("%s \n", cryptology.decryptString("ƕǪɄɄɘȰȿǹ"));
    }
}
