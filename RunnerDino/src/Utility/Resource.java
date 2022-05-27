package Utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resource
{
    public static BufferedImage getImage(String filePath)
    {
      BufferedImage image=null;

        try {
            image= ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
