/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Notonogoro
 */
public class ObjectManagerProgrammer
{

    private File file = new File("Programmer.dat");

    public ObjectManagerProgrammer(Object obj)
    {
        //jika file tidak ada
        if (!file.exists())
        {
            try
            {
                //buat file baru
                file.createNewFile();

                //file biar tidak kosong
                if (saveObject(obj))
                {

                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public boolean saveObject(Object obj)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Object readObject()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();

        } catch (EOFException ex)
        {
            return null;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
