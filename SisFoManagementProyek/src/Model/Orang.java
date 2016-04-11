/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Notonogoro
 */
public abstract class Orang {

    private String nama;
    private String alamat;
    private String telepon;
    private String jenisKelamin;
    private String id;
    private String pw;

    public Orang(String nama, String jenisKelamin, String telepon, String alamat,String Id,String Password) {
        setNama(nama);
        setJenisKelamin(jenisKelamin);
        setTelepon(telepon);
        setAlamat(alamat);
        setId(Id);
        setPassword(Password);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }
    
    public String getID(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setPassword(String pw){
        this.pw = pw;
    }
    
    public String getPassword(){
        return pw;
    }
}

