package br.com.hdi.test.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusCorretor {
	
	private String name;
	private String active;
	private String code;

}
