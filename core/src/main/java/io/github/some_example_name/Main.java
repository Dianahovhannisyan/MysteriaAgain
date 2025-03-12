package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import Screen.GameScreen;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    public Texture image;


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("Player.png");
        batch = new SpriteBatch();

        // saxi mej grel
        setScreen(new GameScreen(this));

    }



//    @Override
//    public void render() {
//        Gdx.gl.glClearColor(1,0,0,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
//        batch.begin();
//        batch.draw(image, 100, 100 );
//        batch.end();
//
//
//    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
