package DeleteFile;

import java.io.File;

public class DeleteFileJava {
    
    public static void main(String[] args) {
        //absolute file name with path
        File file = new File("D://Science//Java//Java IO//InputOutput//src//DeleteFile//file.txt");
        if (file.delete()) {
            System.out.println(" File deleted");
        } else {
            System.out.println("File doesn't exists");
        }

        //file name only
        file = new File("file.txt");
        if (file.delete()) {
            System.out.println("file.txt File deleted from Project root directory");
        } else {
            System.out.println("File file.txt doesn't exists in project root directory");
        }

        //relative path
        file = new File("tmp/file.txt");
        if (file.delete()) {
            System.out.println("tmp/file.txt File deleted from Project root directory");
        } else {
            System.out.println("File tmp/file.txt doesn't exists in project root directory");
        }

        //delete empty directory
        file = new File("tmp");
        if (file.delete()) {
            System.out.println("tmp directory deleted from Project root directory");
        } else {
            System.out.println("tmp directory doesn't exists or not empty in project root directory");
        }

        //try to delete directory with files
        file = new File("D://Science//Java//Java IO//InputOutput//src//DeleteFile");
        if (file.delete()) {
            System.out.println("/Users/pankaj/project directory deleted from Project root directory");
        } else {
            System.out.println("/Users/pankaj/project directory doesn't exists or not empty");
        }
    }
}