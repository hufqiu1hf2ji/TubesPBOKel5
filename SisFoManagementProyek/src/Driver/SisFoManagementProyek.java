/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.Controller;
import Model.AplikasiKonsol;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Notonogoro
 */
public class SisFoManagementProyek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AplikasiKonsol coba = new AplikasiKonsol();
        Controller c = new Controller(coba);
        coba.MainMenu();
        
    }
}
