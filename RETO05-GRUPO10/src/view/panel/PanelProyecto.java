package view.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import constant.AppFont;
import model.vo.ReporteLiderVo;
import model.vo.ReporteProyectoVo;
import model.vo.ReporteCompraVo;

public class PanelProyecto extends JPanel{
	
	private ReporteProyectoVo proyecto;
	
	public PanelProyecto(ReporteProyectoVo proyecto) {
		this.proyecto = proyecto;
		this.setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(0x2c3333));
		int widthColumn = getWidth()/4;
		g2d.setColor(Color.WHITE);
		g2d.fillRoundRect(0, 0, widthColumn-15, getHeight(), 50, 50);
		g2d.fillRoundRect(widthColumn , 0, widthColumn-15, getHeight(), 50, 50);
		g2d.fillRoundRect(widthColumn * 2 ,0 , widthColumn-15, getHeight(), 50, 50);
		g2d.fillRoundRect(widthColumn * 3 ,0 , widthColumn-15, getHeight(), 50, 50);
		g2d.setColor(Color.BLACK);
		g2d.setFont(AppFont.SIZE_18);
		g2d.drawString(proyecto.getId()+"", 15, 25);
		g2d.drawString(proyecto.getConstructora(), widthColumn +25, 27);
		g2d.drawString(proyecto.getNumeroHabitaciones()+"", widthColumn * 2 +25, 27);
		g2d.drawString(proyecto.getCiudad(), widthColumn * 3 +25, 27);
		
		//g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0d));
	}
}
