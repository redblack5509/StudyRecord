package com.niuc.basical.changyongbao;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @Date:2017��4��10��
 * @author niuc
 *
 */
public class TimerTest {
	
	private Timer timer = null;
	
	public void startTimer() throws Exception {
		timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				
				
			}
			
		}, 1000);
	}
	
	public static void main(String[] args) {
		

	}
	

}
