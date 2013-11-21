package cn.hujun.future.test;

import cn.hujun.future.Data;

public class Client {
	
	/**
	 * 因为是多线程的关系，所以，当执行了request这个方法后，
	 * 就立马执行了data.getContent方法，但由于对其进行加锁，导致其一直在等待，
	 * 当数据创建完成后，通知观察者，第一个线程进来后，创建了RealData对象（注意这时候realData已经不为空）
	 * 然后执行了notifyAll（）方法（这是关键），它唤醒了所有线程，包括第二个线程，第二个线程data1.getContent()
	 * 对其进行while(!isFinished())判断，发现realData不为空，就直接把realData返回了。所以，两次得到的数据都是
	 * 一样的。
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		Data data = server.request(10, 'a');
		Data data1 = server.request(20, 'c');
		System.out.println("字符串为：" + data.getContent());
		System.out.println("字符串为：" + data1.getContent());
	}


}
