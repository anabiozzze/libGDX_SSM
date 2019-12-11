package com.anabiozzze.ssm.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Sun {
    private Texture img;
    private TextureRegion region;
    private Vector2 position;
    private float width, height, red, green;
    private Pixmap sunSize;
    private Pixmap finSize;
    private int count;
    private float rotation;
    private static boolean pause;


    public Sun() {
        // set the pic source and size
        sunSize = new Pixmap(Gdx.files.internal("icons/sun.png"));
        finSize = new Pixmap(300, 300, sunSize.getFormat());
        finSize.drawPixmap(sunSize,
                0, 0, sunSize.getWidth(), sunSize.getHeight(),
                0, 0, finSize.getWidth(), finSize.getHeight()
        );

        // set the start coordinates for the pic - in the center of the screen
        img = new Texture(finSize);
        width = Gdx.graphics.getWidth()/2-img.getWidth()/2;
        height = Gdx.graphics.getHeight()/2-img.getHeight()/2;
        position = new Vector2(width, height);

        region = new TextureRegion(img);

        red = 0.9f;
        green = 0.6f;
    }

    // drawing, rotation and colors of sun
    public void render(SpriteBatch batch) {
        count++;
        rotation+=0.5;

        batch.setColor(red, green, 0.0f, 0.8f);
        if (!pause) {
            batch.draw(region, position.x, position.y,
                    region.getRegionWidth()/2, region.getRegionHeight()/2,
                    300, 300, 1, 1, rotation);
        } else {
            // hide the sun while AbstractMover is displaying the info window
            batch.draw(region, 2000, 2000,
                    region.getRegionWidth()/2, region.getRegionHeight()/2,
                    300, 300, 1, 1, rotation);
        }

        // changing colors
        switch(count/180) {
            case 1:
                red+=0.006f;
                green+=0.003f;
                break;
            case 2:
                red-=0.006f;
                green-=0.003f;
                break;
            case 3:
                count=0;
                break;
        }
    }
}