package duolingo.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import duolingo.lib.model.id.LvlId;

@Entity
@Table (name = "lvl")
@IdClass(LvlId.class)
public class LvlModel {
	
	@Id
	@Column (name = "lvl_index")
	private int index;
	
	
	@Id
	@ManyToOne
	@JoinColumns(
		    {
		        @JoinColumn(name="cat_index", referencedColumnName="cat_index"),
		        @JoinColumn(name="crs_id", referencedColumnName="crs_id")
		    })
	private CatModel cat;	
	
	
	@OneToMany (mappedBy = "lvl")
	private List<ExsModel> exercices;
	
	@ManyToMany(mappedBy = "levelsResolved")
	private List<UsersModel> usersRvd;
	
	public LvlModel(){}
	public LvlModel(CatModel cat, int index) {
		super();
		this.cat = cat;
		this.index = index;
		this.exercices = new ArrayList<ExsModel>();
		this.usersRvd = new ArrayList<UsersModel>();
		
	}
	
	public void addUserRvd(UsersModel usr)
	{
		this.usersRvd.add(usr);
	}
}
