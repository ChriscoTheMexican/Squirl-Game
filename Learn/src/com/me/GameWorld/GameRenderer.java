package com.me.GameWorld;

import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.me.GameObjects.Bird;
import com.me.GameObjects.Grass;
import com.me.GameObjects.Lava;
import com.me.GameObjects.ScrollHandler;
import com.me.Helpers.AssetLoader;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private int midPointY;
    //game object
    private Bird bird;
    private ScrollHandler scroller;
    private Grass frontGrass,backGrass;
    private Lava lava1,lava2,lava3;
    //assets
    private Texture background;
    private TextureRegion squirl;
    private Texture stake;
    private Texture lava;
    private Texture grass;
    private ShapeRenderer shapeRenderer;
    private Rectangle sky;
    
    
 
   
    
    public GameRenderer(GameWorld world,int midPointY) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 450, 200);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);//attach batch to the camera
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        this.midPointY = midPointY;
        initObjects();
        initAssets();
       

    }
    
    public void initObjects()//get the GameObject once so the render method does not have to seek it out from myWorld every time
    {
    	bird = myWorld.getBird();
    	scroller = myWorld.getScroller();
    	frontGrass = scroller.getFrontGrass();
    	backGrass = scroller.getBackGrass();
    	lava1 = scroller.getLava1();
    	lava2 = scroller.getLava2();
    	lava3 = scroller.getLava3();
    	sky = myWorld.getSky();
    }
    
    public void initAssets()
    {
    	background = AssetLoader.background;
    	lava = AssetLoader.lava;
    	stake = AssetLoader.stake;
    	squirl = AssetLoader.squirl;
    	grass = AssetLoader.grass;
    	
    }
    
    private void drawGrass()
    {
    	batch.draw(grass,frontGrass.getX(),frontGrass.getY(),frontGrass.getWidth(),frontGrass.getHeight());
    	batch.draw(grass,backGrass.getX(),backGrass.getY(),backGrass.getWidth(),backGrass.getHeight());
    }
    
    private void drawLava()
    {
    	batch.draw(lava,lava1.getX(),lava1.getY() + 66,lava1.getWidth(),lava1.getHeight());
    	batch.draw(lava,lava2.getX(),lava2.getY() + 66,lava2.getWidth(),lava2.getHeight());
    	batch.draw(lava,lava3.getX(),lava3.getY() + 66,lava3.getWidth(),lava3.getHeight());
    
    }

    public void render(float runTime) {
    	

        //System.out.println("GameRenderer - render");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);//draws black background
        
        batch.begin();
        batch.draw(background,0,0,450,200);
        drawGrass();
        drawLava();
        batch.enableBlending();
        //batch.draw(squirl, bird.getX(), bird.getY(),bird.getWidth(), bird.getHeight());
        batch.draw(squirl, bird.getX(), bird.getY(), bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,  bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
        //testing for hit circle
        
        if(myWorld.isGameOver())
        {
        	
        	AssetLoader.font.draw(batch, "Click To Restart", 150, 100);//draw click
        }
        
        else if(myWorld.isReady())
        {
        	
        	AssetLoader.font.draw(batch, "Click To start", 150, 100);//draw click
        }
        
        
        AssetLoader.font.draw(batch, "" + myWorld.getScore(), 300, 11);//draw score
        AssetLoader.font.draw(batch, "Clicks: " + bird.getClicks(), 100, 11);//draw click
        batch.end();
        /*
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(bird.getCircle().x, bird.getCircle().y, bird.getCircle().radius);
        shapeRenderer.circle(bird.getCircle2().x, bird.getCircle2().y, bird.getCircle2().radius);
        shapeRenderer.rect(lava1.getRectangle().x,lava1.getRectangle().y,lava1.getRectangle().width,lava1.getRectangle().height);
        shapeRenderer.rect(lava2.getRectangle().x,lava2.getRectangle().y,lava2.getRectangle().width,lava2.getRectangle().height);
        shapeRenderer.rect(lava3.getRectangle().x,lava3.getRectangle().y,lava3.getRectangle().width,lava3.getRectangle().height);
        shapeRenderer.rect(sky.x,sky.y,sky.width,sky.height);
        shapeRenderer.end();*/

       

       
    }

}
