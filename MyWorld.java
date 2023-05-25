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
    int level = 1;
    
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
        
        if(score < 0)
        {
            gameOver();
        }
        
        createOrange();
        createBomb();
        createPlum();
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
        
        if(score % 8 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * decrease score
     */
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
    }
    
    /**
     * create a new orange at random location at top of screen.
     */
    public void createOrange()
    {
        Orange orange = new Orange();
        orange.setSpeed(level);
        int x1 = Greenfoot.getRandomNumber(600);
        addObject(orange, x1, 0);
    }
    
    /**
     * create a new bomb at random location at top of screen.
     */
    public void createBomb()
    {
        Bomb bomb = new Bomb();
        int x2 = Greenfoot.getRandomNumber(600);
        addObject(bomb, x2, 0);
    }
    
    /**
     * create a new plum at random location at top of screen.
     */
    public void createPlum()
    {
        Plum plum = new Plum();
        plum.setSpeed(level);
        int x3 = Greenfoot.getRandomNumber(600);
        addObject(plum, x3, 0);
    }
}
