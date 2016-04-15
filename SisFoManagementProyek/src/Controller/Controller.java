/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiKonsol;
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
    private String levelAktif=null;

    public Controller(AplikasiKonsol model) {
        this.model = model;
        this.l1 = new Login1();
        this.l = new Login2();
        l1.setVisible(true);
        l1.addListener(this);
        l.setVisible(false);
        l.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(l1.getBtnManajerProyek())) {
            l.setVisible(true);
            l1.setVisible(false);
            l1.dispose();
            levelAktif="mp";
        }
        if (source.equals(l1.getBtnProgrammer())) {
            l.setVisible(true);
            l1.setVisible(false);
            l1.dispose();
            levelAktif="p";
        }
        if (source.equals(l.getBtnBack())){
            l1.setVisible(true);
            l.setVisible(false);
            l.dispose();
            levelAktif=null;
        }
    }

}
