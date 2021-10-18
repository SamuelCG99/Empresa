package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpleadoDAO {

	private Connection connection;
	private PreparedStatement ps;
	private boolean estadoOperacion;
}
