import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class run {
    public static int quantum = 2;
    public static void main(String[] args) throws InterruptedException {
    	Scanner in = new Scanner(System.in);
    	ArrayList<Process> processList = new ArrayList<>();
        ArrayList<Process> processBatch1 = new ArrayList<>();
        ArrayList<Process> processBatch2 = new ArrayList<>();
        ArrayList<Process> processBatch3 = new ArrayList<>();
        System.out.println("Enter process number: ");
        int processNum = in.nextInt();
        
        for(int i = 1; i <= processNum; i++) {
        	System.out.println("Enter burst time of Process " + i + ": ");
        	int burstProcess = in.nextInt();
        	Process process = new Process();
        	process.getProcessInfo(burstProcess, "Process " + i);
        	processList.add(process);
        }
        
        //INSERTION SORT
        for (int j = 1; j < processList.size(); j++) {  
            Process key = processList.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( processList.get(i).burstTime > key.burstTime ) ) {
                Collections.swap(processList, i+1, i);
                i--;  
            }  
            processList.set(i+1, key);  
        }
        double batchSize = (double)processList.size()/3.0;

        
        Stack<Process> processStack = new Stack<>();
        for(int i = 0; i < processList.size();i++){
            processStack.push(processList.get(i));
        }
        for(int i = 0; i < Math.ceil(batchSize); i++)
            processBatch1.add(processStack.pop());
        for(int i = 0; i < Math.ceil(batchSize); i++)
            processBatch2.add(processStack.pop());
        for(int i = 0; i <= processStack.size(); i++)
            processBatch3.add(processStack.pop());

        System.out.println("BATCH SIZE: " + batchSize);

        System.out.println("\n-----ROUND ROBIN-----");
        rr.runRr(processBatch1, quantum);
        System.out.println("\n-----SHORTEST JOB FIRST-----");
        sjf.runSjf(processBatch2);
        System.out.println("\n-----FIRST COME FIRST SERVE-----");
        fcfs.runFcfs(processBatch3);
        
        System.out.println("\n=========================================");
    }
}
