package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

import static br.com.erudio.util.MediaType.APPLICATION_JSON;
import static br.com.erudio.util.MediaType.APPLICATION_XML;
import static br.com.erudio.util.MediaType.MEDIA_TYPE_YML;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML})
    public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
        return personService.findById(id);
    }

    @GetMapping(value = "/findAll", produces = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML})
    public List<PersonVO> findAll() throws Exception {
        return personService.findAll();
    }

    @PostMapping(value = "/create", produces = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML}, consumes = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML})
    public PersonVO create(@RequestBody PersonVO person) {
        return personService.createPerson(person);
    }

    @PostMapping(value = "/create/v2", produces = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML}, consumes = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return personService.createPersonV2(person);
    }


    @PutMapping(value = "/update", produces = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML}, consumes = {APPLICATION_JSON, APPLICATION_XML, MEDIA_TYPE_YML})
    public PersonVO update(@RequestBody PersonVO person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
