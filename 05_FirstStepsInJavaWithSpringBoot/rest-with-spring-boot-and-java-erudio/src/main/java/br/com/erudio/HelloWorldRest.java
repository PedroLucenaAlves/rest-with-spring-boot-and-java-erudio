package br.com.erudio;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe teste para testar nosso endpoint Rest
 */

@Getter
public class HelloWorldRest {
	
	private final Long id;
	private final String content;
	
	
	public HelloWorldRest(Long id, String content) {
		this.id = id;
		this.content = content;
	}


	public Long getId() {
		return id;
	}


	public String getContent() {
		return content;
	}
	
	

}
