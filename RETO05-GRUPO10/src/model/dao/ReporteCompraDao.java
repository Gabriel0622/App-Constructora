package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ReporteProyectoVo;
import model.vo.ReporteCompraVo;

public class ReporteCompraDao {
	public ReporteCompraDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ReporteCompraVo> getReporteCompra(Connection conn) throws SQLException {
		ArrayList<ReporteCompraVo> result = new ArrayList<>();
		String sql = "SELECT c.id_compra AS id, p.constructora, p.banco_vinculado "
				+ "FROM Proyecto p "
				+ "JOIN Compra c ON c.id_proyecto = p.id_proyecto "
				+ "WHERE c.proveedor = 'Homecenter' AND p.ciudad = 'Salento';";
		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		while (rs.next()) {
			result.add(new ReporteCompraVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
