import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) throws IOException {

        try {
        PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
        writer.println("das sit ein edit");
        writer.close();
        }catch (IOException ex){
            System.err.println("file not found or no access");
        }
    }
}


