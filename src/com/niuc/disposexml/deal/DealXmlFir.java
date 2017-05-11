package com.niuc.disposexml.deal;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.niuc.disposexml.entity.Response;


/**
 * @Description:解析xml
 * 				具体内容有：Java对象《==》xml格式（有/无头声明的格式）
 * 						xml格式《==》java对象
 * @class:NoHeadXml.java
 * @Date:2017年5月10日
 * @author niuc
 *
 */
public class DealXmlFir {
	public String noHeadXml(Response rep) throws Exception {
		StringWriter sw = new StringWriter();
		JAXBContext jContext = JAXBContext.newInstance(Response.class);
		Marshaller marshaller = jContext.createMarshaller();
		/**
		 * 设置Marshaller的属性，可以使Java对象转化为xml时，没有xml的头部声明
		 */
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		marshaller.marshal(rep, sw);
		return sw.toString();
	}
	
	public String getWholeXml(Response rep) throws Exception{
		StringWriter sw = new StringWriter();
		JAXBContext jContext = JAXBContext.newInstance(Response.class);
		Marshaller marshaller = jContext.createMarshaller();
		marshaller.marshal(rep, sw);
		return sw.toString();
	}
	
	public Response xmlToJava(String xmlStr) throws Exception {
		StringReader reader = new StringReader(xmlStr);
		 JAXBContext context = JAXBContext.newInstance(Response.class);  
		 Unmarshaller unmarshaller = context.createUnmarshaller();
		 Response response = (Response)unmarshaller.unmarshal(reader);
		return response;
	}
}
