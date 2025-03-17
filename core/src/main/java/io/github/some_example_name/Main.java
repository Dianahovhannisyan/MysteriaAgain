package io.github.some_example_name;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screen.GameScreen;


/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    public static SpriteBatch batch;
    public static Texture image;
    public static int width, height;
    public static Texture circle, actor;


    @Override
    public void create() {

        circle = new Texture("circle.png");
        actor = new Texture("actor.png");


        batch = new SpriteBatch();
        image = new Texture("Player.png");
        //batch = new SpriteBatch();

        // saxi mej grel
        setScreen(new GameScreen(this));

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();


    }


    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}

