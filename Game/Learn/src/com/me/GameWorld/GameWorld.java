package com.me.GameWorld;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.me.GameObjects.Bird;
import com.me.GameObjects.ScrollHandler;
import com.me.Helpers.AssetLoader;

//create all game objects here then pass to GameRenderer to render them

public class GameWorld {
	
	private Bird bird;//create a new bird object
	private ScrollHandler scroller;
	private Rectangle sky;
	private int score = 0;
	private gameState currentState;
	private int midPointY;
	
	public GameWorld(int midPointY)
	{
		bird = new Bird(100,midPointY - 300,40,40);//new bird gives to GameScreen and GameRenderer
		scroller = new ScrollHandler(this);
		sky = new Rectangle(0,0,450,1);
		currentState = gameState.READY;
		this.midPointY = midPointY;
	}
	
	public void updateRunning(float delta)
	{
		bird.update(delta);//call the bird update method
		scroller.update(delta);
		if(bird.isAlive() == true && scroller.collides(bird) || bird.isAlive() == true && Intersector.overlaps(bird.getCircle(),sky) || bird.isAlive() == true && Intersector.overlaps(bird.getCircle2(),sky)  )
		{
			AssetLoader.die.play();	//play only one time
		}
		
		if(scroller.collides(bird))
		{
			bird.die();
			scroller.stop();
			currentState = gameState.GAMEOVER;
		}
		
		if(Intersector.overlaps(bird.getCircle(),sky) || Intersector.overlaps(bird.getCircle2(),sky))
		{
			bird.die();
			scroller.stop();
			currentState = gameState.GAMEOVER;
		}
		
	}
	
	public void update(float delta)
	{
		switch(currentState)//checks the current state of the game before determining which more specific update method to call. 
		{
		case READY:
			updateReady(delta);
			break;
			
			
		case RUNNING:
			default:
			updateRunning(delta);
			break;
		}
	}
	
	public void updateReady(float delta)
	{
		
	}
	
	public enum gameState
	{
		READY,RUNNING,GAMEOVER
	}
	
	public void restart()
	{
		currentState = gameState.READY;
		score = 0;
		bird.onRestart(midPointY - 300);
		scroller.onRestart();
		currentState = gameState.READY;
		
	}
	public void start() 
	{
        currentState = gameState.RUNNING;
    }
	
	public boolean isReady()
	{
        return currentState == gameState.READY;
    }
	public boolean isGameOver()
	{
        return currentState == gameState.GAMEOVER;
    }
	
	
	public Bird getBird()
	{
		return bird;
	}
	
	public ScrollHandler getScroller()
	{
		return scroller;
	}
	
	public Rectangle getSky()
	
	{
		return sky;
	}
	
	public int getScore()
	{
		return score;
	}

	public void addScore(int increment)
	{
		score += increment;
	}
}
