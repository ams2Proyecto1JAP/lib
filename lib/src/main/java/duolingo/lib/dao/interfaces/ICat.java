package duolingo.lib.dao.interfaces;

import java.util.ArrayList;

import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;

public interface ICat {

	public CatModel getCatByIndex(CrsModel crs, int index);
	public boolean saveCat(CatModel Cat);
	public ArrayList<CatModel> getAllCategoriesByCrs(CrsModel crs);
	public int getCountCategoriesByCrs(CrsModel crs);
}
