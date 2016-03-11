/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfomanagementproyek;

/**
 *
 * @author Notonogoro
 */
    public class Programmer extends Orang{
	public String tugas;
        public int status;
        public boolean verifikasiStatus;
	
        public Programmer(String nama,String jenisKelamin, String telepon, String alamat){
            super(nama,jenisKelamin,telepon,alamat);
            status = 0;
            verifikasiStatus = false;
	}
    }