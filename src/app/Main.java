package app;

import java.util.Scanner;

import escalonadores.Escalonadores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 Escalonadores esc  = new Escalonadores(); 
	 int opcao;
     Scanner entrada = new Scanner(System.in);
     
     do{
         System.out.println("Digite a opção desejada: \n1-FCFS \n2-SJF \n3-SRTF \n4-Round Robin \n5-Multinivel \n6-Sair");
         opcao = entrada.nextInt();
         
         switch(opcao){
         case 1:
              esc.fcfs();
             break;
             
         case 2:
             esc.sjf();
             break;
             
         case 3:
             esc.srtf();
             break;
             
         case 4:
             esc.roundrobin();
             break;
             
         case 5:
        	 esc.multinivel();
        	 break;
         case 6:
        	 System.exit(0);
         default:
             System.out.println("Opção inválida.");
         }
     } while(opcao != 0);
		
	}

}
