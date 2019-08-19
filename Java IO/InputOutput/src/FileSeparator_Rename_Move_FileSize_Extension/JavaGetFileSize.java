package FileSeparator_Rename_Move_FileSize_Extension;

import java.io.File;

public class JavaGetFileSize {

    static final String FILE_NAME = "D://Science//Java//Java IO//InputOutput//src//FileSeparator_Rename_Move_FileSize_Extension//java2.txt";

    public static void main(String[] args) {
        File file = new File(FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return;
        }

        System.out.println(getFileSizeBytes(file));
        System.out.println(getFileSizeKiloBytes(file));
        System.out.println(getFileSizeMegaBytes(file));
    }

    private static String getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

    private static String getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }

    private static String getFileSizeBytes(File file) {
        return file.length() + " bytes";
    }
}
