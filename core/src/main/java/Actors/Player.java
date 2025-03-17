package Actors;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;
import io.github.some_example_name.Main;

public class Player extends Actor {

   // private int Score;
    private int lives = 3;

    public Player(
        Texture img,
        Point2D position,/*Circle granica,*/
        float Speed,
        float R
    ) {
        super(img, position, /*granica*/ Speed, R);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX() - R, position.getY() - R);
    }

    @Override
    public void update() {
        if (position.getX() + R > Main.width) position.setX(Main.width - R);
        if (position.getX() - R < 0) position.setX(R);
        if (position.getY() + R > Main.height) position.setY(Main.height - R);
        if (position.getY() - R < 0) position.setY(R);

        position.add(direction.getX(), direction.getY());
    }
}
