package duolingo.lib.dao.implementations;

import duolingo.lib.dao.interfaces.IShopItems;
import duolingo.lib.model.ShopItemsModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.hibernate.util.HibernateUtil;

public class ShopItemsImpl implements IShopItems {

	@Override
	public ShopItemsModel getShopItemById(int id) {
		try( Session session = HibernateUtil.getSessionFactory().openSession() )
        { 
			ShopItemsModel item = (ShopItemsModel) session.get(ShopItemsModel.class, id);
			return item;
        }catch(Exception e) {        	
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean saveShopItem(ShopItemsModel item) {
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(item);
            t.commit();
            return true;
            
        }catch(Exception e) {        	
            e.printStackTrace();
            return false;
        }
		
		
	}

}
