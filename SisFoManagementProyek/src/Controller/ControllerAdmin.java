/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

/**
 *
 * @author Notonogoro
 */
public class ControllerAdmin implements ActionListener{
    private AplikasiKonsol model;
    private DashboardAdmin dashAd;
    private Controller c;
    private AdHapusManajerProyek ahMP;
    private AdHapusProgrammer ahPro;
    private AdTambahManajerProyek atMP;
    private AdTambahProgrammer atPro;
    
    public ControllerAdmin(Controller c,AplikasiKonsol m) {
        this.c=c;
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
    }
    
    public void trigerLogin(){
        dashAd.setVisible(true);
        dashAd.addListener(this);
    }
    
    public void PindahLayar(){
        if (dashAd.isShowing()) {
            dashAd.setVisible(false);
        }
        if (ahMP.isShowing()){
            ahMP.setVisible(false);
        }
        if (ahPro.isShowing()){
            ahPro.setVisible(false);
        } 
        if (atMP.isShowing()){
            atMP.setVisible(false);
        }
        if (atPro.isShowing()){
            atPro.setVisible(false);
        } 
    }
    
    public void dashAdBukaLayar(){
        dashAd.setVisible(true);
        dashAd.setlblUserAdmin("Admin");
    }
    
    public void ahMPBukaLayar(){
        ahMP.setVisible(true);
        ahMP.reset();
    }
    
    public void ahProBukaLayar(){
        ahPro.setVisible(true);
        ahPro.reset();
    }
    
    public void atMPBukaLayar(){
       atMP.setVisible(true);
       atMP.reset();
    }
    
    public void atProBukaLayar(){
        atPro.setVisible(true);
        atPro.reset();
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
        if (source.equals(ahPro.getBtnHapus())){
            try{
                Programmer temp = model.menuRemoveProgrammer(ahPro.getTextIdPro());
                ahPro.viewErrorMsg("Programmer " + temp.getNama()+ "berhasil dihapus.");
            }catch (Exception e) {
                ahPro.viewErrorMsg(e.getMessage());                
            }
            PindahLayar();
            ahProBukaLayar();
        }
        
        //HAPUS MANAJER PROYEK
        if (source.equals(ahMP.getBtnHapus())){
            try{
                ManajerProyek temp = model.menuRemoveManajerProyek(ahMP.getTextIdMP());
                ahPro.viewErrorMsg("Manajer Proyek " + temp.getNama() + "berhasil dihapus.");
            }catch (Exception e) {
                ahPro.viewErrorMsg(e.getMessage());                
            }
            PindahLayar();
            ahMPBukaLayar();
        }
        
        //TAMBAH MANAJER PROYEK
        if (source.equals(atMP.getBtnSimpan())){
            try{
                
                String nama = atMP.getTextNamaMP();
                String telepon = atMP.getTextTeleponMP();
                String alamat = atMP.getTextAlamatMP();
                String id = atMP.getTextIdMP();
                String password = atMP.getTextPassMP();
                String jk = null;
                    if (atMP.getCbJenisKelaminMP()==0){
                        jk ="L";
                    }
                    else{
                        jk ="P";
                    }            
                if(nama.equals("") || telepon.equals("") || alamat.equals("") || id.equals("") || password.equals("") || jk.equals("")){
                   atMP.viewErrorMsg("Harap isi semua field diatas");
                }
                else{    
                    model.menuAddManajerProyek(nama, alamat, telepon, alamat, id, password);
                    atMP.viewErrorMsg("berhasil");
                }        
                    }catch(Exception e){
                        atMP.viewErrorMsg("Input gagal");
            }
            PindahLayar();
            atMPBukaLayar();
        }
        
        if (source.equals(atPro.getBtnSimpan())){
            try{
                
                String nama = atPro.getTextNamaPro();
                String telepon = atPro.getTextTeleponPro();
                String alamat = atPro.getTextAlamatPro();
                String id = atPro.getTextIdPro();
                String password = atPro.getTextPassPro();
                String jk = null;
                    if (atPro.getCbJenisKelaminPro()==0){
                        jk ="L";
                    }
                    else{
                        jk ="P";
                    }            
                if(nama.equals("") || telepon.equals("") || alamat.equals("") || id.equals("") || password.equals("") || jk.equals("")){
                   throw new IllegalStateException("Harap inputkan semua field");
                }
                else{    
                    model.menuAddProgrammer(nama, alamat, telepon, alamat, id, password);
                }        
                    }catch(Exception e){
                        atPro.viewErrorMsg(e.getMessage());
            }
            PindahLayar();
            atProBukaLayar();
        }
    }
    
        
    
    
 
}
