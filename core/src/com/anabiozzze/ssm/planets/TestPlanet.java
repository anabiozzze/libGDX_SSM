package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TestPlanet extends AbstractMover {
    protected Sprite img;
    protected Vector2 startPosition;
    protected float centerX, centerY;

    protected float nextX, nextY, speed;; // coordinates and speed for moving in a circle
    protected float xPos, yPos; // coordinates for checking mouse clicks

    public TestPlanet() {
        // set the start coordinates for the pic - in the center of the screen
        img = new Sprite(new Texture("icons/mars.png"));
        centerX = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        centerY = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        startPosition  = new Vector2(centerX, centerY);
    }

    // moving for all planets
    public void render(SpriteBatch batch, float width, float height, float radius, float boost) {
        speed += boost; // rotational speed
        nextX = radius * (float) Math.cos(speed); // Offset step X
        nextY = radius * (float) Math.sin(speed); // Offset step Y

        // set image size and position
        img.setBounds(startPosition.x + nextX, startPosition.y + nextY, width, height);
        img.draw(batch);

        // Corrected coordinates of the image for InputAdapter coordinate system
        xPos = img.getX()+img.getWidth()/2;
        yPos = Gdx.graphics.getHeight()-img.getY()- img.getHeight()/2;
    }

    public void reactToClick(int screenX, int screenY) {
        // Check the coincidence of the coordinates of the image area and the click point
        if ((Math.abs(xPos - screenX) <= img.getWidth()) && (Math.abs(yPos - screenY) <= img.getHeight())) {
            System.out.println(this.getClass().toString().substring(33).toUpperCase() + " Clicked");
        }
    }
}