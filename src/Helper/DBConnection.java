package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
     Connection c = null;
     
     public DBConnection() {};
     public Connection connDB() {
    	 try {
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness","root","553212");
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 return c;
     };
     
     
}
