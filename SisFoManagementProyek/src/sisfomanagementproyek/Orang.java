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

        public void setNama(String nama){
            this.nama=nama;
        }
        
        public String getNama(){
            return nama;
        }
        
        public void setAlamat(String alamat){
            this.alamat=alamat;
        }
        
        public String getAlamat(){
            return alamat;
        }
        
        public void setTelepon(String telepon){
            this.telepon=telepon;
        }
        
        public String getTelepon(){
            return telepon;
        }
        
        public void setJenisKelamin(String jenisKelamin){
            this.jenisKelamin=jenisKelamin;
        }
        
        public String getJenisKelamin(){
            return jenisKelamin;
        }
}
//Wendi maafin kl msh ada atau byk yg salah
