package Tools;

import static javax.swing.text.StyleConstants.Size;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Joystick {
    Texture CircleImg;
    Texture Stickimg;
    Circle CircleGranica;
    Circle StickGranica;
    float Rcircle, Rstick;
    Point2D direction;
    private int pointer = -1;

    public Joystick (Texture CircleImg, Texture Stickimg, Point2D point, float size){
        this.CircleImg = CircleImg;
        this.Stickimg = Stickimg;
        Rcircle = size/2;
        Rstick = Rcircle/2;
        CircleGranica = new Circle(Rcircle, point);
        StickGranica = new Circle(Rstick, point);
        direction = new Point2D(0,0);


    }

    public void draw (SpriteBatch batch){
        batch.draw(CircleImg, CircleGranica.kordinat.getX() - Rcircle,CircleGranica.kordinat.getY()-Rcircle,Rcircle*2,Rcircle*2);
        batch.draw (Stickimg, StickGranica.kordinat.getX()-Rstick, StickGranica.kordinat.getY()-Rstick,Rstick*2,Rstick*2 );


    }

    public void update (float x, float y, boolean isDownTouch, int pointer){
           Point2D touch = new Point2D(x,y);
           if(CircleGranica.isContains(touch) && isDownTouch && this.pointer == -1){
               this.pointer=pointer;
           }

           if (CircleGranica.Overlaps(StickGranica) && isDownTouch && pointer == this.pointer){
               atControl(new Point2D(x,y));
           }

           if ((!isDownTouch && pointer == this.pointer) || (isDownTouch && pointer==this.pointer && !CircleGranica.isContains(touch))){
               returnStick();
           }
    }



    public void atControl (Point2D point){
       StickGranica.kordinat.setPoint(point);
       float dx = CircleGranica.kordinat.getX() - StickGranica.kordinat.getX();
       float dy = CircleGranica.kordinat.getY() - StickGranica.kordinat.getY();
       float distance = (float) Math.sqrt(dx*dx + dy*dy);

       direction.setPoint(-(dx/distance), -(dy/distance));


    }

    public void returnStick(){
        StickGranica.kordinat.setPoint(StickGranica.kordinat);
        direction.setPoint(0,0);
        pointer = -1;

    }

    public Point2D getDir (){
        return direction;
    }
}
