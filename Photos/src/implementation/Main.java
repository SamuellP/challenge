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
        


        new Photo().resize("http://54.152.221.29/images.json");
    }
        
    
}
