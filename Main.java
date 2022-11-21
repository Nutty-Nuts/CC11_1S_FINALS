import modules.InitApp;
import modules.FileSystem;
import modules.Cryptology;

import java.io.File;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        InitApp init = new InitApp();

        if (init.checkInit()) {
            // do nothing
        } else {
            init.initStorage();
        }

        FileSystem fileSys = new FileSystem();
        String[] files = fileSys.fetchFiles();

        System.out.println(files[0]);
    }
}
