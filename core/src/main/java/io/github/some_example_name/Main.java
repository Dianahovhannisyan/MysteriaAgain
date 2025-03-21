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
    public static int width, height;
    public static Texture circle, actor;

    @Override
    public void create() {
        batch = new SpriteBatch();
        actor = new Texture("Player.png");
        circle = new Texture("circle.png");

        setScreen(new GameScreen(this)); // Start with GameScreen

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void dispose() {
        batch.dispose();
        circle.dispose(); // Dispose additional textures
        actor.dispose();  // Dispose additional textures
    }
}
