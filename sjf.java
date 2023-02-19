import java.util.ArrayList;
import java.util.Collections;

public class sjf {
    public static float awt;
	public static float att;
    public static void runSjf(ArrayList<Process> processList){
        ArrayList<Process> sortedProcess = new ArrayList<>();
        sortedProcess = processList;
        //INSERTION SORT
        for (int j = 1; j < sortedProcess.size(); j++) {  
            Process key = sortedProcess.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( sortedProcess.get(i).burstTime > key.burstTime ) ) {
                Collections.swap(sortedProcess, i+1, i);
                i--;  
            }  
            sortedProcess.set(i+1, key);  
        }

        //PROCESS EXECUTION
        int time = 0;
        for(int i = 0; i < processList.size(); i++) {
			int j = 1;
            processList.get(i).startTime = time;
			while (j<=processList.get(i).burstTime){
					System.out.println(processList.get(i).processName + ": "  + j + "/" + processList.get(i).burstTime);
                    time = time + 1;
				    processList.get(i).run();
					j++;
				}
				System.out.println(processList.get(i).processName + " completed at " + time + " second/s.");
                processList.get(i).endTime = time;
		}

        //Process.setTime(sortedProcess);
        float[] arr = new float[2];
		arr = Process.printTime(processList);
		awt = arr[0];
		att = arr[1];
    }
}
