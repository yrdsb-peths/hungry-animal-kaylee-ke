import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @Kaylee Ke
 * @version May 2023
 */
public class titleScreen extends World
{
    Label titleLabel = new Label("Hungry Sheep",60);
    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 235, 75);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Sheep sheep = new Sheep();
        addObject(sheep,517,254);
        sheep.setLocation(541,111);
        sheep.setLocation(510,82);
        sheep.setLocation(514,59);
        sheep.setLocation(523,76);
        Label label = new Label("Press <space> to start", 30);
        addObject(label,341,268);
        label.setLocation(321,165);
        label.setLocation(344,134);
        label.setLocation(306,125);
        label.setLocation(353,161);
        Label label2 = new Label("Use → and ← to move", 30);
        addObject(label2,377,228);
        label2.setLocation(340,215);
    }
}
