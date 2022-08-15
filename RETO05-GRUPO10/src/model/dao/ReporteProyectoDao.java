package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ReporteProyectoVo;

public class ReporteProyectoDao {
	public ReporteProyectoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ReporteProyectoVo> getReporteProyecto(Connection conn) throws SQLException {
		ArrayList<ReporteProyectoVo> result = new ArrayList<>();
		String sql = "select id_proyecto,constructora ,numero_habitaciones,ciudad "
				+ "FROM Proyecto "
				+ "where (clasificacion = 'Casa Campestre') AND ciudad IN ('Santa Marta','Cartagena','Barranquilla');";
		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		while (rs.next()) {
			result.add(new ReporteProyectoVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		if (conn != null) {
			conn.close();
		}
	
		if (rs != null) {
			rs.close();
		}
		return result;
	}
}
