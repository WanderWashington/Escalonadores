package escalonadores;

import java.util.Scanner;

public class Sjf {
	
	
	private int num,temp, mediawt=0,mediatat=0,total;
	private int[]btime= new int[20];
	private int[]wtime= new int[20];
	private int[]tatime= new int[20];
	private int[] processo = new int[20];
	
	
	private Scanner leitor= new Scanner(System.in);
	
	
	public void sjf() 
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
			
			System.out.println("Entre com o Burst Time :");
			for(int i=0;i<num;i++) 
				{
					System.out.printf("Entre com o ID do processo[%d] :",i+1);
					processo[i]=leitor.nextInt();
					System.out.printf("PID[%d] Burst Time: ",processo[i]);
					btime[i]=leitor.nextInt();
				}
			
		for(int i=0;i<num-1;i++)
			{
				for(int j=i+1;j<num;j++) 
					{
						if(btime[i]>btime[j]) 
							{
							   temp=btime[i];
							   btime[i]=btime[j];
							   btime[j]=temp;
							   temp=processo[i];
							   processo[i]=processo[j];
							   processo[j]=temp;
							}
						
					
					}

			}
		wtime[0]=0;
		for(int i=1;i<num;i++) 
			{
				wtime[i]= wtime[i-1]+btime[i-1];
				total= total+wtime[i];
			}
			
		mediawt=(total/num);
			
	
		System.out.println("Processo_ID  Burst Time   Waiting_Time");
		for(int i=0;i<num;i++) 
			{
				System.out.printf("\nPID[%d]"+"\t\t%d"+"\t\t%d",processo[i],btime[i],wtime[i]);
			}
		System.out.println("\nTotal de Waiting Time: "+total);
		System.out.println("Media de Waiting Time: "+mediawt);
		
		}
}
