package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Course;

import java.util.Collection;
import java.util.Optional;

public interface SchedulerService {

    Collection<Course> getCourses();
    Optional<Course> getCourseById(long id);
}