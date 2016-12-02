package br.com.unicamp.mc437.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account extends Base {

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "PHONE", nullable = false)
    private String phone;
    @Column(name = "HOME_PHONE", nullable = false)
    private String homephone;
    @Column(name = "CPF", nullable = false)
    private String cpf;
    @Column(name = "RG", nullable = false)
    private String rg;
    @Column(name = "INTERNSHIP", nullable = false)
    private String internship;
    @Column(name = "UNDERGRADUATE", nullable = false)
    private String undergraduate;
    @Column(name = "AVAILABILITY", nullable = false)
    private String availability;
    @Column(name = "LINKEDIN", nullable = false)
    private String linkedin;
    @Column(name = "ADDRESS", nullable = false)
    private String address;
    @Column(name = "CONPEC", nullable = false)
    private String conpec;
    @Column(name = "OBS", nullable = false)
    private String obs;
    @Column(name = "COURSE", nullable = false)
    private String course;
    @Column(name = "BUSY", nullable = false)
    private String busy;
	@Column(name = "UNIVERSITY", nullable = false)
    @OneToOne
    private University university;
    @OneToMany
    private List<Project> projects;
    @OneToMany
    private List<Knowledge> knowledgeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}

	public String getUndergraduate() {
		return undergraduate;
	}

	public void setUndergraduate(String undergraduate) {
		this.undergraduate = undergraduate;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConpec() {
		return conpec;
	}

	public void setConpec(String conpec) {
		this.conpec = conpec;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
}
