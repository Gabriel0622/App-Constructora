package view.button;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JButton;

import constant.AppColor;
import constant.AppFont;

public class ButtonMainMenu extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8546006116949610713L;
	private String message;
	private Color colorButton;
	private Color colorButtonRollover;
	private Color colorButtonPressed;
	private Color colorText;
	private Font fnText;
	public ButtonMainMenu(String message) {
		this.message = message;
		defaultValues();
		setOpaque(false);
		setContentAreaFilled(false);
        setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorderPainted(false);
	}
	
	private void defaultValues() {
		colorButton =  AppColor.LIGHT_GREY;
		colorText = Color.WHITE;
		colorButtonRollover = AppColor.GREENISH_GRAY;
		colorButtonPressed = AppColor.BLUEISH_GRAY;
		fnText = AppFont.COMPONENT_16;
	}
	private void paintButton(Graphics2D g2d, Color colorButton) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5d));
		g2d.setColor(colorButton);
		g2d.fillRect(0, 0, getWidth(),getHeight());
		g2d.setColor(Color.WHITE);
		g2d.setFont(fnText);
		FontMetrics fn = g2d.getFontMetrics();
		paintMessage(g2d, fn);
	}
	private void paintMessage(Graphics2D g2d, FontMetrics fn) {
		int initialTextX = getWidth()/2 - fn.stringWidth(message)/2;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.8d));
		g2d.setColor(colorText);
		g2d.drawString(message, initialTextX, getHeight()/2+6);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.1d));
		ButtonModel m = this.getModel();
		if (m.isRollover()) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			paintButton(g2d, colorButtonRollover);
		}else {
			paintButton(g2d,colorButton);
		}
		if (m.isPressed()) {
			paintButton(g2d, colorButtonPressed);
		}
	}
}
