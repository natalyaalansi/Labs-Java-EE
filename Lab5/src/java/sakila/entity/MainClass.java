/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakila.entity;


import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;


/**
 *
 * @author Alansi89
 */
public class MainClass {
    public static void main(String[] args) {
        int id = 15;
        String firstname = "Nata";
        String lastname = "Alansi";
        addInformation(id, firstname, lastname);
        readInformation();

}
    static void addInformation(int id, String firstname, String lastname) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        Bookings t = new Bookings(id, firstname, lastname);
        s.save(t);
        tr.commit();
        s.close();
        sf.close();
    }

    static void readInformation() {
    Configuration configuration = new Configuration().configure();
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());
    SessionFactory sf = configuration.buildSessionFactory(builder.build());
    Session s = sf.openSession();
    Transaction tr = s.beginTransaction();
    Query query = s.createQuery("from Bookings");
    java.util.List res = query.list();
    for (Object i : res) {
        Bookings out = (Bookings) i;
        System.out.println("»>" + out.getId() + ", " + out.getFirstname() + ", " + out.getLastname());
    }
    sf.close();

}

}

