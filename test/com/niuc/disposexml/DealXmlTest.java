package com.niuc.disposexml;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.niuc.disposexml.deal.DealXmlFir;
import com.niuc.disposexml.entity.Response;

/**
 * @Description:
 * @class:DealXmlTest.java
 * @Date:2017��5��10��
 * @author niuc
 *
 */

public class DealXmlTest {
	DealXmlFir dealXmlFir = new DealXmlFir();
	Response response = new Response();
	@Before
	public void setUp() throws Exception {
		response.setName("Ӧ������KKK");
		response.setResult(1);
		response.setErrorInfo("������ϢMMM");
		response.setContent("Ӧ������ݣ�һ��Ϊ֤���base64���룡");
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println("--------�������--------");
	}

	
	@Test
	public void testNoHeadXml() throws Exception {
		String wholeXml = dealXmlFir.getWholeXml(response);
		System.out.println("response��������ʽ�ǣ�\n" + wholeXml);
		
		String noHeadXml = dealXmlFir.noHeadXml(response);
		System.out.println("response����ͷ�����ĸ�ʽ�ǣ�\n" + noHeadXml);
		
		Response rep = dealXmlFir.xmlToJava(wholeXml);
		System.out.println("����response�����������ǣ�" + rep.getContent());
	}


	
	
	

}
