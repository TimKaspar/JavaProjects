import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CreateWriteFile {
    public static void main(String[] args) throws IOException {

        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("test.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);

    }
}


