package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ReporteLiderVo;


public class ReporteLiderDao {
	public ReporteLiderDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ReporteLiderVo> getReporteLider(Connection conn) throws SQLException {
		ArrayList<ReporteLiderVo> result = new ArrayList<>();
		String sql = "SELECT l.id_lider AS ID, l.nombre || ' ' || l.primer_apellido || ' ' || l.segundo_apellido, l.ciudad_residencia AS Ciudad "
				+ "FROM Lider l "
				+ "ORDER BY l.ciudad_residencia ASC;";
		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		while (rs.next()) {
			result.add(new ReporteLiderVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
