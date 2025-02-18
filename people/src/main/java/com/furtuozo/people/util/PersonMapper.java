package com.furtuozo.people.util;

import com.furtuozo.people.dto.request.PersonRequestDTO;
import com.furtuozo.people.dto.response.PersonResponseDTO;
import com.furtuozo.people.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO) {

        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();

    }

    public PersonResponseDTO toPersonDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> peoplelist) {
        return peoplelist.stream().map(PersonResponseDTO:: new).collect(Collectors.toList());
    }

    public void updatePersonDate (Person person , PersonRequestDTO personDTO){

        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());

    }

}
