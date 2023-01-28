import java.util.*;

public class ModifyBuilding implements Command{
    private Caretaker ct;
    private Vector<Building> buildings;

    public ModifyBuilding(Vector<Building> buildings, Caretaker ct){
        this.buildings = buildings;
        this.ct = ct;
    }

    public void execute() throws Exception {
        System.out.print("Building No.: ");
        int id = Main.sc.nextInt();

        try {
            for (int i = 0; i < buildings.size(); i++){
                if((buildings.elementAt(i) instanceof Apartment) && (buildings.elementAt(i)).getId() == id){
                    System.out.println("Building No: " + (buildings.elementAt(i)).getId() + " Support Staff: " + ((Apartment) buildings.elementAt(i)).getSupportStaff() + " Monthly Rental: "+ ((Apartment) buildings.elementAt(i)).getMonthlyRental());
                    System.out.print("Modify Monthly Rental: ");
                    double modifyMonthlyRental = Main.sc.nextDouble();
                    System.out.print("Modify Support Staff: ");
                    Main.sc.nextLine();
                    String modifySupportStaff = Main.sc.nextLine();

                    ct.rememberModifyApartmentBuilding((buildings.elementAt(i)), modifyMonthlyRental, modifySupportStaff);

                    // run command
                    ((Apartment) buildings.elementAt(i)).setMonthlyRental(modifyMonthlyRental);
                    ((Apartment) buildings.elementAt(i)).setSupportStaff(modifySupportStaff);

                    System.out.println("Building is modified: ");
                    System.out.println(buildings.elementAt(i).toString());

                }else if((buildings.elementAt(i) instanceof House) && (buildings.elementAt(i)).getId() == id){
                    System.out.println("Building No: " + (buildings.elementAt(i)).getId() + " No of Floors: " + ((House) buildings.elementAt(i)).getNoOfFloors());
                    System.out.print("No. of Floors: ");
                    int noOfFloors = Main.sc.nextInt();

                    ct.rememberModifyHouseBuilding((buildings.elementAt(i)), noOfFloors);

                    ((House) buildings.elementAt(i)).setNoOfFloors(noOfFloors);

                    System.out.print("Building is modified: ");
                    System.out.println(buildings.elementAt(i).toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void undo(){
    }
    public void redo(){
    }
}
