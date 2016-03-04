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
	private String firstNama;
	private String lastNama;
	private long id;
	private String jenisKelamin;
	private String tanggalLahir;
	private String telepon;
	private String alamat;
	private String kota;

	public Orang(String firstNama, String lastNama, String jenisKelamin, String tanggalLahir, String telepon, String alamat,String kota){
		this.firstNama = firstNama;
		this.lastNama = lastNama;
		this.jenisKelamin = jenisKelamin;
		this.tanggalLahir = tanggalLahir;
		this.telepon = telepon;
		this.alamat = alamat;
		this.kota = kota;
	}

	public abstract long createID();
    
}
