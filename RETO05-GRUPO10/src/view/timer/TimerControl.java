package view.timer;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerControl {
	private Timer timerButtons;
	private int timeDefualt;
	
	public TimerControl(ActionListener listener) {
		timeDefualt = 10;
		timerButtons = new Timer(timeDefualt, listener);
	}
	
	public TimerControl() {
		// TODO Auto-generated constructor stub
	}
	
	public void initsTimerButton(ActionListener listener, int time) {
		timerButtons = new Timer(time, listener);
	}
	
	public void startTimerButton() {
		if (timerButtons != null) {
			timerButtons.start();
		}
	}
	
	public void removeTimerButtonAction(ActionListener listener) {
		timerButtons.removeActionListener(listener);
	}
	
	public void addTimerButtonAction(ActionListener listener) {
		timerButtons.addActionListener(listener);
	}
	
	public void setTimerButtonDelay(int time) {
		timerButtons.setDelay(time);
	}
}
