import java.util.*;

public class Caretaker {
    private ArrayList<Object> undoList;
    private ArrayList<Object> redoList;

    public Caretaker(){
        undoList = new ArrayList <>();
        redoList = new ArrayList <>();
    }

    public Caretaker(ArrayList<Object> undoList, ArrayList<Object> redoList) {
        this.undoList = undoList;
        this.redoList = redoList;
    }

    public void rememberModifyApartmentBuilding(Building object, double modifyMonthlyRental, String modifySupportStaff) {
            this.undoList.add(new ApartmentMemento((Apartment) object, modifyMonthlyRental, modifySupportStaff));
    }

    public void rememberModifyHouseBuilding(Building object, int noOfFloors) {
            this.undoList.add(new HouseMemento((House) object, noOfFloors));
    }

    public void rememberModifyRoom(Building object, int rmId, double length, double width) {
        if (object instanceof Apartment) {
            this.undoList.add(new ApartmentModifyRoomMemento((Apartment) object , rmId, length, width));
        }else if(object instanceof House) {
            this.undoList.add(new HouseModifyRoomMemento((House) object, rmId, length, width));
        }
    }

    public void undo(){
        if(undoList.size() > 0){
            Object lastEle = undoList.remove(undoList.size() - 1);
            if(lastEle instanceof Command com){
                redoList.add(com);
                com.undo();
            }else if(lastEle instanceof Memento com){
            com.restore();
            redoList.add(com);
            }
        }
    }

    public void redo(){
        if(redoList.size() > 0){
            Object lastEle = redoList.remove(redoList.size() - 1);
            if(lastEle instanceof Command com){
                undoList.add(com);
                com.redo();
            }else if(lastEle instanceof Memento com){
                com.restore();
                undoList.add(com);
            }
        }
    }
}
