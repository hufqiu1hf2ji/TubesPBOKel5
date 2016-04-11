/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Notonogoro
 */
public class ManajerProyek extends Orang {

    //private Proyek[] proyek;
    private ArrayList<Proyek> proyek = new ArrayList<Proyek>();

    public ManajerProyek(String nama, String jenisKelamin, String telepon, String alamat,String Id,String Password) {
        super(nama, jenisKelamin, telepon, alamat, Id, Password);
        //proyek = new Proyek[10];
    }

   /* public ManajerProyek(String nama, String jenisKelamin, String telepon, String alamat, String Id,String Password, int maxProyek) {
        super(nama, jenisKelamin, telepon, alamat, Id,Password);
        proyek.ensureCapacity(maxProyek);
        //proyek = new Proyek[maxProyek];
    }*/

    public void createProyek(String namaProyek, Date deadline) {
           // proyek[numProyek] = new Proyek(namaProyek, deadline);
            proyek.add(new Proyek(namaProyek,deadline));
    }

    /*public void createProyek(String namaProyek, Date deadline, int maxTugas) {
        if (numProyek < proyek.length) {
            proyek[numProyek] = new Proyek(namaProyek, deadline, maxTugas);
            numProyek++;
        }
    }*/

    public Proyek getProyek(int index) {
            return proyek.get(index);
    }
    


    public void deleteProyek(int index) {
        if(index<proyek.size() && index>-1){
            proyek.remove(index);
        } 
       /* if ((index < numProyek) && (index >= 0)) {
            proyek[index] = null;
            //mekanisme penggeseran
            for (int i = index; i < numProyek; i++) {
                proyek[i] = proyek[i + 1];
            }
            proyek[numProyek]=null;
            numProyek--;
        } */
    }

    public int getSizeProyek() {
        return proyek.size();
    }

    

}
