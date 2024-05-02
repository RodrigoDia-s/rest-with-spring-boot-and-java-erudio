package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id) {
        logger.info("Finding new person");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people");

        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        logger.info("Creating a person");
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating a person");
        var entity = personRepository.findById(person.getId()).orElseThrow(()
                -> new ResourceNotFoundException("No records found for this ID"));

        entity.setLastName(person.getLastName());
        entity.setFirtName(person.getFirtName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }


    public void deletePerson(Long id) {
        var entity = personRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }
}
