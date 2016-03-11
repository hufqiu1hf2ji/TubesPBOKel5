/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfomanagementproyek;

import java.util.Date;

/**
 *
 * @author Notonogoro
 */
    public class Proyek{
	private String namaProyek;
        private Programmer programmer[]=new Programmer[10];
	private Tugas tugas[]=new Tugas[10];
	private int numProgrammer;
        private int numTugas;
        private Date deadline;
        
	public Proyek(String namaProyek, Date deadline){
        this.namaProyek=namaProyek;
		this.deadline=deadline;   
	}
	
        public void addProgrammer(Programmer p){
            //add Programmer ketika numProgrammer kurang dari maxProgrammer
			if (numProgrammer<10){
			programmer[numProgrammer]=p;
			numProgrammer++;
		}
		}
        
        public void createTugas(String namaTugas){
            //create Tugas ketika numTugas kurang dari max Tugas
			if (numTugas<10){
			tugas[numTugas]=p;
			numTugas++;
		}
        }
        
        public void removeProgrammer(int indexProgrammer){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma
                Jika verifikasiStatus Programmer == true || Tugas Programmer == null,bila tidak berarti masih ada tugas yang belum selesai.
            */
			for (i=indexProgrammer;i<numProgrammer;i++){
			programmer[i]=programmer[i+1]
		}
		programmer[numProgrammer]=null;
		numProgrammer--;
        }
        
        public void removeTugas(int indexTugas){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma 
                Jika Tugas[indexTugas].getStatus() == 1 , maka remove tugas dilakukan.
                Jika tidak, Tugas tidak dapat dihapus.
            */
			for (i=indexTugas;i<numTugas;i++){
			tugas[i]=tugas[i+1]
		}
		tugas[numTugas]=null;
		numTugas--;
        }
        
        public Tugas getTugas(int indexTugas){
			return Tugas[indexTugas];     
        }
        
        public Programmer getProgrammer(int indexProgrammer){
            return Programmer[indexProgrammer];
        }
        
        public String getNama(){
            //return namaProyek
			this.nama=nama;
        }
        
        public void setNama(){
            //set namaProyek
			return nama;
        }
        
        public Date getDeadline(){
            //return deadline
			return deadline;
        }
        
        
    }