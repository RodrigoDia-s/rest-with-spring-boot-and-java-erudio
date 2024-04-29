package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
    logger.info("Finding new person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirtName("Rodrigo");
        person.setLastName("Dias");
        person.setGender("Trans-não binarie");
        person.setAddress("Casa da mãe joana");
        return person;
    }

    public List<Person> findAll(){
        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person createPerson(Person person) {
        logger.info("Creating a person");
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating a person");
        return person;
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirtName("" + i);
        person.setLastName("" + i);
        person.setGender("" + i);
        person.setAddress(i%2 ==0 ? "Male" : "Female" );
        return person;
    }
}
