package GameObject;

import UserInterface.MainWindow;
import Utility.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sun
{
    private final BufferedImage sunImage;
    public int posX=0;

    public Sun()
    {
        sunImage= Resource.getImage("src/Data/Sun.png");
    }

    public void draw(Graphics g)
    {
        g.drawImage(sunImage, MainWindow.windowWidth-posX,sunImage.getHeight()*2,null);
    }
}
