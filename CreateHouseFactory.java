import java.io.*;
import java.util.*;

public class CreateHouseFactory implements CommandFactory{
    private Vector<Building> buildings;

    private Caretaker ct;

    public CreateHouseFactory(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public CreateHouseFactory(){
    }

    public void setBuilding(Caretaker ct, Vector<Building> buildings){
        this.buildings = buildings;
        this.ct = ct;
    }

    public Command createCommand() throws IOException {
        System.out.print("Building No.: ");
        int id = Main.sc.nextInt();
        System.out.print("No. of Floors: ");
        int noOfFloors = Main.sc.nextInt();
        System.out.print("Number of rooms: ");
        int noOfRooms = Main.sc.nextInt();
        return new CreateHouse(ct, buildings, id, noOfRooms, noOfFloors);
    }
}












