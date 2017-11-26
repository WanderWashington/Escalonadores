package escalonadores;

import java.util.Scanner;

public class Srtf {

	private int num,tempo,menor,cont=0;
	float mediawt,mediatat,tempo_espera=0,tempo_turnaround=0, finale;
	private int[]btime= new int[20];
	private int[]arrival= new int[20];
	private int[]wtime= new int[20];
	private int[]tatime= new int[20];
	private int[] processo = new int[20];
	private int[]temp= new int[20];
	private int[]inttemp= new int[10];
	
	private Scanner leitor= new Scanner(System.in);
	
	
	
	public void srtf() 
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
			
			
			System.out.println("Entre com o Burst Time :");
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
			btime[19]=9999;
			for(tempo=0;cont!=num;tempo++) 
				{
				
					menor=19;
					 for(int i = 0; i < num; i++)
			            {
			                  if(arrival[i] <= tempo && btime[i] < btime[menor] && btime[i] > 0)
			                  {
			                        menor = i;
			                  }
			            }
					 btime[menor]--;
			            if(btime[menor] == 0)
			            {
			                  cont++;
			                  finale = tempo + 1;
			                  tempo_espera = tempo_espera + finale - arrival[menor] - temp[menor];
			                  tempo_turnaround = tempo_turnaround + finale - arrival[menor];
			            }
				
				}
			
				mediawt = tempo_espera/num;
	            mediatat = tempo_turnaround / num;
	            System.out.println("\n\nMedia Waiting Time:\t\n"+ mediawt);
	            System.out.println("Media Turnaround Time:\t\n"+ mediatat);
		
		
		
		}
	
}
