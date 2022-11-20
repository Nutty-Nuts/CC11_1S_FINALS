import java.io.File;
/**
 * FileSystem
 */
public class FileSystem {

    public static void main(String[] args) {
        File dir = new File("storage");
        File[] dirListing = dir.listFiles();

        if (dirListing != null) {
            for (File child: dirListing) {
                System.out.printf("%s \n", child.getName());
            }
        } else {
            // do something
        }
    }
}
