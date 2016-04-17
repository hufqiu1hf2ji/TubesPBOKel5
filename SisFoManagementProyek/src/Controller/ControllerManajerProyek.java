/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//NEW
package Controller;

import Model.AplikasiKonsol;
import Model.Programmer;
import Model.Proyek;
import Model.Tugas;
import View.DashboardAdmin;
import View.DashboardManajerPro;
import View.DetailProyekMP;
import View.HapusProyekMP;
import View.TambahProyekMP;
import com.sun.webkit.graphics.RenderTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Notonogoro
 */
public class ControllerManajerProyek implements ActionListener {

    private AplikasiKonsol model;
    private DashboardManajerPro dashMP;
    private Controller c;
    private TambahProyekMP tpMP;
    private HapusProyekMP hpMP;
    private DetailProyekMP dpMP;
    private String[][] arTambahP;

    public ControllerManajerProyek(Controller c, AplikasiKonsol m) {
        this.c = c;
        this.dashMP = new DashboardManajerPro();
        this.tpMP = new TambahProyekMP();
        this.hpMP = new HapusProyekMP();
        this.dpMP = new DetailProyekMP();
        this.model = m;
        dashMPBukaLayar();
        tpMP.setVisible(false);
        hpMP.setVisible(false);
        dpMP.setVisible(false);
        dashMP.addListener(this);
        tpMP.addListener(this);
        dpMP.addListener(this);
        hpMP.addListener(this);
    }

    public void PindahLayar() {
        if (dashMP.isShowing()) {
            dashMP.setVisible(false);
        }
        if (tpMP.isShowing()) {
            tpMP.setVisible(false);
        }
        if (hpMP.isShowing()) {
            hpMP.setVisible(false);
        }
        if (dpMP.isShowing()) {
            dpMP.setVisible(false);
        }
    }

    public void dashMPBukaLayar() {
        dashMP.setVisible(true);

        dashMP.setLblUser(model.getMPAktif());
    }

    public void tpMPBukaLayar() {
        try {
            tpMP.setVisible(true);
            tpMP.reset();
            tpMP.setLblUser(model.getMPAktif());
        } catch (Exception e) {
            tpMP.viewErrorMsg(e.getMessage());
        }
    }

    public void hpMPBukaLayar() {
        try {
            hpMP.setVisible(true);
            hpMP.resetCbNamaProyek();
            ViewHapusProyek();
            hpMP.setLblUser(model.getMPAktif());

            dpMP.getPanelTblTugas().setWheelScrollingEnabled(true);
        } catch (Exception e) {
            hpMP.viewErrorMsg(e.getMessage());
        }
    }

    public void dpMPBukaLayar() {
        try {
            model.setNonAktifPro();
            dpMP.setVisible(true);
            dpMP.getPanel().setVisible(false);
            dpMP.reset();
            ViewDetailProyek();

            dpMP.setLblUser(model.getMPAktif());
        } catch (Exception e) {
            dpMP.viewErrorMsg(e.getMessage());
        }
    }

