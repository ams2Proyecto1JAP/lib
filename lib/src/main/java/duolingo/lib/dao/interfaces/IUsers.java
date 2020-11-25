package duolingo.lib.dao.interfaces;

import duolingo.lib.model.AvtModel;
import duolingo.lib.model.UsersModel;

public interface IUsers {

	public UsersModel getUserById(int id);
	public boolean saveUser(UsersModel usr);
}
