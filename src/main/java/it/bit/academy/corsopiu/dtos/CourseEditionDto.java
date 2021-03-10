package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.*;
import it.bit.academy.corsopiu.entities.Module;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CourseEditionDto {

    public CourseEditionDto(){}

    public CourseEditionDto(CourseEdition c){
        id = c.getId();
        startDate = c.getStartDate();
        classroomId = c.getClassroom().getId();
        classroomName = c.getClassroom().getName();
        description = c.getDescription();
        tutorId = c.getTutor().getId();
        tutorName = c.getTutor().getFirstName() + " " + c.getTutor().getLastName();
        courseId = c.getCourse().getId();
        this.modules = c.getModules().stream().map(EditionModuleDto::new).collect(Collectors.toList());

    }

    private long id;

    private LocalDateTime startDate;

    private long classroomId;     // aula in cui si svolge il corso

    private String classroomName;

    private String description;

    private long tutorId;

    private String tutorName;

    private long courseId;

    public List<EditionModuleDto> getModules() {
        return modules;
    }

    public void setModules(List<EditionModuleDto> modules) {
        this.modules = modules;
    }

    private List<EditionModuleDto> modules;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
