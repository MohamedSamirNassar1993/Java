package FileSeparator_Rename_Move_FileSize_Extension;

import java.io.File;

public class RenameOrMoveFile {

    public static void main(String[] args) {
        //absolute path rename file
        File file = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java.txt");
        File newFile = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java1.txt");
        if (file.renameTo(newFile)) {
            System.out.println("File rename success");;
        } else {
            System.out.println("File rename failed");
        }

        //relative path rename file
        file = new File("java2.txt");
        newFile = new File("java2_New.txt");
        if (file.renameTo(newFile)) {
            System.out.println("File rename success");;
        } else {
            System.out.println("File rename failed");
        }

        //java move file from one directory to another
        file = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java1.txt");
        newFile = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//folder//java.txt");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");;
        } else {
            System.out.println("File move failed");
        }

        //when source file is not present
        file = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//xyz.txt");
        newFile = new File("xyz.properties");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");;
        } else {
            System.out.println("File move failed");
        }

        // when destination already have a file with same name
        file = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//export.sql");
        newFile = new File("D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java2.txt");
        if (file.renameTo(newFile)) {
            System.out.println("File move success");;
        } else {
            System.out.println("File move failed");
        }
    }

}
