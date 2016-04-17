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
/**
 *
 * @author Notonogoro
 */
public class ControllerProgrammer implements ActionListener{
    private ProSetStatusTugas sstp;
    private AplikasiKonsol model;
    private Tugas tgs;
    private Programmer p;
    private Controller c;
    private DashboardProgrammer dbp;
    
    public ControllerProgrammer(Controller c, AplikasiKonsol model){
        this.c=c;
        this.model=model;
        this.sstp=new ProSetStatusTugas();
        sstp.setVisible(false);
        this.dbp=new DashboardProgrammer();
        dbp.setVisible(true);
        sstp.addListener(this);
        dbp.addListener(this);
    }
    
        public void PindahLayar() {
        if (dbp.isShowing()) {
            dbp.setVisible(false);
            dbp.dispose();
        }
        if (sstp.isShowing()) {
            sstp.setVisible(false);
            sstp.dispose();
        }
    }
    
    public void DashboardBukaLayar() {
        if (!dbp.isShowing()) {
            dbp.setVisible(true);
            dbp.addListener(this);
        }
    }
    
    public void SetStatusBukaLayar(){
        if(!sstp.isShowing()){
            sstp.setVisible(true);
            sstp.addListener(this);
        }
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(dbp.getBtnLogout()) || (source.equals(sstp.getBtnLogout()))){
            model.menuLogoutProgrammer();
            c.triggerLogout();
            PindahLayar();
        }
        
        if(source.equals(dbp.getBtnBeranda()) || (source.equals(sstp.getBtnBeranda()))){
            PindahLayar();
            DashboardBukaLayar();
            
        }
        
        if(source.equals(dbp.getBtnSetStatus()) || (source.equals(sstp.getBtnSetStatus()))){
            PindahLayar();
            SetStatusBukaLayar();
        }
        
        if(source.equals(sstp.getBtnSimpan())){
            try{
                model.menuViewProyekProgrammer();
                model.setStatusTugas(p, tgs);
                sstp.viewErrorMsg("Berhasil");
                sstp.reset();
            }
            catch (Exception ex){
                sstp.viewErrorMsg(ex.getMessage());
                sstp.reset();
            }
        }

        if(source.equals(sstp.getCmbNamaProyek())){
            try{
                int pilihan=-1;
                String[][] ar2 = model.menuDetailProyekProgrammer(pilihan);
                if (ar2 != null) {
                    for (int i=1; i<ar2.length; i++) {
                    sstp.getCmbNamaProyek((ar2[i][0]));
                    }
                }
            }
            catch (Exception ex){
                    
            }
        }
        
        if(source.equals(sstp.getCmbInputNamaT())){
            int pilihan=-1;
            Tugas tempTs = model.menuSetStatusTugas(pilihan);
            /*if (tempTs != null) {
                System.out.println("Berhasil");
            }else {
                System.out.println("Gagal");
            }*/
        }
        
        if(source.equals(sstp.getCmbSetStatus())){
            try{
                int pilihan=-1;
                String[][] ar2 = model.menuDetailProyekProgrammer(pilihan);
                if (ar2 != null) {
                    for (int i=1; i<ar2.length; i++) {
                    sstp.getCmbSetStatus((ar2[i][1]));
                    }
                }
            }
            catch (Exception ex){
                    
            }
        }
    
   }
}
