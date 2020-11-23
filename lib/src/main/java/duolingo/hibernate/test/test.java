package duolingo.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.hibernate.util.HibernateUtil;
import duolingo.model.Prueba;

public class test {

	public static void main(String[] args) {
		
		System.out.println("Holaa");
		Prueba p = new Prueba("hola");
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
        	System.out.println("Holaa");
            t = session.beginTransaction();
            System.out.println("Holaa");
            session.save(p);
            System.out.println("Holaa");
            t.commit();
            System.out.println("Holaa");
        }catch(Exception e) {
            e.printStackTrace();
        }

	}

}
