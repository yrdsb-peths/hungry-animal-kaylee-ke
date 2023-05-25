import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our sheep.
 * 
 * @author Kaylee Ke 
 * @version May 2023;
 */
public class Orange extends Actor
{
    int speed = 1;
    
    public void act()
    {
        setLocation(getX(), getY()+speed);
        
        //remove orange and decrease score when it gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.decreaseScore();
            world.decreaseScore();
            world.createOrange();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
