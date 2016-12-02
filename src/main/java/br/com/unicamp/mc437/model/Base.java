package br.com.unicamp.mc437.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Base {

    @Column(name = "ID", unique = true, nullable = false)
    @Id
    private Long id;

    @Column(name = "CREATE_DATE", unique = true, nullable = false)
    private Date createDate;

    @Column(name = "UPDATE_DATE", unique = true, nullable = false)
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
