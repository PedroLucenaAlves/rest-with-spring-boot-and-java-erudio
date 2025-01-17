package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.entitie.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
