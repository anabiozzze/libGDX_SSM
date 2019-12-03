package com.anabiozzze.ssm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SSM extends ApplicationAdapter {
    SpriteBatch batch;
	Sun sun;
	Earth earth;

	@Override
	public void create () {
		batch = new SpriteBatch();
		sun = new Sun();
		earth = new Earth();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sun.render(batch);
		earth.render(batch, 300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
