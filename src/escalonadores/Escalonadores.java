package escalonadores;
import escalonadores.*;

public class Escalonadores {

	public void fcfs() {
		Fcfs fcfs = new Fcfs();
		fcfs.fcfs();
		}
	public void sjf() {
		Sjf sjf = new Sjf();
		sjf.sjf();
		}
	public void srtf (){
		Srtf srtf = new Srtf();
		srtf.srtf();
		}
	public void roundrobin() {
		Roundrobin rr = new Roundrobin();
		rr.roundrobin();
	}
	public void multinivel() {
		Multinivel mn= new Multinivel();
		mn.multinivel();
	}

}
