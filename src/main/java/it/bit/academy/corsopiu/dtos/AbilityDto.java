package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Ability;

public class AbilityDto {
    private long id;
    private String name;
    private long areaId;
    private String description;

    public AbilityDto(Ability a){
        this.id = a.getId();
        this.name = a.getName();
        this.areaId = a.getArea().getId();
        this.description = a.getDescription();
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

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
