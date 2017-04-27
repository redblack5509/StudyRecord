package com.niuc.basical.meiju;

import java.util.EnumSet;

import javax.sound.midi.VoiceStatus;

/**
 * @Description:使用枚举类型表示交�?�信号灯
 * @class:Light.java
 * @Date:2017�?4�?26�?
 * @author niuc
 *
 */
public enum Light {
	RED("redLight"),
	YELLOW("yellowLight"),
	GREEN("greenLight");
	
	private String describe;
	
	private Light(String _describe) {
		this.describe = _describe;
	}
	
	public String toString() {
		return String.valueOf(this.describe);
	}
	
	
	public static void main(String[] args) {
		traversalLights();
		traversalForEnumSet();
	}
	
	
	
	
	
	public static void traversalLights () {
		System.out.println("------使用enum的values()方法进行遍历-----");
		Light[] lights = Light.values();
		for (Light light : lights) {
			System.out.println("枚举类型Light中当�? 灯的名字�? [ " + light.name() + "],当前灯的描述�? [" + light.toString() +"]");
		}
	}
	
	/**
	 * 演示 EnumSet 如何使用�? EnumSet 是一个抽象类，获取一个类型的枚举类型内容
	 * 可以使用 allOf 方法
	 */
	public static void traversalForEnumSet() {
		System.out.println("-----使用EnumSet抽象类的allOf()方法遍历枚举类型------------");
		EnumSet<Light> eSet = EnumSet.allOf(Light.class);
		for (Light eSetLight : eSet) {
			System.out.println("Light中当前灯的名字是[" + eSetLight.name() + "],当前灯的描述是[" + eSetLight + "]");
		}
	} 
}
