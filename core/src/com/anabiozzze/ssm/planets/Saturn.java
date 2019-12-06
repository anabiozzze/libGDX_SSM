package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Saturn extends AbstractMoover {
    public Saturn() {
        // set the start coordinates for the pic - in the center of the screen
        img = new Sprite(new Texture("icons/saturn.png"));
        centerX = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        centerY = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        startPosition  = new Vector2(centerX, centerY);
    }
}