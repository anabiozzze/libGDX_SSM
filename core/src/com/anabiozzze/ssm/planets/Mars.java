package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Mars extends AbstractMoover {
    public Mars() {
        // set the start coordinates for the pic - in the center of the screen
        img = new Sprite(new Texture("icons/mars.png"));
        centerX = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        centerY = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        startPosition  = new Vector2(centerX, centerY);
    }
}