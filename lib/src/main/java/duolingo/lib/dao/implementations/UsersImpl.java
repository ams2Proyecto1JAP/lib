package duolingo.lib.dao.implementations;


import duolingo.lib.dao.interfaces.IUsers;
import duolingo.lib.model.UsersModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class UsersImpl implements IUsers {

	@Override
	public UsersModel getUserById(int id) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			UsersModel usr = (UsersModel) session.get(UsersModel.class, id);
			return usr;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveUser(UsersModel usr) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(usr);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
	}

	

}
