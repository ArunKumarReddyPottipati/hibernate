package hib.hibDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {     
    	Scanner sc = new Scanner(System.in);
    	
    	Name name = new Name();
      
    	Alien a = new Alien();
    	
        System.out.print("Enter Alien Id: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Alien First Name: ");
        String fname = sc.nextLine();
        System.out.print("Enter Alien Middle Name: ");
        String mname = sc.nextLine();
        System.out.print("Enter Alien Last Name: ");
        String lname = sc.nextLine();       
        System.out.print("Enter Alien color: ");
        String color = sc.nextLine();
        System.out.print("Enter Alien Planet: ");
    	String planet = sc.nextLine();
    
    	name.setFname(fname);
        name.setMname(mname);
        name.setLname(lname);
        
        a.setAid(id);
        a.setAname(name);
        a.setColor(color);
        a.setPlanet(planet); 
        
    /*
    a.setAid(102);
    a.setAname("Swam Fire");
    a.setColor("Gold");
    a.setPlanet("Fire World"); */
    	
    	
    
        
        Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = conn.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = (Transaction) session.beginTransaction();
        session.save(a);
//        a = session.get(Alien.class, 101);
        tx.commit();
        System.out.println(a);
        
    }
}
