import java.io.*;

public class CreateWriteFile {
    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter("test-file.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

    }
}


