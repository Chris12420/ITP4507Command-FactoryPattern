import java.util.*;

public class CreateApartment implements Command{
    private Building build;
    private Caretaker ct;
    private int id;
    private int noOfRooms;
    private double monthlyRental;
    private String supportStaff;
    private Vector<Building> buildings;

    public CreateApartment(Caretaker ct, Vector<Building> buildings, int id, int noOfRooms, double monthlyRental, String supportStaff){
        this.ct = ct;
        this.buildings = buildings;
        this.id = id;
        this.noOfRooms = noOfRooms;
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }

    public void execute() throws Exception {
        build = new Apartment(id, noOfRooms, monthlyRental, supportStaff);

        for (int i = 1; i<= noOfRooms;i++){
            System.out.println("Room No. " + i + ":");
            System.out.print("length: ");
            double length = Main.sc.nextDouble();
            System.out.print("width: ");
            double width = Main.sc.nextDouble();
            build.addRoom(length, width);
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
        return "Add Building: Building No.: " + id + " Support Staff: " + supportStaff + " Monthly Rental: "+ monthlyRental;
    }
}




