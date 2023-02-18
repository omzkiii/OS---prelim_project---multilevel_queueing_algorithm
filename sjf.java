import java.util.ArrayList;
import java.util.Collections;

public class sjf {
    public static void runSjf(ArrayList<Process> processList){
        ArrayList<Process> sortedProcess = new ArrayList<>();
        sortedProcess = processList;

        for (int j = 1; j < sortedProcess.size(); j++) {  
            Process key = sortedProcess.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( sortedProcess.get(i).burstTime > key.burstTime ) ) {
                Collections.swap(sortedProcess, i+1, i);
                i--;  
            }  
            sortedProcess.set(i+1, key);  
        }
        for(int i = 0; i < processList.size(); i++) {
			int j = 1;
			while (j<=processList.get(i).burstTime){
					System.out.println(processList.get(i).processName + ": "  + j + "/" + processList.get(i).burstTime);
				    processList.get(i).run();
					j++;
				}
				System.out.println(processList.get(i).processName + " completed!");
		}

        Process.setTime(sortedProcess);
        Process.printTime(sortedProcess);
    }
}
