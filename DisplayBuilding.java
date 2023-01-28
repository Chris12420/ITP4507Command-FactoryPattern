import java.util.*;

public class DisplayBuilding implements Command {
    private Vector<Building> buildings;

    public DisplayBuilding(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public void execute() throws Exception {
        System.out.println("Enter Building No.(* to display all): ");

        String id = Main.sc.next();
        if(id.equals("*")){
            for (int i = 0; i < buildings.size(); i++){
                System.out.println(buildings.elementAt(i).toString());
            }
        }else {
            int intId = Integer.parseInt(id);
            for (int i = 0; i < buildings.size(); i++){
                if((buildings.elementAt(i).getId() == intId)){
                    buildings.elementAt(i).printBuilding();
                }
            }
        }
    }

    public void undo(){
    }
    public void redo(){
    }
}











