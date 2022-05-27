package GameObject;

import UserInterface.MainWindow;
import Utility.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds
{
    public List<BufferedImage> cloud=new ArrayList<>();
    public List<Integer> randomX = new ArrayList<>();
    public List<Integer> randomY  = new ArrayList<>();

    public Clouds()
    {
        for(int count=0;count<5;count++)
        {
            generate();
        }
    }

    public void generate()
    {
        cloud.add(Resource.getImage("src/Data/cloud.png"));
        randomX.add((new Random().nextInt(10,200))-200);
        randomY.add(new Random().nextInt(10,100));
    }
    public void update()
    {
        for(int count=0;count<randomX.size();count++)
        {
            randomX.set(count,randomX.get(count)+2);
        }
    }
    public void draw(Graphics g)
    {
        for(int count=0;count<cloud.size();count++)
        {
            g.drawImage(cloud.get(count), MainWindow.windowWidth-randomX.get(count), randomY.get(count), null);
        }
    }
}
