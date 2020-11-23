package duolingo.lib.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.*;


public class test {

	public static void main(String[] args) {
		
		
		UsersModel user1 = new UsersModel("user1");
		UsersModel user2 = new UsersModel("user2");
		
		user1.followUser(user2);
		user2.followUser(user1);
		
		LangModel lang1 = new LangModel("Castellano");
		CrsModel course1 = new CrsModel(lang1);
		
		CatModel cat1 = new CatModel(course1, 1, "categoria1", "imagePath1");
		CatModel cat2 = new CatModel(course1, 1, "categoria2", "imagePath2");
		
		course1.addCategory(cat1);
		course1.addCategory(cat2);
		
		
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
        	
            t = session.beginTransaction();
            
            session.save(user1);
            session.save(user2);
            session.save(lang1);
            session.save(course1);
            session.save(cat1);
            session.save(cat2);
            
            t.commit();
            
        }catch(Exception e) {
            e.printStackTrace();
        }

	}

}
