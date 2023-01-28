import java.util.*;

public class CreateHouse implements Command{
    private Building build;
    private Caretaker ct;
    private int id;
    private int noOfRooms;
    private int noOfFloors;
    private Vector<Building> buildings;

    public CreateHouse(Caretaker ct, Vector<Building> buildings, int id, int noOfRooms, int noOfFloors){
        this.buildings = buildings;
        this.id = id;
        this.noOfFloors = noOfFloors;
        this.noOfRooms = noOfRooms;
    }

    public void execute() throws Exception {
        build = new House(id, noOfRooms, noOfFloors);

        for (int i = 1; i<= noOfRooms;i++){
            System.out.println("Room No. " + i + " :");
            System.out.print("length: ");
            double length = Main.sc.nextDouble();
            System.out.print("width: ");
            double width = Main.sc.nextDouble();
            build.getRooms().add(new Room(length, width));
        }
        System.out.print("New Building Added: \n");
        build.printBuilding();

        buildings.add(build);
    }

    public void undo(){
        buildings.remove(build);
    }
    public void redo(){
        buildings.add(build);
    }

    @Override
    public String toString() {
        return "Add Building: Building No.: " + id + " No of Floors: " + noOfFloors;
    }
}
