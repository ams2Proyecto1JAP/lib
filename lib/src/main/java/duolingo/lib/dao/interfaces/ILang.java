package duolingo.lib.dao.interfaces;


import duolingo.lib.model.LangModel;

public interface ILang {

	public LangModel getLangById(int id);
	public boolean saveLang(LangModel lang);
}
