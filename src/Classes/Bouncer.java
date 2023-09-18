package Classes;

import java.awt.Graphics2D;

public class Bouncer extends GameObject{

    public Bouncer() {
        super(500, 500, 50);

        double direction = Math.random() * Math.PI * 2;
        xVelocity = (float)Math.cos(direction) * 5;
        yVelocity = (float)Math.sin(direction) * 5;
    }

    @Override
    public void update() {
        x += xVelocity;
        y += yVelocity;

        if(x < radius || x > 1000 - radius){
            xVelocity *= -1;
        }
        if(y < radius || y > 1000 - radius){
            yVelocity *= -1;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(java.awt.Color.RED);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
    }
    
}
