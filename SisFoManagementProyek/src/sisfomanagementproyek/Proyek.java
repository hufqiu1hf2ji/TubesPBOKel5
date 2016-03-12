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
            } else System.out.println("Programmer pada Proyek "+namaProyek+" sudah melebihi batas");
	}
        
        public void createTugas(String namaTugas){
            //create Tugas ketika numTugas kurang dari max Tugas
            if (numTugas<10){
                    tugas[numTugas]= new Tugas(namaTugas);
		    numTugas++;
	    } else System.out.println("Tugas pada Proyek "+namaProyek+" sudah melebihi batas");
        }
        
        public void removeProgrammer(int indexProgrammer){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma
                Jika verifikasiStatus Programmer == true || Tugas Programmer == null,bila tidak berarti masih ada tugas yang belum selesai/terverifikasi.
            */
            if (indexProgrammer<=numProgrammer){
                for(int i=0;i<numTugas;i++){
                    tugas[i].getStatus();
                }
                if(programmer[indexProgrammer].verifikasiStatus == true || programmer[indexProgrammer].tugas == null){
                    if(indexProgrammer != numProgrammer){
                        for (int i=indexProgrammer;i<numProgrammer;i++){
                            programmer[i]=programmer[i+1];
                        }
                    }
                    programmer[numProgrammer]=null;
                    numProgrammer--;
                }else System.out.println("Hapus Programmer gagal. Programmer belum menyelesaikan tugas "+programmer[indexProgrammer].tugas);
            }else System.out.println("Mohon input indexProgrammer tidak melebihi "+numProgrammer);
	}
        
        public void removeTugas(int indexTugas){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma 
                Jika Tugas[indexTugas].getStatus() == 1 , maka remove tugas dilakukan.
                Jika tidak, Tugas tidak dapat dihapus.
            */
            if (indexTugas<=numTugas) {
       		if (tugas[indexTugas].getStatus() == 1){
                    if (indexTugas != numTugas){
                        for (int i=indexTugas;i<numTugas;i++){
                            tugas[i]=tugas[i+1];
                        }
                    }
                    tugas[numTugas]=null;
                    numTugas--;
                }else System.out.println("Hapus Tugas gagal.Tugas belum selesai");
            }else System.out.println("Mohon input indexTugas tidak melebihi "+numTugas);
        }
        
        public Tugas getTugas(int indexTugas){
            if (indexTugas<=numTugas){
                return tugas[indexTugas];
            }else return null;
        }
        
        public Programmer getProgrammer(int indexProgrammer){
            if (indexProgrammer<=numProgrammer){
                return programmer[indexProgrammer];
            }else return null;
        }
        
        public String getNama(){
            //return namaProyek
            return namaProyek;
        }
        
        public void setNama(String namaProyek){
            //set namaProyek
            this.namaProyek=namaProyek;	
        }
        
        public Date getDeadline(){
            //return deadline
            return deadline;
        }
        
        
    }