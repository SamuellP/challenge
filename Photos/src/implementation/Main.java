package implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author samuel
 */
public class Main {

    
    public static void main(String[] args) throws IOException {
        
        BufferedImage thumbnail = 
    Thumbnails.of(new URL("http://54.152.221.29/images/b737_5.jpg"))
        .size(320,240)
        .outputFormat("jpg")
        .asBufferedImage();

ImageIO.write(thumbnail, "png", new File("/tmp/teste.png"));

    new Photo().resize("http://54.152.221.29/images.json");
        
    }
    
}
