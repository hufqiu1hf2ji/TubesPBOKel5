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
public abstract class Orang {
	private String nama;
        private String alamat;
        private String telepon;
        private String jenisKelamin;

	public Orang(String nama,String jenisKelamin, String telepon, String alamat){
		this.nama = nama;
		this.jenisKelamin = jenisKelamin;
		this.telepon = telepon;
		this.alamat = alamat;
	}

        //Buat Setter
        //Buat Getter
    
}
