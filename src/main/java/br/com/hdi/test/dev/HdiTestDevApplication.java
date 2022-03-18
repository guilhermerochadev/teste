package br.com.hdi.test.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class HdiTestDevApplication {
	
	@Bean
	public WebClient webClientBroker(WebClient.Builder builder) {
		return builder
			.baseUrl("https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/broker")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();
	}
	
	@Bean
	public WebClient webClientBrokerData(WebClient.Builder builder) {
		return builder
			.baseUrl("https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HdiTestDevApplication.class, args);
	}

}
