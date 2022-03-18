package br.com.hdi.test.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.hdi.test.dev.domain.StatusCorretor;
import reactor.core.publisher.Mono;

@Service
public class ValidationStatusService {
	
	@Autowired
	private WebClient webClientBroker;
	
	@Autowired
	private WebClient webClientBrokerData;
	
	
	public StatusCorretor obterPorCodigoParalelo(StatusCorretor statusCorretor) {

		Mono<StatusCorretor> monoBroker = this.webClientBroker
			.method(HttpMethod.GET)
			.uri("/broker", statusCorretor)
			.retrieve()
			.bodyToMono(StatusCorretor.class);
	
		Mono<StatusCorretor> monoBrokerData = this.webClientBrokerData
				.method(HttpMethod.GET)
				.uri("/brokerData", statusCorretor)
				.retrieve()
				.bodyToMono(StatusCorretor.class);

		StatusCorretor status = Mono.zip(monoBroker, monoBrokerData).map(tuple -> {
			tuple.getT1().setName(tuple.getT2().getName());
			tuple.getT1().setActive(tuple.getT2().getActive());
			tuple.getT1().setCode(tuple.getT2().getCode());
			return tuple.getT1();
		}).block();

		return status;
	}
}
