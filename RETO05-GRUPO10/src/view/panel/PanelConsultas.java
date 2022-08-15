package view.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import constant.AppFont;
import constant.Path;
import model.vo.ReporteLiderVo;
import model.vo.ReporteProyectoVo;
import model.vo.ReporteCompraVo;

public class PanelConsultas extends JPanel {
	private JScrollPane scPane;
	private PanelMenuConsultas pnConsultas;
	private PanelSinReporte pnSinReporte;
	private PanelReporteCompra pnReporteCompra;
	private PanelReporteProyecto pnReporteProyecto;
	private PanelReporteLider pnReporteLider;
	private GridBagConstraints gbc;
	private Dimension dim;
	private Image imgFondo;
	private String reporteActual;

	public PanelConsultas(ActionListener listener, Dimension dim) {
		this.dim = dim;
		reporteActual = "";
		imgFondo = new ImageIcon(getClass().getResource(Path.DATA_IMAGES_SIN_MENU_CONSULTA)).getImage();
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		initsComponents(listener, dim);
	}

	private void initsComponents(ActionListener listener, Dimension dim) {
		gbc.gridx = 0;
		pnConsultas = new PanelMenuConsultas(listener, dim);
		this.add(pnConsultas, gbc);
		gbc.gridx = 1;
		pnSinReporte = new PanelSinReporte(listener, dim);
		gbc.ipady = dim.height - 122;
		gbc.ipadx = dim.width - 645;
		this.add(pnSinReporte, gbc);
	}
	
	public void salirConsultas(ActionListener listener) {
		removeAll();
		gbc.ipady = 0;
		gbc.ipadx = 0;
		gbc.gridx = 0;
		pnConsultas = new PanelMenuConsultas(listener, dim);
		this.add(pnConsultas, gbc);
		gbc.gridx = 1;
		pnSinReporte = new PanelSinReporte(listener, dim);
		gbc.ipady = dim.height - 122;
		gbc.ipadx = dim.width - 645;
		this.add(pnSinReporte, gbc);
	}

	public void showPanelReporteCompras(ActionListener listener, ArrayList<ReporteCompraVo> reportesCompras) {
		this.removeAll();
		gbc.gridx = 0;
		pnConsultas = new PanelMenuConsultas(listener, dim);
		gbc.ipady = 0;
		gbc.ipadx = 0;
		this.add(pnConsultas, gbc);
		gbc.gridx = 1;
		pnReporteCompra = new PanelReporteCompra(reportesCompras, dim);
		scPane = new JScrollPane();
		scPane.getVerticalScrollBar().setUnitIncrement(36);
		scPane.setViewportView(pnReporteCompra);
		scPane.setBorder(new LineBorder(Color.WHITE, 0, true));
		scPane.setOpaque(false);
		scPane.getViewport().setOpaque(false);
		gbc.ipady = dim.height - 500;
		gbc.ipadx = dim.width - 308;
		this.add(scPane, gbc);
		this.repaint();
	}

