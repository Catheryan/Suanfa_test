package com.demo.httpget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientPost {

	public static void main(String[] args) {
			new post2().start();
	}
}
	class post2 extends Thread{
		//?keyfrom=testjavads&key=1926183613&type=data&doctype=xml&version=1.1&q=潘明晖
		HttpClient httpClient =HttpClients.createDefault();
		@Override
		public void run() {
			
			HttpPost post =new HttpPost("http://fanyi.youdao.com/openapi.do");
			try {
				List<BasicNameValuePair> paramsList=new ArrayList<BasicNameValuePair>();
				paramsList.add(new BasicNameValuePair("keyfrom", "testjavads"));
				paramsList.add(new BasicNameValuePair("key", "1926183613"));
				paramsList.add(new BasicNameValuePair("type", "data"));
				paramsList.add(new BasicNameValuePair("doctype", "json"));
				paramsList.add(new BasicNameValuePair("version", "1.1"));
				paramsList.add(new BasicNameValuePair("q", "潘明晖"));
				
				post.setEntity(new UrlEncodedFormEntity(paramsList,"utf-8"));
				HttpResponse response=	httpClient.execute(post);
				HttpEntity entity=response.getEntity();
				String result=EntityUtils.toString(entity, "utf-8");
				System.out.println(result);
				
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
}
