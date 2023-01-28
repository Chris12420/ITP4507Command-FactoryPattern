import java.util.*;

// this class is store the data before modify building
class ApartmentModifyRoomMemento implements Memento{
//    private Apartment customer;

    // this is the building for the current building
    private Apartment _apartment;

    // may not need
    private int _id;
    private ArrayList<Room> _rooms;

    private double _rmLength;
    private double _rmWidth;

    private int _rmID;
    private double _newLength;
    private double _newWidth;

    public ApartmentModifyRoomMemento(Apartment apartment, int rmId, double length, double width){
        this._apartment = apartment;

        this._rmLength = apartment.getRooms().get(rmId-1).getLength();
        this._rmWidth = apartment.getRooms().get(rmId-1).getWidth();

        this._id = apartment.getId();
        this._rooms = apartment.getRooms();

        this._rmID = rmId;

        this._newLength = length;
        this._newWidth = width;
    }


    public void restore(){
        double _rmLength = _apartment.getRooms().get(_apartment.getRoomQty()-2).getLength();
        double _rmWidth = _apartment.getRooms().get(_apartment.getRoomQty()-2).getWidth();

        _apartment.getRooms().get(_rmID-1).setLength(this._rmLength);
        _apartment.getRooms().get(_rmID-1).setWidth(this._rmWidth);

        this._rmLength = _rmLength;
        this._rmWidth = _rmWidth;
    }

    // show the undo/redo list message of edit room / building
    public String toString() {
        return "Modify Room: Building No: " + _apartment.getId() + "  Room No. " + _rmID + " Length: "+ _newLength + " Width: " + _newWidth;
    }
}
