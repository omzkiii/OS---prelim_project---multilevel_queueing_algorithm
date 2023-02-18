import java.util.ArrayList;

public class Process extends Thread{
    public int burstTime;
    public String processName;
    public int i=1;
    public int startTime;
    public int endTime;

    public void getProcessInfo(int burstTime, String processName){
        this.burstTime = burstTime;
        this.processName = processName;
        startTime = 0;
        endTime = burstTime;
    }
    @Override
    public void run(){
        while (i<=burstTime){
            System.out.println(processName + ": "  + i + "/" + burstTime);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println(processName + " completed!");
    }

    public static void setTime(ArrayList<Process> processList){
        for(int i = 1; i < processList.size(); i++) {			
			processList.get(i).endTime = processList.get(i).burstTime + processList.get(i-1).endTime;
			processList.get(i).startTime = processList.get(i-1).endTime;
		}
    }

    public static void printTime(ArrayList<Process> processList){
        for (int i=0; i<processList.size(); i++) {
        	Process outstring = processList.get(i);
        	System.out.println("Name: "+outstring.processName + " BT: " + outstring.burstTime  + " ST: " + outstring.startTime  + " ET: " + outstring.endTime);
        	}
    }
}