    public void ViewDetailProyek() {
        try {

            String[][] ar2 = model.menuViewProyek();
            if (ar2 != null) {
                DefaultTableModel mdlTable = (DefaultTableModel) hpMP.getTblProyek().getModel();
                for (int i = 0; i < ar2.length; i++) {
                    dpMP.setCbNamaProyek(ar2[i][0]);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Proyek");
        }
    }

    public void ViewHapusProyek() {
        try {

            String[][] ar2 = model.menuViewProyek();
            dpMP.resetCbNamaProyek();

            DefaultTableModel mdlTable = (DefaultTableModel) hpMP.getTblProyek().getModel();
            mdlTable.setRowCount(0);
            if (ar2 != null) {
                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    hpMP.getTblProyek().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    hpMP.getTblProyek().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    hpMP.getTblProyek().setValueAt(ar2[i][2], i, 2);
                    hpMP.getTblProyek().setValueAt(ar2[i][3], i, 3);
                    hpMP.setCbNamaProyek(ar2[i][0]);
                    dpMP.setCbNamaProyek(ar2[i][0]);
//               
//                ia = 0;
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Proyek");
        }
    }

    public void ViewTugas() {
        try {
            dpMP.resetCbNamaTugas();
            dpMP.resetCbTugasSetP();
            String[][] ar2 = model.menuDetailProyek(dpMP.getCbNamaProyek());

            DefaultTableModel mdlTable = (DefaultTableModel) dpMP.getTblTugas().getModel();
            mdlTable.setRowCount(0);

            DefaultTableModel mdlTable2 = (DefaultTableModel) dpMP.getTblTugasSP().getModel();
            mdlTable2.setRowCount(0);
            if (ar2 != null) {
                for (int i = 1; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    mdlTable2.addRow(new Object[]{});

                    dpMP.getTblTugas().setValueAt(ar2[i][0], i - 1, 0);
                    dpMP.getTblTugasSP().setValueAt(ar2[i][0], i - 1, 0);
//                ia++;
                    dpMP.getTblTugas().setValueAt(ar2[i][1], i - 1, 1);
                    dpMP.getTblTugasSP().setValueAt(ar2[i][1], i - 1, 1);
//                ia++;
                    dpMP.getTblTugas().setValueAt(ar2[i][2], i - 1, 2);
                    dpMP.getTblTugasSP().setValueAt(ar2[i][2], i - 1, 2);
                    dpMP.setCbNamaTugas(ar2[i][0]);
                    dpMP.setCbTugasSetP(ar2[i][0]);
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Tugas");
        }
    }

    public String[][] ViewTambahPelaksana() {
        try {
            dpMP.resetCbNamaProTP();
            String[][] ar2 = model.listProgrammerTersediaP();
            DefaultTableModel mdlTable = (DefaultTableModel) dpMP.getTblProTersedia().getModel();
            mdlTable.setRowCount(0);

            if (ar2 != null) {

                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    dpMP.getTblProTersedia().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    dpMP.getTblProTersedia().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    dpMP.getTblProTersedia().setValueAt(ar2[i][2], i, 2);
                    dpMP.setCbNamaProTP(ar2[i][0]);
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
                return ar2;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Tambah Pelaksana");
        }
    }

    public void ViewPelaksanaProyek() {
        try {
            dpMP.resetCbNamaProHapus();
            dpMP.resetCbNamaProSP();
            String[][] ar2 = model.listProgrammerProyek();
            DefaultTableModel mdlTable = (DefaultTableModel) dpMP.getTblProDlmProyek().getModel();
            mdlTable.setRowCount(0);

            DefaultTableModel mdlTable2 = (DefaultTableModel) dpMP.getTblProSP().getModel();
            mdlTable2.setRowCount(0);
            if (ar2 != null) {

                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    mdlTable2.addRow(new Object[]{});
                    dpMP.getTblProDlmProyek().setValueAt(ar2[i][0], i, 0);
                    dpMP.getTblProSP().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    dpMP.getTblProDlmProyek().setValueAt(ar2[i][1], i, 1);
                    dpMP.getTblProSP().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    dpMP.getTblProDlmProyek().setValueAt(ar2[i][2], i, 2);
                    dpMP.getTblProSP().setValueAt(ar2[i][2], i, 2);
                    dpMP.setCbNamaProHapus(ar2[i][0]);
                    dpMP.setCbNamaProSP(ar2[i][0]);
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Pelaksana");
        }
    }

    public void AktifitasTerakhir() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(dashMP.getBtnLogout()) || source.equals(dpMP.getBtnLogout()) || source.equals(tpMP.getBtnLogout()) || source.equals(hpMP.getBtnLogout())) {
            model.menuLogoutManajerProyek();
            c.triggerLogout();
            PindahLayar();
        }

        if (source.equals(dashMP.getBtnTambahProyek()) || source.equals(dpMP.getBtnTambahProyek()) || source.equals(tpMP.getBtnTambahProyek()) || source.equals(hpMP.getBtnTambahProyek())) {
            PindahLayar();
            tpMPBukaLayar();
        }

        if (source.equals(dashMP.getBtnHapusProyek()) || source.equals(dpMP.getBtnHapusProyek()) || source.equals(tpMP.getBtnHapusProyek()) || source.equals(hpMP.getBtnHapusProyek())) {
            PindahLayar();
            hpMPBukaLayar();
        }

        if (source.equals(dashMP.getBtnDetailProyek()) || source.equals(dpMP.getBtnDetailProyek()) || source.equals(tpMP.getBtnDetailProyek()) || source.equals(hpMP.getBtnDetailProyek())) {

            PindahLayar();
            dpMPBukaLayar();

        }

        if (source.equals(tpMP.getBtnBeranda()) || source.equals(dpMP.getBtnBeranda()) || source.equals(dashMP.getBtnBeranda()) || source.equals(hpMP.getBtnBeranda())) {
            PindahLayar();
            dashMPBukaLayar();
        }
        //create proyek
        if (source.equals(tpMP.getBtnSimpan())) {
            try {
                Date deadline = new Date(tpMP.getCbTahun() - 1900,
                        tpMP.getCbBulan() - 1,
                        tpMP.getCbTgl());
                String nama = tpMP.getTxtNamaProyek();
                if (!nama.equals("")) {
                    model.menuCreateProyek(
                            nama, deadline);
                    tpMP.viewErrorMsg("Proyek " + tpMP.getTxtNamaProyek() + " berhasil ditambahkan");
                } else {
                    tpMP.viewErrorMsg("Gagal,Masukkan Nama !");
                }
            } catch (Exception e) {
                tpMP.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            tpMPBukaLayar();

        }
        //HAPUS PROYEK
        if (source.equals(hpMP.getBtnHapus())) {
            try {
                Proyek temp = model.menuRemoveProyek(hpMP.getCbNamaProyek());

                hpMP.viewErrorMsg("Proyek " + temp.getNamaProyek() + " berhasil dihapus.");

            } catch (Exception e) {
                hpMP.viewErrorMsg(e.getMessage());

            }
            PindahLayar();
            hpMPBukaLayar();
        }

        //DETAIL PROYEK
        if (source.equals(dpMP.getBtnAktifkan())) {
            try {
                ViewTugas();
                if (!model.getProyekAktif().equals("Tidak ada")) {
                    dpMP.getPanelTblTugas().setWheelScrollingEnabled(true);
                    dpMP.setLblProyekAktif(model.getProyekAktif());
                    dpMP.getPanel().setVisible(true);
                    arTambahP = ViewTambahPelaksana();
                    ViewPelaksanaProyek();
                } else {
                    dpMP.viewErrorMsg("Tidak ada proyek yang dipilih");
                }
            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }
        }

        if (source.equals(dpMP.getBtnSimpanTgs())) {
            try {
                String input = dpMP.getTxtNamaTugas();
                if (!input.equals("")) {
                    Tugas temp = model.menuCreateTugas(input);
                    dpMP.viewErrorMsg("Tugas " + temp.getNamaTugas() + " berhasil ditambahkan");
                    dpMP.setTxtNamaTugas("");
                } else {
                    dpMP.viewErrorMsg("Masukkan nama");
                }
            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }

            ViewTugas();
        }

        if (source.equals(dpMP.getBtnHapusTugas())) {
            try {
                Tugas temp = model.menuRemoveTugas(dpMP.getCbNamaTugas());
                dpMP.viewErrorMsg("Tugas " + temp.getNamaTugas() + " berhasil dihapuskan");
            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }

            ViewTugas();
        }

        if (source.equals(dpMP.getBtnSimpanPelaksana())) {
            try {
                Programmer temp = model.menuAddProgrammer(arTambahP, dpMP.getCbNamaProTP());
                if (temp != null) {
                    dpMP.viewErrorMsg("Programmer " + temp.getNama() + " berhasil ditambahkan");
                } else {
                    dpMP.viewErrorMsg("Tidak ada Programmer yang dipilih.");
                }
            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }
            ViewTambahPelaksana();
            ViewPelaksanaProyek();
        }

        if (source.equals(dpMP.getBtnHapusPelaksana())) {
            try {
                Programmer temp = model.menuRemoveProgrammer(dpMP.getCbNamaProHapus());
                if (temp != null) {
                    dpMP.viewErrorMsg("Programmer " + temp.getNama() + " berhasil dihapus dari proyek");
                } else {
                    dpMP.viewErrorMsg("Tidak ada Programmer yang dipilih.");
                }

            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }
            ViewTambahPelaksana();
            ViewPelaksanaProyek();
            ViewTugas();
        }

        if (source.equals(dpMP.getBtnSimpanSetP())) {
            try {
                model.menuSetPelaksana(dpMP.getCbNamaProSP(), dpMP.getCbTugasSetP());
            } catch (Exception e) {
                dpMP.viewErrorMsg(e.getMessage());
            }
            ViewTugas();
            ViewPelaksanaProyek();
        }

    }

}
