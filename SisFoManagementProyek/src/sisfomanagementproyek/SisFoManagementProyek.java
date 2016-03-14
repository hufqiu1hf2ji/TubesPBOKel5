/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfomanagementproyek;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Notonogoro
 */
public class SisFoManagementProyek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("               TEST FUNGSIONALITAS");
        System.out.println("====================================================");
        //mendeklarasikan tanggal
        Date date = new Date(2012 - 1900, 1, 4);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        //mendeklarasikan ManajerProyek
        ManajerProyek mp = new ManajerProyek("Wendi", "Laki-Laki", "081272137", "BDG", 3);
        //mendeklarasikan Programmer
        Programmer p = new Programmer("Lintang", "Laki-Laki", "082431234", "BDG");
        Programmer q = new Programmer("Ulya", "Perempuan", "0834567", "BDG");
        Programmer r = new Programmer("Doi", "Perempuan", "0834567", "BDG");
        Programmer s = new Programmer("Manta", "Perempuan", "0834567", "BDG");

        //Manajer membuat Proyek tanpa maxTugas
        mp.createProyek("Sisfo", date);
        //Manajer membuat Proyek dengan maxTugas 5
        mp.createProyek("RPL Project", date, 5);

        //Manajer menambah programmer lintang dan ulya ke Proyek Sisfo
        mp.getProyek(0).addProgrammer(p);
        mp.getProyek(0).addProgrammer(q);
        mp.getProyek(0).addProgrammer(r);
        //Manajer menambah programmer doi dan mantan ke Proyek RPL Project
        mp.getProyek(1).addProgrammer(r);
        mp.getProyek(1).addProgrammer(s);

        mp.getProyek(0).createTugas("Sisfo Management");
        mp.getProyek(0).createTugas("Dokumentasi");
        mp.getProyek(1).createTugas("SKPL RPL");
        mp.getProyek(1).createTugas("DFD Martabak Manis");

        mp.getProyek(0).getTugas(0).setPelaksana(p, mp.getProyek(0));
        mp.getProyek(1).getTugas(1).setPelaksana(p, mp.getProyek(1));
        mp.getProyek(1).getTugas(0).setPelaksana(r, mp.getProyek(1));
        mp.getProyek(0).getTugas(1).setPelaksana(p, mp.getProyek(0));

        p.listProyek(mp);
        p.listTugas(mp, mp.getProyek(0));
        p.setStatusTugas(mp.getProyek(0).getTugas(0));
        p.listTugas(mp, mp.getProyek(0));

        mp.getProyek(0).removeTugas(0);
        mp.getProyek(0).removeTugas(0);
        p.listTugas(mp, mp.getProyek(0));
        r.listTugas(mp, mp.getProyek(0));
        r.listTugas(mp, mp.getProyek(1));
        
        mp.getProyek(1).removeProgrammer(0);
        r.listTugas(mp, mp.getProyek(1));
        System.out.println("");
        System.out.println("====================================================");
        System.out.println("Display Info Manajer Proyek, proyek dan Programmer");
        System.out.println("====================================================");
        System.out.println("Nama Manager Proyek    : " + mp.getNama());
        System.out.println("Telepon Manager Proyek : " + mp.getTelepon());
        System.out.println("Jumlah Proyek Manager Proyek : " + mp.getNumProyek());
        System.out.println("====================================================");
        System.out.println("Proyek 0 : " + mp.getProyek(0).getNamaProyek());
        System.out.println("Deadline Proyek : " + sdf.format(mp.getProyek(0).getDeadline()));
        System.out.println("");
        mp.getProyek(1).createTugas("Revisi 52");
        System.out.println("List Tugas Proyek RPL Project");
        for(int i=0;i<mp.getProyek(1).getNumTugas();i++){
            System.out.println(i+". "+mp.getProyek(1).getTugas(i).getNamaTugas());
        }
    }
}
