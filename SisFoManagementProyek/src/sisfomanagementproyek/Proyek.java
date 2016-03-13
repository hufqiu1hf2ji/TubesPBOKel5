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
public class Proyek {

    private String namaProyek;
    private Programmer programmer[] = new Programmer[10];
    private Tugas[] tugas;
    private int numProgrammer;
    private int numTugas;
    private Date deadline;

    public Proyek(String namaProyek, Date deadline) {
        this.namaProyek = namaProyek;
        this.deadline = deadline;
        tugas = new Tugas[10];
    }

    public Proyek(String namaProyek, Date deadline, int maxTugas) {
        this.namaProyek = namaProyek;
        this.deadline = deadline;
        tugas = new Tugas[maxTugas];
    }

    public void addProgrammer(Programmer p) {
        if (numProgrammer < programmer.length) {
            programmer[numProgrammer] = p;
            numProgrammer++;
            System.out.println("![SUKSES]-Programmer " + p.getNama() + " berhasil dimasukkan ke proyek " + this.namaProyek);
        } else {
            System.out.println("![GAGAL]-Programmer pada Proyek " + namaProyek + " sudah melebihi batas");
        }
    }

    public void createTugas(String namaTugas) {
        if (numTugas < tugas.length) {
            tugas[numTugas] = new Tugas(namaTugas);
            numTugas++;
            System.out.println("![SUKSES]-Tugas [" + namaTugas + "] berhasil dimasukkan ke proyek " + this.namaProyek);
        } else {
            System.out.println("![GAGAL]-Tugas pada Proyek " + namaProyek + " sudah melebihi batas");
        }
    }

    public void removeProgrammer(int indexProgrammer) {
        if ((indexProgrammer < numProgrammer) && (indexProgrammer >= 0)) {
            System.out.println("![SUKSES]-Programmer " + programmer[indexProgrammer].getNama() + " telah terhapus dari proyek " + this.getNamaProyek());
            for (int i = 0; i < numTugas; i++) {
                if (tugas[i].getPelaksana().equals(programmer[indexProgrammer])) {
                    removeTugas(i);
                }
            }
            //mekanisme penggeseran
            for (int i = indexProgrammer; i < numProgrammer; i++) {
                programmer[i] = programmer[i + 1];
            }
            programmer[numProgrammer] = null;
            numProgrammer--;
            if (numProgrammer == 0) {
                System.out.println("![INFO]-List Programmer proyek " + this.namaProyek + " habis.");
            }
        } else {
            System.out.println("![GAGAL]-Programmer tidak bisa dihapus");
        }
    }

    public void removeTugas(int indexTugas) {
        if ((indexTugas < numTugas) && (indexTugas >= 0)) {
            System.out.println("![SUKSES]-Tugas " + tugas[indexTugas].getNamaTugas() + " telah terhapus dari proyek " + this.getNamaProyek());
            for (int i = indexTugas; i < numTugas; i++) {
                tugas[i] = tugas[i + 1];
            }
            tugas[numTugas] = null;
            numTugas--;
            if (numTugas == 0) {
                System.out.println("![INFO]-List Tugas proyek " + this.namaProyek + " habis.");
            }
        } else {
            System.out.println("![GAGAL]-Tugas tidak bisa dihapus");
        }
    }

    public Tugas getTugas(int indexTugas) {
        return tugas[indexTugas];
    }

    public Programmer getProgrammer(int indexProgrammer) {
        return programmer[indexProgrammer];
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public int getNumProgrammer() {
        return numProgrammer;
    }

    public int getNumTugas() {
        return numTugas;
    }
}
