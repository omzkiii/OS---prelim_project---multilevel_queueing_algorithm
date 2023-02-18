import java.util.ArrayList;

public class rr {
    public static  void runRr(ArrayList<Process> processList, int quantum) throws InterruptedException{
		int counter = 0;
        while(processList.get(counter).remaining > 0) {
			if(processList.get(counter).remaining<quantum){
				int j = processList.get(counter).remaining;
				while (j<=processList.get(counter).remaining){
						int k = (processList.get(counter).burstTime - processList.get(counter).remaining) + j;
						System.out.println(processList.get(counter).processName + ": "  + k + "/" + processList.get(counter).burstTime);
						processList.get(counter).run();
						j++;
					}
					processList.get(counter).remaining = 0;
					System.out.println(processList.get(counter).processName + " completed!");

					if(counter < processList.size()-1)
						counter ++;
					else
						counter = 0;
			}
			else{
			int j = 1;
				while (j<=quantum){
					int k = (processList.get(counter).burstTime - processList.get(counter).remaining) + j;
						System.out.println(processList.get(counter).processName + ": "  + k + "/" + processList.get(counter).burstTime);
						processList.get(counter).run();
						j++;
					}
					processList.get(counter).remaining = processList.get(counter).remaining - quantum;

					if(counter < processList.size()-1)
						counter ++;
					else
						counter = 0;
			}

			
		}
    }
    public void runProcess(){
        
    }
}
