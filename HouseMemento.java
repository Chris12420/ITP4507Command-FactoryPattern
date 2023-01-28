import java.util.*;

class HouseMemento implements Memento{
    private House _house;
    private int _id;
    private ArrayList<Room> _rooms;
    private int _noOfFloors;
    private int _newNoOfFloors;

    public HouseMemento(House house, int noOfFloors){
        this._house = house;
        this._id = house.getId();
        this._rooms = house.getRooms();
        this._noOfFloors = house.getNoOfFloors();
        this._newNoOfFloors = noOfFloors;
    }

    public void restore(){
        int _noOfFloors = _house.getNoOfFloors();

        _house.setNoOfFloors(this._noOfFloors);

        this._noOfFloors = _noOfFloors;
    }

    // show the undo/redo list message of edit room / building
    public String toString() {
            return "Modify Building: Building No: " + this._id + " No of Floors: " + this._newNoOfFloors;
    }
}

