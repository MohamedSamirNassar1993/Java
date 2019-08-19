package CreateNewFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Create_write {

    public static void main(String[] args) throws IOException {
        String fileData = "Pankaj Kumar";
        FileOutputStream fos = new FileOutputStream("name.txt");
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();

        /*
        We can use Java NIO Files class to create a new file and write some data into it.
        This is a good option because we don’t have to worry about closing IO resources.
        */
        Files.write(Paths.get("name1.txt"), fileData.getBytes());

    }
}
