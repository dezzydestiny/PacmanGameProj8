import java.awt.*;
import java.util.ArrayList;

public abstract class Dot {
    ArrayList<Location> dotLocation;
    String imageFileName;

    public void addDot(Location loc){
        dotLocation.add(loc);
    }

    public void removeDot(Location loc){
        for (int i = 0; i < dotLocation.size(); i++){
            if(dotLocation.get(i).equals(loc)){
                dotLocation.remove(i);
                break;
            }
        }
        System.out.println("No Dot Found at given Location");
    }

    public void drawSelf(Grid g){
        //stuff
    }
}
