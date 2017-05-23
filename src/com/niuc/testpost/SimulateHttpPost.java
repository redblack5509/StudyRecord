package com.niuc.testpost;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @Description:模拟http请求
 * @class:SimulateHttpPost.java
 * @Date:2017年5月11日
 * @author niuc
 *
 */
public class SimulateHttpPost {
	public void simpleHttpPost(String url){
		//创建默认的HttpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建httpPost
		HttpPost httpPost = new HttpPost(url);
		//创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("username", "admin"));
		formparams.add(new BasicNameValuePair("password", "123"));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			uefEntity.setContentEncoding("UTF-8");
			uefEntity.setContentType("application/xml");
			httpPost.setEntity(uefEntity);
			System.out.println("executing request " + httpPost.getURI());
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					 System.out.println("--------------------------------------");  
	                 System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
	                 System.out.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} 
	
	public static void main(String[] args) {
		String url = "";
		SimulateHttpPost test = new SimulateHttpPost();
		test.simpleHttpPost(url);
	}
	
	
}
