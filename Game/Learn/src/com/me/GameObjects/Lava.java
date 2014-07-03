package com.me.GameObjects;

import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Lava extends Scrollable {
	
	private Random r;
	int tempHeight;
	private Rectangle rectangle;
	private boolean isScored = false;
	
	public Lava(float x, float y, int width, int height, float scrollSpeed)
	{
		super(x,y,width,height,scrollSpeed);
		r = new Random();
		rectangle = new Rectangle();
		
		
	
		
	}

	@Override//means use this method instead of the reset in the superclass Scrollable
	public void reset(float newX)
	{
		//Call the reset method in the superclass (Scrollable)
		super.reset(newX);//call the reset in the superclass
		tempHeight = r.nextInt(53) + 40;
		height = -tempHeight;
		isScored = false;
		
	}
	
	@Override
	public void update(float delta)
	{
		super.update(delta);//updates normally in Scrollable
		//rectangle.set(posistion.x,180 + height,width,tempHeight);
		rectangle.set(posistion.x,180 + height,width,-height);
		
		
		
	}
	
	public boolean collides(Bird bird) {
        
            return (Intersector.overlaps(bird.getCircle(), rectangle)
                    || Intersector.overlaps(bird.getCircle2(), rectangle));
	}
	
	public void restart(float x,float scrollSpeed)
	{
		velocity.x = scrollSpeed;
		reset(x);
	}
    
	
	public float getHeight()
	{
		return height;
	}
	
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	
	public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean b) {
        isScored = b;
    }
	

}
