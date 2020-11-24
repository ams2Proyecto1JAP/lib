package duolingo.lib.model.id;

import java.io.Serializable;

import duolingo.lib.model.CatModel;

public class LvlId implements Serializable {
	private int index;
	private CatModel cat;
	
	public LvlId(){}
	public LvlId (int index, CatModel cat)
	{
		this.index = index;
		this.cat = cat;
	}
}
