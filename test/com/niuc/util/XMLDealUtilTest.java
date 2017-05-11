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
 * @Date:2017��5��11��
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
		response.setName("Ӧ������KKK");
		response.setResult(1);
		response.setErrorInfo("������ϢMMM");
		response.setContent("Ӧ������ݣ�һ��Ϊ֤���base64���룡");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------���Խ���-------");
	}


	@Test
	public void testJavaToXml() throws JAXBException {
		xmlFir = xDealUtil.javaToXml(response);
		System.out.println("javaToXml�����ݣ�\n" + xmlFir);
		XmlSec = xDealUtil.javaToXmlNoHead(response);
		System.out.println("javaToXmlNoHead�����ݣ�\n" + XmlSec);
		Response rep1 = xDealUtil.xmlToJava(xmlFir);
		System.out.println("ʹ����ͷ�����ĸ�ʽ,����Ӧ��������ǣ�" + rep1.getContent());
		Response rep2 = xDealUtil.xmlToJava(XmlSec);
		System.out.println("ʹ����ͷ�����ĸ�ʽ,����Ӧ��������ǣ�" + rep2.getContent());
		
		xmlThr = xDealUtil.javaToXmlNoHeadNoFormat(response);
		System.out.println("javaToXmlNoHeadNoFormat�����ݣ�\n" + xmlThr);
		if(xmlFir.equals(xmlThr)) {
			System.out.println("��ʽ��ǰ�󣬵���equals()�������Ƚ���ͬ");
		} else {
			System.out.println("��ʽ��ǰ�󣬵���equals()�������Ƚ� �� ��ͬ");
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
//		System.out.println("ʹ����ͷ�����ĸ�ʽ,����Ӧ��������ǣ�" + rep1.getContent());
//		Response rep2 = xDealUtil.xmlToJava(XmlSec);
//		System.out.println("ʹ����ͷ�����ĸ�ʽ,����Ӧ��������ǣ�" + rep2.getContent());
//		
//		xmlThr = xDealUtil.javaToXmlNoHeadNoFormat(response);
//		if(xmlFir.equals(xmlThr)) {
//			System.out.println("��ʽ��ǰ�󣬵���equals()�������Ƚ���ͬ");
//		} else {
//			System.out.println("��ʽ��ǰ�󣬵���equals()�������Ƚ� �� ��ͬ");
//		}
		
		
	}

}
