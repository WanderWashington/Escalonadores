package escalonadores;

import java.util.Scanner;

public class Fcfs {
	private int num, mediawt=0,mediatat=0;
	private int[]btime= new int[20];
	private int[]wtime= new int[20];
	private int[]tatime= new int[20];
	private int[]processo=new int[20];
	
	private Scanner leitor= new Scanner(System.in);
	
	public void fcfs() 
		{
			System.out.println("Entre com o numero total de processos (maximo 20) :");
			num=leitor.nextInt();
			
			if(num>20) 
				{
				while(num>20) 
				{
					System.out.println("O valor máximo é 20, insira um valor válido");
					num=leitor.nextInt();
					}
			}
			System.out.println("Entre com as informações do processo :");
			for(int i=0;i<num;i++) 
				{
					
					System.out.printf("Entre com o ID do processo[%d] :",i+1);
					processo[i]=leitor.nextInt();
					System.out.printf("PID[%d] Burst Time: ",processo[i]);
					btime[i]=leitor.nextInt();
				}
			wtime[0]=0;
			for(int i=1;i<num;i++)
				{
					wtime[i]=0;
					for(int j=0;j<i;j++) 
						{
							wtime[i]+=btime[j];
						}
				
				}
            System.out.println("\nProcess\t\tBurst Time\tWaiting Time\tTurnaround Time");
            
            
            for(int i=0;i<num;i++) 
            	{
            	 tatime[i]=btime[i]+wtime[i];
            	 mediawt+=wtime[i];
            	 mediatat+=tatime[i];
            	 System.out.printf("\nP[%d]\t\t%d\t\t%d\t\t%d",i+1,btime[i],wtime[i],tatime[i]);
            	
            	}
            mediawt= mediawt/num;
            mediatat= mediatat/num;
            System.out.println("\n Media de Waiting Time : "+mediawt);
            System.out.println("\n Media de Turnaround Time:"+mediatat);
             
			
		}
	

}
