/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
import View.DashboardAdmin;
import View.Login1;
import View.Login2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Notonogoro
 */
public class Controller implements ActionListener {

    private AplikasiKonsol model;
    private Login1 l1;
    private Login2 l;
    private String levelAktif = null;
    private ControllerAdmin ca;
    private ControllerManajerProyek cmp;
    private ControllerProgrammer cp;

    public Controller(AplikasiKonsol model) {
        this.model = model;
        this.l1 = new Login1();
        this.l = new Login2();
        l1.setVisible(true);
        l1.addListener(this);
        l.setVisible(false);
        l.addListener(this);
        

    }

    public void triggerLogout() {
        l1.setVisible(true);
        l1.addListener(this);
        l.setVisible(false);
        l.addListener(this);
        l.reset();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(l1.getBtnManajerProyek())) {
            l.setVisible(true);
            l1.setVisible(false);
            l1.dispose();
            levelAktif = "mp";
        }
        if (source.equals(l1.getBtnProgrammer())) {
            l.setVisible(true);
            l1.setVisible(false);
            l1.dispose();
            levelAktif = "p";
        }
        if (source.equals(l.getBtnBack())) {
            l1.setVisible(true);
            l.setVisible(false);
            l.dispose();
            levelAktif = null;
        }
        if (source.equals(l1.getBtnAdmin())) {
            l.setVisible(true);
            l1.setVisible(false);
            l1.dispose();
            levelAktif = "ad";
        }
        if (source.equals(l.getBtnLogin())) {
            if (l.getTxtuser() != null && l.getTxtpass() != null) {
                String user = l.getTxtuser();
                String pass = l.getTxtpass();
                if(levelAktif!=null){
                if (levelAktif.equals("ad")) {
                    try {
                        model.menuLoginAdmin(user, pass);
                        if (ca != null) {
                            ca.dashAdBukaLayar();
                        } else {
                            ca = new ControllerAdmin(this, model);
                        }
                        l.setVisible(false);
                        levelAktif = null;
                        l.dispose();
                    } catch (Exception e) {
                        l.viewErrorMsg(e.getMessage());
                        l.reset();
                    }
                }else if (levelAktif.equals("mp")) {
                     try {
                        model.MenuLoginManajerProyek(user, pass);
                        if (cmp != null) {
                            cmp.dashMPBukaLayar();
                        } else {
                            cmp = new ControllerManajerProyek(this, model);
                        }
                        l.setVisible(false);
                        levelAktif = null;
                        l.dispose();
                    } catch (Exception e) {
                        l.viewErrorMsg(e.getMessage());
                        l.reset();
                    }
                }else if (levelAktif.equals("p")){
                    try{
                        model.MenuLoginProgrammer(user, pass);
                        if (cp != null){
                            cp.DashboardBukaLayar();
                        }else{
                            cp = new ControllerProgrammer(this, model);
                        }
                        l.setVisible(false);
                        levelAktif = null;
                        l.dispose();
                    } catch (Exception e) {
                        l.viewErrorMsg(e.getMessage());
                        l.reset();
                    }
                }
                }
            }
        }
    }

}
