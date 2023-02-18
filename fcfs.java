import java.util.ArrayList;

public class fcfs {
	public static void runFcfs(ArrayList<Process> processList){

		for(int i = 0; i < processList.size(); i++) {
			processList.get(i).run();
		}
		
		Process.setTime(processList);
		Process.printTime(processList);
	}
	
}
