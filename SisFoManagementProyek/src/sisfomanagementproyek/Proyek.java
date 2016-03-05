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
            
	}
	
        public void addProgrammer(Programmer p){
            //add Programmer ketika numProgrammer kurang dari maxProgrammer
        }
        
        public void createTugas(String namaTugas){
            //create Tugas ketika numTugas kurang dari max Tugas
        }
        
        public void removeProgrammer(int indexProgrammer){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma
                Jika verifikasiStatus Programmer == true || Tugas Programmer == null,bila tidak berarti masih ada tugas yang belum selesai.
            */
        }
        
        public void removeTugas(int indexTugas){
            /*melakukan remove pada array dan merapihkan posisi array
                remove dilakukan dengan algoritma 
                Jika Tugas[indexTugas].getStatus() == 1 , maka remove tugas dilakukan.
                Jika tidak, Tugas tidak dapat dihapus.
            */
        }
        
        public Tugas getTugas(int indexTugas){
            
        }
        
        public Programmer getProgrammer(int indexProgrammer){
            
        }
        
        public String getNama(){
            //return namaProyek
        }
        
        public void setNama(){
            //set namaProyek
        }
        
        public Date getDeadline(){
            //return deadline
        }
        
        
    }