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
public class ManajerProyek extends Orang {

    private Proyek[] proyek;
    private int numProyek = 0;

    public ManajerProyek(String nama, String jenisKelamin, String telepon, String alamat) {
        super(nama, jenisKelamin, telepon, alamat);
        proyek = new Proyek[10];
    }

    public ManajerProyek(String nama, String jenisKelamin, String telepon, String alamat, int maxProyek) {
        super(nama, jenisKelamin, telepon, alamat);
        proyek = new Proyek[maxProyek];
    }

    public void createProyek(String namaProyek, Date deadline) {
        if (numProyek < proyek.length) {
            proyek[numProyek] = new Proyek(namaProyek, deadline);
            numProyek++;
            System.out.println("![SUKSES]-Proyek " + namaProyek + " berhasil ditambahkan.");
        } else {
            System.out.println("![INFO]-Gagal.Proyek sudah melebihi batas");
        }
    }

    public void createProyek(String namaProyek, Date deadline, int maxTugas) {
        if (numProyek < proyek.length) {
            proyek[numProyek] = new Proyek(namaProyek, deadline, maxTugas);
            numProyek++;
            System.out.println("![SUKSES]-Proyek " + namaProyek + " berhasil ditambahkan.");
        } else {
            System.out.println("![INFO]-Gagal. Proyek sudah melebihi batas");
        }
    }

    public Proyek getProyek(int index) {
        if (index <= numProyek) {
            return proyek[index];
        } else {
            return null;
        }
    }

    public void deleteProyek(int index) {
        if ((index < numProyek) && (index >= 0)) {
            System.out.println("![SUKSES]-Proyek "+proyek[index].getNamaProyek() + " telah terhapus");
            proyek[index] = null;
            //mekanisme penggeseran
            for (int i = index; i < numProyek; i++) {
                proyek[i] = proyek[i + 1];
            }
            proyek[numProyek]=null;
            numProyek--;
            if (numProyek == 0) {
                System.out.println("![INFO]-List Proyek Manager Proyek habis.");
            }

        } else {
            System.out.println("![INFO]-Gagal.Tidak ada proyek yang terdeteksi");
        }
    }

    public int getNumProyek() {
        return numProyek;
    }

}
