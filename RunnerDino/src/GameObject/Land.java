package GameObject;

import UserInterface.MainWindow;
import Utility.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Land
{
    private final BufferedImage landOne;
    private final BufferedImage landTwo;
    private final BufferedImage landThree;
    public final int width;
    public int poX=0;
    public int current=0;
    public List<BufferedImage> terrain=new ArrayList<>();

    public Land()
    {
        landOne= Resource.getImage("src/Data/land1.png");
        landTwo=Resource.getImage("src/Data/land2.png");
        landThree=Resource.getImage("src/Data/land3.png");
        width=landOne.getWidth();
        for(;width*current<=MainWindow.windowWidth;current++)
        {
            generate();
        }
    }

    public void generate()
    {
        switch (new Random().nextInt(1, 3)) {
            case 1 -> terrain.add(landOne);
            case 2 -> terrain.add(landTwo);
            case 3 -> terrain.add(landThree);
        }
    }
    public void draw(Graphics g)
    {
        for(;current<terrain.size();current++)
        {
            g.drawImage(terrain.get(current),terrain.get(current).getWidth()*current+poX, MainWindow.windowHeight - (5 + landOne.getHeight()) * 2, null);
        }
        current=0;
    }
}
