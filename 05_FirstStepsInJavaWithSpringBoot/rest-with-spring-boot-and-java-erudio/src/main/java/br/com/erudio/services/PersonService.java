package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.entitie.Person;

@Service // classe sera injetada em run time em outras classes (injecao de dependencias evitando usar o new)
public class PersonService {

	public final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(String id) {

		// retornando um mock (mock e uma estrutura temporaria , semelhante a estrutura
		// que colocamos na obra ate o cimento secar), que serve como teste
		// para nosso projeto enquanto o restante da estrutura segue em andamento -
		// existe mocks permanetes nos testes unitarios

		logger.info("Finding one person!");

		Person person = new Person();

		// simulando info das pessoas (mock simula qualquer id passado na url)
		person.setId(counter.incrementAndGet());
		person.setFirstName("Pedro");
		person.setLastName("Silva");
		person.setGender("Man");
		person.setAddress("Teresopolis");
		
		return person;

	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		return person;
	}
	
	//retornando uma lista de objetos
	public List<Person> findAll(){
		
		logger.info("Finding all people!");
		
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i ++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting one person with success!");
		
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();

		// simulando info das pessoas (mock simula qualquer id passado na url)
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name = " + i);
		person.setLastName("Last name" + i);
		person.setGender("Male");
		person.setAddress("Some address in Brasil " + i);
		
		logger.info("Valor id: " + person.getId());
		logger.info("Valores: " + person.getFirstName());
		logger.info("Valores: " + person.getLastName());
		return person;
	}

	

}
