/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Notonogoro
 */
public class Programmer extends Orang {

    public Programmer(String nama, String jenisKelamin, String telepon, String alamat,String Id,String Password) {
        super(nama, jenisKelamin, telepon, alamat, Id,Password);
    }
    
    /* DI APLIKASI KONSOL
    public void setStatusTugas(Tugas t) {
        if (t != null && t.getPelaksana() == this) {
            t.setStatus(1);
        } 
    }

    //mengecek apakah programmer termasuk didalam proyek atau tidak
    public boolean getProgrammerDalamProyek(Proyek p) {
        boolean a = false;
        for (int i = 0; i < p.getNumProgrammer(); i++) {
            if (p.getProgrammer(i).equals(this)) {
                a = true;
            }
        }
        return a;
    }

    public void listProyek(ManajerProyek mp) {
        int x = 0;
        for (int i = 0; i < mp.getNumProyek(); i++) {
            for (int j = 0; j < mp.getProyek(i).getNumProgrammer(); j++) {
                if (mp.getProyek(i).getProgrammer(j).equals(this)) {
                    System.out.println("        "+x + ". " + mp.getProyek(i).getNamaProyek());
                    x++;
                }
            }
        }
    }

    public void listTugas(ManajerProyek mp, Proyek p) {
        if(getProgrammerDalamProyek(p)){
        for (int i = 0; i < mp.getNumProyek(); i++) {
            if (mp.getProyek(i).equals(p)) {
                int x = 0;
                for (int j = 0; j < mp.getProyek(i).getNumTugas(); j++) {
                    if(mp.getProyek(i).getTugas(j).getPelaksana()!=null){
                    if (mp.getProyek(i).getTugas(j).getPelaksana().equals(this) && mp.getProyek(i).getTugas(j).getStatus()==0) {
                        System.out.println("        "+x + ". " + mp.getProyek(i).getTugas(j).getNamaTugas());
                        x++;
                    }
                    }
                }
            }
        }
    }
    }

    public Tugas getTugas(Proyek p, int indexTugas) {
        return p.getTugas(indexTugas);
    }
*/
}
