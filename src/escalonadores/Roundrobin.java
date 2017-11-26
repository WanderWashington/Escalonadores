package escalonadores;

import java.util.Scanner;

public class Roundrobin {

	private int i,num,tempo_quantum,cont=0,total=0,aux;
	float mediawt,mediatat,tempo_espera=0,tempo_turnaround=0;
	private int[]btime= new int[20];
	private int[]arrival= new int[20];
	private int[]wtime= new int[20];
	private int[]tatime= new int[20];
	private int[] processo = new int[20];
	private int[]temp= new int[20];
	
	Scanner leitor= new Scanner(System.in);
	
	public void roundrobin() 
		{
				System.out.println("Entre com o numero total de processos (maximo 20)");
				num=leitor.nextInt();
				
				if(num>20) 
					{
					while(num>20) 
					{
						System.out.println("O valor máximo é 20, insira um valor válido");
						num=leitor.nextInt();
						}
					}
				
				aux = num;
				System.out.println("Entre com as informações do processo :");
				for(int i=0;i<num;i++) 
					{
						System.out.printf("Entre com o ID do processo[%d] :",i+1);
						processo[i]=leitor.nextInt();	
						System.out.printf("Entre com o Tempo de Chegada( Arrival Time ) :");
						arrival[i]=leitor.nextInt();
						System.out.printf("PID[%d] Burst Time: ",processo[i]);
						btime[i]=leitor.nextInt();
						temp[i]=btime[i];
					}
				
				
				System.out.println("\n Entre com o Tempo Quantum (Quantum Time ) :");
				tempo_quantum= leitor.nextInt();
				System.out.println("\nProcesso ID\t\tBurst Time\t Turnaround Time\t Waiting Time\n");
				
			for(total=0, i=0;aux!=0;) 
				{
					if(temp[i] <= tempo_quantum && temp[i] > 0) 
		            { 
		                  total = total + temp[i]; 
		                  temp[i] = 0; 
		                  cont = 1; 
		            } 
		            else if(temp[i] > 0) 
		            { 
		                  temp[i] = temp[i] - tempo_quantum; 
		                  total = total + tempo_quantum; 
		            } 
		            if(temp[i] == 0 && cont == 1) 
		            { 
		                  aux--; 
		                  System.out.printf("\nProcesso[%d]\t\t%d\t\t %d\t\t\t %d", i + 1, btime[i], total - arrival[i],total - arrival[i] - btime[i]);
		                  tempo_espera = tempo_espera + total - arrival[i] - btime[i]; 
		                  tempo_turnaround = tempo_turnaround + total - arrival[i]; 
		                  cont = 0; 
		            } 
		            if(i == num - 1) 
		            {
		                  i = 0; 
		            }
		            else if(arrival[i + 1] <= total) 
		            {
		                  i++;
		            }
		            else 
		            {
		                  i = 0;
		            }
				
				}
				mediawt = (float) (tempo_espera * 1.0 / num);
	            mediatat = (float) (tempo_turnaround * 1.0 / num);
	            System.out.printf("\n\nMedia de Waiting Time:\t%.2f", mediawt); 
	            System.out.printf("\nMedia de Turnaround Time:\t%.2f\n", mediatat); 
			
		}
}
