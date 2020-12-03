package duolingo.lib.dao.interfaces;

import java.util.ArrayList;

import duolingo.lib.model.CatModel;
import duolingo.lib.model.LvlModel;

public interface ILvl {

	public LvlModel getLvlByIndex(CatModel cat, int index);

	public ArrayList<LvlModel> getAllLevelsByCat(CatModel cat);

	public boolean saveLvl(LvlModel lvl);
}
