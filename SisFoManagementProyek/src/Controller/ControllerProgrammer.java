/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
import Model.Tugas;
import Model.Programmer;
import View.DashboardProgrammer;
import View.ProSetStatusTugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Notonogoro
 */
public class ControllerProgrammer implements ActionListener {

    private ProSetStatusTugas sstp;
    private AplikasiKonsol model;
    private Tugas tgs;
    private Programmer p;
    private Controller c;
    private DashboardProgrammer dbp;

    public ControllerProgrammer(Controller c, AplikasiKonsol model) {
        this.c = c;
        this.model = model;
        this.sstp = new ProSetStatusTugas();
        sstp.setVisible(false);
        this.dbp = new DashboardProgrammer();
        dbp.setVisible(true);
        sstp.addListener(this);
        dbp.addListener(this);
        sstp.getPanelProyek().setWheelScrollingEnabled(true);
        sstp.getPanelTugas().setWheelScrollingEnabled(true);

    }

    public void PindahLayar() {
        if (dbp.isShowing()) {
            dbp.setVisible(false);
        }
        if (sstp.isShowing()) {
            sstp.setVisible(false);
        }
    }

    public void DashboardBukaLayar() {
        dbp.setVisible(true);
        dbp.setlblUser(model.getPAktif());
    }

    public void SetStatusBukaLayar() {
        sstp.setVisible(true);
        sstp.reset();
        View();
        sstp.setlblUser(model.getPAktif());

    }

    public void ViewTugas() {
        try {
            sstp.resetCmbInputNamaT();

            String[][] ar2 = model.menuDetailProyekProgrammer(sstp.getCmbNamaProyek());
            DefaultTableModel mdlTable = (DefaultTableModel) sstp.gettblTugas().getModel();
            mdlTable.setRowCount(0);
            if (ar2 != null) {
                for (int i = 1; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    sstp.gettblTugas().setValueAt(ar2[i][0], i-1, 0);
//                ia++;
                    sstp.gettblTugas().setValueAt(ar2[i][1], i-1, 1);
                    sstp.setCmbInputNamaT(ar2[i][0]);
//               
//                ia = 0;
//                ia++;
//                fr.getTable().setValueAt(ia, i, i);
                }
            } else throw new IllegalStateException("Proyek tidak ditemukan");

            
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void View() {
        try {

            String[][] ar2 = model.menuViewProyekProgrammer();

            DefaultTableModel mdlTable = (DefaultTableModel) sstp.gettblProyek().getModel();
            mdlTable.setRowCount(0);
            if (ar2 != null) {
                for (int i = 0; i < ar2.length; i++) {
                    mdlTable.addRow(new Object[]{});
                    sstp.gettblProyek().setValueAt(ar2[i][0], i, 0);
//                ia++;
                    sstp.gettblProyek().setValueAt(ar2[i][1], i, 1);
//                ia++;
                    sstp.gettblProyek().setValueAt(ar2[i][2], i, 2);
                    sstp.gettblProyek().setValueAt(ar2[i][3], i, 3);
                    sstp.gettblProyek().setValueAt(ar2[i][4], i, 4);
                    sstp.setCmbNamaProyek(ar2[i][0]);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(dbp.getBtnLogout()) || (source.equals(sstp.getBtnLogout()))) {
            model.menuLogoutProgrammer();
            c.triggerLogout();
            PindahLayar();
        }

        if (source.equals(dbp.getBtnBeranda()) || (source.equals(sstp.getBtnBeranda()))) {
            PindahLayar();
            DashboardBukaLayar();

        }

        if (source.equals(dbp.getBtnSetStatus()) || (source.equals(sstp.getBtnSetStatus()))) {
            PindahLayar();
            SetStatusBukaLayar();
        }

        if (source.equals(sstp.getBtnAktif())) {
            try {
                ViewTugas();
                sstp.setlblAktif(model.getProyekAktif());
            } catch (Exception es) {
                sstp.viewErrorMsg(es.getMessage());
            }
        }

        if (source.equals(sstp.getBtnSimpan())) {
            try {
                model.menuSetStatusTugas(sstp.getCmbInputNamaT());
                sstp.viewErrorMsg("Berhasil mengeset status Tugas");
                ViewTugas();
            } catch (Exception ex) {
                sstp.viewErrorMsg(ex.getMessage());
            }
            
        }

    }
}
