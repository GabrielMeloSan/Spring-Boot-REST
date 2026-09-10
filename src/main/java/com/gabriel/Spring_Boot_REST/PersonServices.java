package com.gabriel.Spring_Boot_REST;

import com.gabriel.Spring_Boot_REST.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> people = new ArrayList<Person>();
        for(int i = 0; i<8; i++){
            Person person = MockPerson(i);
            people.add(person);
        }

        return people;
    }

    public Person findById(String id){
        logger.info("Finding one person");

        Person person = new Person();

        //substituir depois por chamadas no mysql
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gabriel");
        person.setLastName("Gabriel");
        person.setAddress("rua 1");
        person.setGender("Masculino");

        return person;
    }

    private Person MockPerson(int i){
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + Integer.toString(i));
        person.setLastName("lastname " + Integer.toString(i));
        person.setAddress("rua 1 " + Integer.toString(i));
        person.setGender("Masculino");
        return person;
    }
}
