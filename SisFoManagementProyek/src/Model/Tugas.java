/*
 * testTo change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Notonogoro
 */
public class Tugas {

    private String namaTugas;
    private Programmer pelaksana=null;
    private int status;

    public Tugas(String namaTugas) {
        this.namaTugas = namaTugas;
        status = 0;
    }

    /*public void setPelaksana(Programmer pelaksana, Proyek p) {  //TARUH DIAPLIKASIKONSOL
        if(pelaksana.getProgrammerDalamProyek(p) && cekTugasDalamProyek(p)){
            this.pelaksana = pelaksana;
        }
    }*/
    
    public void setPelaksana(Programmer pelaksana){
        if(this.status==0 && pelaksana !=null){
            this.pelaksana = pelaksana;
        }
    }
    
    /*
    public boolean cekTugasDalamProyek(Proyek p){ //TARUH DIAPLIKASI KONSOL
        boolean t=false;
        for(int i =0 ; i<p.getNumTugas();i++){
            if(p.getTugas(i).equals(this)){
                t=true;
            }
        }
        return t;
//    
    
    }*/
    
    
    
    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public Programmer getPelaksana() {
        return pelaksana;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
