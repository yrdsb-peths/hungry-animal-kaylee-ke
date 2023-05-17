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
    GreenfootImage[] idle = new GreenfootImage[7];
    
    /**
     * Constructor - The code that gets run one time whrn objects is created
     */
    public Sheep()
    {
        for(int i=1; i<idle.length; i++)
        {
            idle[i] = new GreenfootImage("sheep_idle/idle "+ i + ".png");
            idle[i].scale(90, 75);
        }
        setImage(idle[1]);
    }
    
    /**
     * Animate the sheep
     */
    int imageIndex = 0;
    public void animateSheep()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
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
