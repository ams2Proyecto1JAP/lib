package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ICrs;
import duolingo.lib.model.CrsModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
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
	public ArrayList<CrsModel> getCrsByLangFilter(int idLangOrigin, int idLangDestiny) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			ArrayList<CrsModel> selectedCrs = new ArrayList<CrsModel>();
			if(idLangOrigin == 0) {
				return this.getCrsByLangDestinyId(idLangDestiny);
			}
			if(idLangDestiny == 0) {
				return  this.getCrsByLangOriginId(idLangOrigin);
			}
			List<CrsModel> courses = session.createSQLQuery("select * from crs where lang_destiny_id = "+idLangDestiny+" and lang_origin_id = "+idLangOrigin).addEntity(CrsModel.class).list();
			selectedCrs = (ArrayList<CrsModel>) courses; 
			return selectedCrs;
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

	@Override
	public List<CrsModel> getAllCrs() {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<CrsModel> cq = cb.createQuery(CrsModel.class);
			Root<CrsModel> rootEntry = cq.from(CrsModel.class);
			CriteriaQuery<CrsModel> all = cq.select(rootEntry);
			TypedQuery<CrsModel> allQuery = session.createQuery(all);
			return allQuery.getResultList();
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public ArrayList<CrsModel> getCrsByLangOriginId(int idLangOrigin) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			ArrayList<CrsModel> selectedCrs = new ArrayList<CrsModel>();
			List<CrsModel> courses = session.createSQLQuery("select * from crs where lang_origin_id="+idLangOrigin).addEntity(CrsModel.class).list();
			selectedCrs = (ArrayList<CrsModel>) courses; 
			return selectedCrs;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public ArrayList<CrsModel> getCrsByLangDestinyId(int idLangDestiny) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			ArrayList<CrsModel> selectedCrs = new ArrayList<CrsModel>();
			List<CrsModel> courses = session.createSQLQuery("select * from crs where lang_destiny_id="+idLangDestiny).addEntity(CrsModel.class).list();
			selectedCrs = (ArrayList<CrsModel>) courses; 
			return selectedCrs;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

}
