package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractMoover {
    protected Texture img;
    protected Vector2 position;
    protected float width, height;

    protected float speed;
    protected float nextX, nextY; // coordinates and speed for moving in a circle

    // moving for all planets
    public void render(SpriteBatch batch, float radius, float boost) {
        speed+=boost;
        nextX = radius * (float) Math.cos(speed);
        nextY = radius * (float) Math.sin(speed);
        batch.draw(img, position.x + nextX, position.y + nextY);
    }
}
