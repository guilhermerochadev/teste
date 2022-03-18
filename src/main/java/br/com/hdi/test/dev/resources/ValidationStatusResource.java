package br.com.hdi.test.dev.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.hdi.test.dev.domain.StatusCorretor;
import br.com.hdi.test.dev.service.ValidationStatusService;

@RestController
public class ValidationStatusResource {
	
	@Autowired
	private ValidationStatusService validationStatusService;
	
	
	@GetMapping("/broker{documentCode}/brokerData")
	public ResponseEntity<StatusCorretor> statusCorretor(@PathVariable Long documentCode) {
		
		StatusCorretor status = this.validationStatusService.obterStatus(documentCode);

		return ResponseEntity.ok(status);
	}

}
