import java.io.*;
import java.util.*;

public class EditRoomAdd implements Command{
    private Building build;
    private Caretaker ct;
    private Vector<Building> buildings;
    private int rmIndex;
    private double newRmLeugth;
    private double newRmWidth;
    private Room rm;

    public EditRoomAdd(Caretaker ct, Vector<Building> buildings, Building build){
        this.buildings = buildings;
        this.ct = ct;
        this.build = build;
    }

    public void execute() throws Exception {
        System.out.print("length: ");
        double length = Main.sc.nextDouble();
        System.out.print("width: ");
        double width = Main.sc.nextDouble();

        rm = build.addRoom(length, width);
        newRmLeugth = length;
        newRmWidth = width;
        rmIndex = build.getRoomQty();
        build.printBuilding();
    }

    public void undo(){
        build.deleteRoom(rmIndex);
    }

    public void redo(){
        build.getRooms().add(rmIndex-1, rm);
    }

    @Override
    public String toString() {
        return "Add Room: Building No: " + build.getId() + "  Room No. " + rmIndex + " Length: "+ newRmLeugth + " Width: " + newRmWidth;
    }
}
