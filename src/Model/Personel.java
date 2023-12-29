package Model;

public class Personel extends User{

	String wHour;

	public Personel(int id, String ad, String tcno, String sifre, String wHour) {
		super(id, ad, tcno, sifre);
		this.wHour = wHour;
	}

	public String getwHour() {
		return wHour;
	}

	public void setwHour(String wHour) {
		this.wHour = wHour;
	}
	
}

		
			
		

	

	

