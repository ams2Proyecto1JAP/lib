package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.ILvl;
import duolingo.lib.model.LvlModel;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.id.LvlId;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class LvlImpl implements ILvl {

	@Override
	public LvlModel getLvlByIndex(CatModel cat, int index) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			LvlId id = new LvlId(index, cat);
			LvlModel lvl = (LvlModel) session.get(LvlModel.class, id);
			return lvl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveLvl(LvlModel lvl) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			session.save(lvl);
			t.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public ArrayList<LvlModel> getAllLevelsByCat(CatModel cat) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			List<LvlModel> lvls = session.createSQLQuery("select * from lvl where cat_index = " + cat.getIndex()+ " and crs_id = " + cat.getCrs().getId() + ";")
					.addEntity(LvlModel.class).list();
			return new ArrayList<LvlModel>(lvls);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
