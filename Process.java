public class Process extends Thread{
    public int burstTime;
    public String processName;
    public int i=1;
    public void getProcessInfo(int burstTime, String processName){
        this.burstTime = burstTime;
        this.processName = processName;
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
    public String returnInfo() {
    	return processName;
    }
}
