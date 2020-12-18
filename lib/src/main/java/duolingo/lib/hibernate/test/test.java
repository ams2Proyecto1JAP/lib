package duolingo.lib.hibernate.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.dao.implementations.*;
import duolingo.lib.dao.interfaces.*;
import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.*;


public class test {

	public static void main(String[] args) {
		
		
		//Ejemplos modelo
		
		UsersModel user1 = new UsersModel("user1");
		UsersModel user2 = new UsersModel("user2");
		
		AvtModel avt1 = new AvtModel(user1, "ruta/de/prueba1");
		AvtModel avt2 = new AvtModel(user2, "ruta/de/prueba2");
		user1.setAvt(avt1);
		user2.setAvt(avt2);		
		
		user1.followUser(user2);
		user2.followUser(user1);
		
		LangModel lang1 = new LangModel("Castellano", "es-ES");
		user1.setAppLang(lang1);
		
		LeagueModel league1 = new LeagueModel("Bronce", 500);
		LeagueModel league2 = new LeagueModel("Plata", 1000);		
		user1.setLeague(league1);
		user2.setLeague(league2);
		
		ShopItemsModel item1 = new ShopItemsModel(10, "ruta/de/prueba", "tipo1", "item1", "este es el item 1");
		ShopItemsModel item2 = new ShopItemsModel(25, "ruta/de/prueba2", "tipo2", "item2", "este es el item 2");
		user1.buyDress(item1);
		item1.userBuy(user1);
		user1.buyDress(item2);
		item2.userBuy(user1);
		user2.buyDress(item1);
		item1.userBuy(user2);
		
		
		CrsModel course1 = new CrsModel(lang1, lang1);
		user1.setActualCourse(course1);
		user1.registerCourse(course1);
		course1.registerUser(user1);
		user2.registerCourse(course1);
		course1.registerUser(user2);
		
		CatModel cat1 = new CatModel(course1, 1, "categoria1", "imagePath1");
		CatModel cat2 = new CatModel(course1, 2, "categoria2", "imagePath2");
		
		course1.addCategory(cat1);
		course1.addCategory(cat2);
		
		LvlModel cat1lvl1 = new LvlModel(cat1, 1, "nivel1");
		LvlModel cat1lvl2 = new LvlModel(cat1, 2, "nivel2");
		LvlModel cat1lvl3 = new LvlModel(cat1, 3, "nivel3");
		LvlModel cat2lvl1 = new LvlModel(cat2, 1, "nivel1");
		LvlModel cat2lvl2 = new LvlModel(cat2, 2, "nivel2");
		
		cat1.addLevel(cat1lvl1);
		cat1.addLevel(cat1lvl2);
		cat1.addLevel(cat1lvl3);
		cat2.addLevel(cat2lvl1);
		cat2.addLevel(cat2lvl2);
		
		ExsTypeModel exsTypeTest = new ExsTypeModel("test");
		ExsTypeModel exsTypeTranslate = new ExsTypeModel("translateOpen");
		
		ExsModel cat1lvl1ex1 = new ExsModel(cat1lvl1, 1, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		ExsModel cat1lvl1ex2 = new ExsModel(cat1lvl1, 2, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		ExsModel cat1lvl1ex3 = new ExsModel(cat1lvl1, 3, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		ExsModel cat1lvl2ex1 = new ExsModel(cat1lvl2, 1, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		ExsModel cat2lvl1ex1 = new ExsModel(cat2lvl1, 1, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		ExsModel cat2lvl1ex2 = new ExsModel(cat2lvl1, 2, exsTypeTest, "{\"testExercise\":{\"options\":[\"Hi\",\"Hello\",\"hh\",\"hhh\"],\"phrToTranslate\":\"Hola\"}}");
		
		
		
		user1.resolvedCategory(cat1);		
		cat1.addUserRvd(user1);
		user1.resolvedCategory(cat2);
		cat2.addUserRvd(user1);		
		user2.resolvedCategory(cat1);
		cat1.addUserRvd(user2);
		
		user1.resolvedLevel(cat1lvl1);
		cat1lvl1.addUserRvd(user1);		
		user2.resolvedLevel(cat2lvl1);
		cat2lvl1.addUserRvd(user2);
		
		user1.resolvedExercice(cat1lvl1ex1);
		cat1lvl1ex1.addUserRvd(user1);
		user1.resolvedExercice(cat1lvl1ex2);
		cat1lvl1ex1.addUserRvd(user1);
		user1.resolvedExercice(cat2lvl1ex1);
		cat2lvl1ex1.addUserRvd(user1);
		
		user2.resolvedExercice(cat2lvl1ex1);
		cat1lvl1ex1.addUserRvd(user2);
		
		
		
		
		
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
        	
            t = session.beginTransaction();
            
            session.save(cat1);
            session.save(cat2);
            session.save(exsTypeTest);
            
            session.save(cat1lvl1);
            session.save(cat1lvl2);
            session.save(cat1lvl3);
            session.save(cat2lvl1);
            session.save(cat2lvl2);
            
            
            
            session.save(lang1);
            
            session.save(course1);
            
            
            session.save(user1);
            session.save(user2);
            session.save(cat1lvl1);
            session.save(cat1lvl2);
            session.save(cat1lvl3);
            session.save(cat2lvl1);
            session.save(cat2lvl2);
            
            session.save(cat1lvl1ex1);
            session.save(cat1lvl1ex2);
            session.save(cat1lvl1ex3);
            session.save(cat1lvl2ex1);
            session.save(cat2lvl1ex1);
            session.save(cat2lvl1ex2);
            
            session.save(avt1);
            session.save(avt2);
            
            session.save(league1);
            session.save(league2);
            
            session.save(item1);
            session.save(item2);
            
            
            t.commit();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        // Ejemplos dao
       
        ExsTypeModel exsTest;
		IExsType exsTypeDAO = new ExsTypeImpl();
		
		
		exsTest = exsTypeDAO.getExsTypeByType("testType");
		
		
        ICat catDao = new CatImpl();
        ICrs crsDao = new CrsImpl();
        IExs exsDAO = new ExsImpl();
        
        CrsModel crs1 = crsDao.getCrsById(1);
       
      
        
      
        CatModel cat = catDao.getCatByIndex(crs1, 1);
        System.out.println(cat.getName());
        
        
       
        
        
        ILvl lvlDAO = new LvlImpl();
        ArrayList<LvlModel>Levels =lvlDAO.getAllLevelsByCat(cat);
        for(LvlModel lm: Levels ) {
        	System.out.println(lm.getIndex());
        }
        

	}

}
