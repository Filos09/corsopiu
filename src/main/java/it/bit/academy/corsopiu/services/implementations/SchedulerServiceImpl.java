package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.repositories.EditionRepository;
import it.bit.academy.corsopiu.repositories.ModuleRepository;
import it.bit.academy.corsopiu.repositories.PersonRepository;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;
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
    public String createSearchString(InfoRicercaCorsi infoRicercaCorsi){
       String base = "SELECT c FROM Course c";
       boolean hasWhere = false;

       if(infoRicercaCorsi.getHasPrice() != null && infoRicercaCorsi.getHasPrice() == true){
           base += " WHERE c.price > 0";
           hasWhere = true;
       } else if(infoRicercaCorsi.getHasPrice() != null && infoRicercaCorsi.getHasPrice() == false){
           base += " WHERE c.price = 0";
           hasWhere = true;
       }

       if (infoRicercaCorsi.getTitleLike() != null ){
           if(hasWhere){
               base += " AND c.title LIKE :title";
           } else {
               base += " WHERE c.title LIKE :title";
               hasWhere = true;
           }
       }

       if(infoRicercaCorsi.getCategory() != null){
           if(hasWhere){
               base += " AND c.category = :category";
           } else {
               base += " WHERE c.category = :category";
               hasWhere = true;
           }
       }

       if(infoRicercaCorsi.getCert() != null && infoRicercaCorsi.getCert() == true){
           if(hasWhere) {
               base += " AND c.certification = true";
           } else {
               base += " WHERE c.certification = true";
           }
       } else if (infoRicercaCorsi.getCert() != null && infoRicercaCorsi.getCert() == false){
           if(hasWhere){
               base += " AND c.certification = false";
           }else {
               base += " WHERE c.certification = false";
           }

       }

       if(hasWhere){
           base += " AND c.duration BETWEEN :min AND :max";
       }else {
           base += " WHERE c.duration BETWEEN :min AND :max";
       }

        return base;
    }

}
