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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constant.AppFont;
import constant.Path;

public class PanelSinReporte extends JPanel{

	private Dimension dim;
	private Image imgFondo;
	
	public PanelSinReporte(ActionListener listener, Dimension dim) {
		this.dim = dim;
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		imgFondo =  new ImageIcon(getClass().getResource(Path.DATA_IMAGES_SIN_MENU_CONSULTA)).getImage();
		initsComponents();
	}
	private void initsComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel lblSinReporte = new JLabel("Seleccione reporte");
		lblSinReporte.setForeground(new Color(0xffffff));
		lblSinReporte.setFont(AppFont.H1);
		this.add(lblSinReporte,gbc);
	}
	
}
