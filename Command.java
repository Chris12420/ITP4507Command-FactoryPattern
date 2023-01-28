import java.io.*;

public interface Command {
    public void execute() throws Exception;
    public void undo();
    public void redo();
}