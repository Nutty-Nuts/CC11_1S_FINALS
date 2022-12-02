package modules;

import java.io.File;

/**
 * InitApp
 */
public class InitApp {

    public boolean checkInit() {
        File initDir = new File("./storage");

        if (!initDir.exists()) {
            System.out.printf("\u001B[31m \u2715 Data Storage has not been Initialized \u001B[0m \n"); 
            return false; 
        } else {
            System.out.printf("\u001B[32m \u2713 Data Storage Exists \u001B[0m \n");
            return true;
        }
    }

    public void initStorage() {
        File initDir = new File("./storage");
        System.out.printf("\u001B[33m \u27F3 Generating Storage... \u001B[0m \n");

        initDir.mkdir(); 

        System.out.printf("\u001B[32m \u2713 Storage Generated \u001B[0m \n");
    }
}
