
package sisfomanagementproyek;
public class Proyek{
	private Programmer[10]programmer;
	private String nama;
	private int numProgrammer;
	private Tugas[10]tugas;
	private int numTugas;
	private date deadline;

	public Proyek(String namaProyek, date deadline){
		this.namaProyek=namaProyek;
		this.deadline=deadline;
	}
	
	public void addProgrammer(Programmer p){
		if (numProgrammer<10){
			programmer[numProgrammer]=p;
			numProgrammer++;
		}
	}
	
	public void createTugas(String namaTugas){
		if (numTugas<10){
			tugas[numTugas]=p;
			numTugas++;
		}
	}
	
	public void removeProgrammer(int indexProgrammer){
		for (i=indexProgrammer;i<numProgrammer;i++){
			programmer[i]=programmer[i+1]
		}
		programmer[numProgrammer]=null;
		numProgrammer--;
	}
	
	public void removeTugas(int indexTugas){
		for (i=indexTugas;i<numTugas;i++){
			tugas[i]=tugas[i+1]
		}
		tugas[numTugas]=null;
		numTugas--;
	}
	
	public Tugas getTugas(int indexTugas){
			return Tugas[indexTugas];
	}
	
	public Programmer getProgrammer[int indexProgrammer]{
			return Programmer[indexProgrammer];
	}
	
	public void setNama(String nama){
		this.nama=nama;
	}
	
	public String getNama(){
			return nama;
	}
	
	public date getDeadline(){
			return deadline;
	}
}