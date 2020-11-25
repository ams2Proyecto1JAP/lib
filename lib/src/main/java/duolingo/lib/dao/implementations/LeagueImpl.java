package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ILeague;
import duolingo.lib.model.LeagueModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class LeagueImpl implements ILeague {

	@Override
	public LeagueModel getLeagueById(int id) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			LeagueModel league = (LeagueModel) session.get(LeagueModel.class, id);
			return league;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveLeague(LeagueModel league) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(league);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

}
