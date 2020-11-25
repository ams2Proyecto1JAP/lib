package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ILang;
import duolingo.lib.model.LangModel;
import duolingo.lib.model.UsersModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class LangImpl implements ILang {

	@Override
	public LangModel getLangById(int id) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			LangModel lang = (LangModel) session.get(LangModel.class, id);
			return lang;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveLang(LangModel lang) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(lang);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

}
