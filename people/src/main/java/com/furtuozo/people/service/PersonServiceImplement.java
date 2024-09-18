package com.furtuozo.people.service;

import com.furtuozo.people.dto.request.PersonRequestDTO;
import com.furtuozo.people.dto.response.PersonResponseDTO;
import com.furtuozo.people.entity.Person;
import com.furtuozo.people.repository.PersonRepository;
import com.furtuozo.people.util.PersonMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Primary

public class PersonServiceImplement implements PersonService {

    private final PersonRepository personRepository;

    private PersonMapper personMapper = null;

    public PersonServiceImplement(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }


    @Override
    public PersonResponseDTO findById(Long id) {
        Person person = returnPerson(id);

        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {

        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id ,PersonRequestDTO personDTO) {
        Person person = returnPerson(id);

        personMapper.updatePersonDate(person, personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {

        personRepository.deleteById(id);

        return "Person Id: " + id + " deleted";

    }

    private Person returnPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));

    }
}
