package cn.hujun.future;

import java.util.Observable;

public class RealData extends Observable implements Data {

	private String content;
	
	public void createChar(int count, char c) {
		System.out.println("开始创建字符串：");
		char[] buffer = new char[count];
		for(int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.content = new String(buffer);
		System.out.println("创建字符串结束，内容为：" + this.content);
		this.setChanged();
		this.notifyObservers("Finished");
	}
	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
