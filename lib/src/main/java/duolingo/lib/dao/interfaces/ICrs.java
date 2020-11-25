package duolingo.lib.dao.interfaces;

import duolingo.lib.model.CrsModel;

public interface ICrs {

	public CrsModel getCrsById(int id);
	public boolean saveCrs(CrsModel crs);
}
