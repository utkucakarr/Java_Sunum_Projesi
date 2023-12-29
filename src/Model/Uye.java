package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Uye extends User{
	  Statement st = null;
	  ResultSet rs = null;
	  DBConnection conn = new DBConnection();
	  Connection c = conn.connDB();
	  PreparedStatement preparedStatement = null;
    String kullaniciAdi,boy,kilo,uyelik;
    int borc,bakiye,kalanGun;
	public Uye(String kullaniciAdi, String boy, String kilo, String uyelik, int borc, int bakiye, int kalanGun) {
	
		this.kullaniciAdi = kullaniciAdi;
		this.boy = boy;
		this.kilo = kilo;
		this.uyelik = uyelik;
		this.borc = borc;
		this.bakiye = bakiye;
		this.kalanGun = kalanGun;
	}
	public Uye(int id, String ad, String tcno, String sifre, int kalanGun) {
		super(id, ad, tcno, sifre);	
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getBoy() {
		return boy;
	}
	public int getKalanGun() {
		return kalanGun;
	}
	public void setKalanGun(int kalanGun) {
		this.kalanGun = kalanGun;
	}
	public void setBoy(String boy) {
		this.boy = boy;
	}
	public String getKilo() {
		return kilo;
	}
	public void setKilo(String kilo) {
		this.kilo = kilo;
	}
	public String getUyelik() {
		return uyelik;
	}
	public void setUyelik(String uyelik) {
		this.uyelik = uyelik;
	}
	public int getBorc() {
		return borc;
	}
	public void setBorc(int borc) {
		this.borc = borc;
	}
	public int getBakiye() {
		return bakiye;
	}
	public void setBakiye(int bakiye) {
		this.bakiye = bakiye;
	}
	public Uye() {}
	public boolean addKullanici(String kullaniciadi, String kullanicisifre, String tc, String adsoyad, String boy, String kilo, String uyelik, int borc, int kalanGun)
	{
		String query = "INSERT INTO user" + "(kullaniciadi, kullanicisifre, tc, adsoyad, boy, kilo, uyelik, borc, kalanGun) VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean key = false;
		try {
			Connection con = conn.connDB();
			Statement st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kullaniciadi);
			preparedStatement.setString(2, kullanicisifre);
			preparedStatement.setString(3, tc);
			preparedStatement.setString(4, adsoyad);
			preparedStatement.setString(5, boy);
			preparedStatement.setString(6, kilo);
			preparedStatement.setString(7, uyelik);
			preparedStatement.setInt(8, borc);
			preparedStatement.setInt(9, kalanGun);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}
	public ArrayList<User>getUyelerList() throws SQLException{
	  	  ArrayList<User>list = new ArrayList();
	  	  User obj;
	  	 
	  	  try {
	  		  st = c.createStatement();
				rs = st.executeQuery("SELECT * FROM user ");
				while(rs.next()) {
		    		  obj = new User(rs.getInt("KullaniciId"),rs.getString("kullaniciadi"),null,rs.getString("kalanGun"));
		    		  list.add(obj);
		    	  }
			} catch (SQLException e) {
			}
	  	  return list;
	  	    
	    }
	 public boolean silUye(int id) throws SQLException {
	   	  String query = "DELETE FROM user WHERE KullaniciId = ?";
	   	  boolean key = false;
	   	 try {
	   		 st = c.createStatement();
	      	  preparedStatement = c.prepareStatement(query);
	      	  preparedStatement.setInt(1,id);
	      	  preparedStatement.executeUpdate();
	      	  key=true;
	      	  }catch(Exception e) {
	   		 e.printStackTrace();	 
	   	 }
	   	 if(key)
	   		 return true;
	   	 else
	   		 return false;
	   	  
	     }
	
}
