package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.entitie.Person;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;

/**
 * Servico encapsula a logica de negocios
 */

@Service // classe sera injetada em run time em outras classes (injecao de dependencias evitando usar o new)
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository personRepository;

	// retornando uma lista de objetos
	public List<Person> findAll() {

		logger.info("Finding all people!");

		return personRepository.findAll();
	}

	public Person findById(Long id) {

		// retornando um mock (mock e uma estrutura temporaria , semelhante a estrutura
		// que colocamos na obra ate o cimento secar), que serve como teste
		// para nosso projeto enquanto o restante da estrutura segue em andamento -
		// existe mocks permanetes nos testes unitarios

		logger.info("Finding one person!");

		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));

	}

	public Person create(Person person) {

		logger.info("Creating one person!");

		return personRepository.save(person);
	}

	public Person update(Person person) {

		// na logica , recebemos uma person nova alterando um valor (exp: sobre nome),
		// nao podemos apenas salvar no banco se nao estariamos gravando novamente essa pessoa no banco

		logger.info("Updating one person!");

		// Aqui recuperamos essa person por id e jogamos na var entity
		var entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !")); //usamos lambda chamando nossa exception

		// setando os valores em entity que vieram nos dados passados para person na requisicao
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return personRepository.save(entity);
	}

	public void delete(Long id) {

		logger.info("Deleting one person with success!");

		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));

		personRepository.delete(entity);

	}

}
