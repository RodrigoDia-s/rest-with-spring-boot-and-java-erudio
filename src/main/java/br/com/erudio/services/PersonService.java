package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.mapper.Mapper;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public PersonVO findById(Long id) {
        logger.info("Finding new person");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return Mapper.parseObject(entity, PersonVO.class) ;
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all people");

        return Mapper.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO createPerson(PersonVO person) {
        logger.info("Creating a person");
        var entity = Mapper.parseObject(person, br.com.erudio.model.Person.class);
        return Mapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating a person");
        var entity = personRepository.findById(person.getId()).orElseThrow(()
                -> new ResourceNotFoundException("No records found for this ID"));

        entity.setLastName(person.getLastName());
        entity.setFirstName(person.getFirstName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var entity2 = Mapper.parseObject(person, br.com.erudio.model.Person.class);
        return Mapper.parseObject(personRepository.save(entity2), PersonVO.class);
    }


    public void deletePerson(Long id) {
        var entity = personRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }
}
