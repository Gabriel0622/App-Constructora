package view.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import constant.CommandButton;
import view.button.ButtonMainMenu;

public class PanelMenuConsultas extends JPanel{
	
	private GridBagConstraints gbc;
	private ButtonMainMenu btnReporteLideres;
	private ButtonMainMenu btnReporteProyectos;
	private ButtonMainMenu btnReporteCompras;
	private ButtonMainMenu btnSalir;
	
	
	public PanelMenuConsultas(ActionListener listener, Dimension dim) {
		gbc = new GridBagConstraints();
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x343a40));
		initsComponents(listener, dim);
	}
	
	private void initsComponents(ActionListener listener, Dimension dim ) {
		btnReporteLideres = new ButtonMainMenu("Reporte 01 - Lideres");
		btnReporteLideres.addActionListener(listener);
		btnReporteLideres.setActionCommand(CommandButton.ACCION_MENU_REPORTE_LIDERES);
		btnReporteProyectos = new ButtonMainMenu("Reporte 02 - Proyectos");
		btnReporteProyectos.addActionListener(listener);
		btnReporteProyectos.setActionCommand(CommandButton.ACCION_MENU_REPORTE_PROYECTOS);
		btnReporteCompras = new ButtonMainMenu("Repoerte 03 - Compras");
		btnReporteCompras.addActionListener(listener);
		btnReporteCompras.setActionCommand(CommandButton.ACCION_MENU_REPORTE_COMPRAS);
		btnSalir = new ButtonMainMenu("Salir");
		btnSalir.addActionListener(listener);
		btnSalir.setActionCommand(CommandButton.ACCION_MENU_SALIR);
		addButtons(dim);
	}
	
	private void addButtons(Dimension dim) {
		gbc.ipadx = 250;
		gbc.ipady = 70;
		this.add(btnReporteLideres,gbc);
		gbc.gridy = 1;
		this.add(btnReporteProyectos,gbc);
		gbc.gridy = 2;
		this.add(btnReporteCompras,gbc);
		gbc.gridy = 3;
		gbc.insets = new Insets(dim.height - 395,0, 0, 0);
		this.add(btnSalir,gbc);
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.6d));
		g2d.fillRect(0, 0, getWidth(), getHeight());
 
	}
}
