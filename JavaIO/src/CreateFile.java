import java.io.*;

public class CreateFile {
    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter("test-file.txt", "UTF-8");
        writer.println("test");
        writer.close();

    }
}


