package Model;

public class Kartlar extends Uye{
     String kartNo;

	public Kartlar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kartlar(int id, String ad, String tcno, String sifre, int kalanGun) {
		super(id, ad, tcno, sifre, kalanGun);
	}

	public Kartlar(String kullaniciAdi, String boy, String kilo, String uyelik, int borc, int bakiye, int kalanGun) {
		super(kullaniciAdi, boy, kilo, uyelik, borc, bakiye, kalanGun);
	}

	public String getKartNo() {
		return kartNo;
	}

	public void setKartNo(String kartNo) {
		this.kartNo = kartNo;
	}
}
