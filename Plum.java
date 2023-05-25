import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plum extends Actor
{
    int speed = 1;
    
    public void act()
    {
        setLocation(getX(), getY()+speed);
        
        //remove plum and decrease score when it gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.decreaseScore();
            world.createPlum();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
