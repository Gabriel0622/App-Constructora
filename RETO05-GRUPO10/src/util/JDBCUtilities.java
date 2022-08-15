package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

	private static final String UBICACION_BD = "target/ProyectosConstruccion.db";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:sqlite:" + UBICACION_BD;
		return DriverManager.getConnection(url);
	}
}
