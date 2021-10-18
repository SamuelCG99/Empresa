package ConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {

	Connection con = null;
	
	public Connection getConexion() {
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/empNominas?user=root&password=");
			if(con != null) {
				System.out.println("Conexion OK " + con);
			}
		}catch(Exception e) {
			
		}
		return con;
	}
	
	public Connection conectar() {
		return con;
	}
	
	public void desconectar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		

	}

	
}
