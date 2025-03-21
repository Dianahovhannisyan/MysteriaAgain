package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import Actors.Player;
import Tools.Joystick;
import Tools.Point2D;
import io.github.some_example_name.Main;

public class GameScreen implements Screen {

     Joystick joy;
     Player player;
     Main main;

    public GameScreen(Main main) {
        this.main = main;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Main.height - screenY; // Adjust coordinates before passing
                multitouch((int)screenX, (int) screenY, true, pointer);
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Main.height - screenY; // Adjust coordinates before passing
                multitouch((int)screenX, (int) screenY, false, pointer);
                return true;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY = Main.height - screenY; // Adjust coordinates before passing
                multitouch((int)screenX, (int) screenY, true, pointer);
                return true;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });

        //loadActors();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // GameUpdate();

        Main.batch.begin();
//        Main.batch.draw(Main.image, 200, 200);
        //GameRender(Main.batch);
        Main.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
//        joy.dispose();
//        player.dispose();
    }

        private void GameUpdate() {
        player.setDirection(joy.getDir());
        player.update();
    }

    private void GameRender(SpriteBatch batch) {
        player.draw(batch);
        joy.draw(batch);
    }

    public void loadActors() {
        joy = new Joystick(
            Main.circle,
            Main.actor,
            new Point2D(
                Main.width - ((float) (Main.height / 3) / 2 + (float) (Main.height / 3) / 4),
                (float) (Main.height / 3) / 2 + (float) (Main.height / 3) / 4),
            (float) Main.height / 3);

        player = new Player(Main.actor, new Point2D((float) Main.width / 2, (float) Main.height / 2), 10.0f, (float) Main.height / 20);
    }

    private void multitouch(float x, float y, boolean isDownTouch, int pointer) {
        for (int i = 0; i < 5; i++) {
            joy.update(x, y, isDownTouch, pointer);
        }
    }
}
