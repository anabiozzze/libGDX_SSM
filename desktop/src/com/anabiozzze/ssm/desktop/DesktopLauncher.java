package com.anabiozzze.ssm.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.anabiozzze.ssm.SSM;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Solar System Missions";
		config.width = 1920;
		config.height = 1080;

		new LwjglApplication(new SSM(), config);
	}
}
