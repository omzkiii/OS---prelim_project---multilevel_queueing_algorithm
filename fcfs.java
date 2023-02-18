import java.util.ArrayList;

public class fcfs {
	public static void runFcfs(ArrayList<Process> processList){

		for(int i = 0; i < processList.size(); i++) {
			int j = 1;
			while (j<=processList.get(i).burstTime){
					System.out.println(processList.get(i).processName + ": "  + j + "/" + processList.get(i).burstTime);
				    processList.get(i).run();
					j++;
				}
				System.out.println(processList.get(i).processName + " completed!");
		}

		Process.setTime(processList);
		Process.printTime(processList);
	}
	
}
