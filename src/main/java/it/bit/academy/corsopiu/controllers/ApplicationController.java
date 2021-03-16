package it.bit.academy.corsopiu.controllers;


import it.bit.academy.corsopiu.dtos.ApplicationInfoDto;
import it.bit.academy.corsopiu.dtos.ApplicationPersonDto;
import it.bit.academy.corsopiu.dtos.PersonDto;
import it.bit.academy.corsopiu.entities.*;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import it.bit.academy.corsopiu.services.abstractions.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/application")
@CrossOrigin
public class ApplicationController {

    private SchedulerService schedulerService;

    private StudentService studentService;

    @Autowired
    public ApplicationController(
            SchedulerService schedulerService,
            StudentService studentService) {
        this.schedulerService = schedulerService;
        this.studentService = studentService;
    }


    @PostMapping("/")
    public ResponseEntity<ApplicationPersonDto> createApplication(@RequestBody ApplicationInfoDto applicationInfoDto){

        Optional<Student> st = studentService.findById(applicationInfoDto.getIdStudent());
        if(st.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<CourseEdition> ce = schedulerService.getCourseEditionById(applicationInfoDto.getIdEdition());
        if(ce.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Application application = new Application();
        application.setApplicationState(ProcessingState.APPROVED);
        application.setComments("");
        application.setApplicationDate(LocalDateTime.now());
        application.setStudent(st.get());
        application.setEdition(ce.get());

        Application saved =  this.schedulerService.insertApplication(application);

        ApplicationPersonDto applicationDto = new ApplicationPersonDto(saved);

        return new ResponseEntity<>(applicationDto, HttpStatus.CREATED);
    }


}
