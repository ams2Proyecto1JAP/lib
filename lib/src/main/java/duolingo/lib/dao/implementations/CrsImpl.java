package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ICrs;
import duolingo.lib.model.CrsModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class CrsImpl implements ICrs {

	@Override
	public CrsModel getCrsById(int id) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			CrsModel crs = (CrsModel) session.get(CrsModel.class, id);
			return crs;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveCrs(CrsModel crs) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(crs);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

}
