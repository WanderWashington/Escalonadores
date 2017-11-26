package escalonadores;

public class Processo {
	
	
	private int prioridade;
	private int aux,pronto;
	private int btime;
	private int processo;
	private int arrival ;
	
	
	public  Processo(int process_id, int arrival_time, int burst_time,int p, int q, int ready) 
	{
		processo= process_id;
		arrival= arrival_time;
		btime=burst_time;
		prioridade= p;
		aux=q;
		pronto =ready;
	}


	public int getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}


	public int getAux() {
		return aux;
	}


	public void setAux(int aux) {
		this.aux = aux;
	}


	public int getPronto() {
		return pronto;
	}


	public void setPronto(int pronto) {
		this.pronto = pronto;
	}


	public int getBtime() {
		return btime;
	}


	public void setBtime(int btime) {
		this.btime = btime;
	}


	public int getProcesso() {
		return processo;
	}


	public void setProcesso(int processo) {
		this.processo = processo;
	}


	public int getArrival() {
		return arrival;
	}


	public void setArrival(int arrival) {
		this.arrival = arrival;
	}






}
