/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfomanagementproyek;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Notonogoro
 */
public class AplikasiKonsol {
    // private ManajerProyek[] daftarManajerProyek = new ManajerProyek[10];   

    private ArrayList<ManajerProyek> daftarManajerProyek = new ArrayList<ManajerProyek>();
    //private Programmer[] daftarProgrammer = new Programmer[200];
    private ArrayList<Programmer> daftarProgrammer = new ArrayList<Programmer>();
    private int indexLogin = -1;
    private ManajerProyek mp;
    private Programmer p;
    private Proyek pro;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Scanner in = new Scanner(System.in);
    int pil;

    public void addManajerProyek(ManajerProyek m) {
        daftarManajerProyek.add(m);
    }

    public void addProgrammer(Programmer p) {
        daftarProgrammer.add(p);
    }

    public Programmer searchProgrammer(String id) {
        for (int i = 0; i < daftarProgrammer.size(); i++) {
            if (daftarProgrammer.get(i).getID().equals(id)) {
                return daftarProgrammer.get(i);
            }
        }
        return null;
    }

    public void deleteProgrammer(String id) {
        if (searchProgrammer(id) != null) {
            daftarProgrammer.remove(searchProgrammer(id));
        }
    }

    public ManajerProyek searchManajerProyek(String id) {
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            if (daftarManajerProyek.get(i).getID().equals(id)) {
                return daftarManajerProyek.get(i);
            }
        }
        return null;
    }

    public void deleteManajerProyek(String id) {
        if (searchManajerProyek(id) != null) {
            daftarManajerProyek.remove(searchManajerProyek(id));
        }
    }

    public int hitungProyekProgrammer(Programmer p) {
        int temp = 0;
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            for (int j = 0; j < daftarManajerProyek.get(i).getSizeProyek(); j++) {
                for (int x = 0; x < daftarManajerProyek.get(i).getProyek(j).getSizeProgrammer(); x++) {
                    if (daftarManajerProyek.get(i).getProyek(j).getProgrammer(x).equals(p)) {
                        temp++;
                    }
                }
            }
        }
        return temp;
    }

    public Proyek[] arProyekProgrammer(Programmer p) {
        int temp = 0;
        int s = 0;
        Proyek[] ar = new Proyek[hitungProyekProgrammer(p)];
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            for (int j = 0; j < daftarManajerProyek.get(i).getSizeProyek(); j++) {
                for (int x = 0; x < daftarManajerProyek.get(i).getProyek(j).getSizeProgrammer(); x++) {
                    if (daftarManajerProyek.get(i).getProyek(j).getProgrammer(x).equals(p)) {
                        ar[s] = daftarManajerProyek.get(i).getProyek(j);
                        s++;
                    }
                }
            }
        }
        return ar;
    }

    public int cekTugasSelesai(Programmer p, Proyek x) {
        int temp = 0;
        for (int i = 0; i < x.getSizeTugas(); i++) {
            if (x.getTugas(i).getPelaksana().equals(p) && x.getTugas(i).getStatus() != 0) {
                temp++;
            }
        }
        return temp;
    }

    public int cekTugasProgrammer(Programmer p) { //cekTugasbelumselesai
        int temp = 0;
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            for (int j = 0; j < mp.getProyek(i).getSizeTugas(); j++) {
                if (mp.getProyek(i).getTugas(j).getPelaksana().equals(p) && mp.getProyek(i).getTugas(j).getStatus() != 1) {
                    temp++;
                }
            }
        }
        return temp;
    }

    public int cekTugasProgrammer(Programmer p, Proyek pro) { //cekTugasbelumselesai
        int temp = 0;
        for (int j = 0; j < pro.getSizeTugas(); j++) {
            if (pro.getTugas(j).getPelaksana().equals(p) && pro.getTugas(j).getStatus() != 1) {
                temp++;
            }
        }

        return temp;
    }

    public void setStatusTugas(Programmer p, Tugas t) {
        if (t != null && t.getPelaksana() == p) {
            t.setStatus(1);
        }
    }

    public boolean cekID(String id, String user) {
        if (user.equals("mp")) {
            for (int i = 0; i < daftarManajerProyek.size(); i++) {
                if (daftarManajerProyek.get(i).getID().equals(id)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String[][] menuManajerProyek() {
        String[][] ar = new String[daftarManajerProyek.size()][3];
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            ar[i][0] = daftarManajerProyek.get(i).getNama();
            ar[i][1] = daftarManajerProyek.get(i).getID();
            ar[i][2] = Integer.toString(daftarManajerProyek.get(i).getSizeProyek());
        }
        return ar;
    }

    public String[][] menuProgrammer() {
        String[][] ar = new String[daftarProgrammer.size()][3];
        for (int i = 0; i < daftarProgrammer.size(); i++) {
            ar[i][0] = daftarProgrammer.get(i).getNama();
            ar[i][1] = daftarProgrammer.get(i).getID();
            ar[i][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
        }
        return ar;
    }

    public ManajerProyek menuAddManajerProyek(String nama, String jenisKelamin, String telepon, String alamat, String Id, String Password) {
        ManajerProyek m = new ManajerProyek(nama, jenisKelamin, telepon, alamat, Id, Password);
        addManajerProyek(m);
        return m;
    }

    public Programmer menuAddProgrammer(String nama, String jenisKelamin, String telepon, String alamat, String Id, String Password) {
        Programmer p = new Programmer(nama, jenisKelamin, telepon, alamat, Id, Password);
        addProgrammer(p);
        return p;
    }

    public ManajerProyek menuRemoveManajerProyek(String id) {
        ManajerProyek temp = searchManajerProyek(id);
        deleteManajerProyek(id);
        return temp;
    }

    public Programmer menuRemoveProgrammer(String id) {
        Programmer p = searchProgrammer(id);
        deleteProgrammer(id);
        return p;
    }

    public ManajerProyek menuSearchManajerProyek(String id) {
        ManajerProyek temp = searchManajerProyek(id);
        if (temp != null) {
            mp = temp;
        }
        return temp;
    }

    public Programmer menuSearchProgrammer(String id) {
        Programmer temp = searchProgrammer(id);
        if (temp != null) {
            p = temp;
        }
        return temp;
    }

    public String[][] menuViewProyek() {//SearchProgrammer untuk ManajerProyek
        pro = null;
        String[][] ar = new String[mp.getSizeProyek()][4];
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            int temp = 0;
            for (int j = 0; j < mp.getProyek(i).getSizeTugas(); j++) {
                if (mp.getProyek(i).getTugas(j).getStatus() != 1) {
                    temp++;
                }
            }
            ar[i][0] = mp.getProyek(i).getNamaProyek();
            ar[i][1] = Integer.toString(mp.getProyek(i).getSizeProgrammer());
            ar[i][2] = Integer.toString(temp);
            ar[i][3] = sdf.format(mp.getProyek(i).getDeadline());
        }
        return ar;

    }

    public String[][] menuViewProyekProgrammer() { //SearchProgrammer untuk Programmer
        String[][] ar = new String[hitungProyekProgrammer(p)][5];
        Proyek[] temp = arProyekProgrammer(p);
        for (int i = 0; i < hitungProyekProgrammer(p); i++) {
            ar[i][0] = temp[i].getNamaProyek();
            ar[i][1] = Integer.toString(temp[i].getSizeProgrammer());
            ar[i][2] = Integer.toString(cekTugasProgrammer((p), temp[i]));
            ar[i][3] = Integer.toString(cekTugasSelesai(p, temp[i]));
            ar[i][4] = sdf.format(temp[i].getDeadline());

        }
        return ar;
    }

    public String[][] menuDetailProyekProgrammer(int indexProyek) { //DetailProyek untuk Programmer
        Proyek[] t = arProyekProgrammer(p);
        pro = t[indexProyek];
        if(pro!=null){
        String[][] ar = new String[pro.getSizeTugas()][4];
        ar[0][0] = pro.getNamaProyek();
        ar[0][1] = sdf.format(pro.getDeadline());
        ar[0][2] = Integer.toString(pro.getSizeProgrammer());
        ar[0][3] = Integer.toString(pro.getSizeTugas());
        for (int i = 0; i < pro.getSizeTugas(); i++) {
            ar[i][0] = pro.getTugas(i).getNamaTugas();
            ar[i][1] = Integer.toString(pro.getTugas(i).getStatus());
        }
        return ar;
        }else return null;
    }

    public Tugas menuSetStatusTugas(int indexTugas) {
        if(pro.getTugas(indexTugas)!=null){
        pro.getTugas(indexTugas).setStatus(1);
        return pro.getTugas(indexTugas);
        }else return null;
    }

    public Proyek searchProyek(int index) { //ManajerProyek
        return mp.getProyek(index);
    }

    public Proyek menuCreateProyek(String namaProyek, Date deadline) {
        mp.createProyek(namaProyek, deadline);
        return mp.getProyek(mp.getSizeProyek() - 1);
    }

    public Proyek menuRemoveProyek(int index) {
        
        Proyek temp = mp.getProyek(index);
        if(temp!=null){
        mp.deleteProyek(index);
        return temp;}
        else return null;
    }

    public String[][] menuDetailProyek(int indexProyek) { //ManajerProyek
        pro = searchProyek(indexProyek);
        if(pro!=null){
        String[][] ar = new String[pro.getSizeTugas() + 1][4];
        if (pro != null) {
            ar[0][0] = pro.getNamaProyek();
            ar[0][1] = sdf.format(pro.getDeadline());
            ar[0][2] = Integer.toString(pro.getSizeProgrammer());
            ar[0][3] = Integer.toString(pro.getSizeTugas());
            for (int i = 1; i < pro.getSizeTugas() + 1; i++) {
                ar[i][0] = pro.getTugas(i).getNamaTugas();
                ar[i][1] = pro.getTugas(i).getPelaksana().getNama();
                ar[i][2] = Integer.toString(pro.getTugas(i).getStatus());
            }
        }
        
        return ar;
        }else return null;
    }

    public Tugas menuCreateTugas(String namaTugas) {
        pro.createTugas(namaTugas);
        return pro.getTugas(pro.getSizeTugas() - 1);
    }

    public Tugas menuCreateTugas(String namaTugas, int indexPelaksana) {
        pro.createTugas(namaTugas);
        pro.getTugas(pro.getSizeTugas() - 1).setPelaksana(pro.getProgrammer(indexPelaksana - 1));
        return pro.getTugas(pro.getSizeTugas() - 1);
    }

    public Tugas menuRemoveTugas(int index) {
        if (index > 0) {
            Tugas temp = pro.getTugas(index);
            pro.removeTugas(index);
            return temp;
        } else {
            return null;
        }

    }

    public String[][] menuViewPelaksana(Proyek p) {
        String[][] ar = new String[p.getSizeProgrammer()][2];
        for (int i = 0; i < p.getSizeProgrammer(); i++) {
            ar[i][0] = p.getProgrammer(i).getNama();
            ar[i][1] = Integer.toString(cekTugasProgrammer(p.getProgrammer(i)));
        }
        return ar;
    }

    public Tugas menuSetPelaksana(int indexPelaksana, int indexTugas) {
        pro.getTugas(indexTugas).setPelaksana(pro.getProgrammer(indexPelaksana));
        return pro.getTugas(indexTugas);
    }

    public int jumlahProgrammer(ManajerProyek mp) {
        int temp = 0;
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            temp = temp + mp.getProyek(i).getSizeProgrammer();
        }
        return temp;
    }

    public String[][] menuViewProgrammerMP() {
        String[][] ar = new String[jumlahProgrammer(mp)][5];
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            for (int j = 0; j < mp.getProyek(i).getSizeProgrammer(); j++) {
                ar[i][0] = mp.getProyek(i).getNamaProyek();
                ar[i][1] = mp.getProyek(i).getProgrammer(i).getNama();
                ar[i][2] = Integer.toString(cekTugasProgrammer(mp.getProyek(i).getProgrammer(j), mp.getProyek(i)));
                ar[i][3] = Integer.toString(cekTugasSelesai(mp.getProyek(i).getProgrammer(j), mp.getProyek(i)));
                ar[i][4] = sdf.format(mp.getProyek(i).getDeadline());
            }
        }
        return ar;
    }

    public String[][] listProgrammerTersedia() {
        String[][] ar = new String[pro.getSizeProgrammer()][3];
        for (int j = 0; j < pro.getSizeProgrammer(); j++) {
            ar[j][0] = pro.getProgrammer(j).getNama();
            ar[j][1] = pro.getProgrammer(j).getID();
            ar[j][2] = Integer.toString(hitungProyekProgrammer(pro.getProgrammer(j)));

        }

        return ar;
    }

    public String[][] listProgrammerTersediaP() {
        String[][] ar = new String[daftarProgrammer.size() - pro.getSizeProgrammer()][3];
        for (int i = 0; i < daftarProgrammer.size(); i++) {
            if (pro.getSizeProgrammer() != 0) {
                for (int j = 0; j < pro.getSizeProgrammer(); j++) {
                    if (daftarProgrammer.get(i) != pro.getProgrammer(j)) {
                        ar[i][0] = daftarProgrammer.get(i).getNama();
                        ar[i][1] = daftarProgrammer.get(i).getID();
                        ar[i][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
                    }
                }
            } else {
                ar[i][0] = daftarProgrammer.get(i).getNama();
                ar[i][1] = daftarProgrammer.get(i).getID();
                ar[i][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
            }
        }

        return ar;
    }

    public Programmer menuAddProgrammer(String[][] ar, int indexProgrammer) { //menuViewProyek - >  listProgrammerTersedia
        Programmer temp = searchProgrammer(ar[indexProgrammer][1]);
        if(temp!=null){
        pro.addProgrammer(temp);
        return temp;
        } else return null;
    }

    /*public Programmer menuRemoveProgrammer(int indexProgrammer, int indexProyek) { //menuViewProgrammerMP
        Programmer temp = mp.getProyek(indexProyek).getProgrammer(indexProgrammer);
        mp.getProyek(indexProyek).removeProgrammer(indexProgrammer);
        return temp;
    }*/
    public Programmer menuRemoveProgrammer(int indexProgrammer) { //menuViewProgrammerMP
        Programmer temp = pro.getProgrammer(indexProgrammer);
        if(temp!=null){
        pro.removeProgrammer(indexProgrammer);
        return temp;
        }else return null;
    }

    public Programmer menuLogoutProgrammer() {
        Programmer temp = p;
        p = null;
        pro = null;
        return temp;
    }

    public ManajerProyek menuLogoutManajerProyek() {
        ManajerProyek temp = mp;
        mp = null;
        pro = null;
        return temp;
    }

    public void MainMenu() {
        do {
            String input = null;
            boolean ceker = false;
            System.out.println("Aplikasi Manajemen Proyek");
            System.out.println("1. ManajerProyek");
            System.out.println("2. Programmer");
            System.out.println("3. Admin");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan Menu: ");
            String[][] ar2;
            pil = in.nextInt();
            String nama = "",
                    jenisKelamin = "",
                    telepon = "",
                    alamat = "",
                    Id = "",
                    Password = "";
            switch (pil) {
                case 1:
                    System.out.print("Input ID ManajerProyek");
                    in.nextLine();
                    System.out.println("ID: ");
                    Id = in.nextLine();
                    if (menuSearchManajerProyek(Id) != null) {
                        int pil1 = -1;
                        do {
                            ar2 = menuViewProyek();
                            System.out.println("Selamat Datang ManajerProyek " + mp.getNama());
                            System.out.println("--------------------------------------------------");

                            if (ar2.length != 0) {
                                System.out.println("Daftar Proyek");
                                System.out.println("---------------------------");
                                System.out.println("No  Keterangan");
                                for (int i = 0; i < ar2.length; i++) {
                                    System.out.print(i);
                                    System.out.println("   Nama              : " + ar2[i][0]);
                                    System.out.println("   Jumlah Programmer : " + ar2[i][1]);
                                    System.out.println("   Jumlah Tugas      : " + ar2[i][2]);
                                    System.out.println("   Deadline          : " + ar2[i][3]);
                                    System.out.println("");
                                }
                            }

                            System.out.println("Menu Manajer Proyek");
                            System.out.println("1. Add Proyek");
                            System.out.println("2. Delete Proyek");
                            System.out.println("3. Detail Proyek");
                            System.out.println("4. Logout");
                            System.out.print("Masukkan Pilihan Menu : ");
                            pil1 = in.nextInt();
                            switch (pil1) {
                                case 1:
                                    System.out.println("Input Nama>>");
                                    do {
                                        in.nextLine();
                                        System.out.print("Nama :");
                                        nama = in.nextLine();
                                        if (nama.equals("")) {
                                            System.out.print("-Nama harus diisi!");
                                            ceker = false;
                                        } else {
                                            ceker = true;
                                        }
                                    } while (ceker == false);

                                    System.out.println("-------------------------------------------");
                                    ceker = false;
                                    System.out.print("Input Date>>");
                                    int thn = -2;
                                    int bln = -2;
                                    int hr = -2;
                                    in.nextLine();

                                    System.out.print("Tahun : ");

                                    thn = in.nextInt();

                                    System.out.print("Bulan : ");

                                    bln = in.nextInt();

                                    System.out.print("Tanggal : ");
                                    hr = in.nextInt();

                                    Date deadline = new Date(thn - 1900, bln - 1, hr);
                                    System.out.println("-------------------------------------------");
                                    ceker = false;
                                    Proyek temp = menuCreateProyek(nama, deadline);

                                    break;
                                case 2:
                                    int tempC2;
                                    Proyek tempC2Pr;

                                    System.out.print("Input index proyek yang ingin dihapus : ");
                                    tempC2 = in.nextInt();
                                    tempC2Pr = menuRemoveProyek(tempC2);
                                    if (tempC2Pr != null) {
                                        System.out.println("Proyek " + tempC2Pr.getNamaProyek() + " terhapus");
                                    } else {
                                        System.out.println("Gagal.");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Input index proyek untuk detail : ");
                                    int pil13 = -2;
                                    int tempil = -2;
                                    int tempil2 = -2;
                                    Tugas tempT;
                                    tempC2 = in.nextInt();

                                    ar2 = menuDetailProyek(tempC2);
                                    System.out.println(pro.getNamaProyek());
                                    if (ar2.length != 0) {
                                        do {

                                            ar2 = menuDetailProyek(tempC2);
                                            System.out.print("Nama Proyek " + ar2[0][0]);

                                            System.out.println("     Deadline " + ar2[0][1]);
                                            System.out.print("Size Programmer : " + ar2[0][2]);
                                            System.out.println("            Size Tugas  : " + ar2[0][3]);
                                            System.out.println("");
                                            if (ar2.length > 1) {

                                                System.out.println("Daftar Tugas");
                                                System.out.println("---------------------------");
                                                System.out.println("No  Keterangan");
                                                for (int i = 0; i < ar2.length; i++) {
                                                    System.out.print(i);
                                                    System.out.println("   Nama Tugas         : " + ar2[i][0]);
                                                    System.out.println("   Pelaksana           : " + ar2[i][1]);
                                                    System.out.println("   Status Tugas  : " + ar2[i][2]);
                                                    System.out.println("");
                                                }
                                            }
                                            ar2 = listProgrammerTersedia();

                                            if (ar2.length > 0) {
                                                System.out.println("Programmer dalam Proyek");
                                                for (int i = 0; i < ar2.length; i++) {
                                                    System.out.print(i);
                                                    System.out.println("   Nama          : " + ar2[i][0]);
                                                    System.out.println("   ID            : " + ar2[i][1]);
                                                    System.out.println("   Jumlah Proyek : " + ar2[i][2]);
                                                    System.out.println("");
                                                }
                                            }

                                            System.out.println("Menu  :");
                                            System.out.println("1. Create Tugas");
                                            System.out.println("2. Remove Tugas");
                                            System.out.println("3. Set Pelaksana");
                                            System.out.println("4. Add Programmer");
                                            System.out.println("5. Remove Programmer");
                                            System.out.println("6. Menu ManajerProyek");
                                            System.out.print("Pilih Menu : ");
                                            pil13 = in.nextInt();
                                            switch (pil13) {
                                                case 1:
                                                    System.out.print("Input Nama>>");
                                                    do {
                                                        nama = "";
                                                        in.nextLine();
                                                        System.out.print("Nama :");
                                                        nama = in.nextLine();
                                                        if (nama.equals("")) {
                                                            System.out.print("-Nama harus diisi!");
                                                            ceker = false;
                                                        } else {
                                                            ceker = true;
                                                        }
                                                    } while (ceker == false);
                                                    ceker = false;
                                                    menuCreateTugas(nama);
                                                    nama = "";
                                                    break;
                                                case 2:
                                                    System.out.println("Input Index Tugas diatas yang ingin dihapus>>");

                                                    tempil = -2;
                                                    System.out.print("Index :");
                                                    tempil = in.nextInt();
                                                    tempT = menuRemoveTugas(tempC2);
                                                    if (tempT != null) {
                                                        System.out.println("Tugas " + tempT.getNamaTugas() + " berhasil dihapus");
                                                    } else {
                                                        System.out.println("Gagal.");
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Input Index Tugas diatas yang ingin diset>>");
                                                    tempil = -2;
                                                    tempil2 = -2;
                                                    System.out.print("Index :");
                                                    tempil = in.nextInt();
                                                    if (tempil > 0) {

                                                        System.out.println("");
                                                        System.out.println("Input Index Pelaksana>>");

                                                        System.out.println("Index : ");
                                                        tempil2 = in.nextInt();
                                                        tempT = menuSetPelaksana(tempil2, tempil);
                                                        if (tempT != null) {
                                                            System.out.println("Tugas " + tempT.getNamaTugas() + " berhasil diset");
                                                        } else {
                                                            System.out.println("Gagal.");
                                                        }
                                                    } else {
                                                        System.out.println("Index Tugas tidak ada.");
                                                    }
                                                    break;
                                                case 4:
                                                    ar2 = listProgrammerTersediaP();
                                                    if (ar2.length != 0) {
                                                        System.out.println("Daftar Programmer Tersedia");
                                                        System.out.println("---------------------------");
                                                        System.out.println("No  Keterangan");
                                                        for (int i = 0; i < ar2.length; i++) {
                                                            System.out.print(i);
                                                            System.out.println("   Nama Programmer : " + ar2[i][0]);
                                                            System.out.println("   ID              : " + ar2[i][1]);
                                                            System.out.println("   Jumlah Proyek   : " + ar2[i][2]);
                                                            System.out.println("");
                                                        }
                                                        System.out.println("---------------------------");

                                                        System.out.println("Input Index Programmer >>");
                                                        System.out.print("Index : ");
                                                        tempil = -2;
                                                        tempil = in.nextInt();
                                                        Programmer tempP = menuAddProgrammer(ar2, tempil);
                                                        if (tempP != null) {
                                                            System.out.println("Programmer " + tempP.getNama() + " berhasil ditambahkan");
                                                        } else {
                                                            System.out.println("Gagal.");
                                                        }

                                                    } else {
                                                        System.out.println("Tidak ada list Programmer tersedia");
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.println("Input Index Programmer untuk dihapus >>");
                                                    System.out.print("Index : ");
                                                    tempil = -2;
                                                    tempil = in.nextInt();
                                                    Programmer tempP = menuRemoveProgrammer(tempil);
                                                    if (tempP != null) {
                                                        System.out.println("Programmer " + tempP.getNama() + " berhasil dihapus");
                                                    } else {
                                                        System.out.println("Gagal.");
                                                    }
                                                    break;

                                            }

                                        } while (pil13 != 6);
                                    }

                                    break;
                                case 4:
                                    menuLogoutManajerProyek();
                                    break;
                            }

                        } while (pil1 != 4);
                    } else {
                        System.out.println("ID tidak ada");
                    }
                    break;
                case 2:

                    break;
                case 3:
                    int pil3;
                    do {
                        ar2 = menuManajerProyek();
                        if (ar2.length != 0) {
                            System.out.println("Daftar Manajer Proyek");
                            System.out.println("---------------------------");
                            System.out.println("No  Keterangan");
                            for (int i = 0; i < ar2.length; i++) {
                                System.out.print(i);
                                System.out.println("   Nama          : " + ar2[i][0]);
                                System.out.println("   ID            : " + ar2[i][1]);
                                System.out.println("   Jumlah Proyek : " + ar2[i][2]);
                                System.out.println("");
                            }
                        }
                        ar2 = menuProgrammer();
                        if (ar2.length != 0) {
                            System.out.println("Daftar Programmer");
                            System.out.println("---------------------------");
                            System.out.println("No  Keterangan");
                            for (int i = 0; i < ar2.length; i++) {
                                System.out.print(i);
                                System.out.println("   Nama          : " + ar2[i][0]);
                                System.out.println("   ID            : " + ar2[i][1]);
                                System.out.println("   Jumlah Proyek : " + ar2[i][2]);
                                System.out.println("");
                            }

                            System.out.println("---------------------------");
                        }

                        System.out.println("Menu :");
                        System.out.println("1. AddManajerProyek");
                        System.out.println("2. AddProgrammer");
                        System.out.println("3. Remove ManajerProyek");
                        System.out.println("4. Remove Programmer");
                        System.out.println("5. Main Menu");
                        System.out.print("Pilih Menu : ");
                        pil3 = in.nextInt();
                        nama = "";
                        jenisKelamin = "";
                        telepon = "";
                        alamat = "";
                        Id = "";
                        Password = "";
                        mp = null;
                        p = null;
                        switch (pil3) {
                            case 1:

                                //boolean ceker=false;
                                System.out.println("Add New Manajer Proyek");
                                System.out.println("");

                                System.out.println("Input Nama>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Nama :");
                                    nama = in.nextLine();
                                    if (nama.equals("")) {
                                        System.out.print("-Nama harus diisi!");
                                        ceker = false;
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Jenis Kelamin>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Jenis Kelamin (L/P) :");
                                    jenisKelamin = in.nextLine();
                                    if (jenisKelamin.equals("")) {
                                        System.out.print("-Jenis Kelamin harus diisi!");
                                    } else if (!jenisKelamin.equalsIgnoreCase("p") && !jenisKelamin.equalsIgnoreCase("l")) {
                                        System.out.print("-Jenis Kelamin harus (p / l)");
                                    } else {
                                        ceker = true;
                                    }

                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Telepon>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Telepon : ");
                                    telepon = in.nextLine();
                                    if (telepon.equals("")) {
                                        System.out.print("-Telepon harus diisi!");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Alamat>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Alamat : ");

                                    alamat = in.nextLine();
                                    if (alamat.equals("")) {
                                        System.out.print("-Alamat harus diisi !");
                                        System.out.println("");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;
                                System.out.println("Input ID>>");
                                System.out.print("ID Tidak boleh ada spasi !");
                                do {
                                    in.nextLine();
                                    System.out.print("ID : ");
                                    Id = in.next();
                                    if (Id.equals("")) {
                                        System.out.print("-Id harus diisi !");
                                        System.out.println("");
                                    } else if (searchManajerProyek(Id) == null) {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;
                                System.out.print("Input Password>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Password : ");
                                    Password = in.nextLine();
                                    if (Password.equals("")) {
                                        System.out.print("-Password harus diisi !");
                                        System.out.println("");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                menuAddManajerProyek(nama, jenisKelamin, telepon, alamat, Id, Password);
                                break;
                            case 2:
                                //boolean ceker=false;
                                System.out.println("Add New Programmer");
                                System.out.println("");

                                System.out.println("Input Nama>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Nama :");
                                    nama = in.nextLine();
                                    if (nama.equals("")) {
                                        System.out.print("-Nama harus diisi!");
                                        ceker = false;
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Jenis Kelamin>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Jenis Kelamin (L/P) :");
                                    jenisKelamin = in.nextLine();
                                    if (jenisKelamin.equals("")) {
                                        System.out.print("-Jenis Kelamin harus diisi!");
                                    } else if (!jenisKelamin.equalsIgnoreCase("p") && !jenisKelamin.equalsIgnoreCase("l")) {
                                        System.out.print("-Jenis Kelamin harus (p / l)");
                                    } else {
                                        ceker = true;
                                    }

                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Telepon>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Telepon : ");
                                    telepon = in.nextLine();
                                    if (telepon.equals("")) {
                                        System.out.print("-Telepon harus diisi!");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;

                                System.out.print("Input Alamat>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Alamat : ");
                                    alamat = in.nextLine();
                                    if (alamat.equals("")) {
                                        System.out.print("-Alamat harus diisi !");
                                        System.out.println("");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;
                                System.out.println("Input ID>>");
                                System.out.print("ID Tidak boleh ada spasi !");
                                do {
                                    in.nextLine();
                                    System.out.print("ID : ");
                                    Id = in.next();
                                    if (Id.equals("")) {
                                        System.out.print("-Id harus diisi !");
                                        System.out.println("");
                                    } else if (searchManajerProyek(Id) == null) {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                ceker = false;
                                System.out.print("Input Password>>");
                                do {
                                    in.nextLine();
                                    System.out.print("Password : ");
                                    Password = in.nextLine();
                                    if (Password.equals("")) {
                                        System.out.print("-Password harus diisi !");
                                        System.out.println("");
                                    } else {
                                        ceker = true;
                                    }
                                } while (ceker == false);
                                System.out.println("-------------------------------------------");
                                menuAddProgrammer(nama, jenisKelamin, telepon, alamat, Id, Password);
                                break;
                            case 3:
                                System.out.print("Input ID ManajerProyek");
                                in.nextLine();
                                System.out.println("ID: ");
                                Id = in.nextLine();
                                mp = menuRemoveManajerProyek(Id);
                                if (mp != null) {
                                    System.out.println(mp.getNama() + " telah dihapus");
                                } else {
                                    System.out.println("Gagal.");
                                }
                                break;
                            case 4:
                                System.out.println("Input ID Programmer");
                                in.nextLine();
                                System.out.println("ID: ");
                                Id = in.nextLine();
                                p = menuRemoveProgrammer(Id);
                                if (p != null) {
                                    System.out.println(p.getNama() + " telah dihapus");
                                } else {
                                    System.out.println("Gagal.");
                                }
                                break;
                        }
                    } while (pil3 != 5);
                    break;
            }

        } while (pil
                != 4);
    }
}
