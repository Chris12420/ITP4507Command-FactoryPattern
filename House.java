public class House extends Building{
    private int noOfFloors;

    public House(int id, int noOfRooms, int noOfFloors) {
        super(id, noOfRooms);
        this.noOfFloors = noOfFloors;
    }

    @Override
    public void modifyBuilding() {
    }

    @Override
    public void printBuilding() {
        System.out.println("Building No: " + this.getId() + "\nNo of Floors: " + noOfFloors);
        for(Room room:this.getRooms()) {
            System.out.println("Room No.: "+ (this.getRooms().indexOf(room)+1) + " Length: " + room.getLength() + " Width: " + room.getWidth());
        }
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    @Override
    public String toString() {
        return "Building No: " + this.getId() + ", No. of Floor: " + noOfFloors;
    }
}






