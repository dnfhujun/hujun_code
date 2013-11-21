package cn.hujun.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo01 {

	public static void main(String[] args){
		
		FutureTask<Object> tt = new FutureTask<Object>(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

}
