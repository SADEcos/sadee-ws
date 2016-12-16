package br.com.unicamp.mc437.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UNIVERSITY")
public class University {

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

    @OneToMany
    private List<Account> accountList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
