package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.ProcessingState;

import java.time.LocalDate;

public class ApplicationPersonDto {

    private long idPerson;
    private long idApplication;
    private String firstName;
    private String lastName;
    private String email;
    private ProcessingState status;
    private LocalDate applicationDate;
    private String comment;

    public ApplicationPersonDto(Application a) {
        this.idPerson = a.getStudent().getId();
        this.idApplication = a.getId();
        this.firstName = a.getStudent().getFirstName();
        this.lastName = a.getStudent().getLastName();
        this.email = a.getStudent().getEmail();
        this.status = a.getApplicationState();
        this.applicationDate = a.getApplicationDate().toLocalDate();
        this.comment = a.getComments();
    }





    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public long getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(long idApplication) {
        this.idApplication = idApplication;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProcessingState getStatus() {
        return status;
    }

    public void setStatus(ProcessingState status) {
        this.status = status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}