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
public class Programmer extends Orang {

    public Programmer(String nama, String jenisKelamin, String telepon, String alamat) {
        super(nama, jenisKelamin, telepon, alamat);
    }

    public void setStatusTugas(Tugas t) {
        if (t != null && t.getPelaksana() == this) {
            t.setStatus(1);
            System.out.println("![SUKSES]-Tugas [" + t.getNamaTugas() + "] sudah diselesaikan.");
        } else {
            System.out.println("![GAGAL]-Tugas tidak ditemukan");
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
        System.out.println("![INFO]-List Proyek "+super.getNama()+" pada Manajer Proyek "+mp.getNama());
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
        System.out.println("![INFO]-List Tugas "+super.getNama()+" pada Proyek "+p.getNamaProyek()+" :");
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
    }else System.out.println(super.getNama()+" tidak berada dalam Proyek "+p.getNamaProyek());
    }

    public Tugas getTugas(Proyek p, int indexTugas) {
        return p.getTugas(indexTugas);
    }

}
