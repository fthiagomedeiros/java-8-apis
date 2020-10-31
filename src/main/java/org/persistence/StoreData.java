package org.persistence;

import org.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Person e1 = new Person();
        e1.setId(1);
        e1.setName("Gaurav1");

        Person e2 = new Person();
        e2.setId(2);
        e1.setName("Gaurav2");


        session.save(e1);
        System.out.println("successfully saved" + e1.getId());
        session.save(e2);
        t.commit();

        System.out.println("successfully saved" + e1.getId() + "" + e2.getId());
        factory.close();
        session.close();
    }
}