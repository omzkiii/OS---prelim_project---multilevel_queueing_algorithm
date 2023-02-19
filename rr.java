import java.util.ArrayList;

public class rr {
    public static  void runRr(ArrayList<Process> processList, int quantum) throws InterruptedException{
		int counter = 0;
		int time = 0;
		int processDone = 0;
		int processStarted = 0;
        while(processList.get(counter).remaining >= 0 && processDone < processList.size()) {
			processStarted = processStarted + 1;
			if(processStarted <= processList.size())
				processList.get(counter).startTime = time;
			if(processList.get(counter).remaining == 0){
				if(counter < processList.size()-1)
						counter ++;
					else
						counter = 0;
			}
			else if(processList.get(counter).remaining<=quantum){
				int j = processList.get(counter).timeDone;
				while (j<=processList.get(counter).remaining){
						System.out.println(processList.get(counter).processName + ": "  + processList.get(counter).timeDone + "/" + processList.get(counter).burstTime);
						time = time + 1;
						processList.get(counter).timeDone = processList.get(counter).timeDone + 1;
						processList.get(counter).run();
						j++;
					}
					processList.get(counter).remaining = 0;
					processList.get(counter).endTime = time;
					System.out.println(processList.get(counter).processName + " completed at " + time + " second/s.");
					processDone = processDone + 1;

					if(counter < processList.size()-1)
						counter ++;
					else
						counter = 0;
			}
			else{
			int j = 1;
				while (j<=quantum){
						System.out.println(processList.get(counter).processName + ": "  + processList.get(counter).timeDone + "/" + processList.get(counter).burstTime);
						time = time + 1;
						processList.get(counter).timeDone = processList.get(counter).timeDone + 1;
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
		Process.printTime(processList);
    }
}
