package FileSeparator_Rename_Move_FileSize_Extension;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class JavaGetFileSizeUsingApacheCommonsIO {

    static final String FILE_NAME = "D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java2.txt";

    public static void main(String[] args) {
        File file = new File(FILE_NAME);

        long fileSize = FileUtils.sizeOf(file);

        System.out.println(fileSize + " bytes");
    }
}
