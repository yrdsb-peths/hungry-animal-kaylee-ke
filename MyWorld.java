import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero lives in.
 * 
 * @author Kaylee Ke 
 * @version May 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Sheep sheep = new Sheep();
        addObject(sheep, 300, 370);
        
        scoreLabel = new Label(0,40);
        addObject(scoreLabel ,20 ,20);
        
        createOrange();
        
    }
    
    /**
     * end the game and draw "Game Over"
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * create a new orange at random location at top of screen.
     */
    public void createOrange()
    {
        Orange orange = new Orange();
        int x = Greenfoot.getRandomNumber(600);
        addObject(orange, x, 0);
    }
}
