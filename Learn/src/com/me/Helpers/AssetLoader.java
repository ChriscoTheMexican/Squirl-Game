package com.me.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture background;
	public static Texture lava;
	public static Texture texture;
	public static TextureRegion squirl;
	public static Texture stake;
	public static Texture grass;
	public static BitmapFont font;
	public static Sound jump;
	public static Sound die;
	public static void load()
	{
		background = new Texture(Gdx.files.internal("data/background.png"));//fence.jpg background.pngbackground.png
		
		lava = new Texture (Gdx.files.internal("data/lava.png"));//lava.png guy.png
		texture = new Texture(Gdx.files.internal("data/squirl.png"));//squirl.png chris
		squirl = new TextureRegion(texture,0,0,128,128);//128 128
		stake = new Texture(Gdx.files.internal("data/stake.jpg"));
		grass = new Texture(Gdx.files.internal("data/grass.jpg"));//grass.jpg Sand.jpg
		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.25f, -.25f);
		jump = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));
		die = Gdx.audio.newSound(Gdx.files.internal("data/di.wav"));
		
	}
	public static void dispose()
	{
		background.dispose();
		lava.dispose();
		texture.dispose();
		stake.dispose();
		grass.dispose();
		font.dispose();
	}

}
