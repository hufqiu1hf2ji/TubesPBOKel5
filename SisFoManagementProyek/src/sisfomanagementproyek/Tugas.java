/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfomanagementproyek;

/**
 *
 * @author Notonogoro
 */
    public class Tugas{
        private String namaTugas;
        private Programmer pelaksana;
        private int status;
        
        public Tugas(String name){
            //setNamaTugas, set status = 0
        }
        
        public void setPelaksana(Programmer p){
            /*Dilakukan bila Tugas di p == NULL || verifikasiStatus di p == true
              1. mengubah Tugas di Programmer(langsung saja karena tidak terenkapsulasi) menjadi namaTugas
              2. mengubah verifikasiStatus di Programmer = false;
              3. mengubah status di Programmer menjadi = 0;
              4. mengisi pelaksana = p
            */
        }
        
        public Programmer getPelaksana(){
            
        }
        
        public int getStatus(){
            this.status=pelaksana.status;
            if status == 1 then{
                pelaksana.verifikasiStatus = true;
            }
            return status;
        }
        
        public void getNama(){
            //return nama Tugas
        }
        
        public String setNama(){
            //set nama Tugas
        }
        
    }