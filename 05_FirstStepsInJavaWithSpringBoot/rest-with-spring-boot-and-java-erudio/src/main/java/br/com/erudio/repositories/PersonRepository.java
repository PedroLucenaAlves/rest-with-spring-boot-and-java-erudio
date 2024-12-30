package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.entitie.Person;

@Repository                       //extender de jparepository nos permite executar um crud
public interface PersonRepository extends JpaRepository<Person, Long> {}
