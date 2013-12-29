package com.dogecoin.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class DogeCoinD {

    public static String callRPC(String username, String password, JSONObject jsonData) throws Exception {
        String scheme = "http";
        String host = "localhost";
        String port = "22555";
        return callRPC(scheme, host, port, username, password, jsonData);
    }
    
    public static String callRPC(String scheme, String host, String port,
            String username, String password, JSONObject jsonData) throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(host, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(username, password));

        HttpPost httppost = new HttpPost(
                String.format("%s://%s:%s", scheme, host, port));
        StringEntity se = new StringEntity(jsonData.toString());  
        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httppost.setEntity(se);
        
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
	    StringBuilder out = new StringBuilder();
        try {
        	CloseableHttpResponse resp = httpclient.execute(httppost);
        	HttpEntity httpEntity = resp.getEntity();
        	if (httpEntity != null) {
        		InputStream in = httpEntity.getContent();
        		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        	    String newLine = System.getProperty("line.separator");
        	    String line;
        	    while ((line = reader.readLine()) != null) {
        	        out.append(line);
        	        out.append(newLine);
        	    }
        	}
        } finally {
            httpclient.close();
        }
        return out.toString();
    }
}
