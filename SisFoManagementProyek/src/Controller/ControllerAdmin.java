/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
import View.DashboardAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Notonogoro
 */
public class ControllerAdmin implements ActionListener{
    private AplikasiKonsol model;
    private DashboardAdmin dashAd;
    private Controller c;

    public ControllerAdmin(AplikasiKonsol m) {
        this.dashAd = new DashboardAdmin();
        this.model = m;
        dashAd.setVisible(true);
        dashAd.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(dashAd.getBtnLogout())){
            c = new Controller(model);
            dashAd.setVisible(false);
            dashAd.dispose();
        }
    }
    
 
}
