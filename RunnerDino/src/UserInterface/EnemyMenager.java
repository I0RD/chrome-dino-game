package UserInterface;

import GameObject.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyMenager
{
    List<BufferedImage>enemies=new ArrayList<>();
    public int posX=0;

    public EnemyMenager()
    {
        for(int count=0;count<=5;count++)
        {
            switch (new Random().nextInt(1)) {
                case 0:
                    enemies.add(new Enemy().enemy);
                case 1:
                    enemies.add(new Enemy().enemyTwo);
            }
        }
    }

    public void draw (Graphics g)
    {
        for(int count=0;count<=5;count++)
        {
            g.drawImage(enemies.get(count),100*count+posX,Enemy.posY,null );
        }
    }
}
