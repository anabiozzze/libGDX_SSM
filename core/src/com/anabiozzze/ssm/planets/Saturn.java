package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Saturn extends AbstractMoover {
    public Saturn() {
        // set the pic source and size
        Pixmap earthSize = new Pixmap(Gdx.files.internal("icons/saturn.png"));
        Pixmap finSize = new Pixmap(200, 200, earthSize.getFormat());
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
}