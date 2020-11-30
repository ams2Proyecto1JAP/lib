package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ICat;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;
import duolingo.lib.model.LangModel;
import duolingo.lib.model.UsersModel;
import duolingo.lib.model.id.CatId;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import duolingo.lib.hibernate.util.HibernateUtil;

public class CatImpl implements ICat {

	

	@Override
	public CatModel getCatByIndex(CrsModel crs, int index) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			CatId id = new CatId(index, crs);
			CatModel cat = (CatModel) session.get(CatModel.class, id);
			return cat;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveCat(CatModel cat) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(cat);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

	@Override
	public ArrayList<CatModel> getAllCategoriesByCrs(CrsModel crs) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 
			List<CatModel> cats = session.createSQLQuery("select * from cat where crs_id="+crs.getId()+";").addEntity(CatModel.class).list();

			return new ArrayList<CatModel>(cats);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public int getCountCategoriesByCrs(CrsModel crs) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query queryNumCats = session.createQuery("select count(*) from cat where crs_id="+crs.getId()+";");
			return (int) queryNumCats.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
}
