import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Sheep, our hero.
 * 
 * @author Kaylee Ke 
 * @version May 2023
 */
public class Sheep extends Actor
{
    /**
     * Act - do whatever the Sheep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        }
    }
}
