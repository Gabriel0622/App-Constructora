package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constant.ComponentText;
import constant.Path;
import model.vo.ReporteLiderVo;
import model.vo.ReporteProyectoVo;
import model.vo.ReporteCompraVo;
import view.panel.PanelConsultas;
import view.panel.PanelInicio;
import view.timer.TimerControl;

public class MainFrame extends JFrame{
	private PanelInicio pnInicio;
	private PanelConsultas pnConsultas;

	public final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();;
	public MainFrame(ActionListener listener) {
		super(ComponentText.TITLE_MAIN_FRAME);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new GridBagLayout());
		this.setSize(1200,800);
		this.setMinimumSize(new Dimension(500, 400));
		this.setResizable(true);
		this.getContentPane().setBackground(new Color(0x2c3333));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(Path.DATA_IMAGES_APP_ICON_PNG)).getImage());
		initsCompontents(listener);
		this.setVisible(true);
	}
	
	private void initsCompontents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		pnInicio = new PanelInicio(listener, SCREEN_SIZE);
		gbc.ipadx = SCREEN_SIZE.width - 400;
		gbc.ipady = SCREEN_SIZE.height - 500;
		this.add(pnInicio,gbc);
		pnConsultas = new PanelConsultas(listener, SCREEN_SIZE);
		gbc.ipadx = 0;
		gbc.ipady = 0;
		this.add(pnConsultas,gbc);
		pnConsultas.setVisible(false);
	}
	
	public void menuConsultas() {
		pnInicio.setVisible(false);
		pnConsultas.setVisible(true);
	}
	
	public void salirMenu(ActionListener listener) {
		pnInicio.setVisible(true);
		pnConsultas.setVisible(false);
		pnConsultas.salirConsultas(listener);
		pnConsultas.setReporteActual("");
		this.getContentPane().revalidate();
	}
	
	public void mostrarReportesCompras(ActionListener listener, ArrayList<ReporteCompraVo> reportesCompras) {
		pnConsultas.showPanelReporteCompras(listener, reportesCompras);
		pnConsultas.setReporteActual("reporte-compra");
		this.getContentPane().revalidate();
	}
	public void mostrarReportesLideres(ActionListener listener, ArrayList<ReporteLiderVo> reportesLideres) {
		pnConsultas.showPanelReporteLideres(listener, reportesLideres);
		pnConsultas.setReporteActual("reporte-lider");
		this.getContentPane().revalidate();
	}
	public void mostrarReportesProyectos(ActionListener listener, ArrayList<ReporteProyectoVo> reportesProyectos) {
		pnConsultas.showPanelReporteProyectos(listener, reportesProyectos);
		pnConsultas.setReporteActual("reporte-proyecto");
		this.getContentPane().revalidate();
	}
	

}
