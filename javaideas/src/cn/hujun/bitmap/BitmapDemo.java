package cn.hujun.bitmap;

import java.util.Scanner;

public class BitmapDemo {
	private final static int BITSPERWORD = 32;
	private final static int SHIFT = 5;
	private final static int MASK = 0x1f;
	private final static int N = 10000000;
	static int[] a = new int[1 + N/BITSPERWORD];
	public static void main(String[] args) {
		int i;
		for(i = 0; i < N; i++){
			clr(i);
		}
		System.out.println("please enter the number below:");
		Scanner scanner = new Scanner(System.in);
		int j = scanner.nextInt();
		while(j != 0) {
			set(j);
			j = scanner.nextInt();
		}
		for(i = 0; i < N; i++) {
				if(test(i) != 0)
					System.out.println(i);
		}
		
	}

	public static void set(int i) {
		a[i>>SHIFT] |= (1<<(i & MASK));
	}
	
	public static void clr(int i) {
		a[i>>SHIFT] &= ~(1<<(i & MASK));
	}
	
	public static int test(int i){
		return a[i>>SHIFT] & (i<<(i & MASK));
	}
	

}
