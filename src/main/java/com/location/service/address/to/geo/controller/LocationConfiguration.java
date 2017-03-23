package com.location.service.address.to.geo.controller;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LocationConfiguration {

	@Bean
	public CloseableHttpClient closeableHttpClient()
			throws KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException {
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
				new SSLContextBuilder().loadTrustMaterial(null,
						new TrustSelfSignedStrategy()).build());

		return HttpClients.custom().setSSLSocketFactory(socketFactory).build();

	}
	
	
	@Bean 
	public RestTemplate restTemplate(CloseableHttpClient closeableHttpClient) {
		RestTemplate restTemplate =  new RestTemplate();
	   ((HttpComponentsClientHttpRequestFactory)restTemplate.getRequestFactory()).setHttpClient(closeableHttpClient);
	   return restTemplate;
	}
}
