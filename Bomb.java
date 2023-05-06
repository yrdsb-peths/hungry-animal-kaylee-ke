import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()+1);
        
        //remove bomb when bomb gets to bottom
        //remove bomb when sheep touches the bomb and draw gameover
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.createBomb();
        }
        else if(isTouching(Sheep.class) || world.score < 0)
        {
            world.gameOver();
            world.removeObject(this);
            Greenfoot.stop();
        }
        
    }
}
