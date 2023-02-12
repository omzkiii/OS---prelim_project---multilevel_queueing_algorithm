
public class run {
    public static void main(String[] args) throws InterruptedException {
        Fcfs();
    }
    public static void Fcfs() throws InterruptedException{
        Process process1 = new Process();
        process1.getProcessInfo(7,"Process 1");
        process1.start();
        process1.join();
        Process process2 = new Process();
        process2.getProcessInfo(3,"Process 2");
        process2.start();
        process2.join();
        Process process3 = new Process();
        process3.getProcessInfo(2,"Process 3");
        process3.start();
        process3.join();
        Process process4 = new Process();
        process4.getProcessInfo(5,"Process 4");
        process4.start();
        process4.join();
    }
}
