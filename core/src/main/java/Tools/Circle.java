package Tools;

import static com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.point;

public class Circle {
    float R;
    public Point2D kordinat;

    public Circle (float R, Point2D Kordinat){
        this.R = R;
        this.kordinat = new Point2D(Kordinat);
    }

    public boolean isContains (Point2D point){
        float dx =  kordinat.getX() - point.getX();
        float dy = kordinat.getY()-point.getY();
        return dx * dx + dy * dy <= R * R;
    }

     public boolean Overlaps (Circle c){
        float dx = kordinat.getY()-c.kordinat.getY();
        float dy = kordinat.getX() - c.kordinat.getX();
        float distance = dx*dx+dy*dy;
        float sumR = c.R+R;
        return distance < sumR*sumR;

     }
}
