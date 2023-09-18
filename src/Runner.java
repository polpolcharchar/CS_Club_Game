import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Classes.Bouncer;
import Classes.Player;

public class Runner {

    JFrame f;
    GamePanel gp;
    Timer t;

    Runner(){
        f = new JFrame();
        gp = new GamePanel();

        //create a timer to update the screen every 1/60th of a second
        t = new Timer(1000/60, e -> gp.repaint());

        f.addKeyListener(gp.getPlayer());

        f.add(gp);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        t.start();
    }

    public static void main(String[] args) throws Exception {
        new Runner();
    }
}

class GamePanel extends JPanel{

    private Bouncer b;

    private Player p;

    GamePanel(){
        //set window size
        this.setPreferredSize(new Dimension(1000, 1000));

        b = new Bouncer();
        p = new Player();
    }

    public void paint(Graphics gt){
        Graphics2D g = (Graphics2D) gt;

        //clear screen
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 1000, 1000);

        //draw bouncer
        b.update();
        b.draw(g);

        //draw player
        p.update();
        p.draw(g);
    }

    public Player getPlayer(){
        return p;
    }
}
