package duolingo.lib.hibernate.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.dao.implementations.CatImpl;
import duolingo.lib.dao.implementations.CrsImpl;
import duolingo.lib.dao.implementations.LangImpl;
import duolingo.lib.dao.interfaces.ICat;
import duolingo.lib.dao.interfaces.ICrs;
import duolingo.lib.dao.interfaces.ILang;
import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.AvtModel;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;
import duolingo.lib.model.ExsModel;
import duolingo.lib.model.LangModel;
import duolingo.lib.model.LeagueModel;
import duolingo.lib.model.LvlModel;
import duolingo.lib.model.ShopItemsModel;
import duolingo.lib.model.UsersModel;

public class TestEsp17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LangModel castellano = new LangModel("español", "es-ES");
		LangModel frances = new LangModel("frances", "fr-FR");
		LangModel ingles = new LangModel("ingles", "en-US");
		LangModel aleman = new LangModel("aleman", "al-AL");
		
		CrsModel crsEsFr = new CrsModel(castellano, frances);
		CrsModel crsEsEng = new CrsModel(castellano, ingles);
		CrsModel crsEsDe = new CrsModel(castellano, aleman);
		
		CrsModel crsFrEs = new CrsModel(frances, castellano);
		CrsModel crsFrEng = new CrsModel(frances, ingles);
		
		CrsModel crsDeEng = new CrsModel(aleman, ingles);
		
		ArrayList<CrsModel> crsOriginEs = new ArrayList<CrsModel>();
		crsOriginEs.add(crsEsFr);
		crsOriginEs.add(crsEsEng);
		crsOriginEs.add(crsEsDe);
		castellano.setCrsLangOrigin(crsOriginEs);
		ArrayList<CrsModel> crsDestinyEs = new ArrayList<CrsModel>();
		crsDestinyEs.add(crsFrEs);
		castellano.setCrsLangDestiny(crsDestinyEs);
		
		ArrayList<CrsModel> crsOriginFr = new ArrayList<CrsModel>();
		crsOriginFr.add(crsFrEs);
		crsOriginFr.add(crsFrEng);
		frances.setCrsLangOrigin(crsOriginFr);
		ArrayList<CrsModel> crsDestinyFr = new ArrayList<CrsModel>();
		crsDestinyFr.add(crsEsFr);
		frances.setCrsLangDestiny(crsDestinyFr);
		
		ArrayList<CrsModel> crsDestinyEng = new ArrayList<CrsModel>();
		crsDestinyEng.add(crsEsEng);
		crsDestinyEng.add(crsFrEs);
		crsDestinyEng.add(crsDeEng);
		ingles.setCrsLangDestiny(crsDestinyEng);
		
		ArrayList<CrsModel> crsOriginDe = new ArrayList<CrsModel>();
		crsOriginDe.add(crsDeEng);
		aleman.setCrsLangOrigin(crsOriginDe);
		ArrayList<CrsModel> crsDestinyDe = new ArrayList<CrsModel>();
		crsDestinyDe.add(crsEsDe);
		aleman.setCrsLangDestiny(crsDestinyDe);
		
		Transaction t = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession() )
        {            
            t = session.beginTransaction();
            session.save(castellano);
            session.save(frances);
            session.save(ingles);
            session.save(aleman);
            session.save(crsEsFr);
            session.save(crsEsEng);
            session.save(crsEsDe);
            session.save(crsFrEs);
            session.save(crsFrEng);
            session.save(crsDeEng);
            
            t.commit();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        ICrs crsDao = new CrsImpl();
        System.out.println("Cursos de Origin id 1 y de destino id 3");
	    ArrayList<CrsModel> crs1 = crsDao.getCrsByLangFilter(1, 3);
	    for(CrsModel c: crs1) {
	    	System.out.println("CursoId "+c.getId());
	    }
	    System.out.println();
	    System.out.println("Cursos de Origin id 1");
	    ArrayList<CrsModel> crs2 = crsDao.getCrsByLangFilter(1, 0);
	    for(CrsModel c: crs2) {
	    	System.out.println("CursoId "+c.getId());
	    }
	    System.out.println();
	    System.out.println("Cursos de destino id 3");
	    ArrayList<CrsModel> crs3 = crsDao.getCrsByLangFilter(0, 3);
	    for(CrsModel c: crs3) {
	    	System.out.println("CursoId "+c.getId());
	    }
	}

}
