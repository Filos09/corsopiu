package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;

import java.util.Collection;
import java.util.Optional;

public interface SchedulerService {

    Collection<Course> getCourses();
    Optional<Course> getCourseById(long id);
    Collection<CourseEdition> getCourseEditions(long id);
    Collection<Module>getModules(long id);

    Optional<Person> getPersonByEmail(String email);

//    Collection<Course>
    String createSearchString(InfoRicercaCorsi infoRicercaCorsi);
    }