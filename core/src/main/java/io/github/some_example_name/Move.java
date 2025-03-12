package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;

public class Move extends Main{
    private float x, y; // Координаты персонажа
    private float speed = 200; // Скорость движения

    @Override
    public void create() {
        x = 100; // Начальная позиция
        y = 100;
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime(); // Время между кадрами

        // Управление с клавиатуры
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  x -= speed * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += speed * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    y += speed * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  y -= speed * deltaTime;

        // Очищаем экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Рисуем персонажа
        batch.begin();
        batch.draw(image, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}

