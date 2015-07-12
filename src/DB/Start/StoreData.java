package DB.Start;

import org.hibernate.Hibernate;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

import database.HibernateUtil;
import database.User;  
  
public class StoreData {  
public static void main(String[] args) {  
	
	//creating seession factory object  
    SessionFactory factory= HibernateUtil.getSessionFactory();//cfg.buildSessionFactory();  
      
    //creating configuration object  
	Configuration cfg = new Configuration();  
    cfg.configure("DB.Start/hibernate.cfg.xml");//populates the data of the configuration file  
      
    
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    User e1=new User();  
    e1.setUserID(115);  
    e1.setUsername("admin");  
    e1.setPassword("1234");  
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is committed  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
} 
