package com.me.GameObjects;

import com.me.GameWorld.GameWorld;

public class ScrollHandler {
	//will create all the scrollable objects we need
	
	private Grass frontGrass,backGrass;
	private Lava lava1,lava2,lava3;
	private GameWorld gameWorld;
	
	 public static final int SCROLL_SPEED = -75;//use capital lettes when defining constants
	 public static final int GAP = 150;
	 
	 public ScrollHandler(GameWorld gameWorld)
	 {
		frontGrass = new Grass(0,180,450,50,SCROLL_SPEED);
		backGrass = new Grass(frontGrass.getTailX(),180,450,50,SCROLL_SPEED);
		lava1 = new Lava(210, 114, 22, -50, SCROLL_SPEED);//30 22
		lava2 = new Lava(lava1.getTailX() + GAP, 114, 22, -60, SCROLL_SPEED);
		lava3 = new Lava(lava2.getTailX() + GAP, 114, 22, -70, SCROLL_SPEED);
		this.gameWorld = gameWorld;
	 }
	 public void update(float delta)
	 {
		 frontGrass.update(delta);
		 backGrass.update(delta);
		 lava1.update(delta);
		 lava2.update(delta);
		 lava3.update(delta);
		 //check to see if scrolled left
		 
		 if(frontGrass.isScrolledLeft)
		 {
			 frontGrass.reset(backGrass.getTailX());
		 }
		 else if(backGrass.isScrolledLeft)
		 {
			 backGrass.reset(frontGrass.getTailX());
		 }
		 
		 if(lava1.isScrolledLeft)
		 {
			 lava1.reset(lava3.getTailX() + GAP);
		 }
		 else if(lava2.isScrolledLeft)
		 {
			 lava2.reset(lava1.getTailX() + GAP);
		 }
		 else if(lava3.isScrolledLeft)
		 {
			 lava3.reset(lava2.getTailX() + GAP);
		 }
	 }
	 
	 
	 public void stop()
	 {
		 frontGrass.stop();
		 backGrass.stop();
		 lava1.stop();
		 lava2.stop();
		 lava3.stop();
		 
	 }
	 
	 public boolean collides(Bird bird)
	 {
		 //handle score
		 if(lava1.isScored() == false && lava1.getX() + (lava1.getWidth() / 2) < bird.getX())
		 {
			 gameWorld.addScore(1);
			 lava1.setScored(true);
		 }
		 else if(lava2.isScored() == false && lava2.getX() + (lava2.getWidth() / 2) < bird.getX())
		 {
			 gameWorld.addScore(1);
			 lava2.setScored(true);
		 }
		 else if(lava3.isScored() == false && lava3.getX() + (lava3.getWidth() / 2) < bird.getX())
		 {
			 gameWorld.addScore(1);
			 lava3.setScored(true);
		 }
		 
		 
		 if(lava1.collides(bird) || lava2.collides(bird) || lava3.collides(bird))
		 {
			 return true;
		 }
		 
		 else 
		 {
			 return false;
		 }
		 
		 
		 
	 }
	 
	 public void onRestart()
	 {
		 frontGrass.restart(0,SCROLL_SPEED);
		 backGrass.restart(frontGrass.getTailX(), SCROLL_SPEED);
		 lava1.restart(210,SCROLL_SPEED);
		 lava2.restart(lava1.getTailX() + GAP,SCROLL_SPEED);
		 lava3.restart(lava2.getTailX() + GAP,SCROLL_SPEED);
	 }
	 
	 
	 //getteres for the instance variables
	 public Grass getFrontGrass()
	 {
		 return frontGrass;
	 }
	 public Grass getBackGrass()
	 {
		 return backGrass;
	 }
	 public Lava getLava1()
	 {
		 return lava1; 
	 }
	 public Lava getLava2()
	 {
		 return lava2; 
	 }
	 public Lava getLava3()
	 {
		 return lava3; 
	 }

}
