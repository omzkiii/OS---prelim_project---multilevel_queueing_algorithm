import java.util.ArrayList;

public class fcfs {
	public static void runFcfs(ArrayList<Process> process){
		int att = 0;
		int att2 = 0;
		double awt = 0;
		for(int i = 0; i < process.size(); i++) {
			
			att2 = att;
			att = (att2) + process.get(i).burstTime;
	
			
			if (i != 0) {
				
				awt = (awt + awt) + process.get(i).burstTime;
				
			}
			
			process.get(i).run();
			if (i == process.size()-1) {
				System.out.println("ATT: "+ att/process.size());
				System.out.println("ATT1: "+ att);
				System.out.println("AWT: "+ awt/process.size());
			}
		}
		
	}
	
}
