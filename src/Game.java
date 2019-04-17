public class Game
{
    private Grid grid;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;

    public Game()
    {
        grid = new Grid(10, 10);
        userRow = 0;
        userCol =  0;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, 0), "pacRight.PNG");
        //setImage(Location loc, String imageFileName)
    }
    public void handleKeyPress()
    {
        int key = grid.checkLastKeyPressed();
        int tempKey = key;
        if(grid.isValid(new Location(userRow-1,userCol)) && key == 38) //up
        {
            grid.setImage(new Location(userRow, userCol), null);
            userRow--;
            grid.setImage(new Location(userRow, userCol), "pacUp.PNG");
        }else{

        }
        if(grid.isValid(new Location(userRow+1,userCol)) && key == 40)  //down
        {
            grid.setImage(new Location(userRow, userCol), null);
            userRow++;
            grid.setImage(new Location(userRow, userCol), "pacDown.PNG");
        }else{

        }
        if(grid.isValid(new Location(userRow,userCol-1)) && key == 37)  //left
        {
            grid.setImage(new Location(userRow, userCol), null);
            userCol--;
            grid.setImage(new Location(userRow, userCol), "pacLeft.PNG");
        }else{

        }
        if(grid.isValid(new Location(userRow,userCol+1)) && key == 39)  //right
        {
            grid.setImage(new Location(userRow, userCol), null);
            userCol++;
            grid.setImage(new Location(userRow, userCol), "pacRight.PNG");
        }else{

        }
        //makes it so it doesn't pause when you change to an invalid direction

    }

    public void play()
    {
        while (!isGameOver())
        {
            grid.pause(100);
            handleKeyPress();
            updateTitle();
            msElapsed += 100;
        }
    }


    public void populateRightEdge()
    {
    }

    public void scrollLeft()
    {
    }

    public void handleCollision(Location loc)
    {
    }

    public int getScore()
    {
        return 0;
    }

    public void updateTitle()
    {
        grid.setTitle("Game:  " + getScore());
    }

    public boolean isGameOver()
    {
        return false;
    }

    public static void test()
    {
        Game game = new Game();
        game.play();
    }

    public static void main(String[] args)
    {
        Game.test();
    }
}
