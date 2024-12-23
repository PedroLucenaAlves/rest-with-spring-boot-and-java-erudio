package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController combina diversas annotations diferente da annotation
 * Controller
 */

@RestController
@RequestMapping("/teste") //mapeia uma requisicao para um metodo tornando em um endereco http
public class HelloWordRestController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping
	public HelloWorldRest helloRest(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new HelloWorldRest(counter.incrementAndGet(), String.format(template, name));

	}

}
