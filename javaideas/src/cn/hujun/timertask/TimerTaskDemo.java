package cn.hujun.timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {
	public static void main(String[] args) {
	/*	TimerTask timeTask = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("�ظ�ִ�ж�ʱ������");
			}
		};
		Timer time = new Timer();
		time.schedule(timeTask, new Date(), 2 * 1000);*/
		String string = new String("kfjkldjf");
		String[] stringArray = string.split("_");
		for(int i = 0; i < stringArray.length; i ++)
		{
			System.out.println(stringArray[i]);
		}
	}

}
