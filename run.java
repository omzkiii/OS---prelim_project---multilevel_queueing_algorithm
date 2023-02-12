
public class run {
    public static void main(String[] args) throws InterruptedException {
        Fcfs();
        
        int bTime[], process[], wTime[], tTime[], i, j, pNum, total=0,pos,temp;
		float awt, att;
		Scanner input = new Scanner(System.in);
		 
		System.out.print("SJF start");
		System.out.print("\nEnter number of process: ");
		pNum = input.nextInt();
		 
		process = new int[pNum];
		bTime = new int[pNum];
		wTime = new int[pNum];
		tTime = new int[pNum];
		 
		System.out.println("\nEnter Burst time:");
		
		for(i=0; i < pNum; i++)
		{
			
		System.out.print("\nProcess["+(i+1)+"]: ");
		bTime[i] = input.nextInt();;
		process[i] = i+1; //Process Number
		
		}
		 
		//Sorting
		for(i=0; i < pNum; i++)
		{
		pos = i;
		
		for(j=i+1; j < pNum; j++)
		{
			
		if(bTime[j] < bTime[pos])
			
		pos = j;
		
		}
		 
		temp = bTime[i];
		bTime[i] = bTime[pos];
		bTime[pos] = temp;
		 
		temp = process[i];
		process[i] = process[pos];
		process[pos] = temp;
		}
		
		//First process has 0 waiting time
		wTime[0]=0;
		
		//calculate waiting time
		for(i=1; i < pNum; i++)
		{
			
		wTime[i] = 0;
		
		for(j=0; j<i; j++)
			
		wTime[i] += bTime[j];
		total += wTime[i];
		
		}
		 
		//Calculating Average waiting time
		awt = (float)total/pNum;
		total=0;
		 
		System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
		
		for(i=0 ;i < pNum ;i++)
		{
			
		tTime[i] = bTime[i] + wTime[i]; //Calculating Turnaround Time
		total += tTime[i];
		
		System.out.println("\n p" + process[i] + "\t\t " + bTime[i] + "\t\t " + wTime[i]+"\t\t " + tTime[i]);
		
		}
		 
		//Calculation of Average Turnaround Time
		att = (float)total/pNum;
		
		System.out.println("\n\nAverage Waiting Time: " + awt);
		System.out.println("\nAverage Turnaround Time: " + att);
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
