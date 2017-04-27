package com.niuc.basical.changyongbao;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @Date:2017Äê4ÔÂ10ÈÕ
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
