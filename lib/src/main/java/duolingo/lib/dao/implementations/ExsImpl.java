package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.IExs;
import duolingo.lib.model.ExsModel;
import duolingo.lib.model.LangModel;
import duolingo.lib.model.LvlModel;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;
import duolingo.lib.model.UsersModel;
import duolingo.lib.model.id.CatId;
import duolingo.lib.model.id.ExsId;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class ExsImpl implements IExs {



	@Override
	public ExsModel getExsByIndex(LvlModel lvl, int index) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			ExsId id = new ExsId(index, lvl);
			ExsModel Exs = (ExsModel) session.get(ExsModel.class, id);
			return Exs;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}
	
	@Override
	public boolean saveExs(ExsModel exs) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(exs);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

	@Override
	public ArrayList<ExsModel> getAllExercicesByLvl(LvlModel lvl) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 
			List<ExsModel> exs = session.createSQLQuery("select * from exs where crs_id="+lvl.getCat().getCrs().getId()
					+ " and cat_index = " + lvl.getCat().getIndex() + " and lvl_index = " + lvl.getIndex()).addEntity(ExsModel.class).list();

			return new ArrayList<ExsModel>(exs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	

	
}
