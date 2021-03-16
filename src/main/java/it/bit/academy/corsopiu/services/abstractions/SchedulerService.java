package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.dtos.ApplicationPersonDto;
import it.bit.academy.corsopiu.entities.*;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.models.StudentSearchInfo;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SchedulerService {

    Collection<Course> getCourses();
    Optional<Course> getCourseById(long id);
    Optional<CourseEdition> getCourseEditionById(long id);
    Collection<CourseEdition> getCourseEditions(long id);
    Collection<Module>getModules(long id);

    Optional<Person> getPersonByEmail(String email);
    List<Course> customSearch(InfoRicercaCorsi infoRicercaCorsi);

//    Collection<ApplicationPersonDto> getApplicationCollections(long id);

    Collection<Application> getByEditionId(long id);


    Collection<Student> searchStudents(StudentSearchInfo studentSearchInfo);
    Application insertApplication(Application application);
}