package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseDto;
import it.bit.academy.corsopiu.dtos.CourseEditionDto;
import it.bit.academy.corsopiu.dtos.EditionModuleDto;
import it.bit.academy.corsopiu.dtos.PersonDto;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.entities.Person;
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
@RequestMapping("/api/person")
@CrossOrigin
public class CourseController {

    private SchedulerService schedulerService;

    @Autowired
    public CourseController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/")
    public ResponseEntity<Collection<CourseDto>> allCourses() {

        // recuperiamo l'elenco dei corsi dal service
        Collection<Course> listaCorsi = schedulerService.getCourses();
        // conversione da entity a dto
//        return listaCorsi.stream().map(e -> new CourseDto(e)).collect(Collectors.toList());
        List<CourseDto> result = listaCorsi.stream().map(CourseDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findCourseById(@PathVariable long id){
        Optional<Course> opt = schedulerService.getCourseById(id);
        if(opt.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CourseDto(opt.get()), HttpStatus.OK);
    }

    @GetMapping("/editions/{id}")
    public ResponseEntity<Collection<CourseEditionDto>> findEditionById(@PathVariable long id){
        Collection<CourseEdition> opt = schedulerService.getCourseEditions(id);
        if(opt.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<CourseEditionDto> result = opt.stream().map(CourseEditionDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/modules/{id}")
    public ResponseEntity<Collection<EditionModuleDto>> findModuleById(@PathVariable long id){
        Collection<Module> opt = schedulerService.getModules(id);
        if(opt.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 //       List<ModuleDto> result = opt.stream().map(ModuleDto::new).collect(Collectors.toList());
        List<EditionModuleDto> result = opt.stream().map(EditionModuleDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
