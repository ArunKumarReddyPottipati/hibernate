package hib.hibDemo2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student s = new Student();
        s.setRno(101);
        s.setName("Charan");
        s.setAge(23);
        
        
        Laptop lap1 = new Laptop();
        lap1.setLid(13);
        lap1.setName("MacBook");
        lap1.getStu().add(s);
        
//        Laptop lap2 = new Laptop();
//        lap2.setLid(11);
//        lap2.setName("Infinix");
//        lap2.setStu(s);
//        
//        List<Laptop> laptop = new ArrayList<>();
//        laptop.add(lap1);
//        laptop.add(lap2);
        
        s.getLap().add(lap1);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txt = session.beginTransaction();
        session.save(s);
        session.save(lap1);
        //session.save(lap2);
        txt.commit();
    }
}
