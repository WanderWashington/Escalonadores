package escalonadores;

import java.util.Scanner;

import escalonadores.Processo;

public class Multinivel {

	private int num,tempo_quantum,cont=0,total=0,aux;
	private int temp_processo,y,j;
	private int pronto;
	float mediawt,mediatat,tempo_espera=0,tempo_turnaround=0;
	private int btime;
	private int arrival; 
	private int wtime;
	private int tatime; 
	private int prioridade; 
	private int processo;
	private Processo temp ;
	private int tempo;
	private Scanner leitor = new Scanner(System.in);
	
	
	Processo []p = new Processo[20];
	
	public int fila(int t) 
	{
		if (t == 0 || t == 1 || t == 2 || t == 3) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public void multinivel() 
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
					
				p[i]= new Processo(processo,arrival,btime,prioridade,aux,pronto);
				
				
					System.out.printf("Entre com o ID do processo[%d] :",i+1);
					p[i].setProcesso(leitor.nextInt());;
					System.out.printf("Entre com o Tempo de Chegada( Arrival Time ) :");
					p[i].setArrival(leitor.nextInt());
					System.out.printf("PID[%d] Burst Time: ",p[i].getProcesso());
					p[i].setBtime(leitor.nextInt());
					System.out.printf("Prioridade do Processo : ");
					p[i].setPrioridade(leitor.nextInt());
					temp_processo=p[i].getPrioridade();
					p[i].setAux(fila(temp_processo));
					p[i].setPronto(0);
				}
			tempo=p[0].getBtime();
			
			 for(y = 0; y < num; y++)
		      {
		            for(cont = y; cont < num; cont++)
		            {
		                  if(p[cont].getArrival() < tempo)
		                  {
		                        p[cont].setPronto(1);
		                  }
		            }
		            for(cont = y; cont < num - 1; cont++)
		            {
		                  for(j = cont + 1; j < num; j++)
		                  {
		                        if(p[cont].getPronto() == 1 && p[j].getPronto() == 1)
		                        {
		                              if(p[cont].getAux() == 2 && p[j].getAux() == 1)
		                              {
		                                    temp = p[cont];
		                                    p[cont] = p[j];
		                                    p[j] = temp;
		                              }
		                        }
		                  }
		            }
		            for(cont = y; cont < num - 1; cont++)
		            {
		                  for(j = cont + 1; j < num; j++)
		                  {
		                        if(p[cont].getPronto() == 1 && p[j].getPronto() == 1)
		                        {
		                              if(p[cont].getPronto() == 1 && p[j].getAux() == 1)
		                              {
		                                    if(p[cont].getBtime() > p[j].getBtime())
		                                    {
		                                          temp = p[cont];
		                                          p[cont] = p[j];
		                                          p[j] = temp;
		                                    }
		                                    else
		                                    {
		                                          break;
		                                    }
		                              }
		                        }
		                  }
		            }
		            System.out.printf("\nProcess[%d]:\tTime:\t%d To %d\n", p[y].getProcesso(), tempo, tempo + p[y].getBtime());
		            tempo = tempo + p[y].getBtime();
		            for(cont = y; cont < num; cont++)
		            {
		                  if(p[cont].getPronto() == 1)
		                  {
		                        p[cont].setPronto(0);
		                  }
		            }
		      }
	
		}

	
	
}
