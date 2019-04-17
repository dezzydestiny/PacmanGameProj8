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
    grid.setImage(new Location(userRow, 0), "user.gif");
    //setImage(Location loc, String imageFileName)
  }
  public void handleKeyPress()
  {
    int key = grid.checkLastKeyPressed();
    if(userRow > 0 && userRow<=100 && key == 38) //up
    {
      grid.setImage(new Location(userRow, userCol), null);
      userRow--;
      grid.setImage(new Location(userRow, userCol), "user.gif");
    }
    else if(userRow < 100 &&userRow>=0 && key == 40)  //down
    {
      grid.setImage(new Location(userRow, userCol), null);
      userRow++;
      grid.setImage(new Location(userRow, userCol), "user.gif");
    }
    else if(userCol>0 && userCol <= 100 && key == 37)  //left
    {
      grid.setImage(new Location(userRow, userCol), null);
      userCol--;
      grid.setImage(new Location(userRow, userCol), "user.gif");
    }
    else if(userCol < 100 && userCol>=0 && key == 39)  //right
    {
      grid.setImage(new Location(userRow, userCol), null);
      userCol++;
      grid.setImage(new Location(userRow, userCol), "user.gif");
    }
    else
      grid.setImage(new Location(userRow, userCol), "user.gif");
  }

  public void play()
  {
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
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
