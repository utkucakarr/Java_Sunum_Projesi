package Model;

public class User {
	private int id;
	String ad,tcno,sifre;
	
	
	public User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public User(int id, String ad, String tcno, String sifre) {
		super();
		this.id = id;
		this.ad = ad;
		this.tcno = tcno;
		this.sifre = sifre;
	}

}
