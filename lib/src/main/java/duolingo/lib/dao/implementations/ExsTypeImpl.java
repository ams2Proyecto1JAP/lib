package duolingo.lib.dao.implementations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import duolingo.lib.dao.interfaces.IExsType;
import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.ExsTypeModel;


public class ExsTypeImpl implements IExsType{

	@Override
	public ExsTypeModel getExsTypeByType(String type) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 Criteria criteria = session.createCriteria(ExsTypeModel.class);
			 ExsTypeModel exsType = (ExsTypeModel) criteria.add(Restrictions.eq("type", type)).uniqueResult();
			return exsType;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean saveExsType(ExsTypeModel exsType) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			session.save(exsType);
			t.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
