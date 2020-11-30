package duolingo.lib.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import duolingo.lib.dao.implementations.CrsImpl;
import duolingo.lib.dao.interfaces.ICrs;
import duolingo.lib.hibernate.util.HibernateUtil;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;
import duolingo.lib.model.LangModel;

public class TestSprint2 {

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
		
		CatModel catBasic = new CatModel(crsEsEng, 1, "Basic");
		CatModel catFood = new CatModel(crsEsEng, 2, "Food");
		CatModel catSports = new CatModel(crsEsEng, 3, "Sports");
		List<CatModel> crsEsEngCats = new ArrayList<CatModel>();
		crsEsEngCats.add(catBasic);
		crsEsEngCats.add(catFood);
		crsEsEngCats.add(catSports);
		crsEsEng.setCategories(crsEsEngCats);
		
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
	}
}
