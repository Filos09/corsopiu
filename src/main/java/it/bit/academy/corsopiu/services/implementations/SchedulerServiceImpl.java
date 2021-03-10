package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.repositories.EditionRepository;
import it.bit.academy.corsopiu.repositories.ModuleRepository;
import it.bit.academy.corsopiu.repositories.PersonRepository;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private CourseRepository courseRepo;

    private EditionRepository editionRepo;

    private ModuleRepository moduleRepo;

    private PersonRepository personRepo;

    @Autowired
    public SchedulerServiceImpl(CourseRepository courseRepo,
                                EditionRepository editionRepo,
                                ModuleRepository moduleRepo,
                                PersonRepository personRepo) {
        this.courseRepo = courseRepo;
        this.editionRepo = editionRepo;
        this.moduleRepo = moduleRepo;
        this.personRepo = personRepo;
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
        Collection<CourseEdition> editions = this.editionRepo.findTop3ByCourseIdOrderByIdDesc(id);
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

}
