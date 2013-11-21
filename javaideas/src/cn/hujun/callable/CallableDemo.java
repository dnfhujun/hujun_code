/**
 * 
 */
package cn.hujun.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 *
 */
public class CallableDemo implements Callable<Integer>{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CallableDemo demo = new CallableDemo();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(demo);//使用future来包装callable
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "___________" + i);
			if(i == 10) {
				new Thread(futureTask,"有返回值的现成").start();
			}
		}
		try {
			System.out.println("返回值为：" + futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i ;
		for (i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "i = " + i);
		}
		return i;
	}

}
