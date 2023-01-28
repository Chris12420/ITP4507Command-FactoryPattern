import java.io.*;
import java.util.Vector;

public interface CommandFactory {
    public Object createCommand() throws IOException;
    public void setBuilding(Caretaker ct, Vector<Building> buildings);
}
