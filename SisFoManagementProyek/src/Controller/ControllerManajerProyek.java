/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
import View.DashboardAdmin;
import View.DashboardManajerPro;
import View.TambahProyekMP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Notonogoro
 */
public class ControllerManajerProyek implements ActionListener {

    private AplikasiKonsol model;
    private DashboardManajerPro dashMP;
    private Controller c;
    private TambahProyekMP tpMP;
    public ControllerManajerProyek(AplikasiKonsol m) {
        this.dashMP = new DashboardManajerPro();
        this.model = m;
        dashMP.setVisible(true);
        dashMP.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(dashMP.getBtnLogout())) {
            c = new Controller(model);
            dashMP.setVisible(false);
            dashMP.dispose();
        }
        if(source.equals(dashMP.getBtnTambahProyek())){
            this.tpMP = new TambahProyekMP();
            dashMP.setVisible(false);
            dashMP.dispose();
            tpMP.setVisible(true);
            tpMP.addListener(this);
        }
        

    }
}
