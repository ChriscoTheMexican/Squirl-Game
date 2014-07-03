package com.me.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.me.GameObjects.Bird;
import com.me.GameWorld.GameWorld;
//we need acess to the bird object
//no one has it but GameWorld and GameWorld belongs to GameScreen

public class InputHandler implements InputProcessor {
	
	private Bird myBird;
	private GameWorld myWorld;

	public InputHandler(GameWorld myWorld) {
		myBird = myWorld.getBird();//myBird is now the GameWorlds bird
		this.myWorld = myWorld;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == 62)	
		{
			if (myWorld.isReady()) 
			{
	            myWorld.start();
	        }

			
			myBird.onClick();
			
			
			if (myWorld.isGameOver())
			{
	            // Reset all variables, go to GameState.READ
				System.out.println("restarting");
	            myWorld.restart();
	        }
			
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//should call birds onClick method
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (myWorld.isReady()) 
		{
            myWorld.start();
        }

		
		myBird.onClick();
		

		
		
		if (myWorld.isGameOver())
		{
            // Reset all variables, go to GameState.READ
			System.out.println("restarting");
            myWorld.restart();
        }
		return true;//return true saying we handled the touch
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
