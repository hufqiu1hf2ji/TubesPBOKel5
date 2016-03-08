package sisfomanagementproyek;

    public class ManajerProyek extends Orang{
	private Proyek[10]proyek;
	private int numProyek;
	private int i=0;

	
	public ManajerProyek(String nama, String jenisKelamin, String telepon, String alamat){
		super(nama,jenisKelamin,telepon,alamat);
	}

	public void createProyek(String namaProyek,date deadline){
		if(numProyekProyek<10){
			proyek[numProyek]=p;
			numProyek++;
		}
	}

	public Proyek getProyek(int indexProyek){
			return Proyek[index];
	}
	
	public void deleteProyek(int indexProyek){
		for (i=indexProyek;i<numProyek;i++){
			Proyek[i]=Proyek[i+1]
		}
		Proyek[numProyek]=null;
		numProyek--;
	}

}
