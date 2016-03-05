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
    public class ManajerProyek extends Orang{
	private Proyek proyek[] = new Proyek[10];
	private int numProyek;

	public ManajerProyek(String nama,String jenisKelamin, String telepon, String alamat){
            super(nama,jenisKelamin,telepon,alamat);
            numProyek = 0;
	}

	public void createProyek(String namaProyek,Date deadline){
            //me-create obyek proyek dan menginputkannya di array proyek,lalu menambahkan numProyek, dibentuk proyek bila namaProyek belum pernah ada dan numProyek < maxProyek
	}
        
        public Proyek getProyek(int index){
            //Mereturn proyek pada array proyek dengan nomor index
        }
        
        public void deleteProyek(int index){
            //Menghapus proyek pada array proyek dengan nomor index lalu menyusun array proyek
        }
}
