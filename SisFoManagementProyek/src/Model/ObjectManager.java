/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Notonogoro
 */
public class ObjectManager {
    private File file = new File("sumber.dat");
    
    ObjectManager(Object obj){
    if(!file.exists()){
        try{
            file.createNewFile();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
}
