package duolingo.lib.dao.interfaces;

import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;

public interface ICat {

	public CatModel getCatByIndex(CrsModel crs, int index);
	public boolean saveCat(CatModel Cat);
}
