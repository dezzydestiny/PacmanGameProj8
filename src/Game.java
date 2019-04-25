import java.io.IOException;

public class Game {
    private Grid grid;

    private int userRow;
    private int userCol;
    private int userDirection;
    private int key;

    private int msElapsed;
    private int timesGet;
    private int timesAvoid;

    private Map map;

    public Game() throws IOException {
        grid = new Grid(25, 25);
        userRow = 1;
        userCol = 1;
        userDirection = -1;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, userCol), "pacRight.PNG");
        map = new Map();
        map.drawSelf(grid);

    }

    public void handleKeyPress() {
        key = grid.checkLastKeyPressed();
        calcUserDirection();
        changeUserDirection();
    }

    public void play() {
        while (!isGameOver()) {
            grid.pause(100);
            handleKeyPress();
            updateTitle();
            msElapsed += 100;
        }
    }

    private void calcUserDirection() {
        if (grid.isValid(new Location(userRow - 1, userCol)) && map.isValid(new Location(userRow - 1, userCol)) && key == 38) { //up
            userDirection = 0;
        } else if (grid.isValid(new Location(userRow + 1, userCol)) && map.isValid(new Location(userRow + 1, userCol)) && key == 40) { //down
            userDirection = 1;
        } else if (grid.isValid(new Location(userRow, userCol - 1)) && map.isValid(new Location(userRow, userCol - 1)) && key == 37) { //left
            userDirection = 2;
        } else if (grid.isValid(new Location(userRow, userCol + 1)) && map.isValid(new Location(userRow, userCol + 1)) && key == 39) { //right
            userDirection = 3;
        }
    }

    private void changeUserDirection() {
        if (verifyAllValid(new Location(userRow - 1, userCol)) && userDirection == 0) {
            grid.setImage(new Location(userRow, userCol), null);
            userRow--;
            grid.setImage(new Location(userRow, userCol), "pacUp.PNG");
        } else if (verifyAllValid(new Location(userRow + 1, userCol)) && userDirection == 1) {
            grid.setImage(new Location(userRow, userCol), null);
            userRow++;
            grid.setImage(new Location(userRow, userCol), "pacDown.PNG");
        } else if (verifyAllValid(new Location(userRow, userCol - 1)) && userDirection == 2) {
            grid.setImage(new Location(userRow, userCol), null);
            userCol--;
            grid.setImage(new Location(userRow, userCol), "pacLeft.PNG");
        } else if (verifyAllValid(new Location(userRow, userCol + 1)) && userDirection == 3) {
            grid.setImage(new Location(userRow, userCol), null);
            userCol++;
            grid.setImage(new Location(userRow, userCol), "pacRight.PNG");
        }
    }

    private boolean verifyAllValid(Location loc) {
        return grid.isValid(loc) && map.isValid(loc);
    }

    public void handleCollision(Location loc) {

    }

    public int getScore() {
        return 0;
    }

    public void updateTitle() {
        grid.setTitle("Pacman: " + getScore());
    }

    public boolean isGameOver() {
        return false;
    }

    public static void test() throws IOException {
        Game game = new Game();
        game.play();
    }

    public static void main(String[] args) throws IOException {
        Game.test();
    }
}
