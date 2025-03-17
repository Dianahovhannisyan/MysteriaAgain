package Actors;

import com.badlogic.gdx.graphics.Texture;

import GraphicsObj.GraphicsObj;
import Tools.Circle;
import Tools.Point2D;

public abstract class Actor extends GraphicsObj {

    public Point2D position;
    public float Speed;
    public float R;
    public  Circle granica;
    public Point2D direction;


    public Actor(Texture img, Point2D position, float Speed, float R) {
        super(img);
        this.position = new Point2D(position) ;
        this.Speed = Speed;
        this.R = R;
        granica = new Circle(R, position);
        direction = new Point2D(0,0);
    }

    public void setDirection(Point2D dir){
        direction = dir;
    }
}
