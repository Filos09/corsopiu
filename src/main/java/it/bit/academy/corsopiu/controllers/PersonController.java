package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.PersonDto;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {

    private SchedulerService schedulerService;

    @Autowired
    public PersonController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/")
    public ResponseEntity<PersonDto> findPersonByEmail(String email){
        Optional<Person> opt = schedulerService.getPersonByEmail(email);
        if(opt.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new PersonDto(opt.get()), HttpStatus.OK);
    }
}
