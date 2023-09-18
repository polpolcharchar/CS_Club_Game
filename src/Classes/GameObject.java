package Classes;

import java.awt.Graphics2D;

public abstract class GameObject {
    protected float x;
    protected float y;

    protected float xVelocity;
    protected float yVelocity;

    protected float radius;

    public GameObject(float x, float y, float radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void update();

    public abstract void draw(Graphics2D g);
}