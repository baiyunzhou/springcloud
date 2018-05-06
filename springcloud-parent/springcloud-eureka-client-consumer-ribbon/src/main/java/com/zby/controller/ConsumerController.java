package com.zby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path = "/ribbon-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}

	public static void main(String[] args) {
		// 模拟HTTP GET请求
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:520/ribbon-consumer",
				String.class);
		System.out.println(responseEntity);
	}
}
