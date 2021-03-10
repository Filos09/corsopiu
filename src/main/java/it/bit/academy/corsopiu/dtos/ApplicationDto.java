package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.ProcessingState;
import it.bit.academy.corsopiu.entities.Student;

import java.time.LocalDateTime;

public class ApplicationDto {

    private long id;
    private String comments;
    private LocalDateTime applicationDate;
    private ProcessingState applicationState;
    private CourseEdition edition;
    private long studentId;

    public ApplicationDto(Application a){
        this.comments = a.getComments();
        this.applicationDate = a.getApplicationDate();
        this.applicationState = a.getApplicationState();
        this.studentId = a.getStudent().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ProcessingState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ProcessingState applicationState) {
        this.applicationState = applicationState;
    }

    public CourseEdition getEdition() {
        return edition;
    }

    public void setEdition(CourseEdition edition) {
        this.edition = edition;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
