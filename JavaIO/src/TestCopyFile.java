import org.junit.Test;

import java.io.*;

public class TestCopyFile {
    @Test
    public void testCopyFile() throws IOException {

        // the file we want to copy
        File source = new File("D:/documents/Assessments/Pizza-Kurier.docx");
        if (!source.exists()) {
            throw new IOException("Source file is missing");
        }
        if (!source.canRead()) {
            throw new IOException("No rights to read source file");
        }

        // the new file we want to create. Note that it is not created yet, it's only a file
        // handle until we actually start writing.
        File dest = new File("D:/temp/copy.docx");
        if (dest.exists()) {
            System.out.println("Warning: destination file already exists and will be overwritten");
        }
        if (!dest.canWrite()) {
            throw new IOException("No rights to write source file");
        }

        // create streams for reading and writing -  for that we use FileInput/OutputStreams
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(dest)) {

            // data (byte) read on each cycle
            int data;

            // read one byte until the stream is exhausted (when < 0 is returned)
            while ((data = in.read()) >= 0) {
                out.write((byte) data);
            }
        }
        System.out.println("Done");
    }

}
