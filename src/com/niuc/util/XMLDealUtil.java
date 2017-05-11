package com.niuc.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.niuc.disposexml.entity.Response;


/**
 * @Description: XML�Ĵ�����
 * @class:XMLDealUtil.java
 * @Date:2017��5��11��
 * @author niuc
 *
 */
public class XMLDealUtil {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public XMLDealUtil(Class<?>[] types) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(types);//����JAXBContext��һ��ʵ��
			this.marshaller = jaxbContext.createMarshaller();//�õ� Marshaller ��һ��ʵ��
			//this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//�����xml���Ƿ���и�ʽ��
			//this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//�Ƿ�XMLͷ��Ϣ��<?xml version="1.0" encoding="gb2312" standalone="yes"?>�� 
			this.marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//�����xml�ı����ʽ������ͷ�����н�����ʾ��
			//this.marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");//�Ƿ����SCHEMA�����ռ�,�������ַ���
			//this.marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");//�Ƿ����SCHEMA_LOCATION,�������ַ���
			
			this.unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public String javaToXml(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//���������XML��ʽ
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		this.marshaller.marshal(root, writer);
		return writer.toString();
	} 
	
	
	public String javaToXmlNoHead(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//���������XML��ʽ
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		this.marshaller.marshal(root, writer);
		return writer.toString();
	}
	
	public String javaToXmlNoHeadNoFormat(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//���������XML��ʽ
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		this.marshaller.marshal(root, writer);
		return writer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T xmlToJava(String xml) throws JAXBException {
		StringReader reader = new StringReader(xml);
		return (T)this.unmarshaller.unmarshal(reader);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
