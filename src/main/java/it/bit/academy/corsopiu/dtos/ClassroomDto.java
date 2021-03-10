package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.*;

public class ClassroomDto {
    private ClassroomType type;
    private long id;
    private String name;
    private String title;
    private int capacity;
    private Equipment equipment;
    private String platform;
    private String link;
    private String password;

    public ClassroomDto(Classroom c){
        this.id = c.getId();
        this.name = c.getName();
        this.title = c.getTitle();
        this.capacity = c.getCapacity();

        if(c instanceof RealClassroom){
            this.equipment = ((RealClassroom) c).getEquipment();
        }else if(c instanceof VirtualClassroom){
            this.platform = ((VirtualClassroom) c).getPlatform();
            this.link = ((VirtualClassroom) c).getLink();
            this.password = ((VirtualClassroom) c).getPassword();
        }
    }

    public ClassroomType getType() {
        return type;
    }

    public void setType(ClassroomType type) {
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
