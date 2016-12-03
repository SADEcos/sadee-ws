package br.com.unicamp.mc437.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Knowledge {

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "GRADE", nullable = false)
    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
