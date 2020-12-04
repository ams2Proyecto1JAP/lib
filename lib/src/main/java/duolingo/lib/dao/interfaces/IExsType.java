package duolingo.lib.dao.interfaces;

import duolingo.lib.model.ExsTypeModel;

public interface IExsType {

	public ExsTypeModel getExsTypeByType(String type);
	public boolean saveExsType(ExsTypeModel exsType);
}
