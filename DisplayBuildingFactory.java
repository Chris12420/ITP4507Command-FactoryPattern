import java.io.*;
import java.util.*;

public class DisplayBuildingFactory implements CommandFactory{
    private Vector<Building> buildings;
    private Caretaker ct;

    public DisplayBuildingFactory(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public DisplayBuildingFactory(){
    }

    public void setBuilding(Caretaker ct, Vector<Building> buildings){
        this.buildings = buildings;
        this.ct = ct;
    }

    public Command createCommand() throws IOException {
        return new DisplayBuilding(buildings);
    }
}






