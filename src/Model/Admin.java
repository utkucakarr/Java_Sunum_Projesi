package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Admin extends User{
       
	public Admin() {}
      DBConnection conn = new DBConnection();
 	  Connection c = conn.connDB();
 	  Statement st = null;
 	  ResultSet rs = null;
 	  PreparedStatement preparedStatement = null;
	public Admin(int id, String ad, String tcno, String sifre) {
		super(id, ad, tcno, sifre);
		
	}	public ArrayList<Personel>getPersonellerList() throws SQLException{
	  	  ArrayList<Personel>list = new ArrayList();
	  	Personel obj;
	  	 
	  	  try {
	  		  st = c.createStatement();
				rs = st.executeQuery("SELECT * FROM antrenor ");
				while(rs.next()) {
		    		  obj = new Personel(rs.getInt("id"),rs.getString("adSoyad"),null, null, rs.getString("wHour"));
		    		  list.add(obj);
		    	  }
			} catch (SQLException e) {
			}
	  	  return list;
	  	    
	    }
		
		
		public boolean addPersonel(String adSoyad,String wHour) throws SQLException {
	  	  String query = "INSERT INTO antrenor" + "(adSoyad,wHour) VALUES" + "(?,?)";
	  	  boolean key = false;
	  	 try {
	  		 st = c.createStatement();
	     	  preparedStatement = c.prepareStatement(query);
	     	  preparedStatement.setString(1,adSoyad);
	     	  preparedStatement.setString(2,wHour);
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
		
		public boolean updatePersonel(int id, String adSoyad,String wHour) throws SQLException { // yeni
			 
		   	  String query = "UPDATE antrenor SET adSoyad = ?,wHour = ? WHERE id = ?";
		   	  boolean key = false;
		   	 try {
		   		  st = c.createStatement();
		      	  preparedStatement = c.prepareStatement(query);
		      	  preparedStatement.setString(1, adSoyad);
		      	  preparedStatement.setString(2, wHour);
		      	  preparedStatement.setInt(3, id);
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
		
		
		
		 public boolean silPersonel(int id) throws SQLException {
	   	  String query = "DELETE FROM antrenor WHERE id = ?";
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
