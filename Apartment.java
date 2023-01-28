public class Apartment extends Building{
    private double monthlyRental;
    private String supportStaff;

    public Apartment(int id, int noOfRooms, double monthlyRental, String supportStaff) {
        super(id, noOfRooms);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }


    public double getMonthlyRental() {
        return monthlyRental;
    }

    public void setMonthlyRental(double monthlyRental) {
        this.monthlyRental = monthlyRental;
    }

    public String getSupportStaff() {
        return supportStaff;
    }

    public void setSupportStaff(String supportStaff) {
        this.supportStaff = supportStaff;
    }

    @Override
    public void modifyBuilding() {
    }

    @Override
    public void printBuilding() {
       System.out.println("Building No: " + this.getId() + "\nSupport Staff: " + this.getSupportStaff()+ "\nMonthly Rental: "+ this.getMonthlyRental());
        for(Room room:this.getRooms()) {
            System.out.println("Room No.: "+ (this.getRooms().indexOf(room)+1) + " Length: " + room.getLength() + " Width: " + room.getWidth());
        }
    }

    @Override
    public String toString() {
        return "Building No: " + this.getId() + ", Support Staff: " + supportStaff  + ", Monthly Rental: " + monthlyRental;
    }
}







