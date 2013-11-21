package cn.hujun.future;

import java.util.Observable;
import java.util.Observer;

public class FutureData implements Data, Observer {

	private volatile RealData realData = null;
	
 
	int i=0;
	private boolean isFinished() {
		return realData != null;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
//		System.out.println("事件：" + arg1);
//		if(!(arg0 instanceof RealData)) {
//			System.out.println("error");
//		}
//		if(!(arg1 instanceof String)) {
//			System.out.println("error");
//		}
		synchronized (this) {
//			if(isFinished()){
//				System.out.println("1111111");
//			//	this.notifyAll();
//				i++;
//				return;
//			}
			System.out.println("GGGG:"+arg1);
			if("Finished".equals(arg1)){
				realData = (RealData)arg0;
				this.notifyAll();
			}
		}
	}

	@Override
	public String getContent() {
		
		synchronized (this) {
			System.out.println("hello world");
			while(!isFinished()){ //这个判断太牛逼了！
				try {
					System.out.println("aaa0" + Thread.currentThread().getName());
					this.wait();
					System.out.println("aaa" + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return realData.getContent();
		}
	}

}
