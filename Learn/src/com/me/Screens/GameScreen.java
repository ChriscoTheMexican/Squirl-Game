package com.me.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.me.GameObjects.Bird;
import com.me.GameWorld.GameRenderer;
import com.me.GameWorld.GameWorld;
import com.me.Helpers.InputHandler;

public class GameScreen implements Screen{
	
	private GameWorld world;//create and initialize two class variables  
	private GameRenderer renderer;//the point of these is so that the GameScreen class does not have	
	//to do the updating and rendering itself
	//I need to store world as a variable inside our GameRenderer, so that whenever I want to refer to an object inside the GameWorld, I can retrieve it.
	private float runTime = 0;
	public GameScreen()
	{
		int midPointY = 450;
		System.out.println("GameScreen added");
		world = new GameWorld(midPointY);
		renderer = new GameRenderer(world,midPointY);
		Bird bird = world.getBird();//draws bird from GameWorld passes it to inputHandler
		InputHandler handler = new InputHandler(world);//passes bird to inputhandler so if a key is pressed a bird method can be run
		Gdx.input.setInputProcessor(handler);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);//GameWorld updates
		renderer.render(runTime);//GameRendere render
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("resizing");
		
	}

	@Override
	public void show() {
		System.out.println("GameScreen show called");
		
	}

	@Override
	public void hide() {
		System.out.println("GameScreen hide called");
		
	}

	@Override
	public void pause() {
		System.out.println("GameScreen pause called");
		
	}

	@Override
	public void resume() {
		System.out.println("GameScreen resume called");
		
	}

	@Override
	public void dispose() {
		
		
	}
	
	

}
