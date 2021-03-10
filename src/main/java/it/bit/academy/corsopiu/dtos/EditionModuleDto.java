package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Lesson;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.Module;

import javax.persistence.*;
import java.util.List;

public class EditionModuleDto {

    private long id;
    private String name;
    private String description;
    private String teacherName;
    private int duration;
//    private CourseEdition edition;

    public EditionModuleDto(){}

    public EditionModuleDto(it.bit.academy.corsopiu.entities.Module m){
        id = m.getId();
        name = m.getName();
        description = m.getDescription();
        teacherName = m.getTeacher().getFirstName() +" "+m.getTeacher().getLastName();
        duration = m.getDuration();
//        edition = m.getEdition();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


//    public CourseEdition getEdition() {
//        return edition;
//    }
//
//    public void setEdition(CourseEdition edition) {
//        this.edition = edition;
//    }
}
