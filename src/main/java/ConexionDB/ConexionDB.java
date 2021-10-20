package ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConexionDB {
	 private static BasicDataSource dataSource = null;
	 
	 private static DataSource getDataSource() {
	  if (dataSource == null) {
	   dataSource = new BasicDataSource();
	   dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	   dataSource.setUrl("jdbc:mysql://localhost/empNominas?user=root&password=");
	  }
	  return dataSource;
	 }
	 
	 public static Connection getConnection() throws SQLException {
	  return getDataSource().getConnection();
	 }
	
	public static void main(String[] args) {
		

	}

	
}
