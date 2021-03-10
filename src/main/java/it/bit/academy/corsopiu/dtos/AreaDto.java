package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Area;

public class AreaDto {
    private long id;
    private String name;
    private String description;

    public AreaDto(Area a){
        this.id = a.getId();
        this.name = a.getName();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
