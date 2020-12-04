package duolingo.lib.dao.interfaces;

import duolingo.lib.model.ExsModel;
import duolingo.lib.model.LvlModel;

import java.util.ArrayList;

import duolingo.lib.model.CatModel;
import duolingo.lib.model.CrsModel;

public interface IExs {

	public ExsModel getExsByIndex(LvlModel lvl, int index);
	public boolean saveExs(ExsModel exs);
	public ArrayList<ExsModel> getAllExercicesByLvl(LvlModel lvl);
}
