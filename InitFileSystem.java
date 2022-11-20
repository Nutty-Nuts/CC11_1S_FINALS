import java.io.File;
/**
 * InitFileSystem
 */
public class InitFileSystem {

    public static void main(String[] args) {
        File initDir = new File("storage");
        if (!initDir.exists()) {
            initDir.mkdir();
        } else {
            System.out.printf("Directory already exists");
        }
    }
}
