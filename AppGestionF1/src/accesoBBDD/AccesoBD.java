package accesoBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBD {
	private String driver;
	private String url;
	
	public AccesoBD() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:dbSQLite/PILOTOS.db";
	}
	
	public Connection getConexion() 
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		System.out.println("Conexión establecida");
		return con;

	}
}