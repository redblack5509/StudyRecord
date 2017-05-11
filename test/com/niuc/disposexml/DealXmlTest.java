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
 * @Date:2017年5月10日
 * @author niuc
 *
 */

public class DealXmlTest {
	DealXmlFir dealXmlFir = new DealXmlFir();
	Response response = new Response();
	@Before
	public void setUp() throws Exception {
		response.setName("应答名字KKK");
		response.setResult(1);
		response.setErrorInfo("错误消息MMM");
		response.setContent("应答的内容，一般为证书的base64编码！");
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println("--------测试完毕--------");
	}

	
	@Test
	public void testNoHeadXml() throws Exception {
		String wholeXml = dealXmlFir.getWholeXml(response);
		System.out.println("response的完整格式是：\n" + wholeXml);
		
		String noHeadXml = dealXmlFir.noHeadXml(response);
		System.out.println("response的无头声明的格式是：\n" + noHeadXml);
		
		Response rep = dealXmlFir.xmlToJava(wholeXml);
		System.out.println("解析response对象，其内容是：" + rep.getContent());
	}


	
	
	

}
