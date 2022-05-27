package UserInterface;

import GameObject.Clouds;
import GameObject.Dino;
import GameObject.Land;
import GameObject.Sun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static GameObject.Dino.*;


public class GamePanel extends JPanel implements KeyListener, Runnable {
    private final Dino dino = new Dino();
    private final Land land=new Land();
    private final Sun sun=new Sun();
    private final EnemyMenager enemyMenager=new EnemyMenager();
    private int score = 0;
    private final Clouds clouds=new Clouds();
    private long speed=80;
    private boolean isPlaying=false;
    private boolean isCrawl=false;
    private boolean isJumping=false;

    public GamePanel() {setBackground(new Color(247,247,247,255));}


    public void paint(Graphics g) {
        super.paint(g);
        clouds.draw(g);

        g.drawString("Score: " + score, 600, 20);
        land.draw(g);
        enemyMenager.draw(g);
        dino.draw(g);
        sun.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if(!isPlaying)
        {
            isPlaying=true;
            score=0;
            startGame();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(isPlaying)
        {
            if(e.getKeyCode() == KeyEvent.VK_S||e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                isCrawl=true;
            }
            else if(dino.posY==NORMAL_GROUND_LEVEL||dino.posY==CRAWL_GROUND_LEVEL)
            {
                isJumping=true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(isPlaying) {isCrawl = false;}
    }

    public void startGame()
    {
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (isPlaying) {
            enemyMenager.posX++;
            clouds.update();
            if(isCrawl)
            {
                if(dino.posY<CRAWL_GROUND_LEVEL)
                {
                    dino.posY+=20;
                }
                else
                {
                    dino.posY = CRAWL_GROUND_LEVEL;
                }
                dino.update(DOWN_RUN);
            }
            else if(isJumping)
            {
                dino.update(JUMPING);
                if(dino.posY>=160)
                {
                    dino.posY-=20;
                }
                else
                {
                    isJumping=false;
                }
            }
            else
            {
                if(dino.posY<NORMAL_GROUND_LEVEL)
                {
                    dino.posY+=20;
                }else
                {
                    dino.posY= NORMAL_GROUND_LEVEL;
                }
                dino.update(NORMAL_RUN);
            }
            for(int count=0;count<clouds.cloud.size();count++)
            {
                if(clouds.randomX.get(count)>MainWindow.windowWidth+80)
                {
                    clouds.cloud.remove(count);
                    clouds.randomX.remove(count);
                    clouds.randomY.remove(count);
                    clouds.generate();
                }
            }
            if(sun.posX>=MainWindow.windowWidth+50)
            {sun.posX=0;}
            else
            {sun.posX+=2;}
            if(land.poX<=-71)
            {
                land.terrain.remove(0);
                land.generate();
                land.poX=0;
            }
            if(score%100==0&&speed>5)
            {
                speed-=5;
                // dino.scoreUpSound.play();
            }
            land.poX-=10;
            score++;
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
