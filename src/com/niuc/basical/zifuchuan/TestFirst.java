package com.niuc.basical.zifuchuan;

/**
 * 
 * @ClassName:TestFirst
 * @Description:TODO 测试StringBuffer与StringBuilder类的用法，两者均继承抽象�? AbstractStringBuilder
 * @Date:2017�?4�?6�?
 * @author niuc
 *
 */
public class TestFirst {

	public static void main(String[] args) {
		
		//StringBuffer属于线程安全�?
		StringBuffer sBuffer = new StringBuffer("abc,");
		sBuffer.append(" def,");
		System.out.println("sBuffer的�?�是�? " + sBuffer);
		
		//StringBuilder属于线程不安全类
		StringBuilder sBuilder = new StringBuilder();
		
		
	}

}
