import java.util.ArrayList;

public class fcfs {
	public static float awt;
	public static float att;
	public static void runFcfs(ArrayList<Process> processList){

		// PROCESS EXECUTION
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

		//Process.setTime(processList);
		float[] arr = new float[2];
		arr = Process.printTime(processList);
		awt = arr[0];
		att = arr[1];
	}
}
