package GameObject;

import Utility.Resource;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;


public class Dino
{
    public static final int NORMAL_RUN = 0;
    public static final int JUMPING = 1;
    public static final int DOWN_RUN = 2;
    public static final int DEATH = 3;
    public static final int NORMAL_GROUND_LEVEL=260;
    public static final int CRAWL_GROUND_LEVEL=280;
    private final BufferedImage walkL;
    private final BufferedImage walkR;
    private final BufferedImage crawlR;
    private final BufferedImage crawlL;
    private final BufferedImage dead;
    private final BufferedImage idle;
    private BufferedImage currentImg;

    private AudioClip jumpSound;
    public AudioClip deadSound;
    public AudioClip scoreUpSound;

    public int posY=NORMAL_GROUND_LEVEL;


    public Dino()
    {
        walkL=Resource.getImage("src/Data/main-character1.png");
        walkR=Resource.getImage("src/Data/main-character2.png");
        dead=Resource.getImage("src/Data/main-character4.png");
        idle=Resource.getImage("src/Data/Main-character3.png");
        crawlL=Resource.getImage("src/Data/main-character5.png");
        crawlR=Resource.getImage("src/Data/main-character6.png");
        currentImg=idle;
        try {
            jumpSound=Applet.newAudioClip(new URL("file","","src/Data/jump.wav"));
            deadSound=Applet.newAudioClip(new URL("file","","src/Data/dead.wav"));
            scoreUpSound=Applet.newAudioClip(new URL("file","","src/Data/scoreup.wav"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void update(int current_state)
    {
        switch (current_state) {
            case NORMAL_RUN -> {
                if (currentImg.equals(walkR)) {
                    currentImg = walkL;
                } else {currentImg = walkR;}
            }
            case JUMPING -> {
                currentImg = idle;
                //jumpSound.play();
            }
            case DOWN_RUN -> {
                if (currentImg.equals(crawlR)) {
                    currentImg = crawlL;
                } else {currentImg = crawlR;}
            }
            case DEATH ->currentImg = dead;
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(currentImg,100, posY,null);
    }

}
