package com.me.GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.Helpers.AssetLoader;
//this bird belongs to GameWorld
//needs two main methods, update method which will be called when GameWorld updates, and an onClick method
public class Bird {
	
	private Vector2 posistion;// cord
	private Vector2 velocity;//speed in y direction
	private Vector2 acceleration;//change in velocity
	private int width;
	private int height;
	private float rotation;//for rotation
	private Circle boundingCircle;
	private Circle boundingCircle2;
	private Rectangle test;
	private boolean isAlive;
	private int clickCounter;
	
	public Bird(float x, float y, int width, int height)//all the information we need to create the bird
	{
		this.width = width;
		this.height = height;
		posistion = new Vector2(x,y);
		velocity = new Vector2(0,0);//new object is not moving in the y direction
		acceleration = new Vector2(0,460);
		boundingCircle = new Circle();
		boundingCircle2 = new Circle();
		isAlive = true;
		clickCounter = 3;
		
	}
	
	public void update(float delta)//the reason the velocity and poisition are scaled is so is your game laggs
	//its multiplied by delta so they will move the same amount of spaces. Frame Independent movement
	{
		
		velocity.add(acceleration.cpy().scl(delta));//add the current velocity and the acceleration to get new velocity
		boundingCircle.set(posistion.x + 32, posistion.y + 25, 10); //set the bounding circle with radius of 6.5
		boundingCircle2.set(posistion.x + 15,posistion.y + 30,10);
		
		if(velocity.y > 200)//speed cap
		{
			velocity.y = 200;
		}
		
		posistion.add(velocity.cpy().scl(delta));//add old posistion and new velocity to get new posistion
		
		if(posistion.y > 140)
		{
			posistion.y = 140;
		}
		//handle rotation
		if(velocity.y < 0)//counterclockwise
		{
			rotation -= 600 * delta;
			if(rotation < -20)//dont rotate too much
			{
				rotation = -20;
			}
		}
		
		if(isFalling())//clockwise
		{
			rotation += 480 * delta;
			if(rotation > 10)
			{
				rotation = 10;
			}
		}
		
		if(posistion.y == 140)//on the ground
		{
			rotation = 0;
			clickCounter = 3;//reset click counter
		}
		
	}
	
	public boolean isFalling()
	{
		return velocity.y > 100;
	}
	
	public void die()
	
	{
		isAlive = false;
		
	}
	
	public void onClick()
	{
		if(isAlive == true && clickCounter > 0)
		{
		
		velocity.y = -205;
		clickCounter -= 1;
		AssetLoader.jump.play();
		}
	}
	
	public void onRestart(int y)
	{
		rotation = 0;
		posistion.y = y;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 460;	
		isAlive = true;
		
	}
	public float getX()
	{
		return posistion.x;
	}
	
	public float getY()
	
	{
		return posistion.y;
	}
	
	public float getWidth()
	{
		return width;
	}
	
	public float getHeight()
	{
		return height;
	}
	public float getRotation()
	{
		return rotation;
	}
	public Circle getCircle()
	{
		return boundingCircle;
	}
	public Circle getCircle2()
	
	{
		return boundingCircle2;
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public int getClicks()
	{
		return clickCounter;
	}
	
	
	

}
