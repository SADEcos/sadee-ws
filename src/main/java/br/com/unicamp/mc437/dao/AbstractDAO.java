package br.com.unicamp.mc437.dao;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.sql.DataSource;

@Component
public interface AbstractDAO {

    void saveOrUpdate(Object object);
}
