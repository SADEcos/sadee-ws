package br.com.unicamp.mc437.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

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

    @ManyToOne
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
