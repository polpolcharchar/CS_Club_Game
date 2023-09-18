package Classes;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObject implements KeyListener{

    private boolean[] inputs;//0,1,2,3 = up,down,left,right
    private final double SPEED;

    public Player() {
        super(500, 500, 20);
        SPEED = 0.8;

        inputs = new boolean[4];
    }


    @Override
    public void update() {

        //update velocities
        if(inputs[0]){
            yVelocity -= SPEED;
        }
        if(inputs[1]){
            yVelocity += SPEED;
        }
        if(inputs[2]){
            xVelocity -= SPEED;
        }
        if(inputs[3]){
            xVelocity += SPEED;
        }
        
        //update position
        x += xVelocity;
        y += yVelocity;
        
        //damping
        xVelocity *= 0.9;
        yVelocity *= 0.9;
        
        //bound inside screen
        if(x < radius){
            x = radius;
            xVelocity = 0;
        }
        if(x > 1000 - radius){
            x = 1000 - radius;
            xVelocity = 0;
        }
        if(y < radius){
            y = radius;
            yVelocity = 0;
        }
        if(y > 1000 - radius){
            y = 1000 - radius;
            yVelocity = 0;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(java.awt.Color.WHITE);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 87){
            inputs[0] = true;
        }
        if(e.getKeyCode() == 83){
            inputs[1] = true;
        }
        if(e.getKeyCode() == 65){
            inputs[2] = true;
        }
        if(e.getKeyCode() == 68){
            inputs[3] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 87){
            inputs[0] = false;
        }
        if(e.getKeyCode() == 83){
            inputs[1] = false;
        }
        if(e.getKeyCode() == 65){
            inputs[2] = false;
        }
        if(e.getKeyCode() == 68){
            inputs[3] = false;
        }
    }
    
}
