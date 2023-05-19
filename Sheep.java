import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Sheep, our hero.
 * 
 * @author Kaylee Ke 
 * @version May 2023
 */
public class Sheep extends Actor
{
    GreenfootSound sheepSound = new GreenfootSound("PUNCH.mp3");
    GreenfootSound bombSound = new GreenfootSound("Explosion+6.mp3");
    
    GreenfootImage[] idleRight = new GreenfootImage[7];
    GreenfootImage[] idleLeft = new GreenfootImage[7];
    
    //Direction the sheep is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time whrn objects is created
     */
    public Sheep()
    {
        for(int i=1; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("sheep_idle/idle "+ i + ".png");
            idleRight[i].scale(90, 75);
        }
        
        for(int i=1; i<idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("sheep_idle/idle "+ i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(90, 75);
        }
        
        animationTimer.mark();
        
        // Initial sheep image
        setImage(idleRight[1]);
    }
    
    /**
     * Animate the sheep
     */
    int imageIndex = 0;
    public void animateSheep()
    {
        if(animationTimer.millisElapsed() < 60)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        
        eatOrange();
        eatPlum();
        
        //animate sheep
        animateSheep();
    }
    
    /**
     * eat orange and make a new orange if the orange is eaten.
     */
    public void eatOrange()
    {
        if(isTouching(Orange.class))
        {
            removeTouching(Orange.class);
            MyWorld world = (MyWorld) getWorld();
            world.createOrange();
            world.increaseScore();
            sheepSound.play();
        }
    }
    
    /**
     * eat plum and make a new plum if the orange is eaten.
     */
    public void eatPlum()
    {
        if(isTouching(Plum.class))
        {
            removeTouching(Plum.class);
            MyWorld world = (MyWorld) getWorld();
            world.createPlum();
            world.increaseScore();
            world.increaseScore();
            world.increaseScore();
            sheepSound.play();
        }
    }
}
