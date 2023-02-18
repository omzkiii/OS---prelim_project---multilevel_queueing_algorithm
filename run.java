import java.util.ArrayList;
import java.util.Scanner;

public class run {
    public static void main(String[] args) throws InterruptedException {
    	Scanner in = new Scanner(System.in);
    	ArrayList<Process> processList = new ArrayList<>();
        System.out.println("Enter process number: ");
        int processNum = in.nextInt();
        
        for(int i = 1; i <= processNum; i++) {
        	System.out.println("Enter burst time of Process " + i + ": ");
        	int burstProcess = in.nextInt();
        	Process process = new Process();
        	process.getProcessInfo(burstProcess, "Process " + i);
        	processList.add(process);
        }
        
        
        
        //run FCFS
        
        fcfs.runFcfs(processList);
    }
}
