import java.util.*;

class HouseModifyRoomMemento implements Memento{
    private House _house;
    private int _id;
    private ArrayList<Room> _rooms;
    private double _rmLength;
    private double _rmWidth;
    private int _rmID;
    private double _newLength;
    private double _newWidth;

    public HouseModifyRoomMemento(House house, int rmId, double length, double width){
        this._house = house;
        this._id = house.getId();
        this._rooms = house.getRooms();
        this._rmLength = house.getRooms().get(rmId-1).getLength();
        this._rmWidth = house.getRooms().get(rmId-1).getWidth();
        this._rmID = rmId;
        this._newLength = length;
        this._newWidth = width;
    }

    public void restore(){
        double _rmLength = _house.getRooms().get(_house.getRoomQty()-1).getLength();
        double _rmWidth = _house.getRooms().get(_house.getRoomQty()-1).getWidth();

        _house.getRooms().get(_rmID-1).setLength(this._rmLength);
        _house.getRooms().get(_rmID-1).setWidth(this._rmWidth);

        this._rmLength = _rmLength;
        this._rmWidth = _rmWidth;
    }

    public Building getBuild() {
        return this._house;
    }

    // show the undo/redo list message of edit room / building
    public String toString() {
        return "Modify Room: Building No: " + _house.getId() + "  Room No. " + _rmID + " Length: "+ _newLength + " Width: " + _newWidth;
    }

}

