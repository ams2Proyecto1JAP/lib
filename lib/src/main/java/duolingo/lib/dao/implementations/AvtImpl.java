package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.IAvt;
import duolingo.lib.model.AvtModel;
import duolingo.lib.model.LangModel;
import duolingo.lib.model.UsersModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class AvtImpl implements IAvt {

	@Override
	public AvtModel getAvtByUser(UsersModel usr) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			AvtModel avt = (AvtModel) session.get(AvtModel.class, usr.getId());
			return avt;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveAvt(AvtModel avt) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(avt);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

}
