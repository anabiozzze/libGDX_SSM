package com.anabiozzze.ssm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Sun {
    Texture img;
    static Vector2 position;
    private float width, height;

    public Sun() {
        // set the pic source and size
        Pixmap sunSize = new Pixmap(Gdx.files.internal("sun.png"));
        Pixmap finSize = new Pixmap(300, 300, sunSize.getFormat());
        finSize.drawPixmap(sunSize,
                0, 0, sunSize.getWidth(), sunSize.getHeight(),
                0, 0, finSize.getWidth(), finSize.getHeight()
        );

        // set the start coordinates for the pic - in the center of the screen
        img = new Texture(finSize);
        width = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        height = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        position = new Vector2(width, height);
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

}