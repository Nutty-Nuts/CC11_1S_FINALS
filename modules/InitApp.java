package modules;

import java.io.File;

/**
 * InitApp
 */
public class InitApp {

    public boolean checkInit() {
        File initDir = new File("./storage");

        if (!initDir.exists()) {
            System.out.printf("Data Storage has not been Initialized \n"); 
            return false; 
        } else {
            System.out.printf("Data Storage Exists \n");
            return true;
        }
    }

    public void initStorage() {
        File initDir = new File("./storage");
        System.out.printf("\n");
        System.out.printf("Generating Storage... \n");

        initDir.mkdir(); 

        System.out.printf("Storage Generated \n");
    }
}
