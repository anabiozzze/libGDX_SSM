package com.anabiozzze.ssm;

import com.anabiozzze.ssm.planets.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SSM extends ApplicationAdapter {
    SpriteBatch batch;
	Sun sun;
	Merc merc;
	Venus venus;
	Earth earth;
	Mars mars;
	Jupiter jup;
	Saturn sat;
	Uran uran;
	Neptun nept;
	TestPlanet testPlanet;

	@Override
	public void create () {
		batch = new SpriteBatch();
		sun = new Sun();
		merc = new Merc();
		venus = new Venus();
		earth = new Earth();
		mars = new Mars();
		jup = new Jupiter();
		sat = new Saturn();
		uran = new Uran();
		nept = new Neptun();
		testPlanet = new TestPlanet();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setColor(0.9f, 0.9f, 0.9f, 0.8f);
		sun.batch.begin();

		sun.render();
		merc.render(batch, 100, 100,170, 0.009f);
		venus.render(batch, 100, 100,240, 0.008f);
		earth.render(batch, 100, 100,300, 0.007f);
		mars.render(batch, 100, 100,350, 0.006f);
		jup.render(batch, 100, 100,370, 0.005f);
		sat.render(batch, 200, 200,400, 0.004f);
		uran.render(batch, 100, 100,450, 0.003f);
		nept.render(batch, 100, 100,500, 0.002f);
		testPlanet.render(batch, 100, 100,600, 0.002f);

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                merc.reactToClick(screenX, screenY);
                venus.reactToClick(screenX, screenY);
                earth.reactToClick(screenX, screenY);
                mars.reactToClick(screenX, screenY);
                jup.reactToClick(screenX, screenY);
                sat.reactToClick(screenX, screenY);
                uran.reactToClick(screenX, screenY);
                nept.reactToClick(screenX, screenY);
//                testPlanet.reactToClick(screenX, screenY);
                return true;
            }
        });
		sun.batch.end();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
