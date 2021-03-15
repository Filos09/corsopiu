package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.dtos.ApplicationPersonDto;
import it.bit.academy.corsopiu.entities.*;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.repositories.*;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private CourseRepository courseRepo;

    private EditionRepository editionRepo;

    private ModuleRepository moduleRepo;

    private PersonRepository personRepo;

    private ApplicationRepository applicationRepo;

    @Autowired
    public SchedulerServiceImpl(CourseRepository courseRepo,
                                EditionRepository editionRepo,
                                ModuleRepository moduleRepo,
                                PersonRepository personRepo,
                                ApplicationRepository applicationRepo) {
        this.courseRepo = courseRepo;
        this.editionRepo = editionRepo;
        this.moduleRepo = moduleRepo;
        this.personRepo = personRepo;
        this.applicationRepo = applicationRepo;
    }

    @Override
    public Collection<Course> getCourses() {
        return (Collection<Course>) this.courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(long id) {
        Optional<Course> course = this.courseRepo.findById(id);
        return course;
    }

    @Override
    public Collection<CourseEdition> getCourseEditions(long id) {
//        Collection<CourseEdition> editions = this.editionRepo.findTop3ByCourseIdOrderByIdDesc(id);
        Collection<CourseEdition> editions = this.editionRepo.findAllByCourseIdOrderByIdDesc(id);
        return editions;
    }

    @Override
    public Collection<Module> getModules(long id) {
        Collection<Module> modules = this.moduleRepo.findByEditionId(id);
        return modules;
    }

    @Override
    public Optional<Person> getPersonByEmail(String email) {
        Optional<Person> person = this.personRepo.findByEmail(email);
        return person;
    }

    @Override
    public List<Course> customSearch(InfoRicercaCorsi infoRicercaCorsi) {
        return courseRepo.customSearch(infoRicercaCorsi);
    }

//    @Override
//    public Collection<ApplicationPersonDto> getApplicationCollections(long id) {
//        Collection<ApplicationPersonDto> applications = this.personRepo.fuggivia(id);
//        return applications;
//    }

    @Override
    public Collection<Application> getByEditionId(long id) {
        Collection<Application> applications = this.applicationRepo.findByEditionId(id);
        return applications;
    }

}
