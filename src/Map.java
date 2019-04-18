import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
    private ArrayList<Location> walls = new ArrayList<>();

    public Map() throws IOException{
        BufferedImage toBeRendered = ImageIO.read(new File("src/map1.png"));
        for(int row = 0;row<toBeRendered.getHeight();row++){
            for(int col = 0;col<toBeRendered.getWidth();col++){
                int renderedColor = toBeRendered.getRGB(row,col);
                if (renderedColor == -16777216){
                    walls.add(new Location(col,row));
                }
            }
        }
    }

    public ArrayList<Location> getWalls(){
        return walls;
    }

    public void drawSelf(Grid grid){
        for(int i = 0;i < walls.size();i++){
            grid.setColor(walls.get(i),new Color(17,24,82));
        }
    }

    public boolean isValid(Location loc){
        int row = loc.getRow();
        int col = loc.getCol();
        for(int i = 0;i < walls.size();i++){
            if(row == walls.get(i).getRow() && col == walls.get(i).getCol()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args) throws IOException {
        Map map = new Map();
        System.out.println(map.getWalls());
    }
}
