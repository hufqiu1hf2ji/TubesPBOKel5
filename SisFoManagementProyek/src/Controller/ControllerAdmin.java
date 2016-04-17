/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
//NEW
import Model.AplikasiKonsol;
import Model.Programmer;
import Model.ManajerProyek;
import View.AdHapusManajerProyek;
import View.AdHapusProgrammer;
import View.AdTambahManajerProyek;
import View.AdTambahProgrammer;
import View.DashboardAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Notonogoro
 */
public class ControllerAdmin implements ActionListener {

    private AplikasiKonsol model;
    private DashboardAdmin dashAd;
    private Controller c;
    private AdHapusManajerProyek ahMP;
    private AdHapusProgrammer ahPro;
    private AdTambahManajerProyek atMP;
    private AdTambahProgrammer atPro;
    private String[][] arTambahP;

    public ControllerAdmin(Controller c, AplikasiKonsol m) {
        this.c = c;
        this.dashAd = new DashboardAdmin();
        this.ahMP = new AdHapusManajerProyek();
        this.ahPro = new AdHapusProgrammer();
        this.atMP = new AdTambahManajerProyek();
        this.atPro = new AdTambahProgrammer();
        this.model = m;
        dashAdBukaLayar();
        ahMP.setVisible(false);
        ahPro.setVisible(false);
        atMP.setVisible(false);
        atPro.setVisible(false);
        dashAd.addListener(this);
        ahMP.addListener(this);
        ahPro.addListener(this);
        atMP.addListener(this);
        atPro.addListener(this);
        dashAd.addListener(this);
    }


    public void PindahLayar() {
        if (dashAd.isShowing()) {
            dashAd.setVisible(false);
        }
        if (ahMP.isShowing()) {
            ahMP.setVisible(false);
        }
        if (ahPro.isShowing()) {
            ahPro.setVisible(false);
        }
        if (atMP.isShowing()) {
            atMP.setVisible(false);
        }
        if (atPro.isShowing()) {
            atPro.setVisible(false);
        }
    }

    public void dashAdBukaLayar() {
        dashAd.setVisible(true);
        dashAd.setlblUserAdmin("Admin");
        dashAd.getPanelMP().setWheelScrollingEnabled(true);
        dashAd.getPanelPro().setWheelScrollingEnabled(true);
        ViewP();
        ViewMP();

    }

    public void ahMPBukaLayar() {
        ahMP.setVisible(true);
        ahMP.setlblUserAdmin("Admin");
        ahMP.getPanelHapusMP().setWheelScrollingEnabled(true);
        ahMP.reset();
        ViewMP();
    }

    public void ahProBukaLayar() {
        ahPro.setVisible(true);
        ahPro.setlblUserAdmin("Admin");
        ahPro.getPanelHapusP().setWheelScrollingEnabled(true);
        ahPro.reset();
         ViewP();
    }

    public void atMPBukaLayar() {
        atMP.setVisible(true);
        atMP.setlblUserAdmin("Admin");
        atMP.reset();
        
    }

    public void atProBukaLayar() {
        atPro.setVisible(true);
        atPro.setlblUserAdmin("Admin");
        atPro.reset();
       
    }

