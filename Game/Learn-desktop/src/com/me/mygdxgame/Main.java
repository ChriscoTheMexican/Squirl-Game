package com.me.mygdxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Learn";
		cfg.useGL20 = false;
		cfg.width = 900;
		cfg.height = 400;
		
		new LwjglApplication(new MyGdxGame(), cfg);
	}
}
//http://www.kilobolt.com/