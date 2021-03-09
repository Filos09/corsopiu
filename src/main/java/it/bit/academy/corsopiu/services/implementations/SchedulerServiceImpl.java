package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.repositories.EditionRepository;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private CourseRepository courseRepo;

    private EditionRepository editionRepo;

    @Autowired
    public SchedulerServiceImpl(CourseRepository courseRepo, EditionRepository editionRepo) {
        this.courseRepo = courseRepo;
        this.editionRepo = editionRepo;
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

}
