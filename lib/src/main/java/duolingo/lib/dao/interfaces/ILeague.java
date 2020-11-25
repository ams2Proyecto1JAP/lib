package duolingo.lib.dao.interfaces;

import duolingo.lib.model.AvtModel;
import duolingo.lib.model.LeagueModel;

public interface ILeague {

	public LeagueModel getLeagueById(int id);
	public boolean saveLeague(LeagueModel league);
}
