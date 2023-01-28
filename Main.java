import java.util.*;
import java.io.*;

public class Main {
	//Global declaration for Scanner
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Vector<Building> buildings = new Vector<Building>();
		ArrayList<Object> undoList = new ArrayList <>();
		ArrayList<Object> redoList = new ArrayList <>();
		Command com;
		CommandFactory cf;
		String [] factories = {"DisplayBuildingFactory", "CreateApartmentFactory", "CreateHouseFactory", "ModifyBuildingFactory", "EditRoomFactory"};
		CommandFactory[] comFactories = new CommandFactory[factories.length];
		Caretaker ct = new Caretaker(undoList, redoList);

		try {
			for (int i = 0; i < factories.length; i++) {
				comFactories[i] = (CommandFactory) Class.forName(factories[i]).newInstance();
				comFactories[i].setBuilding(ct, buildings);
			}
		}catch (Exception e) {
			System.out.println("*** " + e.getMessage());
		}

		while (true) {
			try {
				System.out.println("Building Management System (BMS)\n" + "Please enter command: [a|d|m|e|u|r|l|x]\n" + "a = add building, d = display buildings, m = modify building, e = edit rooms\n" +
						"u = undo, r = redo, l = list undo/redo, x = exit system");
				String option = sc.next();
				if(option.equals("x") || option.equals("X")){
					System.out.println("-- End --");
					System.exit(0);
				} else if(option.equals("u")){
					ct.undo();
				}
				else if(option.equals("r")) {
					ct.redo();
				}else if(option.equals("a")){
					System.out.println("Enter Building Type (a=Apartment/h=House):");
					String optionBuildType = sc.next();
					cf = ((optionBuildType.equals("a")) ? comFactories[1] : comFactories[2]);
					com = (Command) cf.createCommand();
					com.execute();
					undoList.add(com);
				}
				else if(option.equals("d")){
					cf = comFactories[0];
					com = (Command) cf.createCommand();
					com.execute();
				}
				else if(option.equals("l")){
					System.out.println("Undo List:");
					for (int i = undoList.size() - 1; i >= 0; i--) {
						System.out.println(undoList.get(i));
					}
					System.out.println();
					System.out.println("Redo List:");
					for (int i = redoList.size() - 1; i >= 0; i--) {
						System.out.println(redoList.get(i));
					}
					if(redoList.size() == 0){
						System.out.println("Nothing to Redo.");
					}
				}
				else if(option.equals("e")){
					cf = comFactories[4];
					com = (Command) cf.createCommand();
					com.execute();
					if (!(com instanceof EditRoomModify)){
						undoList.add(com);
					}
				}
				else if(option.equals("m")) {
					cf = comFactories[3];
					com = (Command) cf.createCommand();
					com.execute();
				}
			} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
			}
			System.out.println();
		}
	}
}
