package br.com.unicamp.mc437.model;

import javax.persistence.*;

@Entity
@Table(name = "KNOWLEDGE")
public class Knowledge {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ID", unique = true, nullable = false)
    @Id
    @GeneratedValue
    private Long id;

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
