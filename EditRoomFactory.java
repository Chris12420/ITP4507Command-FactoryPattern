import java.io.*;
import java.util.*;

public class EditRoomFactory implements CommandFactory{
    private Vector<Building> buildings;
    private Caretaker ct;

    public EditRoomFactory(Vector<Building> buildings){
        this.buildings = buildings;
    }

    public EditRoomFactory(){
    }

    public void setBuilding(Caretaker ct, Vector<Building> buildings){
        this.buildings = buildings;
        this.ct = ct;
    }

    public Command createCommand() throws IOException {
        System.out.print("Building No.: ");
        int id = Main.sc.nextInt();

        for (int i = 0; i < buildings.size(); i++) {
            if ((buildings.elementAt(i)).getId() == id) {
                buildings.elementAt(i).printBuilding();

                System.out.println();
                System.out.println("Please enter command: [a|d|m]\n" + "a = add room, d = delete room, m = modify room");
                String editRoomChoice = Main.sc.next();

                if (editRoomChoice.equals("a")) {
                    return new EditRoomAdd(ct, buildings, buildings.elementAt(i));
                } else if (editRoomChoice.equals("d")) {
                    return new EditRoomDelete(ct, buildings, buildings.elementAt(i));
                } else if (editRoomChoice.equals("m")) {
                    return new EditRoomModify(ct, buildings, buildings.elementAt(i));
                }
            }
        }
        return null;
    }
}









