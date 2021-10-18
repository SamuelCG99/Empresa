package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexionDB.ConexionDB;


public class EmpleadoDAO {

	private ConexionDB connection;
	private boolean estadoOperacion;
	private PreparedStatement ps;
	
	//Guardar Producto
	public boolean guardar(Empleado emp) throws SQLException{
		String sql = null;
		estadoOperacion = false;
		connection.conectar();
		try {
			sql = "INSERT INTO empleados (id, nombre, dni, sexo, categoria, numAnnyos)";
			ps = connection.getConexion().prepareStatement(sql);
			
			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getDni());
			ps.setString(3, emp.getSexo());
			ps.setInt(4, emp.getCategoria());
			ps.setInt(5, emp.getAnnyo());
			
			estadoOperacion = ps.executeUpdate() > 0;
			connection.getConexion().commit();
			ps.close();
			connection.desconectar();
		}catch(SQLException e) {
			
		}
	}
}
