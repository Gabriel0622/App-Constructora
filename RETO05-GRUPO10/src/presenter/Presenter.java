package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import constant.CommandButton;
import model.Manager;
import model.vo.ReporteLiderVo;
import view.MainFrame;

public class Presenter implements ActionListener{
	
	private MainFrame view;
	private Manager manager;
	
	public Presenter() {
		view = new MainFrame(this);
		manager = new Manager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case CommandButton.ACCION_MENU_CONSULTAS:
			view.menuConsultas();
			break;
		case CommandButton.ACCION_MENU_SALIR:
			view.salirMenu(this);
			break;
		case CommandButton.ACCION_MENU_REPORTE_COMPRAS:
			view.mostrarReportesCompras(this, manager.getReportesCompra());
			break;
		case CommandButton.ACCION_MENU_REPORTE_LIDERES:
			view.mostrarReportesLideres(this, manager.getReporteLider());
			break;
		case CommandButton.ACCION_MENU_REPORTE_PROYECTOS:
			view.mostrarReportesProyectos(this, manager.getReporteProyecto());
			break;
		default:
			break;
		}
		
	}

}
