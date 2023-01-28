import java.io.*;
import java.util.*;

public class ModifyBuildingFactory implements CommandFactory{
    private Vector<Building> buildings;
    private Caretaker ct;

    public ModifyBuildingFactory(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public ModifyBuildingFactory(){
    }

    public void setBuilding(Caretaker ct, Vector<Building> buildings){
        this.ct = ct;
        this.buildings = buildings;
    }

    public Command createCommand() throws IOException {
        return new ModifyBuilding(buildings, ct);
    }
}








