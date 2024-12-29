package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.entitie.Person;
import br.com.erudio.services.PersonService;

/**
 * RestController que soma dois números Controller
 */

@RestController
@RequestMapping("/person") // mapeia uma requisicao para um metodo tornando em um endereco http
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception { // PathVariable = avisando que o id da url e o mesmo do parametro
		return personService.findById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(String id) {
		return personService.findAll();
	}

}
