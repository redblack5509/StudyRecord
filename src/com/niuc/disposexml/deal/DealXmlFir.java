package com.niuc.disposexml.deal;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.niuc.disposexml.entity.Response;


/**
 * @Description:����xml
 * 				���������У�Java����==��xml��ʽ����/��ͷ�����ĸ�ʽ��
 * 						xml��ʽ��==��java����
 * @class:NoHeadXml.java
 * @Date:2017��5��10��
 * @author niuc
 *
 */
public class DealXmlFir {
	public String noHeadXml(Response rep) throws Exception {
		StringWriter sw = new StringWriter();
		JAXBContext jContext = JAXBContext.newInstance(Response.class);
		Marshaller marshaller = jContext.createMarshaller();
		/**
		 * ����Marshaller�����ԣ�����ʹJava����ת��Ϊxmlʱ��û��xml��ͷ������
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
