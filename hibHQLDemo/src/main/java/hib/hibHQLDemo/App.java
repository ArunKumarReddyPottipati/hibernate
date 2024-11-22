package hib.hibHQLDemo;

import java.lang.annotation.Native;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.NativeQuery;


public class App 
{
    public static void main( String[] args )
    {
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
//        for(int i=0;i<50;i++)
//        {
//        	Employee e = new Employee();
//        	e.setId(i);
//        	e.setName("Emp"+i);
//        	e.setWage(i*50+50);
//        	session.save(e);
//        }
//        session.getTransaction().commit();
        
        
        
        //Returns a Employee list
        
         /* 
        Query q = session.createQuery("from Employee");
        List<Employee> emp = q.list();
        for(Employee e : emp)
        {
        	System.out.println(e);
        }
        */
        
        // Returns a single Employee object
        
//        Query q = session.createQuery("from Employee where id=20");
//        Employee emp = (Employee)q.uniqueResult();
//        System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getWage());
        
        //Using Select in HQL(Hibernate Query Language)
        //Returns an List of array of Objects of type Object
        
//        Query q = session.createQuery("select id,name,wage from Employee");
//        List<Object[]> emp=q.list();
//        for(Object[] e: emp)
//        {
//        	System.out.println(e[0]+" : "+e[1]+" : "+e[2]);
//        }
        
        //Returns a single object array of type Object
//        Query q = session.createQuery("select id,name,wage from Employee where id=44");
//        Object[] emp = (Object[]) q.uniqueResult();
//        System.out.println(emp[0]+" "+emp[1]+" "+emp[2]);
        
        //********  Using SQL in Hibernate   *********************
        
        
//        NativeQuery<Object[]> q = session.createNativeQuery("select * from Employee");
//        List<Object[]> emp = q.list();
//        for(Object[] e:emp)
//        {
//        	System.out.println(e[0]+" "+e[1]+" "+e[2]);
//        }
        
//        NativeQuery<Object[]> q = session.createNativeQuery("select name,wage from Employee where wage>1000");
//        List<Object[]> emp = q.list();
//        for(Object[] e:emp)
//        {
//        	System.out.println("Name = "+e[0]+"  "+"Wage = "+e[1]);
//        }
        
        NativeQuery<Object[]> q = session.createNativeQuery("select id,name,wage from Employee where id=50");
        Object[] emp = q.uniqueResult();
        if(emp != null)
        	System.out.println("Id = "+emp[0]+"Name = "+emp[1]+"  "+"Wage = "+emp[2]);
        else
        	System.out.println("No employee found");
        
    }
}
