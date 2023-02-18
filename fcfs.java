import java.util.ArrayList;

public class fcfs {
	public static void runFcfs(ArrayList<Process> processList){
		for(int i = 1; i < processList.size(); i++) {			
			processList.get(i).endTime = processList.get(i).burstTime + processList.get(i-1).endTime;
			processList.get(i).startTime = processList.get(i-1).endTime;
		}
		for(int i = 0; i < processList.size(); i++) {
			processList.get(i).run();
				
		}
		for (int i=0; i<processList.size(); i++) {
        	Process outstring = processList.get(i);
        	System.out.println("Name: "+outstring.processName + " BT: " + outstring.burstTime  + " ST: " + outstring.startTime  + " ET: " + outstring.endTime);
        	}
	}
	
}
