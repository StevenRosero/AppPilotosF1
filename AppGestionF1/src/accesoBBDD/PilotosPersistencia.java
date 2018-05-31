package accesoBBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Piloto;

public class PilotosPersistencia {
	private AccesoBD acceso;
	
	public PilotosPersistencia() {
		acceso = new AccesoBD();
		
	}
	
	public ArrayList<Piloto> consultaPilotos(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>();
		
		
		try {
			con = acceso.getConexion();
			
			stmt = con.createStatement();
			String query = "SELECT * FROM PILOTOS";
			
			rslt = stmt.executeQuery(query);//ejecucion del statement, query porque es una select
			
			int numero;
			String nombre = "";
			String nacionalidad = "";
			int edad;
			String escuderia = "";
			
			
			Piloto piloto = null;
			while (rslt.next()) {//consultar por posiciones, del primero al ultimo
				
				numero = rslt.getInt(1);
				nombre = rslt.getString(2);
				nacionalidad = rslt.getString(3);
				edad = rslt.getInt(4);
				escuderia = rslt.getString(5);
				piloto = new Piloto(numero, nombre, nacionalidad, edad, escuderia);//al tener estos datos lo almacenamos en un obj
				listaPilotos.add(piloto);//la añadimos a la lista
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				
				if (stmt != null) stmt.close();
				
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return listaPilotos;
	}
	
	
	
	public String borrarPilotoporNumero(int numero) {
		String res = "";//control de lo que se esta eliminando
		int iRes = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM PILOTOS WHERE NUMERO = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, numero);
			
			iRes = pstmt.executeUpdate();//update por que lo queremos actualizar borrando
			
			if (iRes > 0) {
				res = "Se ha eliminado el usuario";
			}
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			res="No se ha podido establecer la conexion";
		} catch (SQLException e) {
			//e.printStackTrace();
			res="No se ha podido realizar al accion SQL";
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
