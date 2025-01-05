package br.com.erudio.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.entitie.Person;

public class MockPerson {


	//criando mocks de entidade
    public Person mockEntity() {
        return mockEntity(0);
    }
    
    //mocks de vo
    public PersonVO mockVO() {
        return mockVO(0);
    }
    
    
    //mockando lista de entidades
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    //mockando lista de vos
    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    //verificando se os dados de conversao de entidade para vo permanecem os mesmos
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
