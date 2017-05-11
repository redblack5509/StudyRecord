package com.niuc.util;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.niuc.disposexml.entity.Response;

/**
 * @Description:
 * @class:XMLDealUtilTest.java
 * @Date:2017年5月11日
 * @author niuc
 *
 */
public class XMLDealUtilTest {
	Response response = new Response();
	XMLDealUtil xDealUtil = null;
	String xmlFir = null;
	String XmlSec = null;
	String xmlThr = null;
	@Before
	public void setUp() throws Exception {
		xDealUtil = new XMLDealUtil(new Class[] {Response.class});
		response.setName("应答名字KKK");
		response.setResult(1);
		response.setErrorInfo("错误消息MMM");
		response.setContent("应答的内容，一般为证书的base64编码！");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------测试结束-------");
	}


	@Test
	public void testJavaToXml() throws JAXBException {
		xmlFir = xDealUtil.javaToXml(response);
		System.out.println("javaToXml的内容：\n" + xmlFir);
		XmlSec = xDealUtil.javaToXmlNoHead(response);
		System.out.println("javaToXmlNoHead的内容：\n" + XmlSec);
		Response rep1 = xDealUtil.xmlToJava(xmlFir);
		System.out.println("使用有头声明的格式,解析应答的内容是：" + rep1.getContent());
		Response rep2 = xDealUtil.xmlToJava(XmlSec);
		System.out.println("使用无头声明的格式,解析应答的内容是：" + rep2.getContent());
		
		xmlThr = xDealUtil.javaToXmlNoHeadNoFormat(response);
		System.out.println("javaToXmlNoHeadNoFormat的内容：\n" + xmlThr);
		if(xmlFir.equals(xmlThr)) {
			System.out.println("格式化前后，调用equals()方法，比较相同");
		} else {
			System.out.println("格式化前后，调用equals()方法，比较 不 相同");
		}
		System.out.println("=========================================================");
	}

	@Test
	public void testJavaToXmlNoHead() throws JAXBException  {
//		XmlSec = xDealUtil.javaToXmlNoHead(response);
//		System.out.println("=========================================================");
	}

	@Test
	public void testXmlToJava() throws JAXBException  {
//		Response rep1 = xDealUtil.xmlToJava(xmlFir);
//		System.out.println("使用有头声明的格式,解析应答的内容是：" + rep1.getContent());
//		Response rep2 = xDealUtil.xmlToJava(XmlSec);
//		System.out.println("使用无头声明的格式,解析应答的内容是：" + rep2.getContent());
//		
//		xmlThr = xDealUtil.javaToXmlNoHeadNoFormat(response);
//		if(xmlFir.equals(xmlThr)) {
//			System.out.println("格式化前后，调用equals()方法，比较相同");
//		} else {
//			System.out.println("格式化前后，调用equals()方法，比较 不 相同");
//		}
		
		
	}

}