    public void ViewMP() {
        try {
            String[][] ar2 = model.menuListManajerProyek();
            DefaultTableModel mdlTable = (DefaultTableModel) dashAd.getTblMP().getModel();
            mdlTable.setRowCount(0);
            DefaultTableModel mdlTable2 = (DefaultTableModel) ahMP.getTblMP().getModel();
            mdlTable2.setRowCount(0);

            if (ar2 != null) {
                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    mdlTable2.addRow(new Object[]{});
                    dashAd.getTblMP().setValueAt(ar2[i][0], i, 0);
                    ahMP.getTblMP().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    dashAd.getTblMP().setValueAt(ar2[i][1], i, 1);
                    ahMP.getTblMP().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    dashAd.getTblMP().setValueAt(ar2[i][2], i, 2);
                    ahMP.getTblMP().setValueAt(ar2[i][2], i, 2);
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Manajer Proyek");
        }
    }

    public void ViewP() {
        try {
            String[][] ar2 = model.menuListProgrammer();
            DefaultTableModel mdlTable = (DefaultTableModel) dashAd.getTblPro().getModel();
            mdlTable.setRowCount(0);
            DefaultTableModel mdlTable2 = (DefaultTableModel) ahPro.getTbPro().getModel();
            mdlTable2.setRowCount(0);

            if (ar2 != null) {
                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    mdlTable2.addRow(new Object[]{});
                    dashAd.getTblPro().setValueAt(ar2[i][0], i, 0);
                    ahPro.getTbPro().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    dashAd.getTblPro().setValueAt(ar2[i][1], i, 1);
                    
                    ahPro.getTbPro().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    dashAd.getTblPro().setValueAt(ar2[i][2], i, 2);
                    
                    ahPro.getTbPro().setValueAt(ar2[i][2], i, 2);

//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Gagal View Programmer");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(dashAd.getBtnLogout()) || source.equals(ahMP.getBtnLogout()) || source.equals(ahPro.getBtnLogout()) || source.equals(atMP.getBtnLogout()) || source.equals(atPro.getBtnLogout())) {
            c.triggerLogout();
            PindahLayar();
        }

        if (source.equals(dashAd.getBtnTambahMP()) || source.equals(ahMP.getBtnTambahMP()) || source.equals(ahPro.getBtnTambahMP()) || source.equals(atMP.getBtnTambahMP()) || source.equals(atPro.getBtnTambahMP())) {
            PindahLayar();
            atMPBukaLayar();
        }

        if (source.equals(dashAd.getBtnTambahPro()) || source.equals(ahMP.getBtnTambahPro()) || source.equals(ahPro.getBtnTambahPro()) || source.equals(atMP.getBtnTambahPro()) || source.equals(atPro.getBtnTambahPro())) {
            PindahLayar();
            atProBukaLayar();
        }

        if (source.equals(dashAd.getBtnHapusPro()) || source.equals(ahMP.getBtnHapusPro()) || source.equals(ahPro.getBtnHapusPro()) || source.equals(atMP.getBtnHapusPro()) || source.equals(atPro.getBtnHapusPro())) {
            PindahLayar();
            ahProBukaLayar();
        }

        if (source.equals(dashAd.getBtnHapusMP()) || source.equals(ahMP.getBtnHapusMP()) || source.equals(ahPro.getBtnHapusMP()) || source.equals(atMP.getBtnHapusMP()) || source.equals(atPro.getBtnHapusMP())) {
            PindahLayar();
            ahMPBukaLayar();
        }

        if (source.equals(dashAd.getBtnBeranda()) || source.equals(ahMP.getBtnBeranda()) || source.equals(ahPro.getBtnBeranda()) || source.equals(atMP.getBtnBeranda()) || source.equals(atPro.getBtnBeranda())) {
            PindahLayar();
            dashAdBukaLayar();
        }

        //HAPUS PROGRAMMER
        if (source.equals(ahPro.getBtnHapus())) {
            try {
                Programmer temp = model.menuRemoveProgrammer(ahPro.getTextIdPro());
                ahPro.viewErrorMsg("Programmer " + temp.getNama() + " berhasil dihapus.");
            } catch (Exception e) {
                ahPro.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            ahProBukaLayar();
        }

        //HAPUS MANAJER PROYEK
        if (source.equals(ahMP.getBtnHapus())) {
            try {
                ManajerProyek temp = model.menuRemoveManajerProyek(ahMP.getTextIdMP());
                ahMP.viewErrorMsg("Manajer Proyek " + temp.getNama() + " berhasil dihapus.");
            } catch (Exception e) {
                ahMP.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            ahMPBukaLayar();
        }

        //TAMBAH MANAJER PROYEK
        if (source.equals(atMP.getBtnSimpan())) {
            try {

                String nama = atMP.getTextNamaMP();
                String telepon = atMP.getTextTeleponMP();
                String alamat = atMP.getTextAlamatMP();
                String id = atMP.getTextIdMP();
                String password = atMP.getTextPassMP();
                String jk = null;
                if (atMP.getCbJenisKelaminMP() == 0) {
                    jk = "l";
                } else {
                    jk = "p";
                }
                if (nama.equals("") || telepon.equals("") || alamat.equals("") || id.equals("") || password.equals("")) {
                    atMP.viewErrorMsg("Harap isi semua field diatas");
                } else {
                    model.menuAddManajerProyek(nama, jk, telepon, alamat, id, password);
                    atMP.viewErrorMsg("Input Berhasil");
                }
            } catch (Exception e) {
                atMP.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            atMPBukaLayar();
        }

        if (source.equals(atPro.getBtnSimpan())) {
            try {

                String nama = atPro.getTextNamaPro();
                String telepon = atPro.getTextTeleponPro();
                String alamat = atPro.getTextAlamatPro();
                String id = atPro.getTextIdPro();
                String password = atPro.getTextPassPro();
                String jk = null;
                if (atPro.getCbJenisKelaminPro() == 0) {
                    jk = "L";
                } else {
                    jk = "P";
                }
                if (nama.equals("") || telepon.equals("") || alamat.equals("") || id.equals("") || password.equals("") || jk.equals("")) {
                    atPro.viewErrorMsg("Harap isi semua field diatas");
                } else {
                    model.menuAddProgrammer(nama, alamat, telepon, alamat, id, password);
                    atPro.viewErrorMsg("Input Berhasil");
                }
            } catch (Exception e) {
                atPro.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            atProBukaLayar();
        }
    }

}
