/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Notonogoro
 */
public class Proyek {

    private String namaProyek;
    //private Programmer programmer[] = new Programmer[10];
    //private Tugas[] tugas;
    private ArrayList<Programmer> programmer = new ArrayList<Programmer>();
    private ArrayList<Tugas> tugas = new ArrayList<Tugas>();
    private Date deadline;
    

    public Proyek(String namaProyek, Date deadline) {
        this.namaProyek = namaProyek;
        this.deadline = deadline;
    }

   /* public Proyek(String namaProyek, Date deadline, int maxTugas) {
        this.namaProyek = namaProyek;
        this.deadline = deadline;
        tugas = new Tugas[maxTugas];
    }*/

    public void addProgrammer(Programmer p) {
       if(p!=null){
       programmer.add(p);
       }
        /*if (numProgrammer < programmer.length) {
            programmer[numProgrammer] = p;
            numProgrammer++;
        } */
    }

    public void createTugas(String namaTugas) {
        Tugas temp = new Tugas(namaTugas);
        tugas.add(temp);
    
       /* if (numTugas < tugas.length) {
            tugas[numTugas] = new Tugas(namaTugas);
            numTugas++;
        } */
    }

    public void removeProgrammer(int indexProgrammer) {
        if(programmer.size()>indexProgrammer && indexProgrammer>-1){
           /* int temp =searchPelaksana(programmer.get(indexProgrammer));
            if (temp!=-1){
                tugas.get(temp).setPelaksana(null);
            }*/
           for(int i = 0; i <tugas.size();i++){
            removeTugas(searchPelaksana(programmer.get(indexProgrammer)));
           }
            programmer.remove(indexProgrammer);
            
        }
      /*  if ((indexProgrammer < numProgrammer) && (indexProgrammer >= 0)) {
           for (int i = 0; i < numTugas; i++) {
                if (tugas[i].getPelaksana().equals(programmer[indexProgrammer])) {
                    removeTugas(i);
                }
            }
            //mekanisme penggeseran
            for (int i = indexProgrammer; i < numProgrammer; i++) {
                programmer[i] = programmer[i + 1];
            }
            programmer[numProgrammer] = null;
            numProgrammer--;
        }*/
    }

    public void removeTugas(int indexTugas) {
        if(tugas.size()>indexTugas && indexTugas>-1){
            tugas.remove(indexTugas);

        }
        /*if ((indexTugas < numTugas) && (indexTugas >= 0)) {
            for (int i = indexTugas; i < numTugas; i++) {
                tugas[i] = tugas[i + 1];
            }
            tugas[numTugas] = null;
            numTugas--;   
        }*/
    }
    
    public int searchPelaksana(Programmer p){
        for (int i = 0; i < tugas.size(); i++) {
                if (tugas.get(i).getPelaksana() == p) {
                    return i;
                }
         }
        return -1;
    }
    public Tugas getTugas(int indexTugas) {
        return tugas.get(indexTugas);
    }

    public Programmer getProgrammer(int indexProgrammer) {
        return programmer.get(indexProgrammer);
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public int getSizeProgrammer() {
        return programmer.size();
    }

    public int getSizeTugas() {
        return tugas.size();
    }
    

    
    
}
