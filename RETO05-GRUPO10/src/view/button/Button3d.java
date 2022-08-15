package view.button;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JButton;

public class Button3d extends JButton{
	private int arcWidth;
	private int arcHeigth;
	private Color normalColor;
	private Color shadowColor;
	private Color normalColorText;
	private Color rollingColor;
	private Color rollingColorText;
	private String messageButton;
	private Font fnButton;
	private float opacity;
	
	public Button3d(String messageButton) {
		this.messageButton = messageButton;
		setOpaque(false);
		setContentAreaFilled(false);
        setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorderPainted(false);
		defaultProperties();
	}
	
	private void defaultProperties() {
		arcWidth = 30;
		arcHeigth = 30;
		normalColorText = Color.WHITE;
		rollingColorText = Color.WHITE;
		normalColor = new Color(0x395b64);
		shadowColor = normalColor.darker();
		rollingColor = normalColor.brighter();
		fnButton = new Font("Impact",Font.PLAIN,36);
		opacity = 0.5f;
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel m = this.getModel();
		if (m.isRollover()) {
			if (m.isPressed()) {
				paintpressedButton(rollingColor, rollingColorText, g2d);
			}else {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				paintUnpressedButton(rollingColor,rollingColorText,  g2d);
			}
		}else {
			paintUnpressedButton(normalColor,normalColorText, g2d);
		}	
	}
	private void paintUnpressedButton(Color buttonColor, Color textColor, Graphics2D g2d) {
		g2d.setFont(fnButton);
		FontMetrics fn = g2d.getFontMetrics();
		g2d.setStroke(new BasicStroke(8));
		g2d.setColor(shadowColor);
		g2d.fillRoundRect(0, 15, getWidth()-15, getHeight()-15, arcWidth, arcHeigth);
		g2d.setColor(buttonColor);
		g2d.fillRoundRect(15, 0, getWidth()-15, getHeight()-15, arcWidth, arcHeigth);
		paintOneMessage(g2d, fn, textColor,15,-15);
	}
	private void paintpressedButton(Color buttonColor, Color textColor, Graphics2D g2d) {
		g2d.setColor(buttonColor);
		g2d.setFont(fnButton);
		FontMetrics fn = g2d.getFontMetrics();
		g2d.setStroke(new BasicStroke(8));
		g2d.fillRoundRect(0, 15, getWidth()-30, getHeight()-15, arcWidth, arcHeigth);
		paintOneMessage(g2d, fn, textColor,-15,0);
	}
	
	private void paintOneMessage(Graphics2D g2d, FontMetrics fn,Color colorText, int positionX, int positionY) {
		int initialTextX = ((getWidth())- fn.stringWidth(messageButton))/2+positionX;
		int initialTextY = ((getHeight()/2 + fn.getHeight()/2))-10+positionY;
		g2d.setColor(colorText);
		g2d.drawString(messageButton, initialTextX, initialTextY);
	}
}
