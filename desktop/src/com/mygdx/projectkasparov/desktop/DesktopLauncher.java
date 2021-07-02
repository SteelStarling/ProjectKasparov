package com.mygdx.projectkasparov.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.projectkasparov.ProjectKasparov;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Starling Technologies: Project Kasparov";
		config.width = 800;
		config.height = 800;
		new LwjglApplication(new ProjectKasparov(), config);
	}
}
