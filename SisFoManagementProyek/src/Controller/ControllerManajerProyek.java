/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
import View.DashboardAdmin;
import View.DashboardManajerPro;
import View.DetailProyekMP;
import View.HapusProyekMP;
import View.TambahProyekMP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

    public ControllerManajerProyek(AplikasiKonsol m) {
        this.dashMP = new DashboardManajerPro();
        this.tpMP = new TambahProyekMP();
        this.hpMP = new HapusProyekMP();
        this.dpMP = new DetailProyekMP();
        this.model = m;
        dashMP.setVisible(true);
        dashMP.addListener(this);
        tpMP.setVisible(false);
        hpMP.setVisible(false);
        dpMP.setVisible(false);
    }

    public void trigerLogin() {
        dashMP.setVisible(true);
        dashMP.addListener(this);
    }

    public void PindahLayar() {
        if (dashMP.isShowing()) {
            dashMP.setVisible(false);
            dashMP.dispose();
        }
        if (tpMP.isShowing()) {
            tpMP.setVisible(false);
            tpMP.dispose();
        }
        if (hpMP.isShowing()) {
            hpMP.setVisible(false);
            hpMP.dispose();
        }
        if (dpMP.isShowing()) {
            dpMP.setVisible(false);
            dpMP.dispose();
        }
    }

    public void tpMPBukaLayar() {
        if (!tpMP.isShowing()) {
            tpMP.setVisible(true);
            tpMP.addListener(this);
        }
    }

    public void hpMPBukaLayar() {
        if (!hpMP.isShowing()) {
            hpMP.setVisible(true);
            hpMP.addListener(this);
        }
    }

    public void dpMPBukaLayar() {
        if (!dpMP.isShowing()) {
            dpMP.setVisible(true);
            dpMP.addListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(dashMP.getBtnLogout()) || source.equals(dpMP.getBtnLogout()) || source.equals(tpMP.getBtnLogout()) || source.equals(hpMP.getBtnLogout())) {
            model.menuLogoutManajerProyek();
            c.triggerLogout();
            PindahLayar();
        }

        if (source.equals(dashMP.getBtnTambahProyek())) {
            PindahLayar();
            tpMPBukaLayar();

        }

        if (source.equals(dashMP.getBtnHapusProyek())) {
            PindahLayar();
            hpMPBukaLayar();
        }

        if (source.equals(dashMP.getBtnDetailProyek())) {
            PindahLayar();
            dpMPBukaLayar();
        }

        if (source.equals(tpMP.getBtnSimpan())) {
            try {
                Date deadline = new Date(tpMP.getCbTahun() - 1900,
                        tpMP.getCbBulan() - 1,
                        tpMP.getCbTgl());
                model.menuCreateProyek(
                        tpMP.getTxtNamaProyek(), deadline);
                tpMP.reset();
            } catch (Exception e) {
                tpMP.reset();
                tpMP.viewErrorMsg(e.getMessage());
            }
        }
    }
}
