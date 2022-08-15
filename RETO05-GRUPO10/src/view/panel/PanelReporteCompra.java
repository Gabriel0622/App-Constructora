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
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import model.vo.ReporteCompraVo;
import model.vo.ReporteLiderVo;

public class PanelReporteCompra extends JPanel{
	public PanelReporteCompra(ArrayList<ReporteCompraVo> reportesCompras, Dimension dim) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initsComponents(reportesCompras,dim);
	}
	
	private void initsComponents(ArrayList<ReporteCompraVo> reportesCompras,Dimension dim) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipadx = dim.width -450;
		gbc.ipady = 40;
		gbc.insets = new Insets(10, 10, 10, 10);
		for (int i = 0; i < reportesCompras.size(); i++) {
			gbc.gridy = i;
			PanelCompra aux = new PanelCompra(reportesCompras.get(i));
			aux.setBackground(Color.green);
			this.add(aux,gbc);
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.6d));
		g2d.fillRoundRect(50, 0, getWidth()-50, getHeight(),0,0);
	}
	
}
