package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractMover {
    protected Sprite img;
    protected Vector2 startPosition;
    protected float centerX, centerY;
    public boolean pause;

    protected float nextX, nextY, speed;; // coordinates and speed for moving in a circle
    protected float xPos, yPos; // coordinates for checking mouse clicks

    protected float count;

    // moving for all planets
    public void render(SpriteBatch batch, float width, float height, float radius, float boost) {
        if (!pause) {
            speed += boost; // rotational speed
            nextX = radius * (float) Math.cos(speed); // Offset step X
            nextY = radius * (float) Math.sin(speed); // Offset step Y
        } else {
            width*=2;
            height*=2;
        }

        // set image size and position in motion
        img.setBounds(startPosition.x + nextX, startPosition.y + nextY, width, height);
        img.draw(batch);

        // Corrected coordinates of the image for InputAdapter coordinate system
        xPos = img.getX() + img.getWidth() / 2;
        yPos = Gdx.graphics.getHeight() - img.getY() - img.getHeight() / 2;
    }

    public boolean reactToClick(SpriteBatch batch, int screenX, int screenY) {
        // Check the coincidence of the coordinates of the image area and the click point
        if ((Math.abs(xPos - screenX) <= img.getWidth()/2) && (Math.abs(yPos - screenY) <= img.getHeight()/2)) {
            System.out.println(this.getClass().toString().substring(33).toUpperCase() + " Clicked");

            count++;

            if (count % 2 != 0) {
                pause = true;
                SSM.infoWindow = new Sprite(new Texture("messageWin.png"));
                float messX = Gdx.graphics.getWidth()/2-SSM.infoWindow.getWidth()/2;
                float messY = Gdx.graphics.getHeight()/2-SSM.infoWindow.getHeight()/2;
                SSM.infoWindow.setBounds(messX, messY, SSM.infoWindow.getWidth(), SSM.infoWindow.getHeight());

            } else {
                pause = false;
                SSM.infoWindow = new Sprite(new Texture("messEmpty.png"));
            }
        }
        return true;
    }
}
