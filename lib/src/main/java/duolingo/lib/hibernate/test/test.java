package duolingo.lib.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.UsersFollowModel;
import duolingo.lib.model.UsersModel;


public class test {

	public static void main(String[] args) {
		
		
		UsersModel user1 = new UsersModel("user1");
		UsersModel user2 = new UsersModel("user2");
		
		user1.followUser(user2);
		
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
        	
            t = session.beginTransaction();
            
            session.save(user1);
            session.save(user2);
            
            t.commit();
            
        }catch(Exception e) {
            e.printStackTrace();
        }

	}

}
