package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.ReporteLiderDao;
import model.dao.ReporteProyectoDao;
import model.dao.ReporteCompraDao;
import model.vo.ReporteLiderVo;
import model.vo.ReporteProyectoVo;
import model.vo.ReporteCompraVo;
import util.JDBCUtilities;

public class Manager {
	private ReporteLiderDao reporteLiderDao;
	private ReporteProyectoDao reporteProyectoDao;
	private ReporteCompraDao reporteCompraDao;
	
	public Manager() {
		reporteCompraDao = new ReporteCompraDao();
		reporteLiderDao = new ReporteLiderDao();
		reporteProyectoDao = new ReporteProyectoDao();
	}
	
	public ArrayList<ReporteCompraVo> getReportesCompra(){
		try {
			return reporteCompraDao.getReporteCompra(JDBCUtilities.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ReporteLiderVo> getReporteLider(){
		try {
			return reporteLiderDao.getReporteLider(JDBCUtilities.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ReporteProyectoVo> getReporteProyecto(){
		try {
			return reporteProyectoDao.getReporteProyecto(JDBCUtilities.getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
