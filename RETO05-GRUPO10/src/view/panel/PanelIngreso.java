package view.panel;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Finishings;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constant.AppFont;
import constant.CommandButton;
import constant.ComponentText;
import constant.Path;
import view.button.Button3d;
import view.button.ButtonRound;

public class PanelIngreso extends JPanel {

	private GridBagConstraints gbc;
	private ButtonRound btnIngress;

	public PanelIngreso(ActionListener listener) {
		gbc = new GridBagConstraints();

		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initsComponents(listener);
	}

	private void initsComponents(ActionListener listener) {
		gbc.insets = new Insets(20, 0, 50, 0);
		initsLabels();
		btnIngress = new ButtonRound(ComponentText.MENU_OPCION);
		btnIngress.addActionListener(listener);
		btnIngress.setActionCommand(CommandButton.ACCION_MENU_CONSULTAS);
		gbc.insets = new Insets(100, 0, 0, 0);
		gbc.gridy = 1;
		gbc.ipadx = 100;
		gbc.ipady = 50;
		this.add(btnIngress, gbc);

	}
	private void initsLabels () {
		JLabel lblTituloPanel = new JLabel(ComponentText.PANEL_INICIO_TITULO);
		lblTituloPanel.setFont(AppFont.SIZE_36);
		lblTituloPanel.setForeground(Color.WHITE);
		this.add(lblTituloPanel,gbc);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(0x2c3333));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.7d));
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
	
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.9d));
	}

}
