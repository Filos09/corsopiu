package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.PersonDto;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.models.StudentSearchInfo;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    private SchedulerService schedulerService;

    @Autowired
    public StudentController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonDto>> searchStudents(@RequestParam String nameLike,
                                                          @RequestParam String surnameLike,
                                                          @RequestParam String emailLike,
                                                          @RequestParam int limit){

        StudentSearchInfo studentSearchInfo = new StudentSearchInfo();
        studentSearchInfo.setNameLike(nameLike);
        studentSearchInfo.setSurnameLike(surnameLike);
        studentSearchInfo.setEmailLike(emailLike);
        studentSearchInfo.setLimit(limit);

        Collection<Student> collStudent =  schedulerService.searchStudents(studentSearchInfo);

        List<PersonDto> collPerson = collStudent.stream().map(PersonDto::new).collect(Collectors.toList());

        return new ResponseEntity<>(collPerson, HttpStatus.OK);
    }

}
