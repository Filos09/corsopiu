package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDto {

    private PersonType type;
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String birthPlace;
    private String fiscalCode;
    private String streetAddress;
    private String city;
    private String province;
    private Region region;
    private List<SkillDto> skills;
    private double salary;
    private String role;
    private double hourlyWage;
    private List<ApplicationDto> applications;

    public PersonDto(Person p){
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.gender = p.getGender();
        this.email = p.getEmail();
        this.phone = p.getPhone();
        this.birthDate = p.getBirthDate();
        this.birthPlace = p.getBirthPlace();
        this.fiscalCode = p.getFiscalCode();
        if(p.getAddress() != null){
            this.streetAddress = p.getAddress().getStreetAddress();
            this.city = p.getAddress().getCity();
            this.province = p.getAddress().getProvince();
            this.region = p.getAddress().getRegion();
        }
        this.skills = p.getSkills().stream().map(SkillDto::new).collect(Collectors.toList());

        if(p instanceof Employee){

            this.type = PersonType.EMPL;
            this.role = ((Employee) p).getRole();
            this.salary = ((Employee) p).getSalary();

        } else if(p instanceof Student){

            this.type = PersonType.STUD;
            this.applications = ((Student) p).getApplications().stream().map(ApplicationDto::new).collect(Collectors.toList());

        } else if(p instanceof Teacher){

            this.type = PersonType.TEACH;
            this.hourlyWage = ((Teacher) p).getHourlyWage();

        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }
}
