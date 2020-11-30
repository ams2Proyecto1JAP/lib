package duolingo.lib.hibernate.test;

import java.util.ArrayList;

import duolingo.lib.dao.implementations.CatImpl;
import duolingo.lib.dao.implementations.CrsImpl;
import duolingo.lib.dao.interfaces.ICat;
import duolingo.lib.dao.interfaces.ICrs;
import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;

public class TestNativeQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ICrs crsDao = new CrsImpl();
	     ArrayList<CrsModel> crs = crsDao.getCrsByLangFilter(1, 3);
	     crs.toString();
	}

}
