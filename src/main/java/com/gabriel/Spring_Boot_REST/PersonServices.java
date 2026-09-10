package com.gabriel.Spring_Boot_REST;

import com.gabriel.Spring_Boot_REST.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

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
}
