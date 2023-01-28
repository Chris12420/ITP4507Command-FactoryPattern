import java.io.*;
import java.util.*;

public class CreateApartmentFactory implements CommandFactory{
    // all the shape will store here
    private Vector<Building> buildings;

    private Caretaker ct;

    public CreateApartmentFactory(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public CreateApartmentFactory(){
    }

    public void setBuilding(Caretaker ct, Vector<Building> buildings){
        this.buildings = buildings;
        this.ct = ct;
    }

    public Command createCommand() throws IOException {
        System.out.print("Building No.: ");
        int id = Main.sc.nextInt();
        System.out.print("Monthly Rental: ");
        double monthlyRental = Main.sc.nextDouble();

        System.out.print("Support Staff: ");

        Main.sc.nextLine();
        String supportStaff = Main.sc.nextLine();

        System.out.print("Number of rooms: ");
        int noOfRooms = Main.sc.nextInt();

        return new CreateApartment(ct, buildings, id, noOfRooms, monthlyRental, supportStaff);
    }
}








