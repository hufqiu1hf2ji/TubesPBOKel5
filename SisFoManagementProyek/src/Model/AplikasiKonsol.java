/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    private int indexLogina = -1;
    static private ManajerProyek mp;
    static private Programmer p;
    static private Proyek pro;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Scanner in = new Scanner(System.in);
    int pil;

    //FUNGSIONALITAS BERSAMA
    //----------------------------------------------------------------------------------------------------
    public void setNonAktifPro() {
        pro = null;
    }

    public String getMPAktif() {
        if (mp != null) {
            return mp.getNama();
        }
        return "Anda siapa?";
    }

    public String getPAktif() {
        if (p != null) {
            return p.getNama();
        }
        return "Anda siapa?";
    }

    public String getProyekAktif() {
        if (pro != null) {
            return pro.getNamaProyek();
        }
        return "Tidak ada";
    }

    //Mencari Programmer di SISTEM berdasarkan ID - Penggunaan : Admin(Add Programmer) , Admin(Delete Programmer) , ManajerProyek (Add Programmer) , Login Programmer.
    public Programmer searchProgrammer(String id) {
        for (int i = 0; i < daftarProgrammer.size(); i++) {
            if (daftarProgrammer.get(i).getID().equals(id)) {
                return daftarProgrammer.get(i);
            }
        }
        return null;
    }

    //Mencari ManajerPRoyek di SISTEM berdasarkan ID - Penggunaan : Admin(Add Manajer Proyek) , Admin(Delete Manajer Proyek), Login Manajer Proyek. 
    public ManajerProyek searchManajerProyek(String id) {
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            if (daftarManajerProyek.get(i).getID().equals(id)) {
                return daftarManajerProyek.get(i);
            }
        }
        return null;
    }

    //Mengecek Tugas yang belum selesai
    public int jumlahTugasProgrammerS(Programmer p, Proyek x) {
        int temp = 0;
        for (int i = 0; i < x.getSizeTugas(); i++) {
            if (x.getTugas(i).getPelaksana() != null) {
                if (x.getTugas(i).getPelaksana().equals(p) && x.getTugas(i).getStatus() != 0) {
                    temp++;
                }
            }
        }
        return temp;
    }

    //Menghitung jumlah Proyek pada Programmer di SISTEM - Penggunaan : Admin(Menu Utama) , ManajerProyek(AddProgrammer) , Programmer(Menu Utama). 
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

    //Menghitung jumlah Tugas Programmer yang belum selesai di Proyek - Penggunaan : Programmer & ManajerProyek
    public int jumlahTugasProgrammerBS(Programmer p, Proyek pro) {
        int temp = 0;
        for (int j = 0; j < pro.getSizeTugas(); j++) {
            if (pro.getTugas(j).getPelaksana() != null) {
                if (pro.getTugas(j).getPelaksana().equals(p) && pro.getTugas(j).getStatus() != 1) {
                    temp++;
                }

            }

        }
        return temp;
    }

    //CekID untuk pembuatan ManajerProyek atau Programmer supaya tidak memiliki ID yang sama.
    public boolean cekID(String id) {
        for (int i = 0; i < daftarManajerProyek.size(); i++) {
            if (daftarManajerProyek.get(i).getID().equals(id)) {
                return false;
            }
        }
        for (int i = 0; i < daftarProgrammer.size(); i++) {
            if (daftarProgrammer.get(i).getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    /*
    public int cekTugasProgrammer(Programmer p) { //cekTugasbelumselesai untuk detail programmer
        int temp = 0;
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            for (int j = 0; j < mp.getProyek(i).getSizeTugas(); j++) {
                if (mp.getProyek(i).getTugas(j).getPelaksana().equals(p) && mp.getProyek(i).getTugas(j).getStatus() != 1) {
                    temp++;
                }
            }
        }
        return temp;
    }*/
    //----------------------------------------------------------------------------------------------------
    //FUNGSIONALITAS ADMIN.
    //----------------------------------------------------------------------------------------------------
    //Menambahkan ManajerProyek ke list sistem
    public void addManajerProyek(ManajerProyek m) {
        daftarManajerProyek.add(m);
    }

    //Menambahkan Programmer ke list sistem
    public void addProgrammer(Programmer p) {
        daftarProgrammer.add(p);
    }

    //Menghapus Programmer dari SISTEM berdasarkan ID
    public void deleteProgrammer(String id) {
        if (searchProgrammer(id) != null) {
            daftarProgrammer.remove(searchProgrammer(id));
        }
    }

    //Menghapus ManajerProyek dari SISTEM berdasarkan ID
    public void deleteManajerProyek(String id) {
        if (searchManajerProyek(id) != null) {
            daftarManajerProyek.remove(searchManajerProyek(id));
        }
    }

    //MENU ADMIN.
    //Mengumpulkan List Programmer pada SISTEM.
    public String[][] menuListProgrammer() {
        if (daftarProgrammer.size() != 0) {
            String[][] ar = new String[daftarProgrammer.size()][3];
            for (int i = 0; i < daftarProgrammer.size(); i++) {
                ar[i][0] = daftarProgrammer.get(i).getNama();
                ar[i][1] = daftarProgrammer.get(i).getID();
                ar[i][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
            }
            return ar;
        } else {
            return null;
        }
    }

    //Mengumpulkan List ManajerProyek pada SISTEM.
    public String[][] menuListManajerProyek() {
        if (daftarManajerProyek.size() != 0) {
            String[][] ar = new String[daftarManajerProyek.size()][3];
            for (int i = 0; i < daftarManajerProyek.size(); i++) {
                ar[i][0] = daftarManajerProyek.get(i).getNama();
                ar[i][1] = daftarManajerProyek.get(i).getID();
                ar[i][2] = Integer.toString(daftarManajerProyek.get(i).getSizeProyek());
            }
            return ar;
        } else {
            return null;
        }
    }

    //Menambahkan ManajerProyek melalui fungsi addManajerProyek ke dalam SISTEM.
    public ManajerProyek menuAddManajerProyek(String nama, String jenisKelamin, String telepon, String alamat, String Id, String Password) {
        if (cekID(Id)) {
            ManajerProyek m = new ManajerProyek(nama, jenisKelamin, telepon, alamat, Id, Password);
            addManajerProyek(m);
            return m;
        } else {
            throw new IllegalStateException("Gagal,ID sudah digunakan");
        }
    }

    //Menambahkan Programmer melalui fungsi addProgrammer ke dalam SISTEM.
    public Programmer menuAddProgrammer(String nama, String jenisKelamin, String telepon, String alamat, String Id, String Password) {
        if (cekID(Id)) {
            Programmer p = new Programmer(nama, jenisKelamin, telepon, alamat, Id, Password);
            addProgrammer(p);
            return p;
        } else {
            throw new IllegalStateException("Gagal, ID sudah digunakan");
        }
    }

    //Menghapus ManajerProyek pada sistem melalui fungsi deleteManajerProyek.
    public ManajerProyek menuRemoveManajerProyek(String id) {
        ManajerProyek temp = searchManajerProyek(id);
        if (temp != null) {
            deleteManajerProyek(id);
            return temp;
        } else {
            throw new IllegalStateException("ManajerProyek tidak ditemukan");
        }

    }
    //Menghapus Programmer pada sistem melalui fungsi deleteProgrammer.

    public Programmer menuRemoveProgrammer(String id) {
        Programmer p = searchProgrammer(id);
        if (p != null) {
            deleteProgrammer(id);
            return p;
        } else {
            throw new IllegalStateException("Programmer Tidak ditemukan");
        }
    }

    public boolean menuLoginAdmin(String id, String pass) {
        if (id.equals("admin") && pass.equals("admin")) {
            return true;
        } else {
            throw new IllegalStateException("Username atau Password salah");
        }
    }

    //----------------------------------------------------------------------------------------------------
    //FUNGSIONALITAS PROGRAMMER.
    //----------------------------------------------------------------------------------------------------
    //Mengumpulkan proyek-proyek dimana programmer ikut berkontribusi.
    public Proyek[] arProyekProgrammer(Programmer p) {
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

    //Mengeset status Tugas yang dikerjakan oleh Programmer.
    public void setStatusTugas(Programmer p, Tugas t) {
        if (t != null && t.getPelaksana() == p) {
            t.setStatus(1);
        }
    }

    //MENU Programmer.
    //Menu LOGIN. TOLONG DIUBAH !
    public Programmer menuSearchProgrammer(String id) {
        Programmer temp = searchProgrammer(id);
        if (temp != null) {
            p = temp;
        }
        return temp;
    }

    public boolean MenuLoginProgrammer(String id, String password) {
        Programmer temp = searchProgrammer(id);
        if (temp != null) {
            if (temp.getPassword().equals(password)) {
                p = temp;
                return true;
            } else {
                throw new IllegalStateException("Username atau Password salah");
            }

        } else {
            throw new IllegalStateException("Username atau Password salah");
        }

    }

    //Mengumpulkan data namaProyek,jumlahProgrammer,tugas belum selesai oleh si programmer,tugas selesai programmer,dan deadline setiap proyek yang di pimpin oleh manager proyek.
    public String[][] menuViewProyekProgrammer() {

        if (hitungProyekProgrammer(p) > 0) {
            String[][] ar = new String[hitungProyekProgrammer(p)][5];
            Proyek[] temp = arProyekProgrammer(p);
            for (int i = 0; i < hitungProyekProgrammer(p); i++) {
                ar[i][0] = temp[i].getNamaProyek();
                ar[i][1] = Integer.toString(temp[i].getSizeProgrammer());
                ar[i][2] = Integer.toString(jumlahTugasProgrammerBS((p), temp[i]));
                ar[i][3] = Integer.toString(jumlahTugasProgrammerS((p), temp[i]));
                ar[i][4] = sdf.format(temp[i].getDeadline());
            }
            return ar;
        } else {
            return null;
        }
    }

    //Mengumpulkan data detail dari suatu proyek berdasarkan indexProyek.
    public String[][] menuDetailProyekProgrammer(int indexProyek) { //DetailProyek untuk Programmer

        Proyek[] t = arProyekProgrammer(p);
        if (indexProyek < t.length && indexProyek > -1) {
            pro = t[indexProyek];

            String[][] ar = new String[pro.getSizeTugas() + 1][4];
            ar[0][0] = pro.getNamaProyek();
            ar[0][1] = sdf.format(pro.getDeadline());
            ar[0][2] = Integer.toString(pro.getSizeProgrammer());
            ar[0][3] = Integer.toString(pro.getSizeTugas());
            for (int i = 1; i <= pro.getSizeTugas(); i++) {
                ar[i][0] = pro.getTugas(i - 1).getNamaTugas();
                ar[i][1] = Integer.toString(pro.getTugas(i - 1).getStatus());
            }
            return ar;
        } else {
            return null;
        }
    }

    //Mengeset status suatu Tugas dengan fungsi setStatus
    public Tugas menuSetStatusTugas(int indexTugas) {
        try {
            if (indexTugas < pro.getSizeTugas() && indexTugas > -1) {
                setStatusTugas(p, pro.getTugas(indexTugas));
                return pro.getTugas(indexTugas);
            }
            return null;
        } catch (Exception e) {
            throw new IllegalStateException("Set status tugas gagal.");}
    }

    //Me-nullkan Programmer dan Proyek aktif.
    public Programmer menuLogoutProgrammer() {
        Programmer temp = p;
        p = null;
        pro = null;
        return temp;
    }

    //----------------------------------------------------------------------------------------------------
    //MENU ManajerProyek.
    //Menu LOGIN . TOLONG DIUBAH !
    public ManajerProyek menuSearchManajerProyek(String id) {
        ManajerProyek temp = searchManajerProyek(id);
        if (temp != null) {
            mp = temp;
        }
        return temp;
    }

    public boolean MenuLoginManajerProyek(String id, String password) {
        ManajerProyek temp = searchManajerProyek(id);
        if (temp != null) {
            if (temp.getPassword().equals(password)) {
                mp = temp;
                return true;
            } else {
                throw new IllegalStateException("Username atau Password salah");
            }
        } else {
            throw new IllegalStateException("Username atau Password salah");
        }

    }

    //Mengumpulkan data nama,jumlahprogrammer,tugas belum selesai,dan deadline setiap proyek yang di pimpin oleh manager proyek.
    public String[][] menuViewProyek() {
        if (mp.getSizeProyek() != 0) {
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
        } else {
            return null;
        }

    }

    //Mengumpulkan data NamaProyek,Deadline,Size programmer,Size Tugas baik yang sudah selesai atau belum berdasarkan indexProyek.
    public String[][] menuDetailProyek(int indexProyek) { //ManajerProyek
        if (indexProyek < mp.getSizeProyek() && indexProyek > -1) {
            pro = mp.getProyek(indexProyek);
            if (pro != null) {
                String[][] ar = new String[pro.getSizeTugas() + 1][4];
                ar[0][0] = pro.getNamaProyek();
                ar[0][1] = sdf.format(pro.getDeadline());
                ar[0][2] = Integer.toString(pro.getSizeProgrammer());
                ar[0][3] = Integer.toString(pro.getSizeTugas());
                for (int i = 1; i
                        <= pro.getSizeTugas(); i++) {
                    ar[i][0] = pro.getTugas(i - 1).getNamaTugas();
                    if (pro.getTugas(i - 1).getPelaksana() != null) {
                        ar[i][1] = pro.getTugas(i - 1).getPelaksana().getNama();
                    } else {
                        ar[i][1] = "Tidak ada";
                    }
                    if (pro.getTugas(i - 1).getStatus() == 0) {
                        ar[i][2] = "Belum Selesai";
                    } else if (pro.getTugas(i - 1).getStatus() == 1) {
                        ar[i][2] = "Sudah selesai";
                    }
                }
                return ar;
            }
        }
        return null;
    }

    //Membuat Proyek berdasarkan ManajerProyek yang aktif.
    public Proyek menuCreateProyek(String namaProyek, Date deadline) {
        try {
            mp.createProyek(namaProyek, deadline);
            return mp.getProyek(mp.getSizeProyek() - 1);
        } catch (Exception e) {
            throw new IllegalStateException("Gagal Create Proyek");
        }
    }

    //Menghapus Proyek pada ManajerProyek yang aktif berdasarkan indexProyek
    public Proyek menuRemoveProyek(int index) {
        Proyek temp = null;
        if (index < mp.getSizeProyek() && index > -1 && mp.getProyek(index) != null) {
            temp = mp.getProyek(index);
            mp.deleteProyek(index);
            return temp;
        } else {
            throw new IllegalStateException("Hapus Proyek gagal");
        }
    }

    //Menambahkan Tugas baru tanpa pelaksana
    public Tugas menuCreateTugas(String namaTugas) {
        try {
            pro.createTugas(namaTugas);
            return pro.getTugas(pro.getSizeTugas() - 1);
        } catch (Exception e) {
            throw new IllegalStateException("Gagal create Tugas.");
        }
    }

    //Menambahkan Tugas baru dengan Pelaksana
    public Tugas menuCreateTugas(String namaTugas, int indexPelaksana) {
        pro.createTugas(namaTugas);
        if (indexPelaksana < pro.getSizeProgrammer() && indexPelaksana > -1) {
            pro.getTugas(pro.getSizeTugas() - 1).setPelaksana(pro.getProgrammer(indexPelaksana));
        }
        return pro.getTugas(pro.getSizeTugas() - 1);
    }

    //Menghapus Tugas di proyek aktif dengan indexTugas
    public Tugas menuRemoveTugas(int index) {
        if (index < pro.getSizeTugas() && index > -1 & pro.getTugas(index) != null) {
            Tugas temp = pro.getTugas(index);
            pro.removeTugas(index);
            return temp;
        } else {
            throw new IllegalStateException("Gagal Remove Tugas");
        }
    }

    //Mengeset Tugas dengan indexTugas dan indexPelaksana pada proyek yang aktif.
    public Tugas menuSetPelaksana(int indexPelaksana, int indexTugas) {
        if (indexPelaksana < pro.getSizeProgrammer() && indexTugas < pro.getSizeTugas() && indexPelaksana > -1 && indexTugas > -1) {
            pro.getTugas(indexTugas).setPelaksana(pro.getProgrammer(indexPelaksana));
            return pro.getTugas(indexTugas);
        } else {
            throw new IllegalStateException("Set Pelaksana gagal");
        }

    }

    //Mengumpulkan data NamaProgrammer,IDProgrammer,dan jumlahProyeknya Programmer pada proyek aktif.
    public String[][] listProgrammerProyek() {
        if (pro.getSizeProgrammer() != 0) {
            String[][] ar = new String[pro.getSizeProgrammer()][3];
            for (int j = 0; j < pro.getSizeProgrammer(); j++) {
                ar[j][0] = pro.getProgrammer(j).getNama();
                ar[j][1] = pro.getProgrammer(j).getID();
                ar[j][2] = Integer.toString(hitungProyekProgrammer(pro.getProgrammer(j)));
            }
            return ar;
        }
        return null;
    }

    //Menambahkan Programmer pada proyek yang aktif berdasarkan indexProgrammer
    public Programmer menuAddProgrammer(String[][] ar, int indexProgrammer) { //menuViewProyek - >  listProgrammerTersedia
        Programmer temp = searchProgrammer(ar[indexProgrammer][1]);
        if (temp != null) {
            pro.addProgrammer(temp);
            return temp;
        } else {
            throw new IllegalStateException("Gagal menambahkan Programmer");
        }

    }

    //Menghapus Programmer pada proyek yang aktif berdasarkan indexProgrammer
    public Programmer menuRemoveProgrammer(int indexProgrammer) { //menuViewProgrammerMP
        if (indexProgrammer < pro.getSizeProgrammer() && indexProgrammer > -1) {
            Programmer temp = pro.getProgrammer(indexProgrammer);

            pro.removeProgrammer(indexProgrammer);
            return temp;
        } else {
            return null;
        }
    }

    //Mengumpulkan list Programmer yang belum ada didalam proyek aktif.
    public String[][] listProgrammerTersediaP() {
        if (daftarProgrammer.size() != 0) {
            String[][] ar = new String[daftarProgrammer.size() - pro.getSizeProgrammer()][3];
            if (ar.length != 0) {
                if (pro.getSizeProgrammer() != 0) {
                    int x = 0;
                    for (int i = 0; i < daftarProgrammer.size(); i++) {
                        for (int j = 0; j < pro.getSizeProgrammer(); j++) {
                            if (!daftarProgrammer.get(i).equals(pro.getProgrammer(j))) {
                                ar[x][0] = daftarProgrammer.get(i).getNama();
                                ar[x][1] = daftarProgrammer.get(i).getID();
                                ar[x][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
                                x++;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < daftarProgrammer.size(); i++) {
                        ar[i][0] = daftarProgrammer.get(i).getNama();
                        ar[i][1] = daftarProgrammer.get(i).getID();
                        ar[i][2] = Integer.toString(hitungProyekProgrammer(daftarProgrammer.get(i)));
                    }
                }
                return ar;
            }
        }
        return null;
    }

    //Me-nullkan ManajerProyek dan Proyek aktif.
    public ManajerProyek menuLogoutManajerProyek() {
        ManajerProyek temp = mp;
        mp = null;
        pro = null;
        return temp;
    }

    //----------------------------------------------------------------------------------------------------
    public String[][] menuViewPelaksana(Proyek p) {
        String[][] ar = new String[p.getSizeProgrammer()][2];
        for (int i = 0; i < p.getSizeProgrammer(); i++) {
            ar[i][0] = p.getProgrammer(i).getNama();
            ar[i][1] = Integer.toString(jumlahTugasProgrammerBS(p.getProgrammer(i), p));
        }
        return ar;
    }

    public String[][] menuViewProgrammerMP() {
        String[][] ar = new String[jumlahProgrammer(mp)][5];
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            for (int j = 0; j < mp.getProyek(i).getSizeProgrammer(); j++) {
                ar[i][0] = mp.getProyek(i).getNamaProyek();
                ar[i][1] = mp.getProyek(i).getProgrammer(i).getNama();
                ar[i][2] = Integer.toString(jumlahTugasProgrammerBS(mp.getProyek(i).getProgrammer(j), mp.getProyek(i)));
                ar[i][3] = Integer.toString(jumlahTugasProgrammerS(mp.getProyek(i).getProgrammer(j), mp.getProyek(i)));
                ar[i][4] = sdf.format(mp.getProyek(i).getDeadline());
            }
        }
        return ar;
    }

    public int jumlahProgrammer(ManajerProyek mp) {
        int temp = 0;
        for (int i = 0; i < mp.getSizeProyek(); i++) {
            temp = temp + mp.getProyek(i).getSizeProgrammer();
        }
        return temp;
    }

    /*public Programmer menuRemoveProgrammer(int indexProgrammer, int indexProyek) { //menuViewProgrammerMP
        Programmer temp = mp.getProyek(indexProyek).getProgrammer(indexProgrammer);
        mp.getProyek(indexProyek).removeProgrammer(indexProgrammer);
        return temp;
    }*/
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
                            System.out.println("-----------------------------------------------");

                            if (ar2 != null) {
                                System.out.println("Daftar Proyek");
                                System.out.println("-------------");
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
                                    if (ar2 != null) {
                                        do {
                                            ar2 = menuDetailProyek(tempC2);
                                            System.out.println(pro.getNamaProyek());
                                            System.out.print("Nama Proyek " + ar2[0][0]);

                                            System.out.println("     Deadline " + ar2[0][1]);
                                            System.out.print("Size Programmer : " + ar2[0][2]);
                                            System.out.println("            Size Tugas  : " + ar2[0][3]);
                                            System.out.println("");
                                            if (ar2.length > 1) {

                                                System.out.println("Daftar Tugas");
                                                System.out.println("---------------------------");
                                                System.out.println("No  Keterangan");
                                                for (int i = 1; i < ar2.length; i++) {
                                                    System.out.print(i - 1);
                                                    System.out.println("   Nama Tugas         : " + ar2[i][0]);
                                                    System.out.println("   Pelaksana           : " + ar2[i][1]);
                                                    System.out.println("   Status Tugas  : " + ar2[i][2]);
                                                    System.out.println("");
                                                }
                                            }

                                            ar2 = listProgrammerProyek();

                                            if (ar2 != null) {
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
                                                    tempT = menuCreateTugas(nama);
                                                    nama = "";
                                                    break;
                                                case 2:
                                                    System.out.println("Input Index Tugas diatas yang ingin dihapus>>");

                                                    tempil = -2;
                                                    System.out.print("Index :");
                                                    tempil = in.nextInt();
                                                    tempT = menuRemoveTugas(tempil);
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
                                                    if (tempil > -1 && tempil < pro.getSizeTugas()) {

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
                                                    if (ar2 != null) {
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
                                    } else {
                                        System.out.println("Proyek tidak ada");
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

                    int pil2;
                    System.out.print("Input ID Programmer");
                    in.nextLine();
                    System.out.println("ID: ");
                    Id = in.nextLine();
                    if (menuSearchProgrammer(Id) != null) {
                        int pil1 = -1;
                        do {
                            ar2 = menuViewProyekProgrammer();
                            System.out.println("Selamat Datang Programmer " + p.getNama());
                            System.out.println("--------------------------------------------------");

                            if (ar2 != null) {
                                System.out.println("Daftar Proyek Programmer");
                                System.out.println("---------------------------");
                                System.out.println("No  Keterangan");
                                for (int i = 0; i < ar2.length; i++) {
                                    System.out.print(i);
                                    System.out.println("   Nama Proyek       : " + ar2[i][0]);
                                    System.out.println("   Jumlah Programmer : " + ar2[i][1]);
                                    System.out.println("   Tugas Aktif       : " + ar2[i][2]);
                                    System.out.println("   Tugas Selesai     : " + ar2[i][3]);
                                    System.out.println("   Deadline Proyek   : " + ar2[i][4]);
                                    System.out.println("");
                                }
                            }

                            System.out.println("Menu Programmer");
                            System.out.println("1. Set Status Tugas");
                            System.out.println("2. Logout");
                            System.out.println("Masukkan pilihan: ");
                            pil2 = in.nextInt();
                            switch (pil2) {
                                case 1:
                                    int pilihan = -1;
                                    System.out.print("Input Index Proyek :");
                                    pilihan = in.nextInt();
                                    ar2 = menuDetailProyekProgrammer(pilihan);
                                    if (ar2 != null) {
                                        for (int i = 1; i < ar2.length; i++) {
                                            System.out.print(i - 1);
                                            System.out.println(" Nama Tugas :" + ar2[i][0]);
                                            System.out.println(" Status     :" + ar2[i][1]);
                                        }

                                        System.out.println("Input index ");
                                        pilihan = -1;
                                        pilihan = in.nextInt();
                                        Tugas tempTs = menuSetStatusTugas(pilihan);
                                        if (tempTs != null) {
                                            System.out.println("Berhasil");
                                        } else {
                                            System.out.println("Gagal");

                                        }
                                    } else {
                                        System.out.println("Tidak ditemukan");
                                    }
                                    break;
                                case 2:
                                    menuLogoutProgrammer();
                                    break;
                            }
                        } while (pil2 != 2);
                    } else {
                        System.out.println("ID Tidak ada");
                    }
                    break;
                case 3:
                    int pil3;
                    do {
                        ar2 = menuListManajerProyek();
                        if (ar2 != null) {
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
                        ar2 = menuListProgrammer();
                        if (ar2 != null) {
                            System.out.println("Daftar Programmer");
                            System.out.println("-----------------");
                            System.out.println("No  Keterangan");
                            for (int i = 0; i < ar2.length; i++) {
                                System.out.print(i);
                                System.out.println("   Nama          : " + ar2[i][0]);
                                System.out.println("    ID            : " + ar2[i][1]);
                                System.out.println("    Jumlah Proyek : " + ar2[i][2]);
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
                                menuAddManajerProyek(nama, jenisKelamin, telepon, alamat, Id, Password);
                                break;
                            case 2:
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
                                    } else {
                                        System.out.println("ID sudah ada");
                                    }
                                } while (ceker == false);
                                ceker = false;
                                in.nextLine();
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
        } while (pil != 4);
    }
}
