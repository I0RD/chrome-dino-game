package UserInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
    public static final int windowHeight=350;
    public static final int windowWidth=720;

    public MainWindow()
    {
        super("Dino Runner");
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/4,windowWidth,windowHeight);
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(gamePanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
