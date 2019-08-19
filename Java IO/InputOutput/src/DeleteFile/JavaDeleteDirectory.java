package DeleteFile;

import java.io.File;

public class JavaDeleteDirectory {

    public static void main(String[] args) {
        File dir = new File("D://Science//Java//Java IO//InputOutput//src//DeleteFile//folder");

        if (dir.isDirectory() == false) {
            System.out.println("Not a directory. Do nothing");
            return;
        }
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            System.out.println("Deleting " + file.getName());
            file.delete();
        }
        //now directory is empty, so we can delete it
        System.out.println("Deleting Directory. Success = " + dir.delete());
    }
}