package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexionDB.ConexionDB;

public class EmpleadoDAO {

	private Connection connection;
	private boolean estadoOperacion;
	private PreparedStatement ps;

	// Guardar Empleado
	public boolean guardar(Empleado emp) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO empleados (nombre, dni, sexo, categoria, numAnnyos) VALUES (?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getDni());
			ps.setString(3, emp.getSexo());
			ps.setInt(4, emp.getCategoria());
			ps.setInt(5, emp.getAnnyo());

			estadoOperacion = ps.executeUpdate() > 0;
			connection.commit();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	private Connection obtenerConexion() throws SQLException {
		  return ConexionDB.getConnection();
		 }

	// Editar Empleado
	public boolean editar(Empleado emp) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE empleados SET nombre=?, dni=?, sexo=?, categoria=?, numAnnyos=? WHERE id=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getDni());
			ps.setString(3, emp.getSexo());
			ps.setInt(4, emp.getCategoria());
			ps.setInt(5, emp.getAnnyo());
			ps.setInt(6, emp.getId());

			estadoOperacion = ps.executeUpdate() > 0;
			connection.commit();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	//Eliminar Empleado
	public boolean eliminar(int idEmp) throws SQLException{
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM empleados WHERE id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idEmp);
			
			estadoOperacion = ps.executeUpdate() > 0;
			connection.commit();
			ps.close();
			connection.close();
		}catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	
	//Obtener lista Empleados
	public List<Empleado> obtenerEmpleados() throws SQLException {
		ResultSet rS = null;
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			sql = "SELECT * FROM empleados";
			ps = connection.prepareStatement(sql);
			rS = ps.executeQuery(sql);
			while(rS.next()) {
				Empleado emp = new Empleado();
				emp.setId(rS.getInt(1));
				emp.setNombre(rS.getString(2));
				emp.setDni(rS.getString(3));
				emp.setSexo(rS.getString(4));
				emp.setCategoria(rS.getInt(5));
				emp.setAnnyo(rS.getInt(6));
				listaEmpleados.add(emp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmpleados;
	}
	
	// obtener producto
	 public Empleado obtenerEmpleado(int idEmpleado) throws SQLException {
	  ResultSet resultSet = null;
	  Empleado emp = new Empleado();
	 
	  String sql = null;
	  estadoOperacion = false;
	  connection = obtenerConexion();
	 
	  try {
	   sql = "SELECT * FROM productos WHERE id =?";
	   ps = connection.prepareStatement(sql);
	   ps.setInt(1, idEmpleado);
	 
	   resultSet = ps.executeQuery();
	 
	   if (resultSet.next()) {
	    emp.setId(resultSet.getInt(1));
	    emp.setNombre(resultSet.getString(2));
	    emp.setDni(resultSet.getString(3));
	    emp.setSexo(resultSet.getString(4));
	    emp.setCategoria(resultSet.getInt(5));
	    emp.setAnnyo(resultSet.getInt(6));
	   }
	 
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 
	  return emp;
	 }
	
}