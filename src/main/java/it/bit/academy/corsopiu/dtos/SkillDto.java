package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Level;
import it.bit.academy.corsopiu.entities.Skill;

public class SkillDto {

    private long id;
    private long abilityId;
    private Level level;
    private boolean certified;
    private long personId;

    public SkillDto(Skill s){
        this.id = s.getId();
        this.abilityId = s.getAbility().getId();
        this.level = s.getLevel();
        this.certified = s.isCertified();
        this.personId = s.getPerson().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(long abilityId) {
        this.abilityId = abilityId;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
