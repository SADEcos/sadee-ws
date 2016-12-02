package br.com.unicamp.mc437.model;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Project extends Base{

    @Column(name = "NAME", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
