import java.util.ArrayList;

public class Process extends Thread{
    public int burstTime;
    public String processName;
    public int i = 1;
    public int startTime;
    public int endTime;
    public int remaining;
    public int timeDone = 1;
    public int partial = 0;

    public void getProcessInfo(int burstTime, String processName){
        this.burstTime = burstTime;
        this.processName = processName;
        this.remaining = burstTime;
        startTime = 0;
        endTime = burstTime;
    }

    @Override
    public void run(){
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // public static void setTime(ArrayList<Process> processList){
    //     for(int i = 1; i < processList.size(); i++) {			
	// 		processList.get(i).endTime = processList.get(i).burstTime + processList.get(i-1).endTime;
	// 		processList.get(i).startTime = processList.get(i-1).endTime;
	// 	}
    // }

    public static float[] printTime(ArrayList<Process> processList){
        float totalWt = 0;
        float totalTt = 0;
        float awt;
        float att;
        for (int i=0; i<processList.size(); i++) {
        	Process outstring = processList.get(i);
            int waitingTime = outstring.startTime - outstring.partial;
            int turnaroundTime = outstring.endTime - outstring.partial;
        	System.out.println("\n" + outstring.processName);
            System.out.println("    Burst Time: " + outstring.burstTime  + " Waiting Time: " + waitingTime  + " Completion Time: " + turnaroundTime);
            totalWt = totalWt + waitingTime;
            totalTt = totalTt + turnaroundTime;
            
        }
        awt = totalWt/processList.size();
        att = totalTt/processList.size();
        //System.out.println("\nAverage Waiting time " + awt + " Average Turnaround Time " + att);
        float[] overAll = new float[2];
        overAll[0] = awt;
        overAll[1] = att;
        return overAll;
        

    }
    
}
