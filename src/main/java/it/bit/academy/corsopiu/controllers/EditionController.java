package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.ApplicationPersonDto;
import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.repositories.ApplicationRepository;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/edition")
@CrossOrigin
public class EditionController {

    private SchedulerService schedulerService;

    @Autowired
    public EditionController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }


    @GetMapping("/{id}/applications")
    public ResponseEntity<Collection<ApplicationPersonDto>> findApplicationPerson(@PathVariable long id){
        Collection<Application> collApplication = schedulerService.getByEditionId(id);
        System.out.println(collApplication);
        List<ApplicationPersonDto> applicationPersonDtos = collApplication.stream().map(ApplicationPersonDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(applicationPersonDtos, HttpStatus.OK);
    }
}
