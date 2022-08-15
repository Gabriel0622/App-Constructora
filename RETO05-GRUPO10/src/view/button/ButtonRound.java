package view.button;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonModel;
import javax.swing.JButton;

import constant.AppColor;
import constant.AppFont;
import constant.ComandTimer;
import view.timer.TimerControl;

public class ButtonRound extends JButton {
	private int arcWidth;
	private int arcHeigth;
	private Color normalColor;
	private Color rollingColor;
	private Color normalTxtColor;
	private Color rollinglTxtColor;
	private String messageButtonTop;
	private Font fnButton;
	private TimerControl timerButton;
	private ActionListener listener;
	private int[] rgb;
	private String buttonStatus;

	public ButtonRound(String mesaggeButton) {
		this.messageButtonTop = mesaggeButton;
		setOpaque(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorderPainted(false);
		initsDefaultProperties();
	}

	private void initsDefaultProperties() {
		arcWidth = 45;
		arcHeigth = 45;
		normalColor = Color.BLACK;
		rollingColor = Color.white;
		normalTxtColor = Color.WHITE;

		rollinglTxtColor = Color.BLACK;
		fnButton = AppFont.SIZE_18;

	}

	/**
	 * pinta un boton con esquinas redondeadas con el texto centrado y un simbolo a
	 * su derecha centrando el texto distribuyendo la diferencia de espacio
	 * sobrante.
	 * 
	 * @param buttonColor el color que tendra el fondo del botton
	 * @param letterColor el color que tendra el texto y simbolo (por ahora)
	 * @param g2d         componente graphico de la clase.
	 */
	private void paintButton(Color buttonColor, Color letterColor, Graphics2D g2d) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.7d));
		g2d.setFont(fnButton);
		g2d.setColor(buttonColor);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeigth);
		g2d.setColor(letterColor);
		FontMetrics fn = g2d.getFontMetrics();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0d));
		paintOneMessage(g2d, fn);
	}

	private void paintOneMessage(Graphics2D g2d, FontMetrics fn) {
		int initialTextX = ((getWidth()) - fn.stringWidth(messageButtonTop)) / 2;
		g2d.drawString(messageButtonTop, initialTextX, getHeight() / 2 + 6);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel m = this.getModel();
		if (m.isRollover()) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			paintButton(rollingColor, rollinglTxtColor, g2d);
		} else {
			paintButton(normalColor, normalTxtColor, g2d);
		}
	}

	public void setArcWidth(int arcWidth) {
		this.arcWidth = arcWidth;
	}

	public void setArcHeigth(int arcHeigth) {
		this.arcHeigth = arcHeigth;
	}

	public void setNormalColor(Color normalColor) {
		this.normalColor = normalColor;
	}

	public void setRollingColor(Color rollingColor) {
		this.rollingColor = rollingColor;
	}

	public void setNormalTxtColor(Color normalTxtColor) {
		this.normalTxtColor = normalTxtColor;
	}

	public void setRollinglTxtColor(Color rollinglTxtColor) {
		this.rollinglTxtColor = rollinglTxtColor;
	}

	public void setMessageButton(String messageButton) {
		this.messageButtonTop = messageButton;
	}

	public void setButtonFont(Font newFont) {
		this.fnButton = newFont;
	}

	public void setAllProperties(int arcWidth, int arcHeigt, Color normalColor, Color rollingColor, Color normalTxColor,
			Color rollingTxtColor) {
		this.arcWidth = arcWidth;
		this.arcHeigth = arcHeigt;
		this.normalColor = normalColor;
		this.rollingColor = rollingColor;
		this.normalTxtColor = normalTxColor;
		this.rollinglTxtColor = rollingTxtColor;
	}
}