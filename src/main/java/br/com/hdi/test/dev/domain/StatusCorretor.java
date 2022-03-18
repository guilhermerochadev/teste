package br.com.hdi.test.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusCorretor {
	
	private String name;
	private String active;
	private Long code;
	private Long document;

}
