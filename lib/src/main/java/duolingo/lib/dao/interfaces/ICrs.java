package duolingo.lib.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import duolingo.lib.model.CrsModel;
import duolingo.lib.model.LangModel;

public interface ICrs {

	public CrsModel getCrsById(int id);
	public ArrayList<CrsModel> getCrsByLangFilter(int idLangOrigin, int idLangDestiny);
	public ArrayList<CrsModel> getCrsByLangOriginId(int idLangOrigin);
	public ArrayList<CrsModel> getCrsByLangDestinyId(int idLangDestiny);
	public List<CrsModel> getAllCrs();
	public boolean saveCrs(CrsModel crs);
}