	public void showPanelReporteLideres(ActionListener listener, ArrayList<ReporteLiderVo> reportesLider) {
		this.removeAll();
		gbc.gridx = 0;
		pnConsultas = new PanelMenuConsultas(listener, dim);
		gbc.ipady = 0;
		gbc.ipadx = 0;
		this.add(pnConsultas, gbc);
		gbc.gridx = 1;
		pnReporteLider = new PanelReporteLider(reportesLider, dim);
		scPane = new JScrollPane();
		scPane.getVerticalScrollBar().setUnitIncrement(36);
		scPane.setViewportView(pnReporteLider);
		scPane.setBorder(new LineBorder(Color.WHITE, 0, true));
		scPane.setOpaque(false);
		scPane.getViewport().setOpaque(false);
		gbc.ipady = dim.height - 500;
		gbc.ipadx = dim.width - 308;
		this.add(scPane, gbc);
		this.repaint();
	}
	public void showPanelReporteProyectos(ActionListener listener, ArrayList<ReporteProyectoVo> reportesProyectos) {
		this.removeAll();
		gbc.gridx = 0;
		pnConsultas = new PanelMenuConsultas(listener, dim);
		gbc.ipady = 0;
		gbc.ipadx = 0;
		this.add(pnConsultas, gbc);
		gbc.gridx = 1;
		pnReporteProyecto = new PanelReporteProyecto(reportesProyectos, dim);
		scPane = new JScrollPane();
		scPane.getVerticalScrollBar().setUnitIncrement(36);
		scPane.setViewportView(pnReporteProyecto);
		scPane.setBorder(new LineBorder(Color.WHITE, 0, true));
		scPane.setOpaque(false);
		scPane.getViewport().setOpaque(false);
		gbc.ipady = dim.height - 500;
		gbc.ipadx = dim.width - 308;
		this.add(scPane, gbc);
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(imgFondo, 0, 0, dim.width, dim.height, null);
		g2d.setColor(new Color(0x2c3333));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.6d));
		g2d.fillRect(0, 0, dim.width, dim.height);
		g2d.setColor(Color.white);

		cualReporteTitulo(g2d);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0d));
	}

	private void cualReporteTitulo(Graphics2D g2d) {
		switch (reporteActual) {
		case "reporte-lider":
			paintLiderTitulo(g2d);
			break;
		case "reporte-proyecto":
			paintProyectoTitulo(g2d);
			break;
		case "reporte-compra":
			paintCompraTitulo(g2d);
			break;
		default:
			break;
		}
	}

	private void paintLiderTitulo(Graphics2D g2d) {
		paintBarras(g2d);
		g2d.setColor(Color.black);
		g2d.setFont(AppFont.SIZE_28);
		g2d.fillRect(dim.width - 829, dim.height - 764, 5, 101);
		g2d.fillRect(dim.width - 463, dim.height - 764, 5, 101);
		
		g2d.drawString("Id", dim.width - 1030, dim.height - 700);
		g2d.drawString("Lider", dim.width - 670, dim.height - 700);
		g2d.drawString("Ciudad", dim.width - 290, dim.height - 700);
	}

	private void paintProyectoTitulo(Graphics2D g2d) {
		paintBarras(g2d);
		g2d.setColor(Color.black);
		g2d.setFont(AppFont.SIZE_28);
		g2d.fillRect(dim.width - 920, dim.height - 764, 5, 101);
		g2d.fillRect(dim.width - 645, dim.height - 764, 5, 101);
		g2d.fillRect(dim.width - 370, dim.height - 764, 5, 101);
		
		g2d.drawString("Id", dim.width - 1075, dim.height - 700);
		g2d.drawString("Constructora", dim.width - 855, dim.height - 700);
		g2d.drawString("Habitaciones", dim.width - 580, dim.height - 700);
		g2d.drawString("Ciudad", dim.width - 260, dim.height - 700);

	}

	private void paintCompraTitulo(Graphics2D g2d) {
		paintBarras(g2d);
		g2d.setColor(Color.black);
		g2d.setFont(AppFont.SIZE_28);
		g2d.fillRect(dim.width - 829, dim.height - 764, 5, 101);
		g2d.fillRect(dim.width - 463, dim.height - 764, 5, 101);
		
		g2d.drawString("Id", dim.width - 1030, dim.height - 700);
		g2d.drawString("Constructora", dim.width - 720, dim.height - 700);
		g2d.drawString("Banco", dim.width - 290, dim.height - 700);
	}

	public void setReporteActual(String reporteActual) {
		this.reporteActual = reporteActual;
	}

	public void paintBarras(Graphics2D g2d) {
		g2d.fillRect(dim.width - 1202, dim.height - 739, 1182, 75);
		g2d.fillArc(dim.width - 1202, dim.height - 764, 50, 50, 90, 90);
		g2d.fillArc(dim.width - 70, dim.height - 764, 50, 50, 0, 90);
		g2d.fillRect(dim.width - 1177, dim.height - 764, 1132, 25);
//		
		g2d.fillRect(dim.width - 1202, dim.height - 277, 1182, 75);
		g2d.fillArc(dim.width - 1202, dim.height - 227, 50, 50, 180, 90);
		g2d.fillArc(dim.width - 70, dim.height - 227, 50, 50, 270, 90);
		g2d.fillRect(dim.width - 1177, dim.height - 202, 1132, 25);
	}

}
