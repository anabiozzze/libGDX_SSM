package com.anabiozzze.ssm;

import com.anabiozzze.ssm.planets.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sun.render(batch);
		merc.render(batch, 170, 0.009f);
		venus.render(batch, 240, 0.008f);
		earth.render(batch, 300, 0.007f);
		mars.render(batch, 350, 0.006f);
		jup.render(batch, 370, 0.005f);
		sat.render(batch, 400, 0.004f);
		uran.render(batch, 450, 0.003f);
		nept.render(batch, 500, 0.002f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
