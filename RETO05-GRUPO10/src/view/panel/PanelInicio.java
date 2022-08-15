package view.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import constant.ComponentText;
import constant.Path;
import view.button.Button3d;

public class PanelInicio extends JPanel{
	
	private GridBagConstraints gbc;
	private PanelIngreso pnIngreso;
	private Dimension dim;
	private Image imgFondo;
	
	public PanelInicio(ActionListener listener, Dimension dim) {
		gbc = new GridBagConstraints();
		this.dim = dim;
		imgFondo =  new ImageIcon(getClass().getResource(Path.DATA_IMAGES_FONDO_INICIO)).getImage();
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initsComponents(listener, dim);
	}
	
	private void initsComponents(ActionListener listener, Dimension dim) {
		pnIngreso = new PanelIngreso(listener);
		gbc.ipadx = 80;
		gbc.ipady = 80;
		this.add(pnIngreso,gbc);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(imgFondo, 0, 0, dim.width, dim.height, null);
 
	}
	
	
}
