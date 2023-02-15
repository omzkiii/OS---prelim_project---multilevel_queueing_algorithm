import java.util.ArrayList;
import java.util.Scanner;

public class run {
    public static void main(String[] args) throws InterruptedException {
    	Scanner in = new Scanner(System.in);
    	ArrayList<Process> processList = new ArrayList<>();
        fcfs.runFcfs(processList);
        System.out.println("Enter process number: ");
        int processNum = in.nextInt();
        
        for(int i = 1; i <= processNum; i++) {
        	System.out.println("Enter burst time of Process " + i + ": ");
        	int burstProcess = in.nextInt();
        	Process process = new Process();
        	process.getProcessInfo(burstProcess, "Process " + i);
        	processList.add(process);
        }
        for (int i=0; i<processList.size(); i++) {
        	Process outstring = processList.get(i);
        	System.out.println("Name: "+outstring.processName + " BT: " + outstring.burstTime);
        	}
        
        
        //run FCFS
        
        fcfs.runFcfs(processList);
    }
}
