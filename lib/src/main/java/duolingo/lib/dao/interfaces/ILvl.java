package duolingo.lib.dao.interfaces;

import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;
import duolingo.lib.model.LvlModel;

public interface ILvl {

	public LvlModel getLvlByIndex(CatModel cat, int index);
	public boolean saveLvl(LvlModel lvl);
}
