public class Process extends Thread{
    private int burstTime;
    private String processName;
    public int i;
    public void getProcessInfo(int burstTime, String processName){
        this.burstTime = burstTime;
        this.processName = processName;
    }
    @Override
    public void run(){
        while (i<=burstTime){
            System.out.println(processName + ": "  + i + "/" + burstTime);
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println(processName + " completed!");
    }
}
