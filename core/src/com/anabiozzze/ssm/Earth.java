package com.anabiozzze.ssm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Earth {
    private Texture img;
    private Vector2 position;

    private float width, height;
    private float nextX, nextY, speed; // coordinates and speed for moving in a circle

    public Earth() {
        // set the pic source and size
        Pixmap earthSize = new Pixmap(Gdx.files.internal("earth.png"));
        Pixmap finSize = new Pixmap(70, 70, earthSize.getFormat());
        finSize.drawPixmap(earthSize,
                0, 0, earthSize.getWidth(), earthSize.getHeight(),
                0, 0, finSize.getWidth(), finSize.getHeight()
        );

        // set the start coordinates for the pic - in the center of the screen
        img = new Texture(finSize);
        width = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        height = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        position = new Vector2(width, height);
    }

    // moving
    public void render(SpriteBatch batch, float radius) {
        speed+=0.03;
        nextX = radius * (float) Math.cos(speed);
        nextY = radius * (float) Math.sin(speed);
        batch.draw(img, position.x + nextX, position.y + nextY);
    }
}