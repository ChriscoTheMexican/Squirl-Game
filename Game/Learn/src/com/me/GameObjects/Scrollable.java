package com.me.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Scrollable {

	protected Vector2 posistion;
	protected Vector2 velocity;
	protected int height,width;
	protected boolean isScrolledLeft;
	
	
	public Scrollable(float x, float y, int width, int height, float scrollSpeed)
	{
		posistion = new Vector2(x,y);
		velocity = new Vector2(scrollSpeed,0);
		this.width = width;
		this.height =  height;
		isScrolledLeft = false;
	}
	
	public void update(float delta)
	{
		posistion.add(velocity.cpy().scl(delta));
		
		if(posistion.x + width < 0)//object has moved off screen
		{
			isScrolledLeft = true;
		}
	}
	
	public void stop()
	{
		velocity.x = 0;
	}
	
	public void reset(float newX)
	{
		posistion.x = newX;
		isScrolledLeft = false;
	}
	public boolean isScrolledLeft()
	{
		return isScrolledLeft;
	}
	public float getTailX()
	{
		return posistion.x + width;
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
	
}
