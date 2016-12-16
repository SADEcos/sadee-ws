package br.com.unicamp.mc437.configuration;

import br.com.unicamp.mc437.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfiguration {


    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration();
            configuration.addAnnotatedClass(Account.class).addAnnotatedClass(Knowledge.class)
                    .addAnnotatedClass(SessionToken.class).addAnnotatedClass(University.class).addAnnotatedClass(Project.class);
            return configuration.configure()
                    .buildSessionFactory(
                            new StandardServiceRegistryBuilder()
                                    .applySettings(configuration.getProperties())
                                    .build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
