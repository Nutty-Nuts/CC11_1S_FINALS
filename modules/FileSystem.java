package modules;

import java.io.File;
import modules.helper.ArrayMethods;

/**
 * FileSystem
 */
public class FileSystem {

    public String[] fetchFiles() {
        File dir = new File("./storage");
        File[] dirListing = dir.listFiles();

        ArrayMethods arrMethods = new ArrayMethods();

        String[] fileListing = {};

        if (dirListing != null) {
            for (File child: dirListing) {
                fileListing = arrMethods.pushString(fileListing, child.getName());
            }
        }

        return fileListing;
    }
}
