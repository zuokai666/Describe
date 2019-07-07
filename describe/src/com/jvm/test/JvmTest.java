package com.jvm.test;

@SuppressWarnings("unused")
public class JvmTest {
	
	static int _512kb = 512 * 1024;
	static int _1m = _512kb * 2;
	
	
	public static void main(String[] args) {
		{
			byte[] a = new byte[_1m];
			byte[] b = new byte[_1m];
			byte[] c = new byte[_1m];
			a = null;
			b = null;
			c = null;
		}
		{
			byte[] a = new byte[_1m];
			byte[] b = new byte[_1m];
			byte[] c = new byte[_1m];
			a = null;
			b = null;
			c = null;
		}
		{
			byte[] c = new byte[6 * _1m];
		}
	}
	
	private static void printMemoryParam() {
		System.out.println("系统最大使用空间：Xmx=" + 
	Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
		System.out.println("系统可用空间：free mem=" + 
	Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
		System.out.println("系统中分配到的空间：total mem=" + 
	Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
	}
}