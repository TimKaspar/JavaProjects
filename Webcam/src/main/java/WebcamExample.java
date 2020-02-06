import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Example class
 */
public class WebcamExample {

    public static void main(String[] args) throws Exception {

        com.github.sarxos.webcam.Webcam webcam = com.github.sarxos.webcam.Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();
        BufferedImage image = webcam.getImage();
        webcam.close();

        String timestamp =
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        File output = new File("webcam-" + timestamp + ".png");
        ImageIO.write(image, "PNG", output);
    }
}
