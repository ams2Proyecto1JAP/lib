package duolingo.lib.model.id;

import java.io.Serializable;

import duolingo.lib.model.LvlModel;

public class ExsId implements Serializable {
	private int index;
	private LvlModel lvl;
	
	public ExsId(){}
	public ExsId (int index, LvlModel lvl)
	{
		this.index = index;
		this.lvl = lvl;
	}
}
