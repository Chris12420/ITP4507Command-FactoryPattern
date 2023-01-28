import java.util.*;

public class EditRoomModify implements Command{
    private Building build;
    private Caretaker ct;
    private Vector<Building> buildings;

    public EditRoomModify(Caretaker ct, Vector<Building> buildings, Building build){
        this.ct = ct;
        this.buildings = buildings;
        this.build = build;
    }

    public void execute() throws Exception {
        System.out.print("Room No.: ");
        int id = Main.sc.nextInt();
        System.out.print("length: ");
        double length = Main.sc.nextDouble();
        System.out.print("width: ");
        double width = Main.sc.nextDouble();

        ct.rememberModifyRoom(build, id, length, width);
        build.modifyRoom(id, length, width);
        build.printBuilding();
    }

    public void undo(){
    }
    public void redo(){
    }
}
