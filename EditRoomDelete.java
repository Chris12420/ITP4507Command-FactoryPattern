import java.util.*;

public class EditRoomDelete implements Command{
    private Building build;
    private Caretaker ct;
    private Vector<Building> buildings;
    private int rmIndex;
    private double rmLength;
    private double rmWidth;
    private int rmDeleteNum;
    private Room rm;

    public EditRoomDelete(Caretaker ct, Vector<Building> buildings, Building build){
        this.buildings = buildings;
        this.ct = ct;
        this.build = build;
    }

    public void execute() throws Exception {
        System.out.println("Room No.: ");
        int roomNum = Main.sc.nextInt();
        this.rmLength = build.getRooms().get(roomNum-1).getLength();
        this.rmWidth = build.getRooms().get(roomNum-1).getWidth();
        this.rmIndex = build.getRoomQty();
        this.rmDeleteNum = roomNum;
        this.rm = new Room(rmLength, rmWidth);

        build.deleteRoom(roomNum);
        build.printBuilding();
    }

    public void undo(){ ;
        build.getRooms().add(rmDeleteNum-1, rm);
    }
    public void redo(){
        build.deleteRoom(rmDeleteNum);
    }

    @Override
    public String toString() {
        return "Delete Room: Building No: " + build.getId() + "  Room No. " + rmDeleteNum + " Length: "+ rmLength + " Width: " + rmWidth;
    }
}


