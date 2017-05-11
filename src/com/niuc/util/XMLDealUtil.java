package com.niuc.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.niuc.disposexml.entity.Response;


/**
 * @Description: XML的处理工具
 * @class:XMLDealUtil.java
 * @Date:2017年5月11日
 * @author niuc
 *
 */
public class XMLDealUtil {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public XMLDealUtil(Class<?>[] types) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(types);//创建JAXBContext的一个实例
			this.marshaller = jaxbContext.createMarshaller();//得到 Marshaller 的一个实例
			//this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//输出的xml串是否进行格式化
			//this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//是否XML头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>） 
			this.marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//输出的xml的编码格式（会在头声明中进行显示）
			//this.marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");//是否添加SCHEMA命名空间,必须是字符串
			//this.marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");//是否添加SCHEMA_LOCATION,必须是字符串
			
			this.unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public String javaToXml(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//输出完整的XML格式
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		this.marshaller.marshal(root, writer);
		return writer.toString();
	} 
	
	
	public String javaToXmlNoHead(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//输出完整的XML格式
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		this.marshaller.marshal(root, writer);
		return writer.toString();
	}
	
	public String javaToXmlNoHeadNoFormat(Object root) throws JAXBException {
		StringWriter writer = new StringWriter();
		this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//输出完整的XML格式
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
