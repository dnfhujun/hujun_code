package cn.hujun.future.test;

import cn.hujun.future.Data;

public class Client {
	
	/**
	 * ��Ϊ�Ƕ��̵߳Ĺ�ϵ�����ԣ���ִ����request���������
	 * ������ִ����data.getContent�����������ڶ�����м�����������һֱ�ڵȴ���
	 * �����ݴ�����ɺ�֪ͨ�۲��ߣ���һ���߳̽����󣬴�����RealData����ע����ʱ��realData�Ѿ���Ϊ�գ�
	 * Ȼ��ִ����notifyAll�������������ǹؼ������������������̣߳������ڶ����̣߳��ڶ����߳�data1.getContent()
	 * �������while(!isFinished())�жϣ�����realData��Ϊ�գ���ֱ�Ӱ�realData�����ˡ����ԣ����εõ������ݶ���
	 * һ���ġ�
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		Data data = server.request(10, 'a');
		Data data1 = server.request(20, 'c');
		System.out.println("�ַ���Ϊ��" + data.getContent());
		System.out.println("�ַ���Ϊ��" + data1.getContent());
	}


}
