package duolingo.lib.dao.interfaces;

import duolingo.lib.model.AvtModel;
import duolingo.lib.model.UsersModel;

public interface IAvt {

	public AvtModel getAvtByUser(UsersModel usr);
	public boolean saveAvt(AvtModel avt);
}
