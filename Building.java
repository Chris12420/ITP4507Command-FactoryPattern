import java.util.*;

public abstract class Building{
    private int id;
    private ArrayList<Room> rooms;

    public Building(int id, int noOfRooms){
        this.id = id;
        this.rooms = new ArrayList<Room>(noOfRooms);
    }

    public int getId(){
        return id;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public Room addRoom(double length, double width){
        Room addRoom = new Room(length, width);
        rooms.add(addRoom);
        return rooms.get(rooms.size() - 1);
    }

    public void modifyRoom(int roomNo, double length, double width){
        Room modifyRoom = new Room(length, width);
        rooms.set(roomNo-1, modifyRoom);
    }

    public void deleteRoom(int roomNo){
        rooms.remove(roomNo-1);
    }

    public void printRooms(int roomNo){
        System.out.println("Room No.: " + roomNo + ", Length: " + getRooms().get(roomNo).getLength() + "Width: " + rooms.get(roomNo).getWidth());
    }

    public int getRoomQty(){
        return rooms.size();
    }

    public abstract void modifyBuilding();
    public abstract void printBuilding();
}
