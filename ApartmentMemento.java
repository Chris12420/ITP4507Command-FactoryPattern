import java.util.*;

// this class is store the data before modify building
class ApartmentMemento implements Memento{

    // this is the building for the current building
    private Apartment _apartment;

    private int _id;
    private ArrayList<Room> _rooms;

    private double _monthlyRental;
    private String _supportStaff;

    private double _newMonthlyRental;
    private String _newSupportStaff;

    public ApartmentMemento(Apartment apartment, double modifyMonthlyRental, String modifySupportStaff){
        this._apartment = apartment;
        this._id = apartment.getId();
        this._rooms = apartment.getRooms();
        this._monthlyRental = apartment.getMonthlyRental();
        this._supportStaff = apartment.getSupportStaff();

        this._newMonthlyRental = modifyMonthlyRental;
        this._newSupportStaff = modifySupportStaff;
    }


    public void restore(){
        double _monthlyRental = _apartment.getMonthlyRental();
        String _supportStaff = _apartment.getSupportStaff();

        _apartment.setMonthlyRental(this._monthlyRental);
        _apartment.setSupportStaff(this._supportStaff);

        this._monthlyRental = _monthlyRental;
        this._supportStaff = _supportStaff;
    }

    // show the undo/redo list message of edit room / building
    public String toString() {
            return "Modify Building: Building No: " + this._id + " Support Staff: " + this._newSupportStaff + " Monthly Rental: "+ this._newMonthlyRental;
    }
}
