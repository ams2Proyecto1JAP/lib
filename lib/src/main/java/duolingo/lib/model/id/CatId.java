package duolingo.lib.model.id;

import java.io.Serializable;

import duolingo.lib.model.CrsModel;

public class CatId implements Serializable {
	private int index;
	private CrsModel crs;
	
	public CatId(){}
	public CatId (int index, CrsModel crs)
	{
		this.index = index;
		this.crs = crs;
	}
}
