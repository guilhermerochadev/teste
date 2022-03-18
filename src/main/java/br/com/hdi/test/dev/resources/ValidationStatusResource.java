package br.com.hdi.test.dev.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hdi.test.dev.domain.StatusCorretor;
import br.com.hdi.test.dev.service.ValidationStatusService;

@RestController
@RequestMapping(value = "/teste") 
public class ValidationStatusResource {
	
	@Autowired
	private ValidationStatusService validationStatusService;
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<StatusCorretor> obterStatusCorretor(@PathVariable Long codigo) {
		
		StatusCorretor status = this.validationStatusService.obterStatus(codigo);

		return ResponseEntity.ok(status);
	}

}
