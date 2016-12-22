package br.com.unicamp.mc437.configuration;

import br.com.unicamp.mc437.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfiguration {


    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure()
                .addAnnotatedClass(Account.class).addAnnotatedClass(Knowledge.class)
                .addAnnotatedClass(Project.class).addAnnotatedClass(SessionToken.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
