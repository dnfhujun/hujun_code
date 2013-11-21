package cn.hujun.future.test;

import cn.hujun.future.Data;
import cn.hujun.future.FutureData;
import cn.hujun.future.RealData;

public class Server {
	final FutureData futureData = new FutureData();
	public Data request(final int count, final char c){
		System.out.println("请求处理开始");
	
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RealData realData = new RealData();
				realData.addObserver(futureData);
				realData.createChar(count, c);
			}
		}).start();
		System.out.println("请求处理结束！");
		return futureData;
	}

}
