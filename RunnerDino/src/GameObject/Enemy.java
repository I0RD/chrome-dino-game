package GameObject;

import Utility.Resource;

import java.awt.image.BufferedImage;

public class Enemy
{
    public BufferedImage enemy;
    public BufferedImage enemyTwo;

    public static final int posY=260;
    public int height;

    public Enemy()
    {
        enemy= Resource.getImage("src/Data/cactus1.png");
        enemyTwo= Resource.getImage("src/Data/cactus2.png");
        height=enemy.getHeight();
    }
}
